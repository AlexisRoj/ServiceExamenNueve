/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.dao;

import com.innovagenesis.service.entidades.Tareas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author alexi
 */
public class DaoTarea implements IDAO<Tareas>{

    private String sql = "";
    private PreparedStatement sentenciaSQL;
    
    @Override
    public void insertar(Tareas entidad) throws SQLException {
        //Insertar tarea
        sql = "INSERT INTO tbl_tareas ("
                + "nom_tareas,"
                + "id_asigna_tareas,"
                + "id_estudiante_tareas,"
                + "nota_tareas) "
                + "VALUES (?,?,?,?)";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        sentenciaSQL.setString(1, entidad.getNom_tarea());
        sentenciaSQL.setInt(2, entidad.getId_asigna_tarea());
        sentenciaSQL.setInt(3, entidad.getId_estudiante_tarea());
        sentenciaSQL.setInt(4, entidad.getNota_tarea());
        
        sentenciaSQL.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        //Eliminar tarea
        sql ="DELETE FROM tbl_tareas WHERE id = ?";
        
        if (sentenciaSQL == null) {
            sentenciaSQL = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        sentenciaSQL.setInt(1, id);
        sentenciaSQL.executeUpdate();
                
    }

    @Override
    public List<Tareas> listar() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tareas buscar(Integer id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Tareas entidad) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
