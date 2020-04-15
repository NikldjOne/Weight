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
import android.widget.TextView;
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
    RecyclerView recyclerView;
    MyAdapterSwipe adapterSwipe;
    LinearLayoutManager layoutManager;
    Context globalContext = null;
    Button dreams;
    String name;

    private DatabaseReference myRef, dreamlist;
    private FirebaseAuth mAuth;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mDatabase;
    int upd_pos;
    private List<ItemSwipe> itemSwipes = new ArrayList<>();
    TextView cart;


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
        cart = view.findViewById(R.id.cart_item_name);
        mDatabase = FirebaseDatabase.getInstance();
        dreamlist = mDatabase.getReference("Dreams").child(user.getUid());


        MySwipeHelper swipeHelper = new MySwipeHelper(getActivity().getApplicationContext(), recyclerView, 100) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
                buffer.add(new MyButton(getActivity().getApplicationContext(),
                        "Delete",
                        30,
                        R.drawable.ic_delete_black_24dp,
                        Color.parseColor("#e10404"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(getActivity(), "Delete click", Toast.LENGTH_SHORT).show();
                                DeleteDreams(pos);
                                itemSwipes.remove(pos);
                                recyclerView.setAdapter(adapterSwipe);
                            }
                        }));
                buffer.add(new MyButton(getActivity().getApplicationContext(),
                        "Update",
                        30,
                        R.drawable.ic_edit_black_24dp,
                        Color.parseColor("#008000"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick( int pos) {
                                Toast.makeText(getActivity(), "Update click", Toast.LENGTH_SHORT).show();
                                DialogUpdate();
                                  upd_pos = pos;
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
        ReadDreams();
        return view;
    }

    private void DeleteDreams(int pos) {
        dreamlist.child(String.valueOf(pos)).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                    }
                });
    }

    private void ReadDreams() {
        dreamlist.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemSwipes.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    name = snapshot.getValue(String.class);
                    itemSwipes.add(new ItemSwipe(name));
                    adapterSwipe = new MyAdapterSwipe(getActivity().getApplicationContext(), itemSwipes);
                    recyclerView.setAdapter(adapterSwipe);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void DialogUpdate() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText ed = new EditText(getActivity());
        itemSwipes.get(upd_pos).getName();
        name = ItemSwipe.class.getName();
        builder.setCancelable(false);
        builder.setView(ed);
        ed.setText(name);
        builder.setPositiveButton("Создать", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

//                dreamlist.child(String.valueOf(pos)).setValue(name).addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//
//                    }
//                });
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.colorBack);
        alertDialog.setTitle("Добавить цель");
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
                    name = ed.getText().toString();
                    myRef.child("Dreams").child(user.getUid()).push().setValue(name);
                    generateItem();
                }
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.colorBack);
        alertDialog.setTitle("Добавить цель");
        alertDialog.show();

    }


    private void generateItem() {

        itemSwipes.add(new ItemSwipe(name));
        adapterSwipe = new MyAdapterSwipe(getActivity().getApplicationContext(), itemSwipes);
        recyclerView.setAdapter(adapterSwipe);
    }
}


