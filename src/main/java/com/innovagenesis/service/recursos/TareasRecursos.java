/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.recursos;

import com.innovagenesis.service.dao.DaoTarea;
import com.innovagenesis.service.entidades.Tareas;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author alexi
 */

@Path("tareas")
public class TareasRecursos {
           
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Tareas> get(){
        //Listar un elemento
        try {
            return DaoTarea.getIntanceTarea().listar();
        } catch (SQLException ex) {
            Logger.getLogger(TareasRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    //Se le agrego boolean y los dos return, este metodo era void
    public Boolean post(Tareas tareas){
        //Insetar un elemento
        try {
            DaoTarea.getIntanceTarea().insertar(tareas);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TareasRecursos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    @GET
    @Path("{id}")
    public Tareas buscarID (@PathParam("id")Integer id){
        //Buescar por id        
        try {
           return DaoTarea.getIntanceTarea().buscar(id);
        } catch (SQLException ex) {
            Logger.getLogger(TareasRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
    
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id")Integer id){
        // Eliminar elemento
        try {
            DaoTarea.getIntanceTarea().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(TareasRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("{id}")
    public void put(@PathParam("id")Integer id, Tareas tareas){
        //Actualizar elemento
        tareas.setId_tarea(id);
        
        try {
            DaoTarea.getIntanceTarea().actualizar(tareas);
        } catch (SQLException ex) {
            Logger.getLogger(TareasRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
