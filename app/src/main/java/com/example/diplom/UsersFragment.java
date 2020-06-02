package com.example.diplom;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class UsersFragment extends Fragment {
    Button exit, polkonfClick, polsoglclick;
    private FirebaseAuth AuthUI;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users, container, false);


        exit = view.findViewById(R.id.exitApp);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(false);
                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseAuth.getInstance().signOut();
                        getActivity().finish();
                        startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
                    }
                });
                builder.setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawableResource(R.color.colorBack);
                alertDialog.setTitle("Вы уверены что хотите выйти?");
                alertDialog.show();

            }
        });


        polkonfClick = view.findViewById(R.id.polkonf);
        polkonfClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), Konfidentional.class));
            }
        });

        polsoglclick = view.findViewById(R.id.polsogl);
        polsoglclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(), Politika.class));
            }
        });
        return view;
    }
}
