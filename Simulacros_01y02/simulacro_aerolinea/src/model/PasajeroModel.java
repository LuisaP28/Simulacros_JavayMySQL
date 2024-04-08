package model;

import database.ConfigDB;
import entity.Pasajero;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroModel {

    public Object insert(Object obj) {

        Connection objConnection = ConfigDB.openConnection();
        Pasajero objPasajero = (Pasajero) obj;

        try {
            String sql = "INSERT INTO pasajero (nombre, apellido, documento_identidad) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objPasajero.getNombre());
            objPrepare.setString(2, objPasajero.getApellido());
            objPrepare.setString(3, objPasajero.getDocumento_identidad());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objPasajero.setId(objResult.getInt(1));
            }
            JOptionPane.showInputDialog(null, "Registro exitoso");
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return objPasajero;

    }

    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Pasajero objPasajero = (Pasajero) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE pasajero SET nombre=?, apellido=?, documento_identidad=? WHERE id=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objPasajero.getNombre());
            objPrepare.setString(2, objPasajero.getApellido());
            objPrepare.setString(3, objPasajero.getDocumento_identidad());
            objPrepare.setInt(4, objPasajero.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0) {
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "Registro actualizado con éxito");

            }


        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdated;

    }

    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listaPasajeros = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pasajero;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Pasajero objPasajero = new Pasajero();
                objPasajero.setId(objResult.getInt("id"));
                objPasajero.setNombre(objResult.getString("nombre"));
                objPasajero.setApellido(objResult.getString("apellido"));
                objPasajero.setDocumento_identidad(objResult.getString("documento_identidad"));

                listaPasajeros.add(objPasajero);
            }
        }catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return listaPasajeros;
    }

    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Pasajero objPasajero = (Pasajero) obj;
        boolean isDeleted = false;

        try {
            String sql = "Deleted FROM patient WHERE id=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objPasajero.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
            }

        }catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }
}


