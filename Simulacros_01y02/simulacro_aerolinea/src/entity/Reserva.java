package entity;

public class Reserva {

    private int id;
    private int id_pasajero;
    private int id_vuelo;
    private String fecha_reserva;
    private String asiento;
    private Pasajero objPasajero;
    private Vuelo objVuelo;

    public Reserva() {
    }

    public Reserva(int id, int id_pasajero, int id_vuelo, String fecha_reserva, String asiento, Pasajero objPasajero, Vuelo objVuelo) {
        this.id = id;
        this.id_pasajero = id_pasajero;
        this.id_vuelo = id_vuelo;
        this.fecha_reserva = fecha_reserva;
        this.asiento = asiento;
        this.objPasajero = objPasajero;
        this.objVuelo = objVuelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pasajero() {
        return id_pasajero;
    }

    public void setId_pasajero(int id_pasajero) {
        this.id_pasajero = id_pasajero;
    }

    public int getId_vuelo() {
        return id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        this.id_vuelo = id_vuelo;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Pasajero getObjPasajero() {
        return objPasajero;
    }

    public void setObjPasajero(Pasajero objPasajero) {
        this.objPasajero = objPasajero;
    }

    public Vuelo getObjVuelo() {
        return objVuelo;
    }

    public void setObjVuelo(Vuelo objVuelo) {
        this.objVuelo = objVuelo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", id_pasajero=" + id_pasajero +
                ", id_vuelo=" + id_vuelo +
                ", fecha_reserva='" + fecha_reserva + '\'' +
                ", asiento='" + asiento + '\'' +
                ", objPasajero=" + objPasajero +
                ", objVuelo=" + objVuelo +
                '}';
    }
}
