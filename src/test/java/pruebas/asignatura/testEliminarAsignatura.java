/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.asignatura;

import com.innovagenesis.service.dao.DaoAsignatura;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class testEliminarAsignatura {
    
    public static void main(String[] args) {
        
        DaoAsignatura daoAsignatura = new DaoAsignatura();
        
        try {
            daoAsignatura.eliminar(1);
            System.out.println("Usuario Eliminado");
        } catch (SQLException ex) {
            Logger.getLogger(testEliminarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al momento de eliminar usuario");
        }
    }
    
}
