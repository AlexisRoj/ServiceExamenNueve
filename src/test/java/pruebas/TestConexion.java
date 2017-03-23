/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import com.innovagenesis.service.dao.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexi
 */
public class TestConexion {
    
    public static void main(String[] args) {
        
        try {
            if (Conexion.getIntance().existeConexion()) {
                System.out.println("Conexion establecida");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestConexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error estableciendo la conexion");
        }
    }
    
}
