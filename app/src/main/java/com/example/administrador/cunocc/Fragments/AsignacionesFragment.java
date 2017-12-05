package com.example.administrador.cunocc.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.administrador.cunocc.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsignacionesFragment extends Fragment {

    public AsignacionesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_asignaciones, container, false);
        return view;
    }



}
