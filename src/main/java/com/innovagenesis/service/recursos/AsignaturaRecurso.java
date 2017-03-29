/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.recursos;

import com.innovagenesis.service.dao.DaoAsignatura;
import com.innovagenesis.service.entidades.Asignatura;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexi
 */
@Path("asignatura")
public class AsignaturaRecurso {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Asignatura> get(){
        
        try {
            return DaoAsignatura.getInstanceAsignatura().listar();
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaRecurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
