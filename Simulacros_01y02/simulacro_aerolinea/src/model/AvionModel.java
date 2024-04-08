package model;

import database.CRUD;
import database.ConfigDB;
import entity.Avion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvionModel implements CRUD {
    public Object insert(Object obj) {
        Connection objConecction = ConfigDB.openConnection();
        Avion objAvion = (Avion) obj;

        try {
            String sql = "INSERT INTO avion (modelo, capacidad) VALUES (?, ?);";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objAvion.getModelo());
            objPrepare.setInt(2, objAvion.getCapacidad());

            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objAvion.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El avión fue agregado con éxito");

        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAvion;

    }

    @Override
    public List<Object> findAll() {

        List<Object> listAviones = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM avion;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();
            while (objResult.next()) {
                Avion objAvion = new Avion();
                objAvion.setId(objResult.getInt("id"));
                objAvion.setCapacidad(objResult.getInt("capacidad"));
                objAvion.setModelo(objResult.getString("modelo"));

                listAviones.add(objAvion);
            }
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }

        ConfigDB.closeConnection();
        ;
        return listAviones;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Avion objAvion = (Avion) obj;
        boolean isUpdate = false;

        try {
            String sql = "UPDATE avion SET modelo = ?, capacidad =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objAvion.getModelo());
            objPrepare.setInt(2, objAvion.getCapacidad());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0) {
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "El registro fue actualizado con éxito");
            }
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {

        Connection objConnection = ConfigDB.openConnection();
        Avion objAvion = (Avion) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM avion WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objAvion.getId());
            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0) {
                isDeleted = true;

                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
            }
        } catch (SQLException e) {
            System.out.println("ERROR" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isDeleted;
    }
}
