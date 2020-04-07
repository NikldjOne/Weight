package com.example.diplom;

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
    Button exit,polkonfClick,polsoglclick;
    private FirebaseAuth AuthUI;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users,container,false);


exit = view.findViewById(R.id.exitApp);
exit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        FirebaseAuth.getInstance().signOut();
        getActivity().finish();
 startActivity(new Intent(getActivity().getApplicationContext(), MainActivity.class));
    }
});


polkonfClick = view.findViewById(R.id.polkonf);
polkonfClick.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity( new Intent(getActivity().getApplicationContext(),Konfidentional.class));
    }
});

        polsoglclick = view.findViewById(R.id.polsogl);
        polsoglclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity().getApplicationContext(),Politika.class));
            }
        });
                return  view;
    }
}
