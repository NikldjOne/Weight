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

public class Day1_fragment extends Fragment {
    View view;
    private ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView_done,block_day1,imageView_done2,imageView_done3;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("41");
    private DatabaseReference two = databaseReference.child("42");
    private DatabaseReference three = databaseReference.child("43");
    private DatabaseReference four = databaseReference.child("44");
    private DatabaseReference five = databaseReference.child("45");
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference resultsList,resultsList2,resultsList3,resultsList4,resultsList5;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Integer weight2;

    Button btn_squat, btn_nakloni, btn_vihodi,btn_snatch;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.day1_fragment, container, false);
        imageView = view.findViewById(R.id.img_squat);
        imageView2 = view.findViewById(R.id.img_nakloni);
        imageView3 = view.findViewById(R.id.img_vihod);
        imageView4 = view.findViewById(R.id.img_snatch);
        imageView5 = view.findViewById(R.id.img_jerk);
        btn_squat = view.findViewById(R.id.btn_squat);
        btn_nakloni = view.findViewById(R.id.btn_nakloni_day1);
        btn_vihodi = view.findViewById(R.id.btn_vihodi_day1);
        btn_snatch = view.findViewById(R.id.btn_snatch);
        imageView_done = view.findViewById(R.id.img_squat_done);
        imageView_done2 = view.findViewById(R.id.img_squat_done2);
        imageView_done3 = view.findViewById(R.id.img_squat_done3);
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Squat");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Nakloni");
        resultsList3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Vihodi");
        btn_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Squat.class));
            }
        });
        btn_nakloni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Nakloni.class));
            }
        });
        btn_vihodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Vihodi.class));
            }
        });
        btn_snatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Snatch.class));
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
        five.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
            resultsList.child("squat_done").addValueEventListener(new ValueEventListener() {
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
        resultsList2.child("nakloni_done").addValueEventListener(new ValueEventListener() {
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
        resultsList3.child("vihodi_done").addValueEventListener(new ValueEventListener() {
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
        }
    }
