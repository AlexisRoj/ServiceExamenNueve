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
public class testInsertarAsignatura {

    public static void main(String[] args) {

        DaoAsignatura asignatura = DaoAsignatura.getInstanceAsignatura();

        try {
            asignatura.insertar(new Asignatura("Cisica2"));
            System.out.println("Materia insertada corectamente");
        } catch (SQLException ex) {
            Logger.getLogger(testInsertarAsignatura.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al insertar materia");
        }
    }
}
