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
public class testListarTareas {
    
    public static void main(String[] args) {
        
            DaoTarea daoTarea = DaoTarea.getIntanceTarea();
            
        try {
            System.out.println(daoTarea.listar());
        } catch (SQLException ex) {
            Logger.getLogger(testListarTareas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al listar tareas");
        }
    }      
    
}
