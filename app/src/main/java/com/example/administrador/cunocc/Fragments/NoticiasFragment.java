package com.example.administrador.cunocc.Fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.example.administrador.cunocc.Main3Activity;
import com.example.administrador.cunocc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NoticiasFragment extends Fragment {
    WebView noticiasWeb;
    Activity activity;

    public NoticiasFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentoN = inflater.inflate(R.layout.fragment_noticias2, container, false);
        // cargar pagina web en fragment
        noticiasWeb = (WebView) fragmentoN.findViewById(R.id.webView);
        noticiasWeb.getSettings().setJavaScriptEnabled(true);

        noticiasWeb.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url)
            {
                noticiasWeb.loadUrl("javascript:(function() { " +
                        "document.getElementsByTagName('footer')[0].style.display='none'; " +
                        "})()");
            }
        });
        try{
            noticiasWeb.loadUrl("http://cunoc.edu.gt");
        }catch (Exception e){}


        return fragmentoN;
    }

}
