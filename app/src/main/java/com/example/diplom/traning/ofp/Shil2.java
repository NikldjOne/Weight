package com.example.diplom.traning.ofp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.diplom.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Shil2 extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("46");
    ImageView imageView;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference resultsList_week1, week_done, resultsList_week2, resultsList_week3, resultsList_week4,
            resultsList_week5, resultsList_week6, resultsList_week7, resultsList_week8;
    Button closeypr_shil;
    TextView tv_result;
    RelativeLayout layout;
    int pos,pos2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shil2);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_10);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.img_shil2_window);
        closeypr_shil = findViewById(R.id.close_ypr_shil2);
        tv_result = findViewById(R.id.tv_ypr_shil2);
        layout = findViewById(R.id.layout_done_shil26);
        week_done = firebaseDatabase.getReference("Results").child(user.getUid());
        resultsList_week1 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week1");
        resultsList_week2 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week2");
        resultsList_week3 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week3");
        resultsList_week4 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week4");
        resultsList_week5 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week5");
        resultsList_week6 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week6");
        resultsList_week7 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week7");
        resultsList_week8 = firebaseDatabase.getReference("Results").child(user.getUid()).child("Week8");
        result();
        closeypr_shil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                week_done.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            pos = Integer.parseInt(weight);
                            switch (pos) {
                                case 1:
                                    resultsList_week1.child("day4_done").setValue("1");
                                    finish();
                                    break;
                                case 2:
                                    resultsList_week2.child("day4_done").setValue("1");
                                    finish();
                                    break;
                                case 3:
                                    resultsList_week3.child("day4_done").setValue("1");
                                    finish();
                                    break;
                                case 4:
                                    resultsList_week4.child("day4_done").setValue("1");
                                    finish();
                                    break;
                                case 5:
                                    resultsList_week5.child("day4_done").setValue("1");
                                    finish();
                                    break;
                                case 6:
                                    resultsList_week6.child("day4_done").setValue("1");
                                    finish();
                                    break;
                                case 7:
                                    resultsList_week7.child("day4_done").setValue("1");
                                    finish();
                                    break;
                                case 8:
                                    resultsList_week8.child("day4_done").setValue("1");
                                    finish();
                                    break;
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    private void result() {
        week_done.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null){
                    pos = Integer.parseInt(weight);
                    switch (pos){
                        case 1: resultsList_week1.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                            break;
                        case 2: resultsList_week2.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                            break;
                        case 3: resultsList_week3.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                            break;
                        case 4: resultsList_week4.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                            break;
                        case 5: resultsList_week5.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                            break;
                        case 6: resultsList_week6.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                            break;
                        case 7: resultsList_week7.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                            }
                        });
                            break;
                        case 8: resultsList_week8.child("day4_done").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                String weight = dataSnapshot.getValue(String.class);
                                if (weight != null) {
                                    tv_result.setText("День завершен");
                                    closeypr_shil.setVisibility(View.INVISIBLE);
                                } else {
                                    tv_result.setVisibility(View.INVISIBLE);
                                    closeypr_shil.setVisibility(View.VISIBLE);
                                }
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
    }
}
