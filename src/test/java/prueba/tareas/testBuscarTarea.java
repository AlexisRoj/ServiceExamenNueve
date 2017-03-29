/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.tareas;

import com.innovagenesis.service.dao.DaoTarea;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class testBuscarTarea {
    
    public static void main(String[] args) {
    
        DaoTarea daoTarea = DaoTarea.getIntanceTarea();
        
        try {
            System.out.println(daoTarea.buscar(13));
        } catch (SQLException ex) {
            Logger.getLogger(testBuscarTarea.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al realizar la busqueda del elemeno");
        }
        
    }
    
}
