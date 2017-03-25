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
public class testListarAsignatura {
    
    public static void main(String[] args) {
        
        DaoAsignatura da = new DaoAsignatura();
      
        try {
              System.out.println(da.listar());
        } catch (SQLException ex) {
            Logger.getLogger(testListarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al listar");
        }
    }
    
}
