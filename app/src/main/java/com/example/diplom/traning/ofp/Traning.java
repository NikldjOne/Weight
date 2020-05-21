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

    HorizontalScrollView sv ;
    Shil_fragment fragmentShil = new Shil_fragment();
    Shil_fragment2 fragmentShil2 = new Shil_fragment2();
    Shil_fragment3 fragmentShil3 = new Shil_fragment3();
    Day7_fragment fragment7 = new Day7_fragment();
    Day5_fragment fragment5 = new Day5_fragment();
    Day3_fragment fragment3 = new Day3_fragment();
    Day1_fragment fragmentOne = new Day1_fragment();
    TabLayout tabLayout;
    RelativeLayout rel_day1, rel_day2, rel_day3, rel_day4, rel_day5, rel_day6, rel_day7;
    Integer position;
    ImageView block_day1;
    String day1_done, day2_done,day3_done,day4_done;
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference resultsList, firebase;

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
        resultsList = firebaseDatabase2.getReference("Results").child(user.getUid()).child("Week1");
        buttonSwipe();
        btn_day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day1Btn();
                inactive();
                rel_day1.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day3();
                inactive();
                rel_day3.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day5();
                inactive();
                rel_day5.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_day7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day7();
                inactive();
                rel_day7.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil();
                inactive();
                rel_day2.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Day_shil2();
                inactive();
                rel_day4.setBackgroundResource(R.drawable.inset);
            }
        });
        btn_shil3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        resultsList.child("day1_done").addValueEventListener(new ValueEventListener() {
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
                } else if (day2_done != null) {                   sv.postDelayed(new Runnable() {
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
                day4_done = dataSnapshot.getValue(String.class);
                if (day4_done != null) {
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
    }
}
