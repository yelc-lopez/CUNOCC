package com.example.administrador.cunocc.Fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.administrador.cunocc.R;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasV2Fragment extends Fragment {

    EditText editText;
    ImageView imageView;
    public NoticiasV2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noticias_v2, container, false);
        editText = (EditText) view.findViewById(R.id.editText);
        imageView = (ImageView) view.findViewById(R.id.imageView);
        new CunocPage().execute();

        return view;
    }


    public class CunocPage extends AsyncTask<Void, Void, Void>{
    String datos="yelc";
    ArrayList<String> fotos = new ArrayList<>();
        @Override
        protected Void doInBackground(Void... voids) {
            try{
                Document doc = Jsoup.connect("http://cunoc.edu.gt").get();
                Elements pngs = doc.select("img[src$=.jpg]");
                datos = pngs.attr("src");

                Log.i("tamaño pngs ", String.valueOf(pngs.size()));
                for (int i = 0; i < pngs.size(); i++) {
                    Log.i("atributo " , pngs.get(i).attr("src").toString());
                    fotos.add(pngs.get(i).attr("src"));
                }



            }catch (Exception e){e.printStackTrace();}

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            editText.setText(datos.toString());
            Glide.with(getContext()).load("http://cunoc.edu.gt"+fotos.get(13)).into(imageView);
        }
    }

}
