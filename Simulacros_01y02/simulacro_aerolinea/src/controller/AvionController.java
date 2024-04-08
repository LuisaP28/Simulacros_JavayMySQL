package controller;

import entity.Avion;
import model.AvionModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class AvionController {

    public static void insert() {
        String modelo = JOptionPane.showInputDialog("Ingresa el modelo del avion");
        String capacidad = JOptionPane.showInputDialog("Ingresa la capacidad del avión");

        instanceModel().insert(new Avion());
    }

    public static void getAll(){
        String list = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }
    public static String getAll(List<Object> list){
        String listString = "Lista de registros: \n";

        for (Object temp: list){
            Avion objAvion = (Avion) temp;
            listString+= objAvion.toString() + "\n";
        }
        return listString;
    }
    public static AvionModel instanceModel() {

        return new AvionModel();
    }

    public static void delete (){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Avion objSelected = (Avion) JOptionPane.showInputDialog(
                null,
                "Seleccione el avión a eliminar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objSelected);
    }
    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Avion objSelected = (Avion) JOptionPane.showInputDialog(
                null,
                "Seleccione un avión para actualizar",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );


        objSelected.setModelo(JOptionPane.showInputDialog(null, "Ingresa el nuevo modelo", objSelected.getModelo()));
        objSelected.setCapacidad(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la nueva capacidad", objSelected.getCapacidad())));

        instanceModel().update(objSelected);
    }
}
