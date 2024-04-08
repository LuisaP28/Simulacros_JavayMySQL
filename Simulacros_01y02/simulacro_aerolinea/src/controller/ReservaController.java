package controller;

import entity.Pasajero;
import entity.Reserva;
import entity.Vuelo;
import model.ReservaModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;


public class ReservaController {
    public static void insert() {
        String fecha = JOptionPane.showInputDialog("Ingresa la fecha de la reserva: YYYY-MM-dd");
        String asiento = JOptionPane.showInputDialog("Ingresa el asiento: ");


        Object[] optionsPasajero = Utils.listToArray(PasajeroController.instanceModel().findAll());
        Object[] optionVuelo = Utils.listToArray(VueloController.instanceModel().findAll());

        Pasajero pasajerotSelected = (Pasajero) JOptionPane.showInputDialog(null, "Seleccione el pasajero", "", JOptionPane.QUESTION_MESSAGE, null, optionsPasajero, optionsPasajero[0]);
        Vuelo vueloSelected = (Vuelo) JOptionPane.showInputDialog(null, "Seleccione el vuelo asignado", "", JOptionPane.QUESTION_MESSAGE, null, optionVuelo, optionVuelo[0]);

        instanceModel().insert(new Reserva());

    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Reserva reservaSelected = (Reserva) JOptionPane.showInputDialog(null, "Seleccione la cita a editar", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        reservaSelected.setFecha_reserva(JOptionPane.showInputDialog(null, "Ingresa la fecha de la cita: YYYY-MM-dd", reservaSelected.getFecha_reserva()));
        reservaSelected.setAsiento(JOptionPane.showInputDialog(null, "Ingresa el asiento: ", reservaSelected.getAsiento()));


        Object[] optionsPasajero = Utils.listToArray(PasajeroController.instanceModel().findAll());
        Object[] optionVuelo = Utils.listToArray(VueloController.instanceModel().findAll());

        reservaSelected.setObjPasajero ((Pasajero) JOptionPane.showInputDialog(null, "Seleccione el pasajero", "", JOptionPane.QUESTION_MESSAGE, null, optionsPasajero, optionsPasajero[0]));

        reservaSelected.setId_pasajero(reservaSelected.getObjPasajero().getId());

        reservaSelected.setObjVuelo ((Vuelo) JOptionPane.showInputDialog(null, "Seleccione el vuelo asignado", "", JOptionPane.QUESTION_MESSAGE, null, optionVuelo, optionVuelo[0]));

        reservaSelected.setId_vuelo(reservaSelected.getId_vuelo());
        instanceModel().update(reservaSelected);
    }

    public static void delete(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Reserva reservaSelected = (Reserva) JOptionPane.showInputDialog(null, "Seleccione la reserva a eliminar", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        instanceModel().delete(reservaSelected);

    }

    public static void getAll(){
        String listString = getAll(instanceModel().findAll());
        JOptionPane.showMessageDialog(null, listString);
    }

    public static String getAll(List<Object> list){
        String listString = "Lista de registros \n";

        for (Object temp : list){
            Reserva obj =(Reserva) temp;
            listString += obj.toString() + "\n";
        }
        return listString;
    }

    public static ReservaModel instanceModel(){
        return  new ReservaModel();
    }
}