package com.example.administrador.cunocc.Fragments;


import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.transform.Result;

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

        new notasTask().execute();

       return view;
    }


    public class notasTask extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... urls) {
            String resultString = "";
            if (!isCancelled() && urls != null && urls.length > 0) {
                String urlString = urls[0];
                URL url = null;

                try {
                    url = new URL(urlString);
                    resultString = downloadUrl(url);
                    return resultString;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return resultString;
        }

        @Override
        protected void onPreExecute() {
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

            if (networkInfo == null || !networkInfo.isConnected() ||
                    (networkInfo.getType() != ConnectivityManager.TYPE_WIFI
                            && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
                cancel(true);
            }
        }

        @Override
        protected void onPostExecute(String resultado) {

        }



        /**
         * Given a URL, sets up a connection and gets the HTTP response body from the server.
         * If the network request is successful, it returns the response body in String form. Otherwise,
         * it will throw an IOException.
         */
        private String downloadUrl(URL url) throws IOException {
            InputStream stream = null;
            HttpsURLConnection connection = null;
            String result = null;
            try {
                connection = (HttpsURLConnection) url.openConnection();
                // Timeout for reading InputStream arbitrarily set to 3000ms.
                connection.setReadTimeout(3000);
                // Timeout for connection.connect() arbitrarily set to 3000ms.
                connection.setConnectTimeout(3000);
                // For this use case, set HTTP method to GET.
                connection.setRequestMethod("GET");
                // Already true by default but setting just in case; needs to be true since this request
                // is carrying an input (response) body.
                connection.setDoInput(true);
                // Open communications link (network traffic occurs here).
                connection.connect();
                int responseCode = connection.getResponseCode();
                if (responseCode != HttpsURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code: " + responseCode);
                }
                // Retrieve the response body as an InputStream.
                stream = connection.getInputStream();
                if (stream != null) {
                    // Converts Stream to String with max length of 500.
                    result = readStream(stream, 500);
                }
            } finally {
                // Close Stream and disconnect HTTPS connection.
                if (stream != null) {
                    stream.close();
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return result;
        }


        /**
         * Converts the contents of an InputStream to a String.
         */
        public String readStream(InputStream stream, int maxReadSize)
                throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] rawBuffer = new char[maxReadSize];
            int readSize;
            StringBuffer buffer = new StringBuffer();
            while (((readSize = reader.read(rawBuffer)) != -1) && maxReadSize > 0) {
                if (readSize > maxReadSize) {
                    readSize = maxReadSize;
                }
                buffer.append(rawBuffer, 0, readSize);
                maxReadSize -= readSize;
            }
            return buffer.toString();
        }

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
