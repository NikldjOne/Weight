package com.example.diplom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplom.model.ItemSwipe;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private MyAdapterSwipe adapterSwipe;
    private LinearLayoutManager layoutManager;
    private Context globalContext = null;
    private Button dreams;
    private String name, name_upd, key, item;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference myRef, dreamlist;
    private FirebaseDatabase mDatabase;
    private List<ItemSwipe> itemSwipes = new ArrayList<>();
    private List<String> keys = new ArrayList<>();
    private List<String> items = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_test);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        dreams = (Button) view.findViewById(R.id.dreams_btn);
        myRef = FirebaseDatabase.getInstance().getReference();
        globalContext = this.getActivity();
        mDatabase = FirebaseDatabase.getInstance();
        dreamlist = mDatabase.getReference("Dreams").child(user.getUid());

        MySwipeHelper swipeHelper = new MySwipeHelper(getActivity(), recyclerView, 100) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
                buffer.add(new MyButton(getActivity(),
                        "Delete",
                        30,
                        R.drawable.ic_delete_black_24dp,
                        Color.parseColor("#e10404"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                key = keys.get(pos);
                                DeleteDreams(key);
                            }
                        }));
                buffer.add(new MyButton(getActivity().getApplicationContext(),
                        "Update",
                        30,
                        R.drawable.ic_edit_black_24dp,
                        Color.parseColor("#008000"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(final int pos) {
                                key = keys.get(pos);
                                name = items.get(pos);
                                DialogUpdate(key, name);
                            }
                        }));
            }
        };

        dreams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogShow();
            }
        });
        ClearDreams();
        ReadDreams();
        return view;
    }

    private void ClearDreams() {
        keys.clear();
        items.clear();
        itemSwipes.clear();
        adapterSwipe = new MyAdapterSwipe(getActivity(), itemSwipes);
        recyclerView.setAdapter(adapterSwipe);
    }


    private void DeleteDreams(String key) {
        ClearDreams();
        dreamlist.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(globalContext, "Ваша цель была удалена!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void ReadDreams() {
        dreamlist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot_key : dataSnapshot.getChildren()) {
                    keys.add(snapshot_key.getKey());
                    item = snapshot_key.getValue(String.class);
                    items.add(item);
                    itemSwipes.add(new ItemSwipe(item));
                    adapterSwipe = new MyAdapterSwipe(getActivity(), itemSwipes);
                    recyclerView.setAdapter(adapterSwipe);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(globalContext, "Не удалось загрузить список целей,перезайдите", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void DialogUpdate(final String key, final String name) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText ed = new EditText(getActivity());
        builder.setCancelable(false);
        builder.setView(ed);
        ed.setText(name);
        builder.setPositiveButton("Изменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (ed.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Вы не изменили цель", Toast.LENGTH_SHORT).show();
                    DialogUpdate(key, name);
                } else if (ed.getText().toString().equals(name)) {
                    Toast.makeText(globalContext, "Вы не изменили данные!", Toast.LENGTH_SHORT).show();
                    DialogUpdate(key, name);
                } else {
                    ClearDreams();
                    name_upd = ed.getText().toString();
                    dreamlist.child(key).setValue(name_upd).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(globalContext, "Ваши данные были обновлены!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                adapterSwipe = new MyAdapterSwipe(getActivity(), itemSwipes);
                recyclerView.setAdapter(adapterSwipe);
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.colorBack);
        alertDialog.setTitle("Изменить цель");
        alertDialog.show();

    }

    private void DialogShow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText ed = new EditText(getActivity());
        builder.setCancelable(false);
        builder.setView(ed);
        ed.post(new Runnable() {
            @Override
            public void run() {
                InputMethodManager inputMethodManager =
                        (InputMethodManager) globalContext.getSystemService(INPUT_METHOD_SERVICE);
                inputMethodManager.toggleSoftInputFromWindow(
                        ed.getApplicationWindowToken(), InputMethodManager.SHOW_IMPLICIT, 0);
                ed.requestFocus();
            }
        });
        builder.setPositiveButton("Создать", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (ed.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Вы не ввели цель", Toast.LENGTH_SHORT).show();
                    DialogShow();
                } else {
                    ClearDreams();
                    name = ed.getText().toString();
                    String key = dreamlist.push().getKey();
                    dreamlist.child(key).setValue(name);
                }
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                adapterSwipe = new MyAdapterSwipe(getActivity(), itemSwipes);
                recyclerView.setAdapter(adapterSwipe);
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.colorBack);
        alertDialog.setTitle("Добавить цель");
        alertDialog.show();

    }
}


