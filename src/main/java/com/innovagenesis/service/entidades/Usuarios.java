/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.entidades;

/**
 * Administra Usuarios
 * @author alexi
 */
public class Usuarios {
    
    private int id_usuario;
    private int ced_usuario;
    private String nom_usuario;
    private String pass_usuario;
    private int rol_user;

    public Usuarios() {
    }

    public Usuarios(int ced_usuario, String nom_usuario, String pass_usuario, int rol_user) {
        this.ced_usuario = ced_usuario;
        this.nom_usuario = nom_usuario;
        this.pass_usuario = pass_usuario;
        this.rol_user = rol_user;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getCed_usuario() {
        return ced_usuario;
    }

    public void setCed_usuario(int ced_usuario) {
        this.ced_usuario = ced_usuario;
    }

    public String getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getPass_usuario() {
        return pass_usuario;
    }

    public void setPass_usuario(String pass_usuario) {
        this.pass_usuario = pass_usuario;
    }

    public int getRol_user() {
        return rol_user;
    }

    public void setRol_user(int rol_user) {
        this.rol_user = rol_user;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "ced_usuario=" + ced_usuario + ", nom_usuario=" + nom_usuario + ", pass_usuario=" + pass_usuario + ", rol_user=" + rol_user + '}'+"\n";
    }
    
    
    
    
}
