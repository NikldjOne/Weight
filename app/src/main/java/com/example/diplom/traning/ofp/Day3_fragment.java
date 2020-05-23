package com.example.diplom.traning.ofp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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
import com.squareup.picasso.Picasso;

public class Day3_fragment extends Fragment {
    View view;
    private ImageView imageView, imageView2, imageView3, imageView4, imageView_done,imageView_done2,imageView_done3,
            imageView_done4,imageView_done5;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("47");
    private DatabaseReference two = databaseReference.child("48");
    private DatabaseReference three = databaseReference.child("49");
    private DatabaseReference four = databaseReference.child("50");
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference resultsList,resultsList2,resultsList3,resultsList4;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Integer weight2;

    Button btn_squat, btn_nakloni, btn_vihodi,btn_snatch,btn_jerk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.day3_fragment, container, false);
        imageView = view.findViewById(R.id.img_front_squat);
        imageView2 = view.findViewById(R.id.img_deadlift_snatch);
        imageView3 = view.findViewById(R.id.img_deadlift_clean);
        imageView4 = view.findViewById(R.id.img_podt);
        btn_squat = view.findViewById(R.id.btn_front_squat);
        btn_nakloni = view.findViewById(R.id.btn_deadlift_snatch);
        btn_vihodi = view.findViewById(R.id.btn_deadlift_clean);
        btn_snatch = view.findViewById(R.id.btn_podt);
        imageView_done = view.findViewById(R.id.img_spina_done);
        imageView_done2 = view.findViewById(R.id.img_spina_done2);
        imageView_done3 = view.findViewById(R.id.img_spina_done3);
        imageView_done4 = view.findViewById(R.id.img_spina_done4);
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Front_Squat");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Deadlift_Snatch");
        resultsList3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Deadlift_Clean");
        resultsList4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Podt");
        btn_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), FrontSquat.class));
            }
        });
        btn_nakloni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Deadlift_Snatch.class));
            }
        });
        btn_vihodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Deadlift_Clean.class));
            }
        });
        btn_snatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Podt.class));
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        two.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        three.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        four.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        resultsList.child("front_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight!=null){
                    imageView_done.setBackgroundResource(R.drawable.done);
                }else
                    imageView_done.setBackgroundResource(R.drawable.round2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        resultsList2.child("deadsn_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight!=null){
                    imageView_done2.setBackgroundResource(R.drawable.done);
                }else
                    imageView_done2.setBackgroundResource(R.drawable.round2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        resultsList3.child("deadcl_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight!=null){
                    imageView_done3.setBackgroundResource(R.drawable.done);
                }else
                    imageView_done3.setBackgroundResource(R.drawable.round2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        resultsList4.child("podt_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight!=null){
                    imageView_done4.setBackgroundResource(R.drawable.done);
                }else
                    imageView_done4.setBackgroundResource(R.drawable.round2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
