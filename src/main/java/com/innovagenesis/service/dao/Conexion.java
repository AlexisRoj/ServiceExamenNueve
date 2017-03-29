/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class Conexion {

    private Connection con;
    private final String driver = "con.mysql.cj.jdbc.Driver";
    private final String usuario = "admin";
    private final String contrasena = "admin123+";
    private final String urlBaseDatos = "jdbc:mysql://localhost:3306/db_examen_nueve?serverTimezone=UTC"
            + "&autoReconnect=true&useSSL=false";

    private static Conexion conexion;

    private Conexion() {
        //constructor vacio
    }

    public static Conexion getIntance() throws SQLException {
        //Clase singlenton para que solo exista una instancia
        if (conexion == null) {
            conexion = new Conexion();
        }
        conexion.conectar();
        return conexion;
    }

    private void conectar() throws SQLException {
        //Conecta a la base de datos
        if (con == null || con.isClosed()) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(urlBaseDatos, usuario, contrasena);
        }
    }

    public Boolean existeConexion() throws SQLException {
        //Verifica que exista conexion a la bd
        return con != null && !con.isClosed();
    }

    public Connection getCon() {
        // trae la conexion
        return con;
    }
}
