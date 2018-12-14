package com.example.tnb_20.numericos;

import android.app.Dialog;
import android.content.Context;
import android.content.SyncStatusObserver;
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

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static String nomJugador;
    private int intents = 0;
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
                    editText.setText("");
                    comprobaNum(insertado,numero);
                    return true;
                }}
                return false;
            }

        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String insertado = String.valueOf(editText.getText());
                editText.setText("");
                comprobaNum(insertado,numero);
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
        ++intents;
        if(insertadoConver == numero){
            mostrarMensaje("Has acertado el numero; reiniciando aplicacion");
            String nom =  registrarNom();
            jugador tmp = new jugador(intents,nom);
            escriureJugadorFitxer(tmp);
            restart();
            start();
        }else if(insertadoConver > numero){
            mostrarMensaje("El número es más pequeño    " + insertadoConver);
        }else if(insertadoConver < numero){
            mostrarMensaje("El número es más grande     " + insertadoConver);

        }
    }
    protected void mostrarMensaje(String mensaje) {
        Context context = getApplicationContext();
        CharSequence cs = mensaje;
        int duracion = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context,cs,duracion);
        toast.show();
    }
    private void restart() {
        intents = 0;
        nomJugador = "";
    }

    private String registrarNom(){
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.dialogview);
        dialog.setTitle("Registrar el nom de Jugador:");
        dialog.show();
        Button register = dialog.findViewById(R.id.dialogButo);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText textName = dialog.findViewById(R.id.dialogNom);
                nomJugador = textName.getText().toString();
                dialog.dismiss();
            }
        });
        register.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){{
                    EditText textName = dialog.findViewById(R.id.dialogNom);
                    nomJugador = textName.getText().toString();
                    dialog.dismiss();
                    return true;
                }}
                return false;
            }
        });

        return nomJugador;
    }
    private void escriureJugadorFitxer(jugador j){
        try {
            OutputStreamWriter fout =
                    new OutputStreamWriter(
                            openFileOutput("regJugadors.txt",Context.MODE_APPEND));

            fout.write(j.getNom() + ":" + j.getIntents());
            fout.append("\r\n");
            fout.close();

        } catch (Exception  e) {
            e.printStackTrace();
        }
    }



}
