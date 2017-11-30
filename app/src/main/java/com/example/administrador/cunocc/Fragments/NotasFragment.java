package com.example.administrador.cunocc.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.administrador.cunocc.Adapters.NotaAdapter;
import com.example.administrador.cunocc.R;
import com.example.administrador.cunocc.models.Nota;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NotasFragment extends Fragment {

    TableLayout tablaNotas;
    public NotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notas, container, false);

        tablaNotas = view.findViewById(R.id.notasTabla);



        String params[] = {"Dato 1", "Dato 2", "Dato 2"};

        TableRow tableRow = new TableRow(getContext());



        tablaNotas.addView(tableRow);

        TextView titulo = new TextView(getContext());
        titulo.setText("Codigo");
        tableRow.addView(titulo);

        TableRow tableRow2 = new TableRow(getContext());
        tablaNotas.addView(tableRow2);
        TextView titulo2 = new TextView(getContext());
        titulo.setText("Curso");
        tableRow2.addView(titulo2);


        return view;
    }


    public void llenarLista(){
        String[] codigos = getResources().getStringArray(R.array.codigoss);
        String[] cursos = getResources().getStringArray(R.array.cursoss);
        String[] zonas = getResources().getStringArray(R.array.zonass);
        String[] nfinales = getResources().getStringArray(R.array.finals);
        String[] totales = getResources().getStringArray(R.array.totals);
        String[] perfiles = getResources().getStringArray(R.array.perfils);
        ArrayList<Nota> lista = new ArrayList<>();
        // fila #1 de titulos
        lista.add(new Nota("Codigo","Curso","Zona","Final","Total","Perfil"));

        for (int i = 0; i < codigos.length; i++) {
            lista.add(new Nota(codigos[i],cursos[i],zonas[i],nfinales[i],totales[i],perfiles[i]));
        }

        NotaAdapter adapter = new NotaAdapter(getContext(),lista);
      //  listaNotas.setAdapter(adapter);

    }
}
