package com.example.diplom;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
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
    VideoView vv_squat, vv_snatch, vv_nakloni, vv_clean, vv_jerk, vv_front, vv_deadsn, vv_deadcl, vv_podt,
            vv_bench, vv_deadpr, vv_benchpr, vv_biceps, vv_triceps, vv_scr, vv_planka;
    ScrollView sv;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Video");
    private DatabaseReference first = databaseReference.child("1");
    private DatabaseReference two = databaseReference.child("2");
    private DatabaseReference three = databaseReference.child("3");
    private DatabaseReference four = databaseReference.child("4");
    private DatabaseReference five = databaseReference.child("5");
    private DatabaseReference six = databaseReference.child("6");
    private DatabaseReference seven = databaseReference.child("7");
    private DatabaseReference eight = databaseReference.child("8");
    private DatabaseReference nine = databaseReference.child("9");

    private DatabaseReference ten = databaseReference.child("10");
    private DatabaseReference eleven = databaseReference.child("11");
    private DatabaseReference twelve = databaseReference.child("12");
    private DatabaseReference threeteen = databaseReference.child("13");
    private DatabaseReference fourteen = databaseReference.child("14");
    private DatabaseReference fiveteen = databaseReference.child("15");
    private DatabaseReference sixteen = databaseReference.child("16");


    private DatabaseReference databaseReference2 = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first2 = databaseReference2.child("41");
    private DatabaseReference two2 = databaseReference2.child("42");
    private DatabaseReference three2 = databaseReference2.child("44");
    private DatabaseReference four2 = databaseReference2.child("45");

    private DatabaseReference five2 = databaseReference2.child("47");
    private DatabaseReference six2 = databaseReference2.child("48");
    private DatabaseReference seven2 = databaseReference2.child("49");
    private DatabaseReference eight2 = databaseReference2.child("50");
    private DatabaseReference nine2 = databaseReference2.child("51");
    private DatabaseReference ten2 = databaseReference2.child("52");
    private DatabaseReference eleven2 = databaseReference2.child("53");
    private DatabaseReference twelve2 = databaseReference2.child("54");
    private DatabaseReference threeteen2 = databaseReference2.child("55");
    private DatabaseReference fourteen2 = databaseReference2.child("56");
    private DatabaseReference fiveteen2 = databaseReference2.child("57");

    Button start_squat, start_snatch, start_nakloni, start_clean, start_jerk, start_front, start_deadsn, start_deadcl, start_podt,
            start_bench, start_deadpr, start_benchpr, start_biceps, start_triceps, start_scr, start_planka;
    ImageView img_squat_video, img_snatch_video, img_nakloni_video, img_clean_video, img_jerk_video, img_front_video, img_deadsn_video,
            img_deadcl_video, img_podt_video, img_bench_video, img_deadpr_video, img_benchpr_video, img_biceps_video, img_triceps_video,
            img_scr_video, img_planka_video;
    MediaController mediaController;
    TextView tv_squat_video, tv_snatch_video, tv_nakloni_video, tv_clean_video, tv_jerk_video, tv_front_video,
            tv_deadsn_video, tv_deadcl_video, tv_potd_video, tv_bench_video, tv_deadpr_video, tv_benchpr_video, tv_biceps_video, tv_triceps_video,
            tv_scr_video, tv_planka_video;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_intellect, container, false);
        sv = view.findViewById(R.id.scrool_tehnic);
        scrollDialogDown();
        vv_squat = view.findViewById(R.id.vv_squat);
        vv_snatch = view.findViewById(R.id.vv_snatch);
        vv_nakloni = view.findViewById(R.id.vv_nakloni);
        vv_clean = view.findViewById(R.id.vv_clean);
        vv_jerk = view.findViewById(R.id.vv_jerk);
        vv_front = view.findViewById(R.id.vv_front);
        vv_deadsn = view.findViewById(R.id.vv_deadsn);
        vv_deadcl = view.findViewById(R.id.vv_deadcl);
        vv_podt = view.findViewById(R.id.vv_podt);
        vv_bench = view.findViewById(R.id.vv_bench);
        vv_deadpr = view.findViewById(R.id.vv_deadpr);
        vv_benchpr = view.findViewById(R.id.vv_benchpr);
        vv_biceps = view.findViewById(R.id.vv_biceps);
        vv_triceps = view.findViewById(R.id.vv_tripes);
        vv_scr = view.findViewById(R.id.vv_scr);
        vv_planka = view.findViewById(R.id.vv_planka);
        img_squat_video = view.findViewById(R.id.img_squat_video);
        img_snatch_video = view.findViewById(R.id.img_snatch_video);
        img_nakloni_video = view.findViewById(R.id.img_nakloni_video);
        img_clean_video = view.findViewById(R.id.img_clean_video);
        img_jerk_video = view.findViewById(R.id.img_jerk_video);
        img_front_video = view.findViewById(R.id.img_front_video);
        img_deadsn_video = view.findViewById(R.id.img_deadsn_video);
        img_deadcl_video = view.findViewById(R.id.img_deadcl_video);
        img_podt_video = view.findViewById(R.id.img_podt_video);
        img_bench_video = view.findViewById(R.id.img_bench_video);
        img_deadpr_video = view.findViewById(R.id.img_deadpr_video);
        img_benchpr_video = view.findViewById(R.id.img_benchpr_video);
        img_biceps_video = view.findViewById(R.id.img_biceps_video);
        img_triceps_video = view.findViewById(R.id.img_tripes_video);
        img_scr_video = view.findViewById(R.id.img_scr_video);
        img_planka_video = view.findViewById(R.id.img_planka_video);

        tv_squat_video = view.findViewById(R.id.tv_squat_video);
        tv_snatch_video = view.findViewById(R.id.tv_snatch_video);
        tv_nakloni_video = view.findViewById(R.id.tv_nakloni_video);
        tv_clean_video = view.findViewById(R.id.tv_clean_video);
        tv_jerk_video = view.findViewById(R.id.tv_jerk_video);
        tv_front_video = view.findViewById(R.id.tv_front_video);
        tv_deadsn_video = view.findViewById(R.id.tv_deadsn_video);
        tv_deadcl_video = view.findViewById(R.id.tv_deadcl_video);
        tv_potd_video = view.findViewById(R.id.tv_podt_video);
        tv_bench_video = view.findViewById(R.id.tv_bench_video);
        tv_deadpr_video = view.findViewById(R.id.tv_deadpr_video);
        tv_benchpr_video = view.findViewById(R.id.tv_benchpr_video);
        tv_biceps_video = view.findViewById(R.id.tv_biceps_video);
        tv_triceps_video = view.findViewById(R.id.tv_tripes_video);
        tv_scr_video = view.findViewById(R.id.tv_scr_video);
        tv_planka_video = view.findViewById(R.id.tv_planka_video);

        mediaController = new MediaController(getActivity());
        start_squat = view.findViewById(R.id.start_squat);
        start_snatch = view.findViewById(R.id.start_snatch);
        start_nakloni = view.findViewById(R.id.start_nakloni);
        start_clean = view.findViewById(R.id.start_clean);
        start_jerk = view.findViewById(R.id.start_jerk);
        start_front = view.findViewById(R.id.start_front);
        start_deadsn = view.findViewById(R.id.start_deadsn);
        start_deadcl = view.findViewById(R.id.start_deadcl);
        start_bench = view.findViewById(R.id.start_bench);
        start_deadpr = view.findViewById(R.id.start_deadpr);
        start_benchpr = view.findViewById(R.id.start_benchpr);
        start_biceps = view.findViewById(R.id.start_biceps);
        start_triceps = view.findViewById(R.id.start_tripes);
        start_scr = view.findViewById(R.id.start_scr);
        start_planka = view.findViewById(R.id.start_scr);
        start_podt = view.findViewById(R.id.start_podt);
        Invisble();
        start_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
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
                Invisble();
                Visible();
                tv_snatch_video.setVisibility(View.INVISIBLE);
                img_snatch_video.setVisibility(View.INVISIBLE);
                vv_snatch.setVisibility(View.VISIBLE);
                start_snatch.setVisibility(View.INVISIBLE);
                Play3(vv_snatch);
                vv_snatch.setMediaController(mediaController);
                mediaController.setAnchorView(vv_snatch);
            }
        });
        start_nakloni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_nakloni_video.setVisibility(View.INVISIBLE);
                img_nakloni_video.setVisibility(View.INVISIBLE);
                vv_nakloni.setVisibility(View.VISIBLE);
                start_nakloni.setVisibility(View.INVISIBLE);
                Play2(vv_nakloni);
                vv_nakloni.setMediaController(mediaController);
                mediaController.setAnchorView(vv_nakloni);
            }
        });
        start_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_clean_video.setVisibility(View.INVISIBLE);
                img_clean_video.setVisibility(View.INVISIBLE);
                vv_clean.setVisibility(View.VISIBLE);
                start_clean.setVisibility(View.INVISIBLE);
                Play4(vv_clean);
                vv_clean.setMediaController(mediaController);
                mediaController.setAnchorView(vv_clean);
            }
        });
        start_jerk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_jerk_video.setVisibility(View.INVISIBLE);
                img_jerk_video.setVisibility(View.INVISIBLE);
                vv_jerk.setVisibility(View.VISIBLE);
                start_jerk.setVisibility(View.INVISIBLE);
                Play5(vv_jerk);
                vv_jerk.setMediaController(mediaController);
                mediaController.setAnchorView(vv_jerk);
            }
        });
        start_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_front_video.setVisibility(View.INVISIBLE);
                img_front_video.setVisibility(View.INVISIBLE);
                vv_front.setVisibility(View.VISIBLE);
                start_front.setVisibility(View.INVISIBLE);
                Play6(vv_front);
                vv_front.setMediaController(mediaController);
                mediaController.setAnchorView(vv_front);
            }
        });
        start_deadsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_deadsn_video.setVisibility(View.INVISIBLE);
                img_deadsn_video.setVisibility(View.INVISIBLE);
                vv_deadsn.setVisibility(View.VISIBLE);
                start_deadsn.setVisibility(View.INVISIBLE);
                Play7(vv_deadsn);
                vv_deadsn.setMediaController(mediaController);
                mediaController.setAnchorView(vv_deadsn);
            }
        });
        start_deadcl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_deadcl_video.setVisibility(View.INVISIBLE);
                img_deadcl_video.setVisibility(View.INVISIBLE);
                vv_deadcl.setVisibility(View.VISIBLE);
                start_deadcl.setVisibility(View.INVISIBLE);
                Play8(vv_deadcl);
                vv_deadcl.setMediaController(mediaController);
                mediaController.setAnchorView(vv_deadcl);
            }
        });
        start_podt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_potd_video.setVisibility(View.INVISIBLE);
                img_podt_video.setVisibility(View.INVISIBLE);
                vv_podt.setVisibility(View.VISIBLE);
                start_podt.setVisibility(View.INVISIBLE);
                Play9(vv_podt);
                vv_podt.setMediaController(mediaController);
                mediaController.setAnchorView(vv_podt);
            }
        });
        start_bench.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_bench_video.setVisibility(View.INVISIBLE);
                img_bench_video.setVisibility(View.INVISIBLE);
                vv_bench.setVisibility(View.VISIBLE);
                start_bench.setVisibility(View.INVISIBLE);
                Play16(vv_bench);
                vv_bench.setMediaController(mediaController);
                mediaController.setAnchorView(vv_bench);
            }
        });
        start_deadpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_deadpr_video.setVisibility(View.INVISIBLE);
                img_deadpr_video.setVisibility(View.INVISIBLE);
                vv_deadpr.setVisibility(View.VISIBLE);
                start_deadpr.setVisibility(View.INVISIBLE);
                Play10(vv_deadpr);
                vv_deadpr.setMediaController(mediaController);
                mediaController.setAnchorView(vv_deadpr);
            }
        });
        start_benchpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_benchpr_video.setVisibility(View.INVISIBLE);
                img_benchpr_video.setVisibility(View.INVISIBLE);
                vv_benchpr.setVisibility(View.VISIBLE);
                start_benchpr.setVisibility(View.INVISIBLE);
                Play11(vv_benchpr);
                vv_podt.setMediaController(mediaController);
                mediaController.setAnchorView(vv_benchpr);
            }
        });
        start_biceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_biceps_video.setVisibility(View.INVISIBLE);
                img_biceps_video.setVisibility(View.INVISIBLE);
                vv_biceps.setVisibility(View.VISIBLE);
                start_biceps.setVisibility(View.INVISIBLE);
                Play12(vv_biceps);
                vv_biceps.setMediaController(mediaController);
                mediaController.setAnchorView(vv_biceps);
            }
        });
        start_triceps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_triceps_video.setVisibility(View.INVISIBLE);
                img_triceps_video.setVisibility(View.INVISIBLE);
                vv_triceps.setVisibility(View.VISIBLE);
                start_triceps.setVisibility(View.INVISIBLE);
                Play13(vv_triceps);
                vv_triceps.setMediaController(mediaController);
                mediaController.setAnchorView(vv_triceps);
            }
        });
        start_scr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_scr_video.setVisibility(View.INVISIBLE);
                img_scr_video.setVisibility(View.INVISIBLE);
                vv_scr.setVisibility(View.VISIBLE);
                start_scr.setVisibility(View.INVISIBLE);
                Play14(vv_scr);
                vv_scr.setMediaController(mediaController);
                mediaController.setAnchorView(vv_scr);
            }
        });
        start_planka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Invisble();
                Visible();
                tv_planka_video.setVisibility(View.INVISIBLE);
                img_planka_video.setVisibility(View.INVISIBLE);
                vv_planka.setVisibility(View.VISIBLE);
                start_planka.setVisibility(View.INVISIBLE);
                Play15(vv_planka);
                vv_planka.setMediaController(mediaController);
                mediaController.setAnchorView(vv_planka);
            }
        });
        return view;
    }

    private void Visible() {
        tv_biceps_video.setVisibility(View.VISIBLE);
        img_biceps_video.setVisibility(View.VISIBLE);
        tv_triceps_video.setVisibility(View.VISIBLE);
        img_triceps_video.setVisibility(View.VISIBLE);
        tv_scr_video.setVisibility(View.VISIBLE);
        img_scr_video.setVisibility(View.VISIBLE);
        tv_planka_video.setVisibility(View.VISIBLE);
        img_planka_video.setVisibility(View.VISIBLE);
        tv_bench_video.setVisibility(View.VISIBLE);
        img_bench_video.setVisibility(View.VISIBLE);
        tv_deadpr_video.setVisibility(View.VISIBLE);
        img_deadpr_video.setVisibility(View.VISIBLE);
        tv_benchpr_video.setVisibility(View.VISIBLE);
        img_benchpr_video.setVisibility(View.VISIBLE);
        tv_front_video.setVisibility(View.VISIBLE);
        img_front_video.setVisibility(View.VISIBLE);
        tv_potd_video.setVisibility(View.VISIBLE);
        img_podt_video.setVisibility(View.VISIBLE);
        tv_deadcl_video.setVisibility(View.VISIBLE);
        img_deadcl_video.setVisibility(View.VISIBLE);
        tv_deadsn_video.setVisibility(View.VISIBLE);
        img_deadsn_video.setVisibility(View.VISIBLE);
        tv_jerk_video.setVisibility(View.VISIBLE);
        img_jerk_video.setVisibility(View.VISIBLE);
        tv_front_video.setVisibility(View.VISIBLE);
        img_front_video.setVisibility(View.VISIBLE);
        tv_clean_video.setVisibility(View.VISIBLE);
        img_clean_video.setVisibility(View.VISIBLE);
        tv_nakloni_video.setVisibility(View.VISIBLE);
        img_nakloni_video.setVisibility(View.VISIBLE);
        tv_snatch_video.setVisibility(View.VISIBLE);
        img_snatch_video.setVisibility(View.VISIBLE);
        tv_squat_video.setVisibility(View.VISIBLE);
        img_squat_video.setVisibility(View.VISIBLE);
    }

    public void Play(View view) {
        vv_squat.start();
    }

    public void Play2(View view) {
        vv_nakloni.start();
    }

    public void Play3(View view) {
        vv_snatch.start();
    }

    public void Play4(View view) {
        vv_clean.start();
    }

    public void Play5(View view) {
        vv_jerk.start();
    }

    public void Play6(View view) {
        vv_front.start();
    }

    public void Play7(View view) {
        vv_deadsn.start();
    }

    public void Play8(View view) {
        vv_deadcl.start();
    }

    public void Play9(View view) {
        vv_podt.start();
    }

    public void Play10(View view) {
        vv_deadpr.start();
    }

    public void Play11(View view) {
        vv_benchpr.start();
    }

    public void Play12(View view) {
        vv_biceps.start();
    }

    public void Play13(View view) {
        vv_triceps.start();
    }

    public void Play14(View view) {
        vv_scr.start();
    }

    public void Play15(View view) {
        vv_planka.start();
    }
    public void Play16(View view) {
        vv_bench.start();
    }

    private void scrollDialogDown() {
        sv.post(new Runnable() {

            @Override
            public void run() {
                sv.fullScroll(ScrollView.FOCUS_UP);
            }
        });

    }

    private void Invisble() {
        vv_squat.setVisibility(View.INVISIBLE);
        vv_snatch.setVisibility(View.INVISIBLE);
        vv_nakloni.setVisibility(View.INVISIBLE);
        vv_clean.setVisibility(View.INVISIBLE);
        vv_jerk.setVisibility(View.INVISIBLE);
        vv_front.setVisibility(View.INVISIBLE);
        vv_deadsn.setVisibility(View.INVISIBLE);
        vv_deadcl.setVisibility(View.INVISIBLE);
        vv_podt.setVisibility(View.INVISIBLE);
        vv_bench.setVisibility(View.INVISIBLE);
        vv_deadpr.setVisibility(View.INVISIBLE);
        vv_benchpr.setVisibility(View.INVISIBLE);
        vv_biceps.setVisibility(View.INVISIBLE);
        vv_triceps.setVisibility(View.INVISIBLE);
        vv_scr.setVisibility(View.INVISIBLE);
        vv_planka.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onStart() {
        super.onStart();
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
                vv_nakloni.setVideoURI(uri);

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
        four.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_clean.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        five.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_jerk.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        six.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_front.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        seven.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_deadsn.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        eight.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_deadcl.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        nine.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_podt.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ten.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_bench.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        eleven.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_deadpr.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        twelve.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_benchpr.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        threeteen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_biceps.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        fourteen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_triceps.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        fiveteen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_scr.setVideoURI(uri);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        sixteen.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Uri uri = Uri.parse(link);
                vv_planka.setVideoURI(uri);

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
        four2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_clean_video);
                Picasso.get().load(link).into(img_jerk_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        five2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_front_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        six2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_deadsn_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        seven2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_deadcl_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        eight2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_podt_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        nine2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_bench_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        ten2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_deadpr_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        eleven2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_benchpr_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        twelve2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_biceps_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        threeteen2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_triceps_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        fourteen2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_scr_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        fiveteen2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String link = dataSnapshot.getValue(String.class);
                Picasso.get().load(link).into(img_planka_video);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
