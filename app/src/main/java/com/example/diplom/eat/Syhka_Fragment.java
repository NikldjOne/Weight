package com.example.diplom.eat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.diplom.R;
import com.example.diplom.eat.menu_eat_syhka.Obed;
import com.example.diplom.eat.menu_eat_syhka.Perekys;
import com.example.diplom.eat.menu_eat_syhka.Yjin;
import com.example.diplom.eat.menu_eat_syhka.Zavtrak;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Syhka_Fragment extends Fragment {
    View view;
    ImageView imageView,im_zav,im_obed,im_per,im_yjin;
    TextView syhka;
    TextView bt_syhka;
    Button btn_zavtrak, btn_perekys, btn_obed, btn_yjin;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("1");
    private DatabaseReference two = databaseReference.child("2");
    private DatabaseReference three = databaseReference.child("3");
    private DatabaseReference four = databaseReference.child("4");
    private DatabaseReference five = databaseReference.child("5");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.syhka_fragment, container, false);
        imageView =  view.findViewById(R.id.perekys);
        im_zav =  view.findViewById(R.id.image_zavtrak);
        im_per =  view.findViewById(R.id.image_perekys);
        im_obed =  view.findViewById(R.id.image_obed);
        im_yjin =  view.findViewById(R.id.image_yjin);
        syhka =  view.findViewById(R.id.textviewsyhka);
        imageView.setImageResource(R.drawable.inset_default);
        im_zav.setImageResource(R.drawable.inset_default);
        im_per.setImageResource(R.drawable.inset_default);
        im_obed.setImageResource(R.drawable.inset_default);
        im_yjin.setImageResource(R.drawable.inset_default);
        syhka.setText("Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight");
        bt_syhka =  view.findViewById(R.id.about_syhka);
        btn_zavtrak =  view.findViewById(R.id.btn_zavtrak);
        btn_perekys =  view.findViewById(R.id.btn_perekys);
        btn_obed = view.findViewById(R.id.btn_obed);
        btn_yjin = view.findViewById(R.id.btn_yjin);
        bt_syhka.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_syhka.setVisibility(View.INVISIBLE);
                syhka.setText("Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание WEIGHT" +
                        " на сушке включает в себя сбалансированный рацион из 4 приемов пищи. Общая калорийность рациона варьируется от 1100" +
                        "до 1800 калорий. Этот рацион даст твоему организму все необходимые вещества для качественного восстановления после тренировки," +
                        "и поддержания сил во время дефицита каллорий.");
            }
        });
        btn_perekys.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Perekys.class));
            }
        });
        btn_zavtrak.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Zavtrak.class));
            }
        });
        btn_obed.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Obed.class));
            }
        });

        btn_yjin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Yjin.class));
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
                Picasso.get().load(link).into(im_zav);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        three.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(im_per);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        four.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(im_obed);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        five.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(im_yjin);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
