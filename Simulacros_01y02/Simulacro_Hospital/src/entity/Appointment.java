package entity;

public class Appointment {

    private int id;
    private int id_patient;
    private int id_doctor;
    private String appointment_date;
    private String appointment_time;
    private String reason;
    private Doctor objDoctor;
    private Patient objPatient;

    public Appointment() {
    }


    public Appointment(int id_patient, int id_doctor, String appointment_date, String appointment_time, String reason, Doctor objDoctor, Patient objPatient) {
        this.id_patient = id_patient;
        this.id_doctor = id_doctor;
        this.appointment_date = appointment_date;
        this.appointment_time = appointment_time;
        this.reason = reason;
        this.objDoctor = objDoctor;
        this.objPatient = objPatient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    public int getId_doctor() {
        return id_doctor;
    }

    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Doctor getPbjDoctor() {
        return objDoctor;
    }

    public void setPbjDoctor(Doctor pbjDoctor) {
        this.objDoctor = pbjDoctor;
    }

    public Patient getObjPatient() {
        return objPatient;
    }

    public void setObjPatient(Patient objPatient) {
        this.objPatient = objPatient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_date='" + appointment_date + '\'' +
                ", appointment_time='" + appointment_time + '\'' +
                ", reason='" + reason + '\'' +
                ", pbjDoctor=" + objDoctor +
                ", objPatient=" + objPatient +
                '}';
    }
}