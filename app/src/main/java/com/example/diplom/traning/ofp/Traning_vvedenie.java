package com.example.diplom.traning.ofp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.diplom.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Traning_vvedenie extends Fragment {
    Button btn_save;
    EditText ed_sqaut, ed_clean_jerk,ed_nakloni;
    String squat,nakloni;
    LinearLayout layout;
    private FirebaseDatabase mDatabase;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference Recordlist,ListNakloni;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.traning_vvedenie, container, false);
        btn_save = view.findViewById(R.id.btn_save);
        ed_sqaut = view.findViewById(R.id.edit_squat);
        ed_clean_jerk = view.findViewById(R.id.ed_clean_jerk);
        ed_nakloni = view.findViewById(R.id.edit_nakloni);
        mDatabase = FirebaseDatabase.getInstance();
        Recordlist = mDatabase.getReference("Records").child(user.getUid());
        ListNakloni = mDatabase.getReference("Records").child(user.getUid());
        loadWeight();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSquat();
                loadNakloni();
            }
        });
        return view;
    }

    private void loadNakloni() {
        nakloni = ed_nakloni.getText().toString();
        ListNakloni.child("max_nakloni").setValue(nakloni);
    }

    private void loadWeight() {
        Recordlist.child("max_squat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                ed_sqaut.setText(weight);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_nakloni").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                ed_nakloni.setText(weight);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void loadSquat() {
        squat = ed_sqaut.getText().toString();
        Recordlist.child("max_squat").setValue(squat);
    }

    private void exitKeybord() {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
        }
    }

