package com.example.diplom;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplom.model.ItemSwipe;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment{
RecyclerView recyclerView;
MyAdapterSwipe adapterSwipe;
LinearLayoutManager layoutManager;
Context globalContext = null;
Button dreams;
String name;
String s;
    public List itemSwipes = new ArrayList<>();
public ItemSwipe item;
    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState){


        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_test);
          recyclerView.setHasFixedSize(true);
       layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
         recyclerView.setLayoutManager(layoutManager);
          dreams=(Button) view.findViewById(R.id.dreams_btn);



        globalContext = this.getActivity();

   MySwipeHelper swipeHelper = new MySwipeHelper(getActivity().getApplicationContext(),recyclerView,100) {
       @Override
       public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
               buffer.add(new MyButton(getActivity().getApplicationContext(),
                       "Delete",
                       30,
                       R.drawable.ic_delete_black_24dp,
                       Color.parseColor("#e10404"),
                       new MyButtonClickListener() {
                           @Override
                           public void onClick(int pos) {
                               Toast.makeText(getActivity(), "Delete click", Toast.LENGTH_SHORT).show();
                               itemSwipes.remove(pos);
                               recyclerView.setAdapter(adapterSwipe);
                           }
                       }));
               buffer.add(new MyButton(getActivity().getApplicationContext(),
                       "Update",
                       30,
                       R.drawable.ic_edit_black_24dp,
                       Color.parseColor("#008000"),
                       new MyButtonClickListener() {
                           @Override
                           public void onClick(int pos) {
                               Toast.makeText(getActivity(), "Update click", Toast.LENGTH_SHORT).show();
                               DialogUpdate();
                           }
                       }));
           }
   };

   dreams.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           DialogShow();
       }});
        return view;
    }

    private void DialogUpdate() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText ed= new EditText(getActivity());
        builder.setCancelable(false);
        builder.setView(ed);
        builder.setPositiveButton("Создать", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.colorBack);
        alertDialog.setTitle("Добавить цель");
        alertDialog.show();

    }

    private void DialogShow() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final EditText ed= new EditText(getActivity());
        builder.setCancelable(false);
        builder.setView(ed);

        builder.setPositiveButton("Создать", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (ed.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Вы не ввели цель", Toast.LENGTH_SHORT).show();
                    DialogShow();
                } else {
                    name = ed.getText().toString();
                    generateItem();
                }
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.getWindow().setBackgroundDrawableResource(R.color.colorBack);
        alertDialog.setTitle("Добавить цель");
        alertDialog.show();

    }


    private void generateItem() {
        itemSwipes.add(new ItemSwipe(name));
        adapterSwipe = new MyAdapterSwipe(getActivity().getApplicationContext(), itemSwipes);
        recyclerView.setAdapter(adapterSwipe);
        }
    }


