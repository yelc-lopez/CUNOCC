package com.example.administrador.cunocc.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrador.cunocc.R;
import com.example.administrador.cunocc.models.Nota;

import java.util.List;

/**
 * Created by INTECAP on 30/11/2017.
 */

public class NotaAdapter extends ArrayAdapter<Nota> {
    TextView codigo, curso, zona, nfinal, total, perfil;
    public NotaAdapter(@NonNull Context context, List<Nota> notas) {
        super(context, R.layout.templatenotas, notas);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.templatenotas,null);


        codigo = view.findViewById(R.id.codigo);
        curso = view.findViewById(R.id.curso);
        zona= view.findViewById(R.id.zona);
        nfinal = view.findViewById(R.id.notaFinal);
        total = view.findViewById(R.id.total);
        perfil = view.findViewById(R.id.perfil);

        codigo.setText(getItem(position).getCodigo());
        curso.setText(getItem(position).getCurso());
        zona.setText(getItem(position).getZona());
        nfinal.setText(getItem(position).getNfinal());
        total.setText(getItem(position).getTotal());
        perfil.setText(getItem(position).getPerfil());
        return view;
    }
}
