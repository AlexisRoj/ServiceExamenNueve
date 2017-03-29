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
public class testBuscarAsignatura {
    
    public static void main(String[] args) {
        
        DaoAsignatura asignatura = DaoAsignatura.getInstanceAsignatura();
        
        try {
            System.out.println(asignatura.buscar(4));
        } catch (SQLException ex) {
            Logger.getLogger(testBuscarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al realizar la busqueda");
        }
    }
    
}
