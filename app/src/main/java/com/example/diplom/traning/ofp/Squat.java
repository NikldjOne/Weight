package com.example.diplom.traning.ofp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class Squat extends AppCompatActivity {
    ImageView imageView, img_squat_left, img_squat_right,img_squat_left2,img_squat_left3img_squat_left4,
            img_squat_left5,img_squat_right2,img_squat_right3,img_squat_right4,img_squat_right5;
    LinearLayout layout,layout2,layout3,layout4,layout5;
    TextView tv_weight, tv_result_squat, tv_result_squat2, tv_result_squat3, tv_result_squat4, tv_result_squat5;
    Button btn_squat_back, btn_squat_back2, btn_squat_back3, btn_squat_back4, btn_squat_back5,
            btn_squat_add, btn_squat_add2, btn_squat_add3btn_squat_add4, btn_squat_add5,
            btn_squat_done, btn_squat_done2, btn_squat_done3, btn_squat_done4, btn_squat_done5;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private FirebaseDatabase firebaseDatabase2 = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference().child("Image");
    private DatabaseReference first = databaseReference.child("41");
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    private DatabaseReference weightList;
    private DatabaseReference weight;
    Double weight_dec;
    Integer result = 0,result2 = 0,result3 = 0,result4 = 0,result5 = 0;
    String ed_result,ed_result2,ed_result3,ed_result4,ed_result5;
    EditText edit_result,edit_result2,edit_result3,edit_result4,edit_result5;
    Boolean podhod = false,podhod2 = false,podhod3 = false,podhod4 = false,podhod5 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_squat);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar_layout_7);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView = findViewById(R.id.img_squat2);
        tv_weight = findViewById(R.id.tv_weight);
        weightList = firebaseDatabase2.getReference("Records").child(user.getUid());
        tv_result_squat = findViewById(R.id.tv_result_squat);
        edit_result = findViewById(R.id.ed_result);
        btn_squat_add = findViewById(R.id.btn_squat_add);
        btn_squat_back = findViewById(R.id.btn_squat_back);
        btn_squat_done = findViewById(R.id.btn_squat_done);
        layout = findViewById(R.id.layout_done);
        img_squat_left = findViewById(R.id.img_squat_left);
        img_squat_right = findViewById(R.id.img_squat_right);

        tv_result_squat2 = findViewById(R.id.tv_result_squat2);
        edit_result2 = findViewById(R.id.ed_result2);
        btn_squat_add2 = findViewById(R.id.btn_squat_add2);
        btn_squat_back2 = findViewById(R.id.btn_squat_back2);
        btn_squat_done2 = findViewById(R.id.btn_squat_done2);
        layout2 = findViewById(R.id.layout_done2);
        img_squat_left2 = findViewById(R.id.img_squat_left2);
        img_squat_right2 = findViewById(R.id.img_squat_right2);

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
        }
        else
        if (podhod2 == true) {
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
        }
        else
        if (podhod == true) {
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
        weightList.child("max_squat").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String weight = dataSnapshot.getValue(String.class);
                weight_dec = Double.parseDouble(weight) * 0.85;
                String stringdouble = Double.toString(weight_dec);
                tv_weight.setText(stringdouble);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
