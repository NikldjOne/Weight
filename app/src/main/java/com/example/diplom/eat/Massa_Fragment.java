package com.example.diplom.eat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.diplom.R;
import com.example.diplom.eat.menu_eat_massa.Obed_massa;
import com.example.diplom.eat.menu_eat_massa.Perekys_massa;
import com.example.diplom.eat.menu_eat_massa.Poldnik_massa;
import com.example.diplom.eat.menu_eat_massa.Yjin_massa;
import com.example.diplom.eat.menu_eat_massa.Zavtrak_massa;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Massa_Fragment extends Fragment {
    View view;
    private ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView6;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("21");
    private DatabaseReference two = databaseReference.child("22");
    private DatabaseReference three = databaseReference.child("23");
    private DatabaseReference four = databaseReference.child("24");
    private DatabaseReference five = databaseReference.child("25");
    private DatabaseReference six = databaseReference.child("26");
    TextView syhka;
    TextView bt_massa;
    Button btn_zavtrak, btn_perekys, btn_obed, btn_yjin, btn_poldnik;

    public Massa_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.massa_fragment, container, false);
        imageView =  view.findViewById(R.id.perekys_2);
        imageView.setImageResource(R.drawable.inset_default);
        imageView2 =  view.findViewById(R.id.zavtrak_2);
        imageView3 =  view.findViewById(R.id.perekys_22);
        imageView4 =  view.findViewById(R.id.poldnik);
        imageView5 =  view.findViewById(R.id.obed_2);
        imageView6 =  view.findViewById(R.id.yjin_2);
        syhka =  view.findViewById(R.id.textviewmassa);
        syhka.setText("Если твоя цель набрать вес и создать в организме оптимальные условия для построения мышц - этот ");
        bt_massa =  view.findViewById(R.id.about_massa);
        btn_zavtrak = view.findViewById(R.id.btn_zavtrak_2);
        btn_perekys = view.findViewById(R.id.btn_perekys_2);
        btn_poldnik = view.findViewById(R.id.btn_poldnik);
        btn_obed = view.findViewById(R.id.btn_obed_2);
        btn_yjin = view.findViewById(R.id.btn_yjin_2);
        bt_massa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_massa.setVisibility(View.INVISIBLE);
                syhka.setText("Если твоя цель набрать вес и создать в организме оптимальные условия для построения мышц - этот" +
                        " рацион для тебя. Питание WEIGHT на массе включает в себя сбалансированный рацион из 5ти приемов" +
                        "пищи. Общая калорийность рациона варьируется от 2900 до 3700 калорий.Этот рацион даст твоему организму" +
                        "все необходимые вещества для качественного восстановления после тренировки и создаст оптимальные условия для построения" +
                        "мышечной массы");
            }
        });
        btn_perekys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Perekys_massa.class));
            }
        });
        btn_zavtrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Zavtrak_massa.class));
            }
        });
        btn_obed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Obed_massa.class));
            }
        });
        btn_poldnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Poldnik_massa.class));
            }
        });
        btn_yjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Yjin_massa.class));
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
                Picasso.get().load(link).into(imageView2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        two.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        three.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView4);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        four.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        five.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView6);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        six.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(imageView);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
