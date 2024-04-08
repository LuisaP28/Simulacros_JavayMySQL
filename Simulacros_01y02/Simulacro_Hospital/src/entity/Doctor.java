package entity;

public class Doctor {

    private int id;
    private String name_doctor;
    private String lastname;
    private int id_speciality;

    private Speciality objSpeciality;
    public Doctor() {
    }


    public Doctor(String name_doctor, String lastname, int id_speciality, Speciality objSpeciality) {
        this.name_doctor = name_doctor;
        this.lastname = lastname;
        this.id_speciality = id_speciality;
        this.objSpeciality = objSpeciality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_doctor() {
        return name_doctor;
    }

    public void setName_doctor(String name_doctor) {
        this.name_doctor = name_doctor;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(int id_speciality) {
        this.id_speciality = id_speciality;
    }

    public Speciality getObjSpeciality() {
        return objSpeciality;
    }
    public void setObjSpeciality(Speciality objSpeciality) {
        this.objSpeciality = objSpeciality;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name_doctor='" + name_doctor + '\'' +
                ", lastname='" + lastname + '\'' +
                ", id_speciality=" + id_speciality +
                '}';
    }
}


