package com.example.tnb_20.numericos;

public class jugador implements Comparable<jugador>{
    private int intents;
    private String nom;

    jugador(int intents){
        this.intents = intents;
        this.nom = "falta afegir";
    }
    public jugador(int intents, String nom){
        this.intents = intents;
        this.nom = nom;
    }

    public int getIntents() {
        return intents;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    public String getPuntuacio() {
        return ""+nom+"--->Intents:"+intents;
    }


    @Override
    public int compareTo(jugador o) {
        return this.intents - o.intents;
    }
}
