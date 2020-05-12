package com.example.diplom.eat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.diplom.R;
import com.example.diplom.eat.menu_eat_syhka.Obed;
import com.example.diplom.eat.menu_eat_syhka.Perekys;
import com.example.diplom.eat.menu_eat_syhka.Yjin;
import com.example.diplom.eat.menu_eat_syhka.Zavtrak;

public class Syhka_Fragment extends Fragment {
View view;
ImageView imageView;
TextView syhka;
TextView bt_syhka;
Button btn_zavtrak,btn_perekys,btn_obed,btn_yjin;
    public Syhka_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.syhka_fragment,container,false);
        imageView = (ImageView) view.findViewById(R.id.perekys);
        imageView.setImageResource(R.drawable.yogert);
        syhka = (TextView) view.findViewById(R.id.textviewsyhka);
        syhka.setText("Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight");
        bt_syhka = (TextView) view.findViewById(R.id.about_syhka);
        btn_zavtrak = (Button) view.findViewById(R.id.btn_zavtrak);
        btn_perekys = (Button) view.findViewById(R.id.btn_perekys);
        btn_obed = (Button) view.findViewById(R.id.btn_obed);
        btn_yjin = (Button) view.findViewById(R.id.btn_yjin);
        bt_syhka.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_syhka.setVisibility(View.INVISIBLE);
                syhka.setText("Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        " Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        "Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        "Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        "Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        "Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        "Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        "Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight" +
                        "Если твоя цель сжечь жир и добавиться максимального рельефа мышц - этот рацион для тебя. Питание Weight");
            }
        });
        btn_perekys.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Perekys.class));
            }
        });
        btn_zavtrak.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Zavtrak.class));
            }
        });
        btn_obed.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Obed.class));
            }
        });
        btn_yjin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Yjin.class));
            }
        });
        return view;
    }
}
