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
    private ImageView imageView, imageView2, imageView3, imageView4, imageView5, imageView_done, block_day1, imageView_done2, imageView_done3,
            imageView_done4, imageView_done5;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("41");
    private DatabaseReference two = databaseReference.child("42");
    private DatabaseReference three = databaseReference.child("43");
    private DatabaseReference four = databaseReference.child("44");
    private DatabaseReference five = databaseReference.child("45");
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference resultsList, resultsList2, resultsList3, resultsList4, resultsList5, resultsList6, resultsList7,
            resultsList_week2, resultsList2_week2, resultsList3_week2, resultsList4_week2, resultsList5_week2,
            resultsList_week3, resultsList2_week3, resultsList3_week3, resultsList4_week3, resultsList5_week3,
            resultsList_week4, resultsList2_week4, resultsList3_week4, resultsList4_week4, resultsList5_week4,
            resultsList_week5, resultsList2_week5, resultsList3_week5, resultsList4_week5, resultsList5_week5,
            resultsList_week6, resultsList2_week6, resultsList3_week6, resultsList4_week6, resultsList5_week6,
            resultsList_week7, resultsList2_week7, resultsList3_week7, resultsList4_week7, resultsList5_week7,
            resultsList_week8, resultsList2_week8, resultsList3_week8, resultsList4_week8, resultsList5_week8;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Integer pos;

    Button btn_squat, btn_nakloni, btn_vihodi, btn_snatch, btn_jerk;

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
        imageView_done4 = view.findViewById(R.id.img_squat_done4);
        imageView_done5 = view.findViewById(R.id.img_squat_done5);
        btn_jerk = view.findViewById(R.id.btn_jerk);
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Squat");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Nakloni");
        resultsList3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Vihodi");
        resultsList4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Snatch");
        resultsList5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Jerk");
        resultsList6 = firebaseDatabase2.getReference("Results").child(user.getUid());

        resultsList_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Squat");
        resultsList2_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Nakloni");
        resultsList3_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Vihodi");
        resultsList4_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Snatch");
        resultsList5_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Jerk");

        resultsList_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Squat");
        resultsList2_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Nakloni");
        resultsList3_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Vihodi");
        resultsList4_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Snatch");
        resultsList5_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Jerk");

        resultsList_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Squat");
        resultsList2_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Nakloni");
        resultsList3_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Vihodi");
        resultsList4_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Snatch");
        resultsList5_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Jerk");

        resultsList_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Squat");
        resultsList2_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Nakloni");
        resultsList3_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Vihodi");
        resultsList4_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Snatch");
        resultsList5_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Jerk");

        resultsList_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Squat");
        resultsList2_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Nakloni");
        resultsList3_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Vihodi");
        resultsList4_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Snatch");
        resultsList5_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Jerk");

        resultsList_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Squat");
        resultsList2_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Nakloni");
        resultsList3_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Vihodi");
        resultsList4_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Snatch");
        resultsList5_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Jerk");

        resultsList_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Squat");
        resultsList2_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Nakloni");
        resultsList3_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Vihodi");
        resultsList4_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Snatch");
        resultsList5_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Jerk");
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
        btn_jerk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Jerk.class));
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
                            resultsList.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
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
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
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
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done5.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 2:
                            resultsList_week2.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList2_week2.child("nakloni_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList3_week2.child("vihodi_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4_week2.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5_week2.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done5.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 3:
                            resultsList_week3.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList2_week3.child("nakloni_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList3_week3.child("vihodi_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4_week3.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5_week3.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done5.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 4:
                            resultsList_week4.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList2_week4.child("nakloni_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList3_week4.child("vihodi_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4_week4.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5_week4.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done5.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 5:
                            resultsList_week5.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList2_week5.child("nakloni_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList3_week5.child("vihodi_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4_week5.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5_week5.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done5.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 6:
                            resultsList_week6.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList2_week6.child("nakloni_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList3_week6.child("vihodi_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4_week6.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5_week6.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done5.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 7:
                            resultsList_week7.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList2_week7.child("nakloni_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList3_week7.child("vihodi_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4_week7.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5_week7.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done5.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 8:
                            resultsList_week8.child("squat_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList2_week8.child("nakloni_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList3_week8.child("vihodi_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done3.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done3.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList4_week8.child("snatch_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done4.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView_done4.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            resultsList5_week8.child("jerk_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView_done5.setBackgroundResource(R.drawable.done);
                                    } else
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
