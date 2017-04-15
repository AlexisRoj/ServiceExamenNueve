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
    
    private PreparedStatement listar,buscar,borrar,actualizar,insertar, 
            buscarLogin;
    private String sql ="";

    private static DaoUsuario instancia;

    private DaoUsuario() {
    }
    
    public static DaoUsuario getInstanceUsuario(){        
        if (instancia == null) {
            instancia = new DaoUsuario();
        }        
        return instancia;
    }      
    
    
    @Override
    public void insertar(Usuarios entidad) throws SQLException {
        //Encargado de insertar los usuarios
        sql = "INSERT INTO tbl_usuario "
                + "(ced_usuario,"
                + "nom_usuario,"
                + "pass_usuario,"
                + "rol_usuario)"
                + "VALUES (?,?,?,?)";
        
        if (insertar== null) {
            insertar = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
        
        insertar.setInt(1, entidad.getCed_usuario());
        insertar.setString(2, entidad.getNom_usuario());
        insertar.setString(3, entidad.getPass_usuario());
        insertar.setInt(4, entidad.getRol_user());
                
        insertar.executeUpdate();
        
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        //Elimina el usuario
        sql = "DELETE FROM tbl_usuario WHERE id_usuario = ?";
        
        if (borrar == null) {
            borrar = Conexion.getIntance().getCon().prepareStatement(sql);
        }        
        borrar.setInt(1, id);
        borrar.executeUpdate();
    }
    

    @Override
    public List<Usuarios> listar() throws SQLException {
        //Listar Usuarios        
        sql = "SELECT * FROM tbl_usuario";
        
        if (listar == null) {            
            listar = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
                       
        ResultSet set = listar.executeQuery();
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
        
        if (buscar == null) {
            buscar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
            
        buscar.setInt(1, id);
        
        ResultSet set = buscar.executeQuery();
        
        return set != null && set.next() ? cargar(set) : null;

    }
    
    
    @Override
    public Usuarios buscarLogin(String usuario, String contrasena) throws SQLException {
        // Buscar Usuario
        sql = "SELECT * FROM tbl_usuario"
                + " WHERE nom_usuario = ?"
                + " AND pass_usuario = ?";
        
        if (buscarLogin == null) {
            buscarLogin = Conexion.getIntance().getCon().prepareStatement(sql);
        }
            
        buscarLogin.setString(1, usuario);
        buscarLogin.setString(2, contrasena);
        
        
        ResultSet set = buscarLogin.executeQuery();
        
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
               
        if (actualizar == null) {
            actualizar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        actualizar.setInt(1, entidad.getCed_usuario());
        actualizar.setString(2, entidad.getNom_usuario());
        actualizar.setString(3, entidad.getPass_usuario());
        actualizar.setInt(4, entidad.getRol_user());
        actualizar.setInt(5, entidad.getId_usuario());
        
        actualizar.executeUpdate();
    }
    
    public Usuarios cargar (ResultSet set) throws SQLException{
        
        Usuarios usuarios = new Usuarios();
        
        usuarios.setId_usuario(set.getInt("id_usuario"));
        usuarios.setCed_usuario(set.getInt("ced_usuario"));
        usuarios.setNom_usuario(set.getString("nom_usuario"));
        usuarios.setPass_usuario(set.getString("pass_usuario"));
        usuarios.setRol_user(set.getInt("rol_usuario"));
        
        return usuarios;
    }
    
}
