package model;

import database.CRUD;
import database.ConfigDB;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialityModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        Connection objConecction = ConfigDB.openConnection();
        Speciality objSpeciality = (Speciality) obj;

        try {
            String sql = "INSERT INTO speciality (name_speciality, description) VALUES (?, ?);";
            PreparedStatement objPrepare = objConecction.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objSpeciality.getName_speciality());
            objPrepare.setString(2, objSpeciality.getDescription());
            objPrepare.execute();
            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()) {
                objSpeciality.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "La especialidad fue agregada con éxito");

        } catch (SQLException e) {
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objSpeciality;

    }

    @Override
    public List<Object> findAll() {

        List<Object> listEspecialities = new ArrayList<>();
                Connection objConnection = ConfigDB.openConnection();

                try {
                    String sql = "SELECT * FROM speciality:";
                    PreparedStatement objPrepare = objConnection.prepareStatement(sql);

                    ResultSet objResult = objPrepare.executeQuery();
                    while (objResult.next()) {
                        Speciality objSpeciality = new Speciality();
                        objSpeciality.setId(objResult.getInt("id"));
                        objSpeciality.setName_speciality(objResult.getString("name_speciality"));
                        objSpeciality.setDescription(objResult.getString("description"));

                        listEspecialities.add(objSpeciality);
                    }
                }catch (SQLException e){
                    System.out.println("ERROR >" + e.getMessage());
                }

                ConfigDB.closeConnection();;
                return listEspecialities;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Speciality objSpeciality = (Speciality) obj;
        boolean isUpdate = false;

        try {
            String sql = "UPDATE especialidad SET nombre = ?, descripcion =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objSpeciality.getName_speciality());
            objPrepare.setString(2, objSpeciality.getDescription());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected>0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "El registro fue actualizado con éxito");
            }
        }catch (SQLException e){
            System.out.println("ERROR >" +e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }

    @Override
    public boolean delete(Object obj) {

        Connection objConnection = ConfigDB.openConnection();
        Speciality objSpeciality = (Speciality) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM speciality WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objSpeciality.getId());
            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0){
                isDeleted= true;

                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
            }
        }catch (SQLException e){
            System.out.println("ERROR" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isDeleted;
    }
}
