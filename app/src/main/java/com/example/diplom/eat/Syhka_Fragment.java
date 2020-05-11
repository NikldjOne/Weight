package com.example.diplom.eat;

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

public class Syhka_Fragment extends Fragment {
View view;
ImageView imageView;
TextView syhka;
TextView bt_syhka;
Button btn_zavtrak;
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
        bt_syhka.setOnClickListener(new View.OnClickListener() {
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
        return view;
    }
}
