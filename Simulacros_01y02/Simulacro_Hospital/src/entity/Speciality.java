package entity;

public class Speciality {

    private int id;
    private String name_speciality;
    private String description;

    public Speciality( String name_speciality, String description) {

        this.name_speciality = name_speciality;
        this.description = description;
    }

    public Speciality() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_speciality() {
        return name_speciality;
    }

    public void setName_speciality(String name_speciality) {
        this.name_speciality = name_speciality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id=" + id +
                ", name_speciality='" + name_speciality + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


