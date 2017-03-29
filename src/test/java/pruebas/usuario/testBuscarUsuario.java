/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.usuario;

import com.innovagenesis.service.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class testBuscarUsuario {

    public static void main(String[] args) {

        DaoUsuario daoUsuario = DaoUsuario.getInstanceUsuario();

        try {
            System.out.println(daoUsuario.buscar(3));
        } catch (SQLException ex) {
            
            Logger.getLogger(testBuscarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la busqueda");
        }
        
    }

}
