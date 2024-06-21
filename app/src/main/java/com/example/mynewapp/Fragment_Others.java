package com.example.mynewapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class Fragment_Others extends Fragment {

    String desc;
    String name;
    TextView place_desc;
    TextView place_head;

    public Fragment_Others(String desc,String name)
    {
        this.desc = desc;
        this.name=name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.secondtab,null);
        place_desc = view.findViewById(R.id.place_desc);
        place_head= view.findViewById(R.id.place_head);
        place_desc.setText(desc);
        place_head.setText(name);
        return view;
    }
}
