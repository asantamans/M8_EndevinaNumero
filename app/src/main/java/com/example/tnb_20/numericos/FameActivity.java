package com.example.tnb_20.numericos;

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

    final TextView fameRecord = findViewById(R.id.fame);;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fame);
        llista = new ArrayList<jugador>();
        Collections.sort(llista, new Comparator<jugador>() {
            public int compare(jugador o1, jugador o2) {
                if (o1.getIntents() < o2.getIntents()) return 1;
                return 0;

        }});
        fameRecord.setText((""));
        for (jugador jug : llista) {
            fameRecord.setText(fameRecord.getText()+jug.getPuntuacio());
        }


    }
}

