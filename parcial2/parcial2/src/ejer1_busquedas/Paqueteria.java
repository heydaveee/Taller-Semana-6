package ejer1_busquedas;

public class Paqueteria implements Comparable <Paqueteria> {
    private static int totalPaquetes;
    private int tracking;
    private double peso;
    private String cuidadRecepcion;
    private String cuidadEntrega;
    private String cedula;
    private String estado;


    public Paqueteria(double peso, String cuidadRecepcion, String cuidadEntrega, String cedula) {
        this.tracking = ++totalPaquetes;
        this.peso = peso;
        this.cuidadRecepcion = cuidadRecepcion;
        this.cuidadEntrega = cuidadEntrega;
        this.cedula = cedula;
        this.estado = "Receptado";
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCuidadRecepcion(String cuidadRecepcion) {
        this.cuidadRecepcion = cuidadRecepcion;
    }

    public void setCuidadEntrega(String cuidadEntrega) {
        this.cuidadEntrega = cuidadEntrega;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public static int getTotalPaquetes() {
        return totalPaquetes;
    }

    public int getTracking() {
        return tracking;
    }

    public double getPeso() {
        return peso;
    }

    public String getCuidadRecepcion() {
        return cuidadRecepcion;
    }

    public String getCuidadEntrega() {
        return cuidadEntrega;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Paqueteria\n" +
                "tracking=" + tracking +
                ",\npeso=" + peso +
                ",\ncuidadRecepcion='" + cuidadRecepcion +
                ",\ncuidadEntrega='" + cuidadEntrega +
                ",\ncedula='" + cedula +
                ",\nestado='" + estado
                ;
    }

    @Override
    public int compareTo(Paqueteria o){
        return Double.compare(peso, o.peso);
    }
}
