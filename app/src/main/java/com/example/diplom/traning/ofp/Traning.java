package com.example.diplom.traning.ofp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.diplom.R;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Traning extends Fragment {
    View view;
    Button btn_day1, btn_day3, btn_day5, btn_day7, btn_shil, btn_shil2, btn_shil3;
    PageAdapter pagerAdapter;
    FragmentTransaction fTrans;

    HorizontalScrollView sv;
    Shil_fragment fragmentShil = new Shil_fragment();
    Shil_fragment2 fragmentShil2 = new Shil_fragment2();
    Shil_fragment3 fragmentShil3 = new Shil_fragment3();
    Day7_fragment fragment7 = new Day7_fragment();
    Day5_fragment fragment5 = new Day5_fragment();
    Day3_fragment fragment3 = new Day3_fragment();
    Day1_fragment fragmentOne = new Day1_fragment();
    Block_day block_day = new Block_day();
    TabLayout tabLayout;
    RelativeLayout rel_day1, rel_day2, rel_day3, rel_day4, rel_day5, rel_day6, rel_day7;
    int position, position2;
    ImageView block_day1;
    String day1_done, day2_done, day3_done, day4_done, day5_done, day6_done;
    String day1_done2, day2_done2, day3_done2, day4_done2, day5_done2, day6_done2;

    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference resultsList, resultsList2, resultsList3, resultsList_1, resultsList_week3, resultsList_week4, resultsList_week5,
            resultsList_week6, resultsList_week7, resultsList_week8;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.traning_ofp_fragment, container, false);
        btn_day1 = view.findViewById(R.id.btn_day1);
        btn_day3 = view.findViewById(R.id.btn_day3);
        btn_day5 = view.findViewById(R.id.btn_day5);
        btn_day7 = view.findViewById(R.id.btn_day7);
        btn_shil = view.findViewById(R.id.btn_shil);
        btn_shil2 = view.findViewById(R.id.btn_shil2);
        btn_shil3 = view.findViewById(R.id.btn_shil3);
        rel_day1 = view.findViewById(R.id.day1_rel);
        rel_day2 = view.findViewById(R.id.day2_rel);
        rel_day3 = view.findViewById(R.id.day3_rel);
        rel_day4 = view.findViewById(R.id.day4_rel);
        rel_day5 = view.findViewById(R.id.day5_rel);
        rel_day6 = view.findViewById(R.id.day6_rel);
        rel_day7 = view.findViewById(R.id.day7_rel);
        tabLayout = view.findViewById(R.id.tablayout_id_ofp);
        sv = view.findViewById(R.id.scroll_btn);
        resultsList_1 = firebaseDatabase2.getReference("Results").child(user.getUid());
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1");
        resultsList2 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week2");
        resultsList_week3 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week3");
        resultsList_week4 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week4");
        resultsList_week5 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week5");
        resultsList_week6 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week6");
        resultsList_week7 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week7");
        resultsList_week8 = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week8");
        resultsList3 = firebaseDatabase2.getReference("Results").child(user.getUid());
        buttonSwipe();
        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            position = Integer.parseInt(weight);
                            switch (position) {
                                case 1:
                                    resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 2:
                                    resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 3:
                                    resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 4:
                                    resultsList_week3.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 5:
                                    resultsList_week3.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 6:
                                    resultsList_week3.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 7:
                                    resultsList_week3.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 8:
                                    resultsList_week3.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
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
                Day1Btn();
                inactive();
                rel_day1.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            position = Integer.parseInt(weight);
                            switch (position) {
                                case 1:
                                    resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 2:
                                    resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 3:
                                    resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 4:
                                    resultsList_week3.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 5:
                                    resultsList_week3.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 6:
                                    resultsList_week3.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 7:
                                    resultsList_week3.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 8:
                                    resultsList_week3.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
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
                Day3();
                inactive();
                rel_day3.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            position = Integer.parseInt(weight);
                            switch (position) {
                                case 1:
                                    resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 2:
                                    resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 3:
                                    resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 4:
                                    resultsList_week3.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 5:
                                    resultsList_week3.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 6:
                                    resultsList_week3.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 7:
                                    resultsList_week3.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 8:
                                    resultsList_week3.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
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
                Day5();
                inactive();
                rel_day5.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            position = Integer.parseInt(weight);
                            switch (position) {
                                case 1:
                                    resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 2:
                                    resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 3:
                                    resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 4:
                                    resultsList_week3.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 5:
                                    resultsList_week3.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 6:
                                    resultsList_week3.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 7:
                                    resultsList_week3.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 8:
                                    resultsList_week3.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
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
                Day7();
                inactive();
                rel_day7.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            position = Integer.parseInt(weight);
                            switch (position) {
                                case 1:
                                    resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 2:
                                    resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 3:
                                    resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 4:
                                    resultsList_week3.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 5:
                                    resultsList_week3.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 6:
                                    resultsList_week3.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 7:
                                    resultsList_week3.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 8:
                                    resultsList_week3.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
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
                Day_shil();
                inactive();
                rel_day2.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            position = Integer.parseInt(weight);
                            switch (position) {
                                case 1:
                                    resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 2:
                                    resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 3:
                                    resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 4:
                                    resultsList_week3.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 5:
                                    resultsList_week3.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 6:
                                    resultsList_week3.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 7:
                                    resultsList_week3.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 8:
                                    resultsList_week3.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
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
                Day_shil2();
                inactive();
                rel_day4.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String weight = dataSnapshot.getValue(String.class);
                        if (weight != null) {
                            position = Integer.parseInt(weight);
                            switch (position) {
                                case 1:
                                    resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {

                                            }
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 2:
                                    resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 3:
                                    resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 4:
                                    resultsList_week3.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 5:
                                    resultsList_week3.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 6:
                                    resultsList_week3.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 7:
                                    resultsList_week3.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });
                                    break;
                                case 8:
                                    resultsList_week3.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                            } else
                                                block_day();
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
                Day_shil3();
                inactive();
                rel_day6.setBackgroundResource(R.drawable.inset);
            }
        });
        Day1();
        return view;
    }

    private void inactive() {
        rel_day1.setBackgroundResource(R.drawable.inset_inactive);
        rel_day2.setBackgroundResource(R.drawable.inset_inactive);
        rel_day3.setBackgroundResource(R.drawable.inset_inactive);
        rel_day4.setBackgroundResource(R.drawable.inset_inactive);
        rel_day5.setBackgroundResource(R.drawable.inset_inactive);
        rel_day6.setBackgroundResource(R.drawable.inset_inactive);
        rel_day7.setBackgroundResource(R.drawable.inset_inactive);
    }

    private void Day_shil() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentShil);
        fTrans.commitAllowingStateLoss();
    }

    private void Day_shil2() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentShil2);
        fTrans.commitAllowingStateLoss();
    }

    private void Day_shil3() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentShil3);
        fTrans.commitAllowingStateLoss();
    }

    private void Day7() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragment7);
        fTrans.commitAllowingStateLoss();

    }

    private void Day5() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragment5);
        fTrans.commitAllowingStateLoss();
    }

    private void Day3() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragment3);
        fTrans.commitAllowingStateLoss();
    }

    private void Day1() {
        resultsList_1.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {

                } else
                    resultsList_1.child("Week_done").setValue("1");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        resultsList.child("Week1_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {

                } else
                    resultsList.child("Week1_done").setValue("1");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        rel_day1.setBackgroundResource(R.drawable.inset);
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentOne);
        fTrans.commitAllowingStateLoss();
    }

    private void Day1Btn() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, fragmentOne);
        fTrans.commitAllowingStateLoss();
    }

    private void buttonSwipe() {
        resultsList3.child("Week_done").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                if (weight != null) {
                    position = Integer.parseInt(weight);
                    switch (position) {
                        case 1:
                            resultsList.child("Week1_done")
                                    .addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                            String weight = dataSnapshot.getValue(String.class);
                                            if (weight != null) {
                                                resultsList.child("day1_done")
                                                        .addValueEventListener(new ValueEventListener() {
                                                            @Override
                                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                day1_done = dataSnapshot.getValue(String.class);
                                                                if (day1_done != null) {
                                                                    sv.postDelayed(new Runnable() {
                                                                        public void run() {
                                                                            sv.smoothScrollBy(250, 0);
                                                                        }
                                                                    }, 100L);
                                                                    Day_shil();
                                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                                } else {
                                                                    sv.postDelayed(new Runnable() {
                                                                        public void run() {
                                                                            sv.smoothScrollBy(-250, 0);
                                                                        }
                                                                    }, 100L);
                                                                    Day1Btn();
                                                                    inactive();
                                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                                }
                                                            }

                                                            @Override
                                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                                            }
                                                        });
                                                resultsList.child("day2_done").addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        day2_done = dataSnapshot.getValue(String.class);
                                                        if (day2_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(250, 0);
                                                                }
                                                            }, 100L);
                                                            Day3();
                                                            inactive();
                                                            rel_day3.setBackgroundResource(R.drawable.inset);
                                                        } else if (day1_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(-250, 0);
                                                                }
                                                            }, 100L);
                                                            Day_shil();
                                                            inactive();
                                                            rel_day2.setBackgroundResource(R.drawable.inset);
                                                        }
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                    }
                                                });
                                                resultsList.child("day3_done").addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        day3_done = dataSnapshot.getValue(String.class);
                                                        if (day3_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(250, 0);
                                                                }
                                                            }, 100L);
                                                            Day_shil2();
                                                            inactive();
                                                            rel_day4.setBackgroundResource(R.drawable.inset);
                                                        } else if (day2_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(-250, 0);
                                                                }
                                                            }, 100L);

                                                            Day3();
                                                            inactive();
                                                            rel_day3.setBackgroundResource(R.drawable.inset);
                                                        }
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                    }
                                                });
                                                resultsList.child("day4_done").addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        day4_done = dataSnapshot.getValue(String.class);
                                                        if (day4_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(200, 0);
                                                                }
                                                            }, 100L);
                                                            Day5();
                                                            inactive();
                                                            rel_day5.setBackgroundResource(R.drawable.inset);
                                                        } else if (day3_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(-200, 0);
                                                                }
                                                            }, 100L);
                                                            Day_shil2();
                                                            inactive();
                                                            rel_day4.setBackgroundResource(R.drawable.inset);
                                                        }
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                    }
                                                });
                                                resultsList.child("day5_done").addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        day5_done = dataSnapshot.getValue(String.class);
                                                        if (day5_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(200, 0);
                                                                }
                                                            }, 100L);
                                                            Day_shil3();
                                                            inactive();
                                                            rel_day6.setBackgroundResource(R.drawable.inset);
                                                        } else if (day3_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(-200, 0);
                                                                }
                                                            }, 100L);
                                                            Day5();
                                                            inactive();
                                                            rel_day5.setBackgroundResource(R.drawable.inset);
                                                        }
                                                    }

                                                    @Override
                                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                                    }
                                                });
                                                resultsList.child("day6_done").addValueEventListener(new ValueEventListener() {
                                                    @Override
                                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                        day6_done = dataSnapshot.getValue(String.class);
                                                        if (day6_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(200, 0);
                                                                }
                                                            }, 100L);
                                                            Day7();
                                                            inactive();
                                                            rel_day7.setBackgroundResource(R.drawable.inset);
                                                        } else if (day5_done != null) {
                                                            sv.postDelayed(new Runnable() {
                                                                public void run() {
                                                                    sv.smoothScrollBy(-200, 0);
                                                                }
                                                            }, 100L);
                                                            Day_shil3();
                                                            inactive();
                                                            rel_day6.setBackgroundResource(R.drawable.inset);
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
                            resultsList2.child("Week2_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList2.child("day1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day1_done2 = dataSnapshot.getValue(String.class);
                                                if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                } else {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day1Btn();
                                                    inactive();
                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList2.child("day2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day2_done2 = dataSnapshot.getValue(String.class);
                                                if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                } else if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    inactive();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList2.child("day3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day3_done2 = dataSnapshot.getValue(String.class);
                                                if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                } else if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);

                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList2.child("day4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day4_done2 = dataSnapshot.getValue(String.class);
                                                if (day4_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList2.child("day5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day5_done2 = dataSnapshot.getValue(String.class);
                                                if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList2.child("day6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day6_done2 = dataSnapshot.getValue(String.class);
                                                if (day6_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day7();
                                                    inactive();
                                                    rel_day7.setBackgroundResource(R.drawable.inset);
                                                } else if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    } else
                                        block_day();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 3:
                            resultsList_week3.child("Week3_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week3.child("day1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day1_done2 = dataSnapshot.getValue(String.class);
                                                if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                } else {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day1Btn();
                                                    inactive();
                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("day2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day2_done2 = dataSnapshot.getValue(String.class);
                                                if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                } else if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    inactive();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("day3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day3_done2 = dataSnapshot.getValue(String.class);
                                                if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                } else if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);

                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("day4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day4_done2 = dataSnapshot.getValue(String.class);
                                                if (day4_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("day5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day5_done2 = dataSnapshot.getValue(String.class);
                                                if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week3.child("day6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day6_done2 = dataSnapshot.getValue(String.class);
                                                if (day6_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day7();
                                                    inactive();
                                                    rel_day7.setBackgroundResource(R.drawable.inset);
                                                } else if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    } else
                                        block_day();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 4:
                            resultsList_week4.child("Week4_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week4.child("day1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day1_done2 = dataSnapshot.getValue(String.class);
                                                if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                } else {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day1Btn();
                                                    inactive();
                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("day2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day2_done2 = dataSnapshot.getValue(String.class);
                                                if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                } else if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    inactive();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("day3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day3_done2 = dataSnapshot.getValue(String.class);
                                                if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                } else if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);

                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("day4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day4_done2 = dataSnapshot.getValue(String.class);
                                                if (day4_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("day5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day5_done2 = dataSnapshot.getValue(String.class);
                                                if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week4.child("day6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day6_done2 = dataSnapshot.getValue(String.class);
                                                if (day6_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day7();
                                                    inactive();
                                                    rel_day7.setBackgroundResource(R.drawable.inset);
                                                } else if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    } else
                                        block_day();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 5:
                            resultsList_week5.child("Week5_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week5.child("day1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day1_done2 = dataSnapshot.getValue(String.class);
                                                if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                } else {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day1Btn();
                                                    inactive();
                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("day2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day2_done2 = dataSnapshot.getValue(String.class);
                                                if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                } else if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    inactive();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("day3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day3_done2 = dataSnapshot.getValue(String.class);
                                                if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                } else if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);

                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("day4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day4_done2 = dataSnapshot.getValue(String.class);
                                                if (day4_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("day5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day5_done2 = dataSnapshot.getValue(String.class);
                                                if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week5.child("day6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day6_done2 = dataSnapshot.getValue(String.class);
                                                if (day6_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day7();
                                                    inactive();
                                                    rel_day7.setBackgroundResource(R.drawable.inset);
                                                } else if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    } else
                                        block_day();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 6:
                            resultsList_week6.child("Week6_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week6.child("day1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day1_done2 = dataSnapshot.getValue(String.class);
                                                if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                } else {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day1Btn();
                                                    inactive();
                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("day2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day2_done2 = dataSnapshot.getValue(String.class);
                                                if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                } else if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    inactive();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("day3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day3_done2 = dataSnapshot.getValue(String.class);
                                                if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                } else if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);

                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("day4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day4_done2 = dataSnapshot.getValue(String.class);
                                                if (day4_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("day5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day5_done2 = dataSnapshot.getValue(String.class);
                                                if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week6.child("day6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day6_done2 = dataSnapshot.getValue(String.class);
                                                if (day6_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day7();
                                                    inactive();
                                                    rel_day7.setBackgroundResource(R.drawable.inset);
                                                } else if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    } else
                                        block_day();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 7:
                            resultsList_week7.child("Week7_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week7.child("day1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day1_done2 = dataSnapshot.getValue(String.class);
                                                if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                } else {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day1Btn();
                                                    inactive();
                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("day2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day2_done2 = dataSnapshot.getValue(String.class);
                                                if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                } else if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    inactive();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("day3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day3_done2 = dataSnapshot.getValue(String.class);
                                                if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                } else if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);

                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("day4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day4_done2 = dataSnapshot.getValue(String.class);
                                                if (day4_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("day5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day5_done2 = dataSnapshot.getValue(String.class);
                                                if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week7.child("day6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day6_done2 = dataSnapshot.getValue(String.class);
                                                if (day6_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day7();
                                                    inactive();
                                                    rel_day7.setBackgroundResource(R.drawable.inset);
                                                } else if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    } else
                                        block_day();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError databaseError) {

                                }
                            });
                            break;
                        case 8:
                            resultsList_week8.child("Week8_done").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    String weight = dataSnapshot.getValue(String.class);
                                    if (weight != null) {
                                        resultsList_week8.child("day1_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day1_done2 = dataSnapshot.getValue(String.class);
                                                if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                    rel_day1.setBackgroundResource(R.drawable.inset_inactive);
                                                } else {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day1Btn();
                                                    inactive();
                                                    rel_day1.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("day2_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day2_done2 = dataSnapshot.getValue(String.class);
                                                if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                } else if (day1_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil();
                                                    inactive();
                                                    rel_day2.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("day3_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day3_done2 = dataSnapshot.getValue(String.class);
                                                if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(250, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                } else if (day2_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-250, 0);
                                                        }
                                                    }, 100L);

                                                    Day3();
                                                    inactive();
                                                    rel_day3.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("day4_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day4_done2 = dataSnapshot.getValue(String.class);
                                                if (day4_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil2();
                                                    inactive();
                                                    rel_day4.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("day5_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day5_done2 = dataSnapshot.getValue(String.class);
                                                if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                } else if (day3_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day5();
                                                    inactive();
                                                    rel_day5.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                        resultsList_week8.child("day6_done").addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                day6_done2 = dataSnapshot.getValue(String.class);
                                                if (day6_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(200, 0);
                                                        }
                                                    }, 100L);
                                                    Day7();
                                                    inactive();
                                                    rel_day7.setBackgroundResource(R.drawable.inset);
                                                } else if (day5_done2 != null) {
                                                    sv.postDelayed(new Runnable() {
                                                        public void run() {
                                                            sv.smoothScrollBy(-200, 0);
                                                        }
                                                    }, 100L);
                                                    Day_shil3();
                                                    inactive();
                                                    rel_day6.setBackgroundResource(R.drawable.inset);
                                                }
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });
                                    } else
                                        block_day();
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

    private void block_day() {
        fTrans = getChildFragmentManager().beginTransaction();
        fTrans.replace(R.id.frame_ofp_traning, block_day);
        fTrans.commitAllowingStateLoss();
    }
}
