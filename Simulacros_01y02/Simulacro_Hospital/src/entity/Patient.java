package entity;

public class Patient {

    private int id;
    private String name;
    private String lastname;
    private String date_birth;
    private String identification_document;

    public Patient() {
    }

    public Patient(int id, String name, String lastname, String date_birth, String identification_document) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.date_birth = date_birth;
        this.identification_document = identification_document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getIdentification_document() {
        return identification_document;
    }

    public void setIdentification_document(String identification_document) {
        this.identification_document = identification_document;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", date_birth='" + date_birth + '\'' +
                ", identification_document=" + identification_document +
                '}';
    }
}
