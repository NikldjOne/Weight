package com.example.diplom;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class IntellectFragment extends Fragment {
    VideoView vv_squat,vv_snatch,vv_nakloni;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Video");
    private DatabaseReference first = databaseReference.child("1");
    private DatabaseReference two = databaseReference.child("2");
    private DatabaseReference three = databaseReference.child("3");
    private DatabaseReference databaseReference2 = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first2 = databaseReference2.child("41");
    private DatabaseReference two2 = databaseReference2.child("42");
    private DatabaseReference three2 = databaseReference2.child("44");

    Button start_squat, start_snatch, start_nakloni;
    ImageView img_squat_video, img_snatch_video, img_nakloni_video;
    MediaController mediaController;
    TextView tv_squat_video, tv_snatch_video, tv_nakloni_video;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_intellect, container, false);
        vv_squat = view.findViewById(R.id.vv_squat);
        vv_snatch = view.findViewById(R.id.vv_snatch);
        vv_nakloni = view.findViewById(R.id.vv_nakloni);
        img_squat_video = view.findViewById(R.id.img_squat_video);
        img_snatch_video = view.findViewById(R.id.img_snatch_video);
        img_nakloni_video = view.findViewById(R.id.img_nakloni_video);

        tv_squat_video = view.findViewById(R.id.tv_squat_video);
        tv_snatch_video = view.findViewById(R.id.tv_snatch_video);
        tv_nakloni_video = view.findViewById(R.id.tv_nakloni_video);
        tv_squat_video = view.findViewById(R.id.tv_squat_video);
        mediaController = new MediaController(getActivity());
        start_squat = view.findViewById(R.id.start_squat);
        start_snatch = view.findViewById(R.id.start_snatch);
        start_nakloni = view.findViewById(R.id.start_nakloni);
        start_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_squat_video.setVisibility(View.INVISIBLE);
                img_squat_video.setVisibility(View.INVISIBLE);
                vv_squat.setVisibility(View.VISIBLE);
                start_squat.setVisibility(View.INVISIBLE);
                Play(vv_squat);
                vv_squat.setMediaController(mediaController);
                mediaController.setAnchorView(vv_squat);
            }
        });
        start_snatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_snatch_video.setVisibility(View.INVISIBLE);
                img_snatch_video.setVisibility(View.INVISIBLE);
                vv_snatch.setVisibility(View.VISIBLE);
                start_snatch.setVisibility(View.INVISIBLE);
                Play(vv_snatch);
                vv_snatch.setMediaController(mediaController);
                mediaController.setAnchorView(vv_snatch);
            }
        });
        start_nakloni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_nakloni_video.setVisibility(View.INVISIBLE);
                img_nakloni_video.setVisibility(View.INVISIBLE);
                vv_nakloni.setVisibility(View.VISIBLE);
                start_nakloni.setVisibility(View.INVISIBLE);
                Play(vv_nakloni);
                vv_nakloni.setMediaController(mediaController);
                mediaController.setAnchorView(vv_nakloni);
            }
        });
        return view;
    }

    public void Play(View view) {
        vv_squat.start();
    }


    @Override
    public void onStart() {
        super.onStart();
        vv_squat.setVisibility(View.INVISIBLE);
        vv_snatch.setVisibility(View.INVISIBLE);
        vv_nakloni.setVisibility(View.INVISIBLE);
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_squat.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        two.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_snatch.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        three.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_snatch.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        first2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_squat_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        two2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_nakloni_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        three2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_snatch_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
