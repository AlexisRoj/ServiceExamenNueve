/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.entidades;

/**
 * Administra asignaturas
 *
 * @author alexi
 */
public class Asignatura {

    private int id_asigna;
    private String nom_asigna;

    public Asignatura(String nom_asigna) {
        this.nom_asigna = nom_asigna;
    }

    public Asignatura() {
    }

    public int getId_asigna() {
        return id_asigna;
    }

    public void setId_asigna(int id_asigna) {
        this.id_asigna = id_asigna;
    }

    public String getNom_asigna() {
        return nom_asigna;
    }

    public void setNom_asigna(String nom_asigna) {
        this.nom_asigna = nom_asigna;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "id_asigna=" + id_asigna + ", nom_asigna=" + nom_asigna + '}' + "\n";
    }

}
