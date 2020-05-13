package com.example.diplom.eat;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.diplom.R;
import com.example.diplom.eat.menu_eat_massa.Obed_massa;
import com.example.diplom.eat.menu_eat_massa.Perekys_massa;
import com.example.diplom.eat.menu_eat_massa.Poldnik_massa;
import com.example.diplom.eat.menu_eat_massa.Yjin_massa;
import com.example.diplom.eat.menu_eat_massa.Zavtrak_massa;

public class Massa_Fragment extends Fragment {
    View view;
    ImageView imageView;
    TextView syhka;
    TextView bt_massa;
    Button btn_zavtrak, btn_perekys, btn_obed, btn_yjin, btn_poldnik;

    public Massa_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.massa_fragment, container, false);
        imageView = (ImageView) view.findViewById(R.id.perekys_2);
        imageView.setImageResource(R.drawable.ic_default);

        syhka = (TextView) view.findViewById(R.id.textviewmassa);
        syhka.setText("Если твоя цель набрать вес и создать оптимальные условия для построения мышц - этот");
        bt_massa = (TextView) view.findViewById(R.id.about_massa);
        btn_zavtrak = (Button) view.findViewById(R.id.btn_zavtrak_2);
        btn_perekys = (Button) view.findViewById(R.id.btn_perekys_2);
        btn_poldnik = (Button) view.findViewById(R.id.btn_poldnik);
        btn_obed = (Button) view.findViewById(R.id.btn_obed_2);
        btn_yjin = (Button) view.findViewById(R.id.btn_yjin_2);
        bt_massa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt_massa.setVisibility(View.INVISIBLE);
                syhka.setText("Если твоя цель набрать вес и создать оптимальные условия для построения мышц - этот" +
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
        btn_perekys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Perekys_massa.class));
            }
        });
        btn_zavtrak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Zavtrak_massa.class));
            }
        });
        btn_obed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Obed_massa.class));
            }
        });
        btn_yjin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Yjin_massa.class));
            }
        });
        btn_poldnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Poldnik_massa.class));
            }
        });
        return view;
    }
}
