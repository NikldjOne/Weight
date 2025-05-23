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
    EditText ed_sqaut, ed_clean_jerk, ed_nakloni, ed_front_squat, ed_bench, edit_bench_press, edit_biceps, edit_triceps,edit_deadpr;
    String squat, nakloni, front, bench, bench_press, biceps, triceps,deadpr;
    LinearLayout layout;
    private FirebaseDatabase mDatabase;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference Recordlist, ListNakloni, ListFront;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.traning_vvedenie, container, false);
        btn_save = view.findViewById(R.id.btn_save);
        ed_sqaut = view.findViewById(R.id.edit_squat);
//        ed_clean_jerk = view.findViewById(R.id.ed_clean_jerk);
        ed_nakloni = view.findViewById(R.id.edit_nakloni);
        ed_front_squat = view.findViewById(R.id.edit_front_squat);
        ed_bench = view.findViewById(R.id.edit_bench);
        edit_biceps = view.findViewById(R.id.edit_biceps);
        edit_triceps = view.findViewById(R.id.edit_triceps);
        edit_bench_press = view.findViewById(R.id.edit_bench_press);
        edit_deadpr = view.findViewById(R.id.edit_deadpr);
        mDatabase = FirebaseDatabase.getInstance();
        Recordlist = mDatabase.getReference("Records").child(user.getUid());
        ListNakloni = mDatabase.getReference("Records").child(user.getUid());
        ListFront = mDatabase.getReference("Records").child(user.getUid());
        loadWeight();
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSquat();
                loadNakloni();
                loadFront();
                loadBench();
                loadBenchPress();
                loadBiceps();
                loadTriceps();
                loadDeadPr();
                CloseEdit();
            }
        });
        return view;
    }

    private void CloseEdit() {
        ed_sqaut.setVisibility(View.INVISIBLE);
        ed_nakloni.setVisibility(View.INVISIBLE);
        ed_front_squat.setVisibility(View.INVISIBLE);
        ed_bench.setVisibility(View.INVISIBLE);
        edit_biceps.setVisibility(View.INVISIBLE);
        edit_triceps.setVisibility(View.INVISIBLE);
        edit_bench_press.setVisibility(View.INVISIBLE);
        edit_deadpr.setVisibility(View.INVISIBLE);

        ed_sqaut.setVisibility(View.VISIBLE);
        ed_nakloni.setVisibility(View.VISIBLE);
        ed_front_squat.setVisibility(View.VISIBLE);
        ed_bench.setVisibility(View.VISIBLE);
        edit_biceps.setVisibility(View.VISIBLE);
        edit_triceps.setVisibility(View.VISIBLE);
        edit_bench_press.setVisibility(View.VISIBLE);
        edit_deadpr.setVisibility(View.VISIBLE);
    }

    private void loadNakloni() {
        if (ed_nakloni.getText().toString().equals("")) {
            nakloni = "0";
        } else
            nakloni = ed_nakloni.getText().toString();
        ListNakloni.child("max_nakloni").setValue(nakloni);
    }

    private void loadFront() {
        if (ed_front_squat.getText().toString().equals("")) {
            front = "0";
        } else
            front = ed_front_squat.getText().toString();
        ListFront.child("max_front").setValue(front);

    }

    private void loadBench() {
        if (ed_bench.getText().toString().equals("")) {
            bench = "0";
        } else
            bench = ed_bench.getText().toString();
        ListFront.child("max_bench").setValue(bench);
    }

    private void loadBenchPress() {
        if (edit_bench_press.getText().toString().equals("")) {
            bench_press = "0";
        } else
            bench_press = edit_bench_press.getText().toString();
        ListFront.child("max_benchpr").setValue(bench_press);
    }

    private void loadBiceps() {
        if (edit_biceps.getText().toString().equals("")) {
            biceps = "0";
        } else
            biceps = edit_biceps.getText().toString();
        ListFront.child("max_biceps").setValue(biceps);
    }

    private void loadTriceps() {
        if (edit_triceps.getText().toString().equals("")) {
            triceps = "0";
        } else
            triceps = edit_triceps.getText().toString();
        ListFront.child("max_triceps").setValue(triceps);
    }
    private void loadDeadPr() {
        if (edit_deadpr.getText().toString().equals("")) {
            deadpr = "0";
        } else
            deadpr = edit_deadpr.getText().toString();
        ListFront.child("max_deadpr").setValue(deadpr);
    }


    private void loadWeight() {
        Recordlist.child("max_squat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    ed_sqaut.setText(weight);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_nakloni").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    ed_nakloni.setText(weight);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_front").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    ed_front_squat.setText(weight);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_bench").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                ed_bench.setText(weight);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_benchpr").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    edit_bench_press.setText(weight);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_biceps").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    edit_biceps.setText(weight);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_triceps").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    edit_triceps.setText(weight);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ListNakloni.child("max_deadpr").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    edit_deadpr.setText(weight);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void loadSquat() {
        if (ed_sqaut.getText().toString().equals("")) {
            squat = "0";
        } else
        squat = ed_sqaut.getText().toString();
        Recordlist.child("max_squat").setValue(squat);
    }

    private void exitKeybord() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(layout.getWindowToken(), 0);
    }
}

