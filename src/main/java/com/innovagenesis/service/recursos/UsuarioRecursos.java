/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.recursos;

import com.innovagenesis.service.dao.DaoUsuario;
import com.innovagenesis.service.entidades.Usuarios;
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
@Path("usuarios")
public class UsuarioRecursos {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //Listar usuarios
    public List<Usuarios> get(){        
        try {
            return DaoUsuario.getInstanceUsuario().listar();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return null;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Usuarios usuarios){
        //Insertar usuario
        try {
            DaoUsuario.getInstanceUsuario().insertar(usuarios);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @GET
    @Path("{id_usuario}")
    public Usuarios buscarID(@PathParam("id_usuario")Integer id_usuario){
        //Buscar usuario
        try {
            return DaoUsuario.getInstanceUsuario().buscar(id_usuario);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;        
    }
    
    @PUT
    @Path("{id_usuario}")
    public void put (@PathParam("id_usuario")Integer id_usuario,Usuarios usuarios ){
        //Actualizar servicio
        usuarios.setId_usuario(id_usuario);
        try {
            DaoUsuario.getInstanceUsuario().actualizar(usuarios);            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id")Integer id){
        //Metodo que elimina un elemento
        try {
            DaoUsuario.getInstanceUsuario().eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
            
}
