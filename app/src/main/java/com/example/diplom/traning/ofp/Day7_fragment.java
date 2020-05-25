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

public class Day7_fragment extends Fragment {
    View view;
    private ImageView imageView, imageView2, imageView_done, imageView_done2;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("56");
    private DatabaseReference two = databaseReference.child("57");
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference resultsList, resultsList2, resultsList6,
            resultsList1_week2, resultsList2_week2,
            resultsList1_week3, resultsList2_week3,
            resultsList1_week4, resultsList2_week4,
            resultsList1_week5, resultsList2_week5,
            resultsList1_week6, resultsList2_week6,
            resultsList1_week7, resultsList2_week7,
            resultsList1_week8, resultsList2_week8;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    Integer pos;
    Button btn_squat, btn_nakloni;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.day7_fragment, container, false);
        imageView = view.findViewById(R.id.img_scr);
        imageView2 = view.findViewById(R.id.img_planka);
        btn_squat = view.findViewById(R.id.btn_scr);
        btn_nakloni = view.findViewById(R.id.btn_planka);
        imageView_done = view.findViewById(R.id.img_press_done);
        imageView_done2 = view.findViewById(R.id.img_press_done2);

        resultsList6 = firebaseDatabase2.getReference("Results").child(user.getUid());

        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Press");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Planka");

        resultsList1_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Press");
        resultsList2_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Planka");

        resultsList1_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Press");
        resultsList2_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Planka");

        resultsList1_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Press");
        resultsList2_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Planka");

        resultsList1_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Press");
        resultsList2_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Planka");

        resultsList1_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Press");
        resultsList2_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Planka");

        resultsList1_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Press");
        resultsList2_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Planka");

        resultsList1_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Press");
        resultsList2_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Planka");


        btn_squat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Press.class));
            }
        });
        btn_nakloni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Planka.class));
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
        resultsList6.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    pos = Integer.parseInt(weight);
                    switch (pos) {
                        case 1:
                            resultsList.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2.child("planka_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 2:
                            resultsList1_week2.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week2.child("planka_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 3:
                            resultsList1_week3.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week3.child("planka_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 4:
                            resultsList1_week4.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week4.child("planka_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 5:
                            resultsList1_week5.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week5.child("planka_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 6:
                            resultsList1_week6.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week6.child("planka_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 7:
                            resultsList1_week7.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week7.child("planka_done").addValueEventListener(new ValueEventListener() {
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
                            break;
                        case 8:
                            resultsList1_week8.child("press_done").addValueEventListener(new ValueEventListener() {
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
                            resultsList2_week8.child("planka_done").addValueEventListener(new ValueEventListener() {
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
