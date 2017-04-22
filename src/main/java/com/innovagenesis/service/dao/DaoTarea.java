/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.dao;

import com.innovagenesis.service.entidades.Tareas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexi
 */
public class DaoTarea implements IDAO<Tareas> {

    private String sql = "";
    private PreparedStatement listar, buscar, insertar, borrar, actualizar;
    
    private static DaoTarea instancia;

    private DaoTarea() {
    }
    
    public static DaoTarea getIntanceTarea (){
        // Clase singlenton
        if(instancia == null){
            instancia = new DaoTarea();
        }        
        return instancia;        
    }   
    

    @Override
    public void insertar(Tareas entidad) throws SQLException {
        //Insertar tarea
        sql = "INSERT INTO tbl_tareas ("
                + "nom_tareas,"
                + "id_asigna_tareas,"
                + "id_estudiante_tareas,"
                + "nota_tareas) "
                + "VALUES (?,?,?,?)";

        if (insertar == null) {
            insertar = Conexion.getIntance().getCon().prepareStatement(sql);
        }       
        
        insertar.setString(1, entidad.getNom_tarea());
        insertar.setInt(2, entidad.getId_asigna_tarea());
        insertar.setInt(3, entidad.getId_estudiante_tarea());
        insertar.setInt(4, entidad.getNota_tarea());

        insertar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        //Eliminar tarea
        sql = "DELETE FROM tbl_tareas WHERE id_tareas = ?";

        if (borrar == null) {
            borrar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        borrar.setInt(1, id);
        borrar.executeUpdate();

    }

    @Override
    public List<Tareas> listar() throws SQLException {
        //Método encargado de listar todos los elementos de la tabla
        sql = "SELECT "
                + "    tareas.id_tareas AS id,"
                + "    tareas.nom_tareas AS nombre,"
                + "    asignatura.id_asignatura AS IdAsigna,"
                + "    asignatura.nom_asignatura AS asignatura,"
                + "    usuario.ced_usuario AS IdUsuario," 
                + "    usuario.nom_usuario AS nombreUsuario,"
                + "    tareas.nota_tareas  AS nota "
                + "FROM"
                + "    tbl_tareas tareas,"
                + "    tbl_usuario usuario,"
                + "    tbl_asignatura asignatura "
                + "WHERE "
                + "    usuario.ced_usuario = tareas.id_estudiante_tareas  "
                + "        AND asignatura.id_asignatura = tareas.id_asigna_tareas "
                + "GROUP BY tareas.id_asigna_tareas , tareas.nom_tareas , asignatura.nom_asignatura , usuario.nom_usuario";

        if (listar == null) {
            listar = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        ResultSet set = listar.executeQuery();
        ArrayList<Tareas> resultado = new ArrayList<>();

        while (set.next()) {
            resultado.add(cargar(set));
        }
        return resultado;

    }

    @Override
    public Tareas buscar(Integer id) throws SQLException {
        //Listar el elemento buscado
        sql =  sql = "SELECT "
                + "    tareas.id_tareas AS id,"
                + "    tareas.nom_tareas AS nombre,"
                + "    asignatura.id_asignatura AS idAsigna "
                + "    asignatura.nom_asignatura AS asignatura,"
                + "    usuario.ced_usuario AS IdUsuario,"
                + "    usuario.nom_usuario AS nombreUsuario,"
                + "    tareas.nota_tareas  AS nota "
                + "FROM "
                + "    tbl_tareas tareas,"
                + "    tbl_usuario usuario,"
                + "    tbl_asignatura asignatura "
                + "WHERE "
                + "    usuario.ced_usuario = tareas.id_estudiante_tareas  "
                + "        AND asignatura.id_asignatura = tareas.id_asigna_tareas "
                + "        AND tareas.id_tareas = ? "
                + "GROUP BY tareas.id_asigna_tareas , tareas.nom_tareas , asignatura.nom_asignatura , usuario.nom_usuario";
        
        if (buscar == null) {
            buscar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        
        buscar.setInt(1, id);
        ResultSet set = buscar.executeQuery();        
        
        return set != null && set.next() ? cargar(set) : null;
    }

    @Override
    public void actualizar(Tareas entidad) throws SQLException {
        //Encargada de realizar la actualizacion de tareas
        sql = "UPDATE tbl_tareas SET "
                + "nom_tareas = ?,"
                + "id_asigna_tareas = ?,"
                + "id_estudiante_tareas = ?,"
                + "nota_tareas = ? "
                + "WHERE id_tareas = ?";
        
         if (actualizar == null) {
            actualizar = Conexion.getIntance().getCon().prepareCall(sql);            
        }        
        
         actualizar.setString(1, entidad.getNom_tarea());
         actualizar.setInt(2, entidad.getId_asigna_tarea());
         actualizar.setInt(3, entidad.getId_estudiante_tarea());
         actualizar.setInt(4, entidad.getNota_tarea());
         actualizar.setInt(5, entidad.getId_tarea());
         
        actualizar.executeUpdate();
    }

    public Tareas cargar(ResultSet set) throws SQLException {
        //Metodo encargado de cargar los elementos a la hora de listar
        Tareas tareas = new Tareas();
        tareas.setId_tarea(set.getInt("id"));
        tareas.setNom_tarea(set.getString("nombre"));
        tareas.setId_asigna_tarea(set.getInt("IdAsigna"));
        tareas.setNom_asigna_tarea(set.getString("asignatura"));
        tareas.setId_estudiante_tarea(set.getInt("IdUsuario"));
        tareas.setNom_usuario_tarea(set.getString("nombreUsuario"));
        tareas.setNota_tarea(set.getInt("nota"));
        return tareas;

    }

    @Override
    public Tareas buscarLogin(String usuario, String contrasena) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
