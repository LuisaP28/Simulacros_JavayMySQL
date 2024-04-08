package controller;

import database.CRUD;
import entity.Pasajero;
import jdk.jshell.execution.Util;
import model.PasajeroModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class PasajeroController {
    public static void insert() {
        String nombrePasajero = JOptionPane.showInputDialog("Ingresa el nombre del pasajero");
        String apellidoPasajero = JOptionPane.showInputDialog("Ingresa los apellidos del pasajero");
        String documentoIdentidad = JOptionPane.showInputDialog("Ingresa el documento del pasajero");
    }

    public static void getAll(){
        String list = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null, list);

    }
    public static String  getAll(List<Object> list){
        String listString = "Lista de registros";

        for (Object temp: list){
            Pasajero objPasajero = (Pasajero) temp;
            listString += objPasajero.toString() +"\n";
        }
        return listString;
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Pasajero pasajeroSelected = (Pasajero) JOptionPane.showInputDialog(
                null,
                "Seleccione el pasajero a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        pasajeroSelected.setNombre(JOptionPane.showInputDialog(null, "Ingrese el nuevo nombre", pasajeroSelected.getNombre()));
        pasajeroSelected.setApellido(JOptionPane.showInputDialog(null, "Ingrese el nuevo apellido", pasajeroSelected.getApellido()));
        pasajeroSelected.setDocumento_identidad(JOptionPane.showInputDialog(null, "Ingrese el nuevo documento de identidad", pasajeroSelected.getDocumento_identidad()));

        instanceModel().update(pasajeroSelected);
    }

    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Pasajero pasajeroSelected = (Pasajero) JOptionPane.showInputDialog(
                null,
                "Seleccione el pasajero a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );
        instanceModel().delete(pasajeroSelected);

    }

    static PasajeroModel instanceModel() {
        return new PasajeroModel();
    }


}
