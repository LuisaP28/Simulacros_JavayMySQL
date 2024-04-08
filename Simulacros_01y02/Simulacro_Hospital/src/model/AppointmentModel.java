package model;

import database.CRUD;
import database.ConfigDB;
import entity.Appointment;
import entity.Doctor;
import entity.Patient;

import javax.print.Doc;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentModel implements CRUD {


    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Appointment objAppoinment = (Appointment) obj;

        try {
            String sql = "INSERT appointment(date_appointment, time_appointment, reason, id_patient, id_doctor) VALUES (?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setDate(1, Date.valueOf(objAppoinment.getAppointment_date()));
            objPrepare.setTime(2, Time.valueOf(objAppoinment.getAppointment_date()));
            objPrepare.setString(3, objAppoinment.getReason());
            objPrepare.setInt(4, objAppoinment.getId_patient());
            objPrepare.setInt(5, objAppoinment.getId_doctor());

            objPrepare.execute();

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                objAppoinment.setId(objResult.getInt(1));
            }
            JOptionPane.showInputDialog(null, "Registro insertado correctamente");

        }catch (SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAppoinment;
    }

    @Override
    public List<Object> findAll() {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> listAppointment = new ArrayList<>();

        try {
            String sql = "SELECT * FROM appointment\n" +
            "INNER JOIN patient ON patient.id = appointment.id_patient\n" +
            "INNER JOIN doctor ON doctor.id = appointment.id_doctor;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Appointment objAppoint = new Appointment();
                Doctor objDoctor = new Doctor();
                Patient objPatient = new Patient();

                objAppoint.setId(objResult.getInt("appointment.id"));
                objAppoint.setAppointment_date(objResult.getString("appointment.date_appointment"));
                objAppoint.setAppointment_time(objResult.getString("appointment.time_appointment"));
                objAppoint.setReason(objResult.getString("appointment.reason"));
                objAppoint.setId_patient(objResult.getInt("appointment.id_patient"));
                objAppoint.setId_doctor(objResult.getInt("appointment.id_doctor"));

                objDoctor.setName_doctor(objResult.getString("doctor.name_doctor"));
                objPatient.setName(objResult.getString("patient.name_patient"));
                objAppoint.setPbjDoctor(objDoctor);
                objAppoint.setObjPatient(objPatient);

                listAppointment.add(objAppoint);
            }

        }catch (SQLException e){
            System.out.println("ERROR >"+ e.getMessage());
        }
        return listAppointment;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Appointment objAppointment = (Appointment) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE appointment SET appointment_date=?, appointment_time=?, reason=?, id_patient=?, id_doctor=? WHERE id=?";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setDate(1, Date.valueOf(objAppointment.getAppointment_date()));
            objPrepare.setTime(2, Time.valueOf(objAppointment.getAppointment_time()));
            objPrepare.setString(3, objAppointment.getReason());
            objPrepare.setInt(4, objAppointment.getId_patient());
            objPrepare.setInt(5, objAppointment.getId_doctor());
            objPrepare.setInt(6, objAppointment.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null, "Registro modificado con éxito");
            }

        }catch (SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdated;
    }


    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Appointment objAppointment = (Appointment) obj;
        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM appointment WHERE id= ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objAppointment.getId());

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isDeleted = true;
                JOptionPane.showMessageDialog(null, "Registro eliminado con éxito");
            }

        }catch (SQLException e){
            System.out.println("ERROR >" + e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDeleted;
    }
}
