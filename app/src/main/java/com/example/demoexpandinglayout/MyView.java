package com.example.demoexpandinglayout;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import net.cachapa.expandablelayout.ExpandableLayout;

public class MyView extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.my_view, container, false);
        LinearLayout header = (LinearLayout) rootView.findViewById(R.id.header);
        ExpandableLayout expandableLayout0 = (ExpandableLayout) rootView.findViewById(R.id.expandable_layout);
        header.setOnClickListener(v -> {
            if (expandableLayout0.isExpanded()) {
                expandableLayout0.collapse();
            } else {
                expandableLayout0.expand();
            }
        });
        expandableLayout0.setOnExpansionUpdateListener((expansionFraction, state) -> rootView.findViewById(R.id.arrow).setRotation(expansionFraction * (-180)));

        return rootView;
    }

    @Override
    public void onClick(View v) {

    }
}