import controller.AvionController;
import controller.PasajeroController;
import controller.ReservaController;
import controller.VueloController;
import database.ConfigDB;
import entity.Reserva;

import javax.swing.*;
import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int option = 0, option2 = 0;


        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Aviones
                    2. Administrar Vuelos
                    3. Administrar Pasajeros
                    4. Administrar Reservas
                    5. Salir
                                        
                    Ingrese una opción:
                    """));

            switch (option) {
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Aviones
                                2. Crear Avión
                                3. Eliminar Avión
                                4. Actualizar Avión
                                5. Salir
                                  
                                Ingrese una opción:
                                """));

                        switch (option2) {
                            case 1:
                                AvionController.getAll();
                                break;
                            case 2:
                                AvionController.insert();
                                break;
                            case 3:
                                AvionController.delete();
                                break;
                            case 4:
                                AvionController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;
                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Vuelos
                                2. Crear Vuelo
                                3. Eliminar Vuelo
                                4. Actualizar Vuelo
                                5. Salir
                                  
                                Ingrese una opción:
                                """));
                        switch (option2) {
                            case 1:
                                VueloController.getAll();
                                break;
                            case 2:
                                VueloController.insert();
                                break;
                            case 3:
                                VueloController.delete();
                                break;
                            case 4:
                                VueloController.update();
                                break;
                        }

                    } while (option2 != 5);
                    break;

                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Pasajeros
                                2. Crear Pasajeros
                                3. Eliminar Pasajeros
                                4. Actualizar Pasajeros
                                5. Salir
                                  
                                Ingrese una opción:
                                """));
                        switch (option2) {
                            case 1:
                                PasajeroController.getAll();
                                break;
                            case 2:
                                PasajeroController.insert();
                                break;
                            case 3:
                                PasajeroController.delete();
                                break;
                            case 4:
                                PasajeroController.update();
                                break;
                        }
                    } while (option2 != 5);
                case 4:
                    option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                            1. Listar Reservas
                            2. Crear Reserva
                            3. Eliminar Reserva
                            4. Actualizar Reserva
                            5. Salir
                              
                            Ingrese una opción:
                            """));

                    switch (option2) {
                        case 1:
                            ReservaController.getAll();
                            break;
                        case 2:
                            ReservaController.insert();
                            break;
                        case 3:
                            ReservaController.delete();
                            break;
                        case 4:
                            ReservaController.update();
                            break;
                    }
                    break;
            }
        } while (option != 5);
    }
}


