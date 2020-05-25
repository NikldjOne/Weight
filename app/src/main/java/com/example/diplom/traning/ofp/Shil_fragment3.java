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

public class Shil_fragment3 extends Fragment {
    View view;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("46");
    ImageView imageView,imageView2;
    Button btn_shil;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference resultsList_week1, resultsList2, resultsList_week2, resultsList_week3, resultsList_week4,
            resultsList_week5, resultsList_week6, resultsList_week7, resultsList_week8;
    int pos;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shil_fragment3,container,false);
        imageView = view.findViewById(R.id.img_shil3_week2);
        resultsList_week1 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week1");
        resultsList_week2 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week2");
        resultsList_week3 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week3");
        resultsList_week4 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week4");
        resultsList_week5 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week5");
        resultsList_week6 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week6");
        resultsList_week7 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week7");
        resultsList_week8 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week8");
        resultsList2 = firebaseDatabase.getReference("Results").child(user.getUid());
        btn_shil = view.findViewById(R.id.btn_shil3_week2);
        imageView2 = view.findViewById(R.id.img_shil3_done_week2);
        btn_shil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Shil3.class));
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


        resultsList2.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    pos = Integer.parseInt(weight);
                    switch (pos) {
                        case 1:
                            resultsList_week1.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 2:
                            resultsList_week2.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 3:
                            resultsList_week3.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 4:
                            resultsList_week4.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 5:
                            resultsList_week5.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 6:
                            resultsList_week6.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 7:
                            resultsList_week7.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {
                                }
                            });
                            break;
                        case 8:
                            resultsList_week8.child("day6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        imageView2.setBackgroundResource(R.drawable.done);
                                    } else
                                        imageView2.setBackgroundResource(R.drawable.round2);
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
