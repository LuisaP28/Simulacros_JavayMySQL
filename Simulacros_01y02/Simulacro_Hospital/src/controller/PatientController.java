package controller;

import entity.Doctor;
import entity.Patient;
import model.PatientModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PatientController {
    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                null,
                "Seleccione el paciente a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        patientSelected.setName(JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre", patientSelected.getName()));
        patientSelected.setLastname(JOptionPane.showInputDialog(null, "Ingrese el nuevo apellido", patientSelected.getLastname()));
        patientSelected.setDate_birth(JOptionPane.showInputDialog(null, "Ingrese la nueva fecha de nacimiento YYYY-MM-dd", patientSelected.getDate_birth()));
        patientSelected.setIdentification_document(JOptionPane.showInputDialog(null, "Ingrese el nuevo documento", patientSelected.getIdentification_document()));

        instanceModel().update(patientSelected);
    }
    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Patient patientSelected = (Patient) JOptionPane.showInputDialog(
                null,
                "Seleccione el paciente a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        instanceModel().delete(patientSelected);

    }
    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null, list);

    }
    public static String  getAll(List<Object> list){
        String listString = "Lista de registros";

        for (Object temp: list){
            Patient objPatient = (Patient) temp;
            listString += objPatient.toString() +"\n";
        }
        return listString;
    }
    public static void insert() {
        String name_patient = JOptionPane.showInputDialog("INgresa el nombre del paciente");
        String lastname = JOptionPane.showInputDialog("Ingresa los apellidos del paciente");
        String date_birth = JOptionPane.showInputDialog("Ingresa la fecha de nacimiento YYY-MM-dd");
        String document = JOptionPane.showInputDialog("Ingresa el documento del paciente");

    }

    public static PatientModel instanceModel(){
        return new PatientModel();

    }
}
