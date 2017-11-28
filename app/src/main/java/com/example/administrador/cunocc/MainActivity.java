package com.example.administrador.cunocc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        public void enviar (View view)
        {
            Intent enviar =new Intent(this,Main3Activity.class);
            startActivity(enviar);

        }


}
