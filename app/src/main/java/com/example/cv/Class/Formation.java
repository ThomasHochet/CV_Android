package com.example.cv.Class;

public class Formation {
    private String debut;
    private String fin;
    private String nom;
    private String lieu;

    public Formation(String fin, String nom, String lieu) {
        this.fin = fin;
        this.nom = nom;
        this.lieu = lieu;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
}
