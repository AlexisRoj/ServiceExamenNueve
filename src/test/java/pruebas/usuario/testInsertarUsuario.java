/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.usuario;

import com.innovagenesis.service.dao.DaoUsuario;
import com.innovagenesis.service.entidades.Usuarios;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class testInsertarUsuario {
    
    public static void main(String[] args) {
        
        DaoUsuario daoUsuario = new DaoUsuario();
        
        try {
            daoUsuario.insertar(
                    new Usuarios(110214,"AocioR","Rojas",2));
            System.out.println("Usuario Insertado");
        } catch (SQLException ex) {
            Logger.getLogger(testInsertarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
