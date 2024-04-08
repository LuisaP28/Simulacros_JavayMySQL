package controller;

import entity.Appointment;
import entity.Doctor;
import entity.Patient;
import model.AppointmentModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AppointmentController {
    public static void insert() {
        String date = JOptionPane.showInputDialog("Ingresa la fecha de la cita: YYYY-MM-dd");
        String time = JOptionPane.showInputDialog("Ingresa la hora de la cita: HH:mm:ss");
        String reason = JOptionPane.showInputDialog("Ingresa el motivo de la cita");

       Object[] optionsPatient = Utils.listToArray(PatientController.instanceModel().findAll());
       Object[] optionDoctor = Utils.listToArray(DoctorController.instanceModel().findAll());

        Patient patientSelected = (Patient) JOptionPane.showInputDialog(null, "Seleccione el paciente", "", JOptionPane.QUESTION_MESSAGE, null, optionsPatient, optionsPatient[0]);
        Doctor doctorSelected = (Doctor) JOptionPane.showInputDialog(null, "Seleccione el médico asignado a la cita", "", JOptionPane.QUESTION_MESSAGE, null, optionDoctor, optionDoctor[0]);

        instanceModel().insert(new Appointment());

    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Appointment appointmentSelected = (Appointment) JOptionPane.showInputDialog(null, "Seleccione la cita a editar", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        appointmentSelected.setAppointment_date(JOptionPane.showInputDialog(null, "Ingresa la fecha de la cita: YYYY-MM-dd", appointmentSelected.getAppointment_date()));
        appointmentSelected.setAppointment_time(JOptionPane.showInputDialog(null, "Ingresa la hora de la cita: HH:mm:ss", appointmentSelected.getAppointment_time()));
        appointmentSelected.setReason(JOptionPane.showInputDialog(null, "Ingresa el motivo de la cita", appointmentSelected.getReason()));

        Object[] optionsPatient = Utils.listToArray(PatientController.instanceModel().findAll());
        Object[] optionDoctor = Utils.listToArray(DoctorController.instanceModel().findAll());

       appointmentSelected.setObjPatient ((Patient) JOptionPane.showInputDialog(null, "Seleccione el paciente", "", JOptionPane.QUESTION_MESSAGE, null, optionsPatient, optionsPatient[0]));

        appointmentSelected.setId_patient(appointmentSelected.getObjPatient().getId());

      appointmentSelected.setPbjDoctor ((Doctor) JOptionPane.showInputDialog(null, "Seleccione el médico asignado a la cita", "", JOptionPane.QUESTION_MESSAGE, null, optionDoctor, optionDoctor[0]));

      appointmentSelected.setId_doctor(appointmentSelected.getId_doctor());
      instanceModel().update(appointmentSelected);
    }

    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Appointment appointmentSelected = (Appointment) JOptionPane.showInputDialog(null, "Seleccione la cita a eliminar", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        instanceModel().delete(appointmentSelected);

    }

    public static void getAll(){
        String listString = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null, listString);
    }

    public static String getAll(List<Object> list){
        String listString = "Lista de registros \n";

        for (Object temp : list){
            Appointment obj =(Appointment) temp;
            listString += obj.toString() + "\n";
        }
        return listString;
    }

    public static AppointmentModel instanceModel(){
        return  new AppointmentModel();
    }
}
