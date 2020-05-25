package com.example.diplom.traning.ofp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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

public class Podt extends AppCompatActivity {
    private ImageView imageView, img_squat_left, img_squat_right, img_squat_left2, img_squat_left3, img_squat_left4,
            img_squat_left5, img_squat_right2, img_squat_right3, img_squat_right4, img_squat_right5, img_squat_done;
    private LinearLayout layout, layout2, layout3, layout4, layout5, layout6;
    private TextView tv_weight, tv_result_squat, tv_result_squat2, tv_result_squat3, tv_result_squat4, tv_result_squat5;
    private Button btn_squat_back, btn_squat_back2, btn_squat_back3, btn_squat_back4, btn_squat_back5,
            btn_squat_add, btn_squat_add2, btn_squat_add3, btn_squat_add4, btn_squat_add5, close_ypr,
            btn_squat_done, btn_squat_done2, btn_squat_done3, btn_squat_done4, btn_squat_done5;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("50");
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private Double weight_dec;
    private Integer result = 0, result2 = 0, result3 = 0, result4 = 0, result5 = 0;
    private String ed_result, ed_result2, ed_result3, ed_result4, ed_result5;
    private EditText edit_result, edit_result2, edit_result3, edit_result4, edit_result5;
    private Boolean podhod = false, podhod2 = false, podhod3 = false, podhod4 = false, podhod5 = false;
    String stringdouble;
    private DatabaseReference weightList, resultsList, resultsList2, resultsList3, resultsList_week2,
            resultsList_week3, resultsList_week4, resultsList_week5, resultsList_week6, resultsList_week7, resultsList_week8,
            done_week1, done_week2, done_week3, done_week4, done_week5, done_week6, done_week7, done_week8;
    int position, position2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podt);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.img_podt2);
        tv_weight = findViewById(R.id.tv_weight_podt);
        weightList = firebaseDatabase2.getReference("Records").child(user.getUid());
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1").child("Podt");

        done_week1 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1");
        done_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2");
        done_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3");
        done_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4");
        done_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5");
        done_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6");
        done_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7");
        done_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid());
        resultsList_week2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2").child("Podt");
        resultsList_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3").child("Podt");
        resultsList_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4").child("Podt");
        resultsList_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5").child("Podt");
        resultsList_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6").child("Podt");
        resultsList_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7").child("Podt");
        resultsList_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8").child("Podt");
        close_ypr = findViewById(R.id.close_ypr_podt);
        close_ypr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (podhod == true && podhod2 == true && podhod3 == true && podhod4 == true) {
                    resultsList2.child("Week_done").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String weight = dataSnapshot.getValue(String.class);
                            if (weight != null) {
                                position = Integer.parseInt(weight);
                                switch (position) {
                                    case 1:
                                        done_week1.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList.child("weight").setValue(stringdouble);
                                                                resultsList.child("kol-vo").setValue(ed_result);
                                                                resultsList.child("kol-vo2").setValue(ed_result2);
                                                                resultsList.child("kol-vo3").setValue(ed_result3);
                                                                resultsList.child("kol-vo4").setValue(ed_result4);
                                                                resultsList.child("podt_done").setValue("1");
                                                                done_week1.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        break;
                                    case 2:
                                        done_week2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList_week2.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList_week2.child("weight").setValue(stringdouble);
                                                                resultsList_week2.child("kol-vo").setValue(ed_result);
                                                                resultsList_week2.child("kol-vo2").setValue(ed_result2);
                                                                resultsList_week2.child("kol-vo3").setValue(ed_result3);
                                                                resultsList_week2.child("kol-vo4").setValue(ed_result4);
                                                                resultsList_week2.child("podt_done").setValue("1");
                                                                done_week2.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        break;
                                    case 3:
                                        done_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList_week3.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList_week3.child("weight").setValue(stringdouble);
                                                                resultsList_week3.child("kol-vo").setValue(ed_result);
                                                                resultsList_week3.child("kol-vo2").setValue(ed_result2);
                                                                resultsList_week3.child("kol-vo3").setValue(ed_result3);
                                                                resultsList_week3.child("kol-vo4").setValue(ed_result4);
                                                                resultsList_week3.child("podt_done").setValue("1");
                                                                done_week3.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        break;
                                    case 4:
                                        done_week4.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList_week4.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList_week4.child("weight").setValue(stringdouble);
                                                                resultsList_week4.child("kol-vo").setValue(ed_result);
                                                                resultsList_week4.child("kol-vo2").setValue(ed_result2);
                                                                resultsList_week4.child("kol-vo3").setValue(ed_result3);
                                                                resultsList_week4.child("kol-vo4").setValue(ed_result4);
                                                                resultsList_week4.child("podt_done").setValue("1");
                                                                done_week4.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        break;
                                    case 5:
                                        done_week5.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList_week5.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList_week5.child("weight").setValue(stringdouble);
                                                                resultsList_week5.child("kol-vo").setValue(ed_result);
                                                                resultsList_week5.child("kol-vo2").setValue(ed_result2);
                                                                resultsList_week5.child("kol-vo3").setValue(ed_result3);
                                                                resultsList_week5.child("kol-vo4").setValue(ed_result4);
                                                                resultsList_week5.child("podt_done").setValue("1");
                                                                done_week5.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        break;
                                    case 6:
                                        done_week6.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList_week6.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList_week6.child("weight").setValue(stringdouble);
                                                                resultsList_week6.child("kol-vo").setValue(ed_result);
                                                                resultsList_week6.child("kol-vo2").setValue(ed_result2);
                                                                resultsList_week6.child("kol-vo3").setValue(ed_result3);
                                                                resultsList_week6.child("kol-vo4").setValue(ed_result4);
                                                                resultsList_week6.child("podt_done").setValue("1");
                                                                done_week6.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        break;
                                    case 7:
                                        done_week7.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList_week7.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList_week7.child("weight").setValue(stringdouble);
                                                                resultsList_week7.child("kol-vo").setValue(ed_result);
                                                                resultsList_week7.child("kol-vo2").setValue(ed_result2);
                                                                resultsList_week7.child("kol-vo3").setValue(ed_result3);
                                                                resultsList_week7.child("kol-vo4").setValue(ed_result4);
                                                                resultsList_week7.child("podt_done").setValue("1");
                                                                done_week7.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        break;
                                    case 8:
                                        done_week8.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    resultsList_week8.child("podt_done").addValueEventListener(new ValueEventListener() {
                                                        @Override
                                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                            String weight = dataSnapshot.getValue(String.class);
                                                            if (weight == null) {
                                                                position = 0;
                                                            } else if (weight != null) {
                                                                position = Integer.parseInt(weight);
                                                            }
                                                            if (position == 1) {
                                                            }
                                                            if (position == 0) {
                                                                resultsList_week8.child("weight").setValue(stringdouble);
                                                                resultsList_week8.child("kol-vo").setValue(ed_result);
                                                                resultsList_week8.child("kol-vo2").setValue(ed_result2);
                                                                resultsList_week8.child("kol-vo3").setValue(ed_result3);
                                                                resultsList_week8.child("kol-vo4").setValue(ed_result4);
                                                                resultsList_week8.child("podt_done").setValue("1");
                                                                done_week8.child("day3_done").setValue("1");
                                                                finish();
                                                            }


                                                        }

                                                        @Override
                                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                                        }
                                                    });

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
                
                } else
                    Toast.makeText(Podt.this, "Вы не закончили все подходы", Toast.LENGTH_SHORT).show();
            }
        });
        resultPodhod();
        SquatPodhod();
        SquatPodhod2();
        SquatPodhod3();
        SquatPodhod4();

    }

    private void resultPodhod() {
        resultsList2.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    position2 = Integer.parseInt(weight);
                    switch (position2) {
                        case 1:
                            done_week1.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 2:
                            done_week2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week2.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week2.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week2.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week2.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week2.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 3:
                            done_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week3.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 4:
                            done_week4.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week4.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 5:
                            done_week5.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week5.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 6:
                            done_week6.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week6.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 7:
                            done_week7.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week7.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 8:
                            done_week8.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week8.child("kol-vo").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("kol-vo2").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result2 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("kol-vo3").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result3 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("kol-vo4").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String povtor = dataSnapshot.getValue(String.class);
                                                if (povtor != null) {
                                                    ed_result4 = povtor;
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("podt_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                String weight = dataSnapshot.getValue(String.class);
                                                if (weight != null) {
                                                    btn_squat_back.setVisibility(View.INVISIBLE);
                                                    btn_squat_add.setVisibility(View.INVISIBLE);
                                                    img_squat_right.setVisibility(View.INVISIBLE);
                                                    img_squat_left.setVisibility(View.INVISIBLE);
                                                    edit_result.setVisibility(View.INVISIBLE);
                                                    tv_result_squat.setVisibility(View.VISIBLE);

                                                    btn_squat_back2.setVisibility(View.INVISIBLE);
                                                    btn_squat_add2.setVisibility(View.INVISIBLE);
                                                    img_squat_right2.setVisibility(View.INVISIBLE);
                                                    img_squat_left2.setVisibility(View.INVISIBLE);
                                                    edit_result2.setVisibility(View.INVISIBLE);
                                                    tv_result_squat2.setVisibility(View.VISIBLE);

                                                    btn_squat_back3.setVisibility(View.INVISIBLE);
                                                    btn_squat_add3.setVisibility(View.INVISIBLE);
                                                    img_squat_right3.setVisibility(View.INVISIBLE);
                                                    img_squat_left3.setVisibility(View.INVISIBLE);
                                                    edit_result3.setVisibility(View.INVISIBLE);
                                                    tv_result_squat3.setVisibility(View.VISIBLE);

                                                    btn_squat_back4.setVisibility(View.INVISIBLE);
                                                    btn_squat_add4.setVisibility(View.INVISIBLE);
                                                    img_squat_right4.setVisibility(View.INVISIBLE);
                                                    img_squat_left4.setVisibility(View.INVISIBLE);
                                                    edit_result4.setVisibility(View.INVISIBLE);
                                                    tv_result_squat4.setVisibility(View.VISIBLE);


                                                    layout.setBackgroundResource(R.drawable.done);
                                                    layout2.setBackgroundResource(R.drawable.done);
                                                    layout3.setBackgroundResource(R.drawable.done);
                                                    layout4.setBackgroundResource(R.drawable.done);

                                                    tv_result_squat.setText(ed_result);
                                                    tv_result_squat2.setText(ed_result2);
                                                    tv_result_squat3.setText(ed_result3);
                                                    tv_result_squat4.setText(ed_result4);
                                                    layout6 = findViewById(R.id.layout_done_podt6);
                                                    layout6.setVisibility(View.INVISIBLE);
                                                    close_ypr.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                            }
                                        });
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


    private void SquatPodhod4() {
        tv_result_squat4 = findViewById(R.id.tv_result_podt4);
        edit_result4 = findViewById(R.id.ed_result_podt4);
        btn_squat_add4 = findViewById(R.id.btn_podt_add4);
        btn_squat_back4 = findViewById(R.id.btn_podt_back4);
        btn_squat_done4 = findViewById(R.id.btn_podt_done4);
        layout4 = findViewById(R.id.layout_done_podt4);
        img_squat_left4 = findViewById(R.id.img_podt_left4);
        img_squat_right4 = findViewById(R.id.img_podt_right4);


        btn_squat_add4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAdd4();
            }
        });
        btn_squat_back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edBack4();
            }
        });
        btn_squat_done4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                podhodDone4();
            }
        });
    }

    private void SquatPodhod3() {
        tv_result_squat3 = findViewById(R.id.tv_result_podt3);
        edit_result3 = findViewById(R.id.ed_result_podt3);
        btn_squat_add3 = findViewById(R.id.btn_podt_add3);
        btn_squat_back3 = findViewById(R.id.btn_podt_back3);
        btn_squat_done3 = findViewById(R.id.btn_podt_done3);
        layout3 = findViewById(R.id.layout_done_podt3);
        img_squat_left3 = findViewById(R.id.img_podt_left3);
        img_squat_right3 = findViewById(R.id.img_podt_right3);


        btn_squat_add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAdd3();
            }
        });
        btn_squat_back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edBack3();
            }
        });
        btn_squat_done3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                podhodDone3();
            }
        });
    }

    private void SquatPodhod2() {
        tv_result_squat2 = findViewById(R.id.tv_result_podt2);
        edit_result2 = findViewById(R.id.ed_result_podt2);
        btn_squat_add2 = findViewById(R.id.btn_podt_add2);
        btn_squat_back2 = findViewById(R.id.btn_podt_back2);
        btn_squat_done2 = findViewById(R.id.btn_podt_done2);
        layout2 = findViewById(R.id.layout_done_podt2);
        img_squat_left2 = findViewById(R.id.img_podt_left2);
        img_squat_right2 = findViewById(R.id.img_podt_right2);


        btn_squat_add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAdd2();
            }
        });
        btn_squat_back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edBack2();
            }
        });
        btn_squat_done2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                podhodDone2();
            }
        });
    }

    private void SquatPodhod() {
        tv_result_squat = findViewById(R.id.tv_result_podt);
        edit_result = findViewById(R.id.ed_result_podt);
        btn_squat_add = findViewById(R.id.btn_podt_add);
        btn_squat_back = findViewById(R.id.btn_podt_back);
        btn_squat_done = findViewById(R.id.btn_podt_done);
        layout = findViewById(R.id.layout_done_podt);
        img_squat_left = findViewById(R.id.img_podt_left);
        img_squat_right = findViewById(R.id.img_podt_right);

        btn_squat_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edAdd();
            }
        });
        btn_squat_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edBack();
            }
        });
        btn_squat_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                podhodDone();
            }
        });
    }


    private void podhodDone4() {
        if (podhod4 == false) {
            podhod4 = true;
            btn_squat_back4.setVisibility(View.INVISIBLE);
            btn_squat_add4.setVisibility(View.INVISIBLE);
            img_squat_right4.setVisibility(View.INVISIBLE);
            img_squat_left4.setVisibility(View.INVISIBLE);
            edit_result4.setVisibility(View.INVISIBLE);
            tv_result_squat4.setVisibility(View.VISIBLE);
            if (result4 == 0) {
                ed_result4 = "0";
                tv_result_squat4.setText(ed_result4);
            } else
                tv_result_squat4.setText(ed_result4);
            layout4.setBackgroundResource(R.drawable.done);
        } else if (podhod4 == true) {
            podhod4 = false;
            img_squat_right4.setVisibility(View.VISIBLE);
            img_squat_left4.setVisibility(View.VISIBLE);
            btn_squat_back4.setVisibility(View.VISIBLE);
            btn_squat_add4.setVisibility(View.VISIBLE);
            edit_result4.setVisibility(View.VISIBLE);
            tv_result_squat4.setVisibility(View.INVISIBLE);
            layout4.setBackgroundResource(R.drawable.round2);
        }
    }

    private void podhodDone3() {
        if (podhod3 == false) {
            podhod3 = true;
            btn_squat_back3.setVisibility(View.INVISIBLE);
            btn_squat_add3.setVisibility(View.INVISIBLE);
            img_squat_right3.setVisibility(View.INVISIBLE);
            img_squat_left3.setVisibility(View.INVISIBLE);
            edit_result3.setVisibility(View.INVISIBLE);
            tv_result_squat3.setVisibility(View.VISIBLE);
            if (result3 == 0) {
                ed_result3 = "0";
                tv_result_squat3.setText(ed_result3);
            } else
                tv_result_squat3.setText(ed_result3);
            layout3.setBackgroundResource(R.drawable.done);
        } else if (podhod2 == true) {
            podhod3 = false;
            img_squat_right3.setVisibility(View.VISIBLE);
            img_squat_left3.setVisibility(View.VISIBLE);
            btn_squat_back3.setVisibility(View.VISIBLE);
            btn_squat_add3.setVisibility(View.VISIBLE);
            edit_result3.setVisibility(View.VISIBLE);
            tv_result_squat3.setVisibility(View.INVISIBLE);
            layout3.setBackgroundResource(R.drawable.round2);
        }
    }

    private void podhodDone2() {
        if (podhod2 == false) {
            podhod2 = true;
            btn_squat_back2.setVisibility(View.INVISIBLE);
            btn_squat_add2.setVisibility(View.INVISIBLE);
            img_squat_right2.setVisibility(View.INVISIBLE);
            img_squat_left2.setVisibility(View.INVISIBLE);
            edit_result2.setVisibility(View.INVISIBLE);
            tv_result_squat2.setVisibility(View.VISIBLE);
            if (result2 == 0) {
                ed_result2 = "0";
                tv_result_squat2.setText(ed_result2);
            } else
                tv_result_squat2.setText(ed_result2);
            layout2.setBackgroundResource(R.drawable.done);
        } else if (podhod2 == true) {
            podhod2 = false;
            img_squat_right2.setVisibility(View.VISIBLE);
            img_squat_left2.setVisibility(View.VISIBLE);
            btn_squat_back2.setVisibility(View.VISIBLE);
            btn_squat_add2.setVisibility(View.VISIBLE);
            edit_result2.setVisibility(View.VISIBLE);
            tv_result_squat2.setVisibility(View.INVISIBLE);
            layout2.setBackgroundResource(R.drawable.round2);
        }
    }

    private void podhodDone() {
        if (podhod == false) {
            podhod = true;
            btn_squat_back.setVisibility(View.INVISIBLE);
            btn_squat_add.setVisibility(View.INVISIBLE);
            img_squat_right.setVisibility(View.INVISIBLE);
            img_squat_left.setVisibility(View.INVISIBLE);
            edit_result.setVisibility(View.INVISIBLE);
            tv_result_squat.setVisibility(View.VISIBLE);
            if (result == 0) {
                ed_result = "0";
                tv_result_squat.setText(ed_result);
            } else
                tv_result_squat.setText(ed_result);
            layout.setBackgroundResource(R.drawable.done);
        } else if (podhod == true) {
            podhod = false;
            img_squat_right.setVisibility(View.VISIBLE);
            img_squat_left.setVisibility(View.VISIBLE);
            btn_squat_back.setVisibility(View.VISIBLE);
            btn_squat_add.setVisibility(View.VISIBLE);
            edit_result.setVisibility(View.VISIBLE);
            tv_result_squat.setVisibility(View.INVISIBLE);
            layout.setBackgroundResource(R.drawable.round2);
        }
    }


    private void edAdd() {
        result = Integer.parseInt(edit_result.getText().toString());
        result++;
        ed_result = result.toString();
        edit_result.setText(ed_result);
    }

    private void edAdd3() {
        result3 = Integer.parseInt(edit_result3.getText().toString());
        result3++;
        ed_result3 = result3.toString();
        edit_result3.setText(ed_result3);
    }

    private void edAdd4() {
        result4 = Integer.parseInt(edit_result4.getText().toString());
        result4++;
        ed_result4 = result4.toString();
        edit_result4.setText(ed_result4);
    }


    private void edAdd2() {
        result2 = Integer.parseInt(edit_result2.getText().toString());
        result2++;
        ed_result2 = result2.toString();
        edit_result2.setText(ed_result2);
    }

    private void edBack() {
        result = Integer.parseInt(edit_result.getText().toString());
        if (result == 0) {
            ed_result = "0";
            edit_result.setText(ed_result);
        } else if (result > 0) {
            result--;
            ed_result = result.toString();
            edit_result.setText(ed_result);
        }
    }

    private void edBack2() {
        result2 = Integer.parseInt(edit_result2.getText().toString());
        if (result2 == 0) {
            ed_result2 = "0";
            edit_result2.setText(ed_result2);
        } else if (result2 > 0) {
            result2--;
            ed_result2 = result2.toString();
            edit_result2.setText(ed_result2);
        }
    }

    private void edBack3() {
        result3 = Integer.parseInt(edit_result3.getText().toString());
        if (result3 == 0) {
            ed_result3 = "0";
            edit_result3.setText(ed_result3);
        } else if (result3 > 0) {
            result3--;
            ed_result3 = result3.toString();
            edit_result3.setText(ed_result3);
        }
    }

    private void edBack4() {
        result4 = Integer.parseInt(edit_result4.getText().toString());
        if (result4 == 0) {
            ed_result4 = "0";
            edit_result4.setText(ed_result4);
        } else if (result4 > 0) {
            result4--;
            ed_result4 = result4.toString();
            edit_result4.setText(ed_result4);
        }
    }

    @Override
    protected void onStart() {
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
        tv_weight.setText("-");
    }
}
