package com.example.tnb_20.numericos;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int intento = 0;
    private int jugadorNumb = 1;
    public static ArrayList<jugador> listaPlayers = new ArrayList<jugador>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start();


    }
    protected void start(){
        Random random = new Random();
        final int numero = random.nextInt(100);
        final Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);
        final EditText editText = findViewById(R.id.editText);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){{
                    String insertado = String.valueOf(editText.getText());
                    comprobaNum(insertado,numero);
                    return true;
                }}
                return false;
            }

        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FameActivity.class);
                startActivityIfNeeded(intent, 0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FameActivity.class);
                startActivityIfNeeded(intent, 0);
            }
        });
    }
    protected void comprobaNum(String insertado,int numero) {
        int insertadoConver = Integer.parseInt(insertado);

        if(insertadoConver == numero){
            mostrarMensaje("Has acertado el numero; reiniciando aplicacion");
            listaPlayers.add(new jugador(intento,"Jugador "+jugadorNumb));
            ++jugadorNumb;
            start();
        }else if(insertadoConver > numero){
            mostrarMensaje("El número es más pequeño" + insertadoConver);
            intento = intento + 1;
        }else if(insertadoConver < numero){
            mostrarMensaje("El número es más grande" + insertadoConver);
            intento = intento + 1;
        }
    }
    protected void mostrarMensaje(String mensaje) {
        Context context = getApplicationContext();
        CharSequence cs = mensaje;
        int duracion = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,cs,duracion);
        toast.show();
    }



}
