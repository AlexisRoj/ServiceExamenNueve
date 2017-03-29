/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.dao;

import com.innovagenesis.service.entidades.Usuarios;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexi
 */
public class DaoUsuario implements IDAO<Usuarios>{
    
    private PreparedStatement sentenciaSQL;
    private String sql ="";

    @Override
    public void insertar(Usuarios entidad) throws SQLException {
        //Encargado de insertar los usuarios
        sql = "INSERT INTO tbl_usuario "
                + "(ced_usuario,"
                + "nom_usuario,"
                + "pass_usuario,"
                + "rol_usuario)"
                + "VALUES (?,?,?,?)";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
        
        sentenciaSQL.setInt(1, entidad.getCed_usuario());
        sentenciaSQL.setString(2, entidad.getNom_usuario());
        sentenciaSQL.setString(3, entidad.getPass_usuario());
        sentenciaSQL.setInt(4, entidad.getRol_user());
                
        sentenciaSQL.executeUpdate();
        
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        //Elimina el usuario
        sql = "DELETE FROM tbl_usuario WHERE id_usuario = ?";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }        
        sentenciaSQL.setInt(1, id);
        sentenciaSQL.executeUpdate();
    }
    

    @Override
    public List<Usuarios> listar() throws SQLException {
        //Listar Usuarios        
        sql = "SELECT * FROM tbl_usuario";
        
        if (sentenciaSQL == null) {            
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
                       
        ResultSet set = sentenciaSQL.executeQuery();
        ArrayList<Usuarios> result = new ArrayList<>();
        
        while (set.next()){
            result.add(cargar(set));
        }        
        return result;        
    }

    @Override
    public Usuarios buscar(Integer id) throws SQLException {
        // Buscar Usuario
        sql = "SELECT * FROM tbl_usuario WHERE id_usuario = ?";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }
            
        sentenciaSQL.setInt(1, id);
        
        ResultSet set = sentenciaSQL.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;

    }

    @Override
    public void actualizar(Usuarios entidad) throws SQLException {
        //Encnargada de actualizar usuario
        sql = " UPDATE tbl_usuario SET "
                + "ced_usuario = ?,"
                + "nom_usuario = ?,"
                + "pass_usuario = ?,"
                + "rol_usuario = ? "
                + "WHERE id_usuario = ?";       
               
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        sentenciaSQL.setInt(1, entidad.getCed_usuario());
        sentenciaSQL.setString(2, entidad.getNom_usuario());
        sentenciaSQL.setString(3, entidad.getPass_usuario());
        sentenciaSQL.setInt(4, entidad.getRol_user());
        sentenciaSQL.setInt(5, entidad.getId_usuario());
        
        sentenciaSQL.executeUpdate();
    }
    
    public Usuarios cargar (ResultSet set) throws SQLException{
        
        Usuarios usuarios = new Usuarios();
        
        usuarios.setCed_usuario(set.getInt("ced_usuario"));
        usuarios.setNom_usuario(set.getString("nom_usuario"));
        usuarios.setPass_usuario(set.getString("pass_usuario"));
        usuarios.setRol_user(set.getInt("rol_usuario"));
        
        return usuarios;
    }
    
}
