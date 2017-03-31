/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.innovagenesis.service.dao;

import com.innovagenesis.service.entidades.Asignatura;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alexi
 */
public class DaoAsignatura implements IDAO<Asignatura> {

    private PreparedStatement insetar, eliminar, listar, buscar, actualizar;
    private String sql = "";

    private static DaoAsignatura instancia;

    private DaoAsignatura() {
    }

    public static DaoAsignatura getInstanceAsignatura() {

        if (instancia == null) {
            instancia = new DaoAsignatura();
        }
        return instancia;
    }

    @Override
    public void insertar(Asignatura entidad) throws SQLException {
        //Inserar usuario
        sql = "INSERT INTO tbl_asignatura (nom_asignatura) VALUES ( ? )";

        if (insetar == null) {
            insetar = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        insetar.setString(1, entidad.getNom_asigna());
        insetar.executeUpdate();
    }

    @Override
    public void eliminar(Integer id) throws SQLException {
        //Eliminar usuario
        sql = "DELETE FROM tbl_asignatura WHERE id_asignatura = ?";

        if (eliminar == null) {
            eliminar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        eliminar.setInt(1, id);
        eliminar.executeUpdate();
    }

    @Override
    public List<Asignatura> listar() throws SQLException {
        //Listar Asignatura
        sql = "SELECT * FROM tbl_asignatura";

        if (listar == null) {
            listar = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        ResultSet set = listar.executeQuery();
        ArrayList<Asignatura> result = new ArrayList<>();

        while (set.next()) {
            result.add(cargar(set));
        }
        return result;
    }

    @Override
    public Asignatura buscar(Integer id) throws SQLException {
        //Buscar por id
        sql = "SELECT * FROM tbl_asignatura WHERE id_asignatura = ?";

        if (buscar == null) {
            buscar = Conexion.getIntance().getCon().prepareStatement(sql);
        }
        buscar.setInt(1, id);

        ResultSet set = buscar.executeQuery();

        return set != null && set.next() ? cargar(set) : null;
    }

    public Asignatura cargar(ResultSet set) throws SQLException {

        Asignatura asignatura = new Asignatura();
        //Cargar Asigntura
        asignatura.setId_asigna(set.getInt("id_asignatura"));
        asignatura.setNom_asigna(set.getString("nom_asignatura"));

        return asignatura;
    }

    @Override
    public void actualizar(Asignatura entidad) throws SQLException {

        sql = "UPDATE tbl_asignatura SET "
                + "nom_asignatura = ? "
                + "WHERE id_asignatura = ?";

        if (actualizar == null) {
            actualizar = Conexion.getIntance().getCon().prepareStatement(sql);
        }

        actualizar.setString(1, entidad.getNom_asigna());
        actualizar.setInt(2, entidad.getId_asigna());

        actualizar.executeUpdate();
    }

}
