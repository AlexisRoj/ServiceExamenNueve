/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.usario;

import com.innovagenesis.service.dao.DaoUsuario;
import com.innovagenesis.service.entidades.Usuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class testActualizarUsuario {
    
    public static void main(String[] args) {
        
        DaoUsuario daoUsuario = new DaoUsuario();
        Usuarios usuarios = new Usuarios(123457,"Santiago","Rojas",2);
        usuarios.setId_usuario(3);
        
        try {
            daoUsuario.actualizar(usuarios);
            System.out.println("Usuario Actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(testActualizarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error Actualizando");
        }
        
    }
}
