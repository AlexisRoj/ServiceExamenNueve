/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.entidades;

/**
 * Administra tareas
 * @author alexi
 */
public class Tareas {
    
    
    private int id_tarea;
    private String nom_tarea;
    private int id_asigna_tarea;
    private String nom_asigna_tarea;
    private int id_estudiante_tarea;
    private String nom_usuario_tarea;
    private int nota_tarea;   
    
    public Tareas() {
        //Constructor vacio
    }

    public Tareas(String nom_tarea, String nom_asigna_tarea, String nom_usuario_tarea, int nota_tarea) {
        this.nom_tarea = nom_tarea;
        this.nom_asigna_tarea = nom_asigna_tarea;
        this.nom_usuario_tarea = nom_usuario_tarea;
        this.nota_tarea = nota_tarea;
    }

    public Tareas(String nom_tarea, int id_asigna_tarea, int id_estudiante_tarea, int nota_tarea) {
        this.nom_tarea = nom_tarea;
        this.id_asigna_tarea = id_asigna_tarea;
        this.id_estudiante_tarea = id_estudiante_tarea;
        this.nota_tarea = nota_tarea;
    }

    public String getNom_asigna_tarea() {
        return nom_asigna_tarea;
    }

    public void setNom_asigna_tarea(String nom_asigna_tarea) {
        this.nom_asigna_tarea = nom_asigna_tarea;
    }

    public String getNom_usuario_tarea() {
        return nom_usuario_tarea;
    }

    public void setNom_usuario_tarea(String nom_usuario_tarea) {
        this.nom_usuario_tarea = nom_usuario_tarea;
    }
        
    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNom_tarea() {
        return nom_tarea;
    }

    public void setNom_tarea(String nom_tarea) {
        this.nom_tarea = nom_tarea;
    }

    public int getId_asigna_tarea() {
        return id_asigna_tarea;
    }

    public void setId_asigna_tarea(int id_asigna_tarea) {
        this.id_asigna_tarea = id_asigna_tarea;
    }

    public int getId_estudiante_tarea() {
        return id_estudiante_tarea;
    }

    public void setId_estudiante_tarea(int id_estudiante_tarea) {
        this.id_estudiante_tarea = id_estudiante_tarea;
    }

    public int getNota_tarea() {
        return nota_tarea;
    }

    public void setNota_tarea(int nota_tarea) {
        this.nota_tarea = nota_tarea;
    }

    @Override
    public String toString() {
        return "Tareas{" + "id_tarea=" + id_tarea + ", nom_tarea=" + nom_tarea + 
                ", nom_asigna_tarea=" + nom_asigna_tarea + ", nom_usuario_tarea=" 
                + nom_usuario_tarea + ", nota_tarea=" + nota_tarea + '}' + "\n";
    }   
        
    
}
