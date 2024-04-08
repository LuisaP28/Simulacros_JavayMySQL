package controller;

import entity.Avion;
import entity.Vuelo;
import model.VueloModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class VueloController {
    public static void getAll() {
        String list = getAll(instanceModel().findAll());
        JOptionPane.showInputDialog(null, list);
    }

    public static String getAll(List<Object> list) {
        String listString = "Lista de registros \n:";

        for (Object temp : list) {
            Vuelo objVuelo = (Vuelo) temp;
            listString += objVuelo.toString() + "\n";
        }
        return listString;

    }

    public static void delete() {
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Vuelo objVuelo = (Vuelo) JOptionPane.showInputDialog(
                null,
                "Seleccione el vuelo a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objVuelo);
    }

    public static void update() {
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Vuelo objVuelo = (Vuelo) JOptionPane.showInputDialog(
                null,
                "Seleccione el vuelo a editar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        String destinoVuelo = JOptionPane.showInputDialog(null, "Ingrese el destino del vuelo", objVuelo.getDestino());
        String fechaSalida = JOptionPane.showInputDialog("Ingrese la fecha de salida del vuelo", objVuelo.getFecha_salida());
        String horaSalida = JOptionPane.showInputDialog("Ingrese la hora de salida del vuelo", objVuelo.getHora_salida());

        Avion objAvion = (Avion) JOptionPane.showInputDialog(
                null,
                "Seleccione una especialidad",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().update(new Vuelo(destinoVuelo, fechaSalida, horaSalida, objAvion.getId(), objAvion));
    }

    public static void insert() {
        String destinoVuelo = JOptionPane.showInputDialog("Ingrese el destino del vuelo:");
        String fechaSalida = JOptionPane.showInputDialog("Ingrese la fecha de salida:");
        String horaSalida = JOptionPane.showInputDialog("Ingrese la hora de salida HH:mm:ss :");

        Object[] optionsAviones = Utils.listToArray(AvionController.instanceModel().findAll());
        Avion objAvion = (Avion) JOptionPane.showInputDialog(
                null,
                "Seleccione un Avión",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsAviones,
                optionsAviones[0]
        );
        instanceModel().insert(new Avion());
    }

    public static VueloModel instanceModel() {
        return new VueloModel();

    }
}
