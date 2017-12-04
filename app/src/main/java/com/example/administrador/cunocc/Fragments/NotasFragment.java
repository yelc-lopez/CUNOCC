package com.example.administrador.cunocc.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.administrador.cunocc.Adapters.NotaAdapterV2;
import com.example.administrador.cunocc.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotasFragment extends Fragment {

    private GridView dato;
    public NotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_notas, container, false);
       dato = view.findViewById(R.id.datosGrid);

       ArrayList<String> arrayList = new ArrayList<>();
       arrayList.add("Codigo");
       arrayList.add("Curso");
        arrayList.add("Zona");
        arrayList.add("Final");
        arrayList.add("Total");
        arrayList.add("Perfil");

        arrayList.add("1231245");
        arrayList.add("Desarrollo Web");
        arrayList.add("50");
        arrayList.add("30");
        arrayList.add("80");
        arrayList.add("Aprobado");

        arrayList.add("312546");
        arrayList.add("Desarrollo Movil");
        arrayList.add("50");
        arrayList.add("50");
        arrayList.add("100");
        arrayList.add("Aprobado");

        arrayList.add("131235446");
        arrayList.add("Algebra Linear");
        arrayList.add("50");
        arrayList.add("10");
        arrayList.add("60");
        arrayList.add("Reprobado");
       dato.setAdapter(new NotaAdapterV2(getContext(),arrayList));

       return view;
    }

}
