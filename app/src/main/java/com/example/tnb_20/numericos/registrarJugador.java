package com.example.tnb_20.numericos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collections;

public class registrarJugador extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialogview);
        final Button button = findViewById(R.id.sendName);
        final EditText editText = findViewById(R.id.editText2);
        final int intents = 0;
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){{
                    nouRegistre(String.valueOf(editText.getText()),intents);
                    return true;
                }}
                return false;
            }

        });
       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
            nouRegistre(String.valueOf(editText.getText()),intents);
           }
       });


    }
    public void nouRegistre(String nom,int num) {
        MainActivity.listaPlayers.add(new jugador(num,nom));

    }
}
