/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba.tareas;

import com.innovagenesis.service.dao.DaoTarea;
import com.innovagenesis.service.entidades.Tareas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class testInsetarTarea {
    
    public static void main(String[] args) {
        DaoTarea daoTarea = new DaoTarea();
        
        try {
            daoTarea.insertar(new Tareas("Examen Biologia",3,3,90));
            System.out.println("Usuario insertado");
            
        } catch (SQLException ex) {
            Logger.getLogger(testInsetarTarea.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error insertando usuario");
        }
    }
    
    
    
}
