package model;

import database.CRUD;
import database.ConfigDB;
import entity.Avion;
import entity.Vuelo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloModel implements CRUD {
    public Object insert(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Vuelo objVuelo = (Vuelo) obj;

        try {
            String sql = "INSERT INTO doctor (destino, fecha_salida, hora_salida, id_avion) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objVuelo.getDestino());
            objPrepare.setDate(2, Date.valueOf(objVuelo.getFecha_salida()));
            objPrepare.setTime(2, Time.valueOf(objVuelo.getHora_salida()));
            objPrepare.setInt(3, objVuelo.getId_avion());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objVuelo.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        return objVuelo;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listMedics = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM vuelo\n" +
                    "INNER JOIN avion ON avion.id = vuelo.id_avion:";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Vuelo objVuelo = new Vuelo();
                Avion objAvion = new Avion();

                objVuelo.setId(objResult.getInt("vuelo.id"));
                objVuelo.setDestino(objResult.getString("vuelo.destino"));
                objVuelo.setFecha_salida(objResult.getString("vuelo.fecha_salida"));
                objVuelo.setHora_salida(objResult.getString("vuelo.hora_salida"));
                objVuelo.setId_avion(objResult.getInt("vuelo.id_avion"));

                objAvion.setId(objResult.getInt("avion.id"));
                objAvion.setModelo(objResult.getString("avion.modelo"));
                objAvion.setCapacidad(objResult.getInt("avion.capacidad"));

                objVuelo.setObjAvion(objAvion);
                listMedics.add(objVuelo);
            }

        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        return listMedics;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vuelo objVuelo = (Vuelo) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE vuelo SET destino=?, fecha_salida=?, hora_salida=?, id_avion=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objVuelo.getDestino());
            objPrepare.setDate(2, Date.valueOf(objVuelo.getFecha_salida()));
            objPrepare.setTime(3, Time.valueOf(objVuelo.getHora_salida()));
            objPrepare.setInt(4, objVuelo.getId_avion());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0) {
                isUpdated = true;
                JOptionPane.showInputDialog(null, "Registro actualizado con éxito");
            }

        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Vuelo objVuelo = (Vuelo) obj;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM vuelo WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objVuelo.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0) {
                isDeleted = true;
                JOptionPane.showInputDialog(null, "Registro eliminado con éxito");
            }

        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }
}
