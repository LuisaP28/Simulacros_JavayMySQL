package controller;

import entity.Doctor;
import entity.Speciality;
import model.DoctorModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class DoctorController {

    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showInputDialog(null, list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros \n:";

        for (Object temp : list){
            Doctor objDoctor = (Doctor) temp;
            listString+= objDoctor.toString() + "\n";
        }
        return listString;

    }

    public static void delete (){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Doctor objDoctor = (Doctor) JOptionPane.showInputDialog(
                null,
                "Seleccione el médico a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objDoctor);
    }
public static void update(){
    Object[] options = Utils.listToArray(instanceModel().findAll());
    Doctor objDoctor = (Doctor) JOptionPane.showInputDialog(
            null,
            "Seleccione el médico a editar",
            "",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
    );

    String name_doctor = JOptionPane.showInputDialog(null, "Ingrese el nombre del médico", objDoctor.getName_doctor());
    String lastname = JOptionPane.showInputDialog("Ingrese los apellidos del médico", objDoctor.getLastname());

    Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
            null,
            "Seleccione una especialidad",
            "",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]
    );

    instanceModel().update(new Doctor(name_doctor, lastname, objSpeciality.getId(), objSpeciality));
}

    public static void insert() {
        String name_doctor = JOptionPane.showInputDialog("Ingrese el nombre del médico:");
        String lastname = JOptionPane.showInputDialog("Ingrese los apellidos del médico:");

        Object[] optionsSpecialities = Utils.listToArray(SpecialityController.instanceModel().findAll());
        Speciality objSpeciality = (Speciality) JOptionPane.showInputDialog(
                null,
                "Seleccione una especialidad",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsSpecialities,
                optionsSpecialities[0]
        );
        instanceModel().insert(new Doctor(name_doctor, lastname, objSpeciality.getId(), objSpeciality));
    }

        public static DoctorModel instanceModel() {
            return new DoctorModel();
        }
}
