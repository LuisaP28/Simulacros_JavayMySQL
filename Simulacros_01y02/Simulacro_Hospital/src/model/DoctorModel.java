package model;

import database.CRUD;
import database.ConfigDB;
import entity.Doctor;
import entity.Speciality;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorModel implements CRUD {

    @Override
    public Object insert(Object obj) {

        Connection objConnection = ConfigDB.openConnection();

        Doctor objDoctor = (Doctor) obj;

        try {
            String sql = "INSERT INTO doctor (name_doctor, lastname, id_speciality) VALUES (?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objDoctor.getName_doctor());
            objPrepare.setString(2, objDoctor.getLastname());
            objPrepare.setInt(3, objDoctor.getId());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while (objResult.next()){
                objDoctor.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
        }catch (SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        return objDoctor;
    }

    @Override
    public List<Object> findAll() {
        List<Object> listMedics = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM doctor\n" +
                    "INNER JOIN speciality ON speciality.id = doctor.id_speciality:";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Doctor objDoctor = new Doctor();
                Speciality objSpeciality = new Speciality();

                objDoctor.setId(objResult.getInt("doctor.id"));
                objDoctor.setName_doctor(objResult.getString("doctor.name_doctor"));
                objDoctor.setLastname(objResult.getString("doctor.lastname"));
                objDoctor.setId_speciality(objResult.getInt("doctor.id_speciality"));

                objSpeciality.setId(objResult.getInt("speciality.id"));
                objSpeciality.setName_speciality(objResult.getString("speciality.name_speciality"));
                objSpeciality.setDescription(objResult.getString("speciality.description"));

            objDoctor.setObjSpeciality(objSpeciality);
            listMedics.add(objDoctor);
            }

        }catch(SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        return listMedics;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Doctor objDoctor = (Doctor) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE doctor SET name_doctor=?, lastname=?, id_speciality=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objDoctor.getName_doctor());
            objPrepare.setString(2, objDoctor.getLastname());
            objPrepare.setInt(3, objDoctor.getId_speciality());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected >0){
                isUpdated = true;
                JOptionPane.showInputDialog(null, "Registro actualizado con éxito");
            }

        }catch(SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Doctor objDoctor =(Doctor) obj;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM doctor WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objDoctor.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected >0){
                isDeleted = true;
                JOptionPane.showInputDialog(null, "Registro eliminado con éxito");
            }

        }catch(SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }
}
