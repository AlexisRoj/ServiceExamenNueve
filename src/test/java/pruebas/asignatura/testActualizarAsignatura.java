/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas.asignatura;

import com.innovagenesis.service.dao.DaoAsignatura;
import com.innovagenesis.service.entidades.Asignatura;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 /**
 *
 * @author alexi
 */
public class testActualizarAsignatura {
    
    public static void main(String[] args) {
        
            DaoAsignatura da = new DaoAsignatura();
            Asignatura asignatura = new Asignatura("Alexis Jesus");
            asignatura.setId_asigna(3);
            
        try {
            da.actualizar(asignatura);
            System.out.println("Usuario actulizado");
        } catch (SQLException ex) {
            System.out.println("Error al actualizar");
            Logger.getLogger(testActualizarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
