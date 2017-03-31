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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
        try {
            return DaoTarea.getIntanceTarea().listar();
        } catch (SQLException ex) {
            Logger.getLogger(TareasRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Tareas tareas){
        
        try {
            DaoTarea.getIntanceTarea().insertar(tareas);
        } catch (SQLException ex) {
            Logger.getLogger(TareasRecursos.class.getName()).log(Level.SEVERE, null, ex);
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
    
}
