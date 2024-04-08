package model;

import database.CRUD;
import database.ConfigDB;
import entity.Pasajero;
import entity.Reserva;
import entity.Vuelo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Reserva objReserva = (Reserva) obj;

        try {
            String sql = "INSERT reserva(id_pasajero, id_vuelo, fecha_reserva, asiento) VALUES (?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objReserva.getId_pasajero());
            objPrepare.setInt(2, objReserva.getId_vuelo());
            objPrepare.setDate(3, Date.valueOf(objReserva.getFecha_reserva()));
            objPrepare.setString(4, objReserva.getAsiento());


            objPrepare.execute();

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                objReserva.setId(objResult.getInt(1));
            }
            JOptionPane.showInputDialog(null, "Registro insertado correctamente");

        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objReserva;
    }

    @Override
    public List<Object> findAll() {
            Connection objConnection = ConfigDB.openConnection();
            List<Object> listReserva = new ArrayList<>();

            try {
                String sql = "SELECT * FROM reserva\n" +
                        "INNER JOIN pasajero ON pasajero.id = reserva.id_pasajero\n" +
                        "INNER JOIN vuelo ON vuelo.id = reserva.id_vuelo;";

                PreparedStatement objPrepare = objConnection.prepareStatement(sql);

                ResultSet objResult = objPrepare.executeQuery();

                while (objResult.next()){
                    Reserva objReser = new Reserva();
                    Pasajero objPasajero = new Pasajero();
                    Vuelo objVuelo = new Vuelo();

                    objReser.setId(objResult.getInt("reserva.id"));
                    objReser.setId_pasajero(objResult.getInt("reserva.id_Pasajero"));
                    objReser.setId_vuelo(objResult.getInt("reserva.id_vuelo"));
                    objReser.setFecha_reserva(objResult.getString("reserva.fecha_reserva"));
                    objReser.setAsiento(objResult.getString("reserva.asiento"));

                    objPasajero.setNombre(objResult.getString("pasajero.nombre"));
                    objVuelo.setId_avion(objResult.getInt("vuelo.id"));
                    objReser.setObjPasajero(objPasajero);
                    objReser.setObjVuelo(objVuelo);

                    listReserva.add(objReser);
                }

            }catch (SQLException e){
                System.out.println("ERROR >"+ e.getMessage());
            }
             return listReserva;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Reserva objReserva = (Reserva) obj;
        boolean isUpdated = false;

            try {
                String sql = "UPDATE reserva SET id_pasajero=?, id_vuelo=?, fecha_reserva=?, asiento=? WHERE id=?";
                PreparedStatement objPrepare = objConnection.prepareStatement(sql);

                objPrepare.setInt(1, objReserva.getId_pasajero());
                objPrepare.setInt(2, objReserva.getId_vuelo());
                objPrepare.setDate(3, Date.valueOf(objReserva.getFecha_reserva()));
                objPrepare.setString(4, objReserva.getAsiento());
                objPrepare.setInt(6, objReserva.getId());

                int totalRowAffected = objPrepare.executeUpdate();

                if (totalRowAffected > 0) {
                    isUpdated = true;
                    JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
                }

            } catch (SQLException e) {
                System.out.println("ERROR >" + e.getMessage());
            }
            ConfigDB.closeConnection();
            return isUpdated;
    }
    @Override
    public boolean delete (Object obj){
       Connection objConnection = ConfigDB.openConnection();
       Reserva objReserva = (Reserva) obj;
       boolean isDeleted = false;

       try {
           String sql = "DELETE FROM reserva WHERE id= ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objReserva.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0) {
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
            }

       } catch (SQLException e) {
               System.out.println("ERROR >" + e.getMessage());
       }
       ConfigDB.closeConnection();
       return isDeleted;
    }

}

