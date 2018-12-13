package com.example.tnb_20.numericos;

import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FameActivity extends AppCompatActivity {
    private ArrayList<jugador> llista;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fame);
        TextView fameRecord = findViewById(R.id.fame);

        llista = lecturaFitxerJugadors();
        if (llista.size()>0) {
            Collections.sort(llista);

            fameRecord.setText((""));

            for (jugador jug : llista) {
                fameRecord.setText(fameRecord.getText() + jug.getPuntuacio() + "\n");

            }
        }else {
            fameRecord.setText("ERROR: Encara no heu registrat cap jugador");
        }

    }
    private ArrayList<jugador> lecturaFitxerJugadors() {
        ArrayList<jugador> llistaTMP = new ArrayList<jugador>();
        try
        {
            BufferedReader lectorFitxer = new BufferedReader(new InputStreamReader(openFileInput("regJugadors.txt")));

            String textLlegit;
            while((textLlegit = lectorFitxer.readLine())!=null){
                String[] textSeparat = textLlegit.split(":");
                llistaTMP.add(new jugador(Integer.parseInt(textSeparat[1]),textSeparat[0]));
            }


            lectorFitxer.close();
        }
        catch (Exception e)
        {
            //Mostrem missatge de error en cas de error en la lectura del fitxer
            e.printStackTrace();
        }

        return llistaTMP;
    }
}

