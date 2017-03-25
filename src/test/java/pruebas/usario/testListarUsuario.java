/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.usario;

import com.innovagenesis.service.dao.DaoUsuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class testListarUsuario {
    
    public static void main(String[] args) {
        
        DaoUsuario daoUsuario = new DaoUsuario();
        
        try {
            System.out.println(daoUsuario.listar());
        } catch (SQLException ex) {
            Logger.getLogger(testListarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al listar");
        }
    }
    
}
