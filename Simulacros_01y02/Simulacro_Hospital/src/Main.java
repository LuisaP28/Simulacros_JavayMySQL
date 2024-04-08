import controller.AppointmentController;
import controller.DoctorController;
import controller.PatientController;
import controller.SpecialityController;
import database.ConfigDB;
import entity.Appointment;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option = 0, option2 = 0;

        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Administrar Especialidades
                    2. Administrar Médicos
                    3. Administrar Pacientes
                    4. Administrar Citas
                    5. Salir
                                        
                    Ingrese una opción:
                    """));

            switch (option) {
                case 1:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Especialidad
                                2. Crear Especialidad
                                3. Eliminar Especialidad
                                4. Actualizar Especialidad
                                5. Salir
                                  
                                Ingrese una opción:
                                """));

                        switch (option2) {
                            case 1:
                                SpecialityController.getAll();
                                break;
                            case 2:
                                SpecialityController.insert();
                                break;
                            case 3:
                                SpecialityController.delete();
                                break;
                            case 4:
                                SpecialityController.update();
                                break;
                        }
                    } while (option2 != 5);
                    break;
                case 2:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Medicos
                                2. Crear Medico
                                3. Eliminar Medico
                                4. Actualizar Medico
                                5. Salir
                                  
                                Ingrese una opción:
                                """));
                        switch (option2) {
                            case 1:
                                DoctorController.getAll();
                                break;
                            case 2:
                                DoctorController.insert();
                                break;
                            case 3:
                                DoctorController.delete();
                                break;
                            case 4:
                                DoctorController.update();
                                break;
                        }

                    } while (option2 != 5);
                    break;
                case 3:
                    do {
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Pacientes
                                2. Crear Paciente
                                3. Eliminar Paciente
                                4. Actualizar Paciente
                                5. Salir
                                  
                                Ingrese una opción:
                                """));
                        switch (option2) {
                            case 1:
                                PatientController.getAll();
                                break;
                            case 2:
                                PatientController.insert();
                                break;
                            case 3:
                                PatientController.delete();
                                break;
                            case 4:
                                PatientController.update();
                                break;
                        }

                    } while (option2 != 5);
                case 4:
                    option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Listar Citas
                                2. Crear Citas
                                3. Eliminar Citas
                                4. Actualizar Citas
                                5. Salir
                                  
                                Ingrese una opción:
                                """));

                    switch (option2){
                        case 1:
                            AppointmentController.getAll();
                            break;
                        case 2:
                            AppointmentController.insert();
                            break;
                        case 3:
                            AppointmentController.delete();
                            break;
                        case 4:
                            AppointmentController.update();
                            break;
                    }
                    break;
            }
        } while (option != 5);

    }
}