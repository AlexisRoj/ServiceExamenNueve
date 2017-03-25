/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.dao;

import com.innovagenesis.service.entidades.Asignatura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexi
 */
public class DaoAsignatura implements IDAO<Asignatura> {

    private PreparedStatement sentenciaSQL;
    private String sql = "";

    @Override
    public void insertar(Asignatura entidad) throws SQLException {
        //Inserar usuario
        sql = "INSERT INTO tbl_asignatura (nom_asignatura) "
                + "VALUES (?)";

        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        sentenciaSQL.setString(1, entidad.getNom_asigna());
        sentenciaSQL.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        //Eliminar usuario
        sql = "DELETE FROM tbl_asignatura WHERE id_asignatura = ?";

        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        sentenciaSQL.setInt(1, id);
        sentenciaSQL.executeUpdate();
    }

    @Override
    public List<Asignatura> listar() throws SQLException {
        //Listar Asignatura
        sql = "SELECT * FROM tbl_asignatura";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        ResultSet set = sentenciaSQL.executeQuery();
        ArrayList<Asignatura> result = new ArrayList<>();
        
        while(set.next()){
            result.add(cargar(set));
        }        
        return result;
    }

    @Override
    public Asignatura buscar(Integer id) throws SQLException {
        //Buscar por id
        sql = "SELECT * FROM tbl_asignatura WHERE id_asignatura = ?";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);            
        }
        sentenciaSQL.setInt(1, id);
        
        ResultSet set = sentenciaSQL.executeQuery();
        
        return  set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(Asignatura entidad) throws SQLException {
       
        sql = "UPDATE tbl_asignatura SET "
                + "nom_asignatura = ? "
                + "WHERE id_asignatura = ?";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        sentenciaSQL.setString(1, entidad.getNom_asigna());
        sentenciaSQL.setInt(2, entidad.getId_asigna());
        
        sentenciaSQL.executeUpdate();
    }
    
    
    public Asignatura cargar (ResultSet set) throws SQLException{
        
        Asignatura asignatura = new Asignatura();
        //Cargar Asigntura
        asignatura.setId_asigna(set.getInt("id_asignatura"));
        asignatura.setNom_asigna(set.getString("nom_asignatura"));
        
        return asignatura;
    }

}
