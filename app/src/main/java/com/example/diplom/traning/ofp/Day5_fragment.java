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
    private DatabaseReference resultsList, resultsList2, resultsList3, resultsList4, resultsList5, resultsList6, resultsList7,
            resultsList1_week2, resultsList2_week2, resultsList3_week2, resultsList4_week2, resultsList5_week2,
            resultsList1_week3, resultsList2_week3, resultsList3_week3, resultsList4_week3, resultsList5_week3,
            resultsList1_week4, resultsList2_week4, resultsList3_week4, resultsList4_week4, resultsList5_week4,
            resultsList1_week5, resultsList2_week5, resultsList3_week5, resultsList4_week5, resultsList5_week5,
            resultsList1_week6, resultsList2_week6, resultsList3_week6, resultsList4_week6, resultsList5_week6,
            resultsList1_week7, resultsList2_week7, resultsList3_week7, resultsList4_week7, resultsList5_week7,
            resultsList1_week8, resultsList2_week8, resultsList3_week8, resultsList4_week8, resultsList5_week8;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Integer weight2;
    Integer pos;

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
        resultsList6 = firebaseDatabase2.getReference("Results").child(user.getUid());
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Bench");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Dead_Press");
        resultsList3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Bench_Press");
        resultsList4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Biceps");
        resultsList5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Triceps");

        resultsList1_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Bench");
        resultsList2_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Dead_Press");
        resultsList3_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Bench_Press");
        resultsList4_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Biceps");
        resultsList5_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Triceps");

        resultsList1_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Bench");
        resultsList2_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Dead_Press");
        resultsList3_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Bench_Press");
        resultsList4_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Biceps");
        resultsList5_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Triceps");

        resultsList1_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Bench");
        resultsList2_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Dead_Press");
        resultsList3_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Bench_Press");
        resultsList4_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Biceps");
        resultsList5_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Triceps");

        resultsList1_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Bench");
        resultsList2_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Dead_Press");
        resultsList3_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Bench_Press");
        resultsList4_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Biceps");
        resultsList5_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Triceps");

        resultsList1_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Bench");
        resultsList2_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Dead_Press");
        resultsList3_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Bench_Press");
        resultsList4_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Biceps");
        resultsList5_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Triceps");

        resultsList1_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Bench");
        resultsList2_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Dead_Press");
        resultsList3_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Bench_Press");
        resultsList4_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Biceps");
        resultsList5_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Triceps");

        resultsList1_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Bench");
        resultsList2_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Dead_Press");
        resultsList3_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Bench_Press");
        resultsList4_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Biceps");
        resultsList5_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Triceps");
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
        resultsList6.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    pos = Integer.parseInt(weight);
                    switch (pos) {
                        case 1:
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
                            resultsList5.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 2:
                            resultsList1_week2.child("bench_done").addValueEventListener(new ValueEventListener(){
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
                            resultsList2_week2.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList3_week2.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList4_week2.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList5_week2.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 3:
                            resultsList1_week3.child("bench_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week3.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList3_week3.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList4_week3.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList5_week3.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 4:
                            resultsList1_week4.child("bench_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week4.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList3_week4.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList4_week4.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList5_week4.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 5:
                            resultsList1_week5.child("bench_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week5.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList3_week5.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList4_week5.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList5_week5.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 6:
                            resultsList1_week6.child("bench_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week6.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList3_week6.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList4_week6.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList5_week6.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 7:
                            resultsList1_week7.child("bench_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week7.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList3_week7.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList4_week7.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList5_week7.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 8:
                            resultsList1_week8.child("bench_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week8.child("deadpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList3_week8.child("beanchpr_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList4_week8.child("biceps_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList5_week8.child("triceps_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }
}
