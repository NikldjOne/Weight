package com.example.diplom;

import android.annotation.SuppressLint;
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

import com.example.diplom.models.Model_pos;
import com.example.diplom.traning.ofp.OFP;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class TraningFragment extends Fragment {

    private ImageView imageView, imageView2, imageView3;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("38");
    private DatabaseReference two = databaseReference.child("39");
    private DatabaseReference three = databaseReference.child("40");
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference resultsList;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Button btn_ofp, btn_cila;
    Model_pos model_pos = new Model_pos();
    Integer position;
    TextView textView, about;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_traning, container, false);
        imageView = view.findViewById(R.id.img_traning);
        imageView.setImageResource(R.drawable.inset_default);
        imageView2 = view.findViewById(R.id.img_ofp);
        btn_ofp = view.findViewById(R.id.btn_ofp);
        textView = view.findViewById(R.id.textview_traning);
        about = view.findViewById(R.id.about_traning);
        textView.setText("Перед тобой план тренировок для начинающих атлетов. После перехода в курс тренировок Weight");
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid());
        btn_ofp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OFP.class);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                textView.setText("Перед тобой план тренировок для начинающих атлетов. После перехода в курс тренировок Weight " +
                        "ты поподаешь в свой календарь тренировок. Первым делом сверху ты видишь список недель программы. " +
                        "Также есть вкладка рекорды, в этой вкладке ты можешь указать свои рекорды в упражнениях, и исходя от этого " +
                        "твои тренировочные веса буду вычисляться из твоих максимальных рекордов. Ну а если ты совсем новичок, то укажи " +
                        "рекорды ввиде 0 и тогда программа тренировок сама подстроиться под тебя. " +
                        "Ниже под списком недель расположен список дней недели. Выбрав текущий день ты попадаешь в сегодняшнюю тренировку " +
                        "В первую очередь тренировочный день разделен на группы мышц. Что позволит тебе постепенно прогрессировать. " +
                        "После перехода в упражнение,ты видишь информацию о весе, подходах, повторениях, и время отдыха. " +
                        "Еще ниже находиться твой тренировочный дневник, где ты будешь фиксировать свой прогресс. " +
                        "Столбец текущий,отвечает за результаты на этой тренировке. Столбец последний показывает твои результаты,на прошлой тренировке " +
                        ",для этого упражнения. Зевершив, день, неделю, ты сразу же переходишь на другой тренировочный день, или неделю ");
                about.setVisibility(View.INVISIBLE);
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
    }
}
