package com.example.administrador.cunocc.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.administrador.cunocc.R;
import com.example.administrador.cunocc.models.Nota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotasFragment extends Fragment {


    TableLayout tabladatos;
    public NotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.fragment_notas, container, false);
       // reference UI
       tabladatos = view.findViewById(R.id.tablaDatos);

       // titulos de columnas para la tabla
       String[] titles = getResources().getStringArray(R.array.titles);
       ArrayList<String> titulos = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            titulos.add(titles[i]);
        }
       llenarfila(titulos,Color.RED);

       // llenar datos

        ArrayList<Nota> notas = new ArrayList<>();

        String[] codigos = getResources().getStringArray(R.array.codigoss);
        String[] cursos = getResources().getStringArray(R.array.cursoss);
        String[] zonas = getResources().getStringArray(R.array.zonass);
        String[] nfinal = getResources().getStringArray(R.array.finals);
        String[] totales = getResources().getStringArray(R.array.totals);
        String[] perfiles = getResources().getStringArray(R.array.perfils);

        for (int i = 0; i < codigos.length; i++) {
            notas.add(new Nota(codigos[i],cursos[i],zonas[i],nfinal[i],totales[i],perfiles[i]));
        }
        notasCursos(notas);

       return view;
    }




    public void notasCursos(ArrayList<Nota> notas){
            for (int i = 0; i < notas.size(); i++) {
                ArrayList<String> datosCurso = notas.get(i).datos();
                llenarfila(datosCurso,getResources().getColor(R.color.colorPrimary));
            }
    }

    public void llenarfila(ArrayList<String> datosFila, int color){
        TableRow fila = new TableRow(getContext());
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT);
        params.setMargins(5,5,5,5);
        TextView txt;

        for (int i = 0; i < datosFila.size(); i++) {
            txt = new TextView(getContext());
            txt.setText(datosFila.get(i));
            txt.setLayoutParams(params);
            txt.setTextColor(color);
            fila.addView(txt);
        }

        tabladatos.addView(fila);
    }

}
