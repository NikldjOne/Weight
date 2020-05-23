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

public class Day5_fragment extends Fragment {
    View view;
    private ImageView imageView, imageView2, imageView3, imageView4,imageView5, imageView_done,imageView_done2,imageView_done3,
            imageView_done4,imageView_done5;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("51");
    private DatabaseReference two = databaseReference.child("52");
    private DatabaseReference three = databaseReference.child("53");
    private DatabaseReference four = databaseReference.child("54");
    private DatabaseReference five = databaseReference.child("55");
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference resultsList,resultsList2,resultsList3,resultsList4,resultList5;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Integer weight2;

    Button btn_squat, btn_nakloni, btn_vihodi,btn_snatch,btn_jerk;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.day5_fragment, container, false);
        imageView = view.findViewById(R.id.img_press);
        imageView2 = view.findViewById(R.id.img_dead_press);
        imageView3 = view.findViewById(R.id.img_bench_press);
        imageView4 = view.findViewById(R.id.img_biceps);
        imageView5 = view.findViewById(R.id.img_triceps);
        btn_squat = view.findViewById(R.id.btn_press);
        btn_nakloni = view.findViewById(R.id.btn_dead_press);
        btn_vihodi = view.findViewById(R.id.btn_bench_press);
        btn_snatch = view.findViewById(R.id.btn_biceps);
        btn_jerk = view.findViewById(R.id.btn_triceps);
        imageView_done = view.findViewById(R.id.img_verh_done);
        imageView_done2 = view.findViewById(R.id.img_verh_done2);
        imageView_done3 = view.findViewById(R.id.img_verh_done3);
        imageView_done4 = view.findViewById(R.id.img_verh_done4);
        imageView_done5 = view.findViewById(R.id.img_verh_done5);
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Bench");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Dead_Press");
        resultsList3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Bench_Press");
        resultsList4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Biceps");
        resultList5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Triceps");
        btn_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Bench.class));
            }
        });
        btn_nakloni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Dead_Press.class));
            }
        });
        btn_vihodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),Bench_Press.class));
            }
        });
        btn_snatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Biceps.class));
            }
        });
        btn_jerk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Triceps.class));
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

        resultsList.child("bench_done").addValueEventListener(new ValueEventListener() {
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
        resultsList2.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
        resultsList3.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
        resultsList4.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
        resultList5.child("triceps_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight!=null){
                    imageView_done5.setBackgroundResource(R.drawable.done);
                }else
                    imageView_done5.setBackgroundResource(R.drawable.round2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
}
