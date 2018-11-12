package com.example.tnb_20.numericos;

import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
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
        TextView fameRecord = findViewById(R.id.fame);;

        llista = MainActivity.listaPlayers;
        Collections.sort(llista);

        fameRecord.setText((""));
        for (jugador jug : llista) {
            fameRecord.setText(fameRecord.getText()+jug.getPuntuacio()+"\n");

        }


    }
}

