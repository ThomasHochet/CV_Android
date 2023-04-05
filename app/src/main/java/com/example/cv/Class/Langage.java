package com.example.cv.Class;

public class Langage {
    private String nom;
    private int progress;

    public Langage(String nom, int progress) {
        this.nom = nom;
        this.progress = progress;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
