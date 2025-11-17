package ejer1_busquedas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {
    private List<Paqueteria> listadoPaquetes;

    public Lista() {
        listadoPaquetes = new ArrayList<>();
    }

    public List<Paqueteria> getListadoPaquetes() {
        return listadoPaquetes;
    }


    public void adicionarElemento(double peso, String cuidadRecepcion, String cuidadEntrega, String cedula) {
        listadoPaquetes.add(new Paqueteria(peso, cuidadRecepcion, cuidadEntrega, cedula));
        Collections.sort(listadoPaquetes);
    }

    public Paqueteria busquedaBinarioPeso(double pesoBuscado) {

        int inicio = 0;
        int fin = listadoPaquetes.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            Paqueteria paqueteMedio = listadoPaquetes.get(medio);

            if (paqueteMedio.getPeso() == pesoBuscado) {
                return paqueteMedio;
            } else if (paqueteMedio.getPeso() < pesoBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return null;
    }



    public Paqueteria busquedaSecuencial(String cuidadRecepcion, String cedula) {

        for (int i = 0; i < listadoPaquetes.size(); i++) {
            Paqueteria p = listadoPaquetes.get(i);

            if (p.getCuidadRecepcion().equalsIgnoreCase(cuidadRecepcion)
                    && p.getCedula().equalsIgnoreCase(cedula)) {
                return p;
            }
        }

        return null;
    }



    public int contarPorEstado(String estadoBuscado) {
        int contador = 0;

        for (Paqueteria p : listadoPaquetes) {
            if (p.getEstado().equalsIgnoreCase(estadoBuscado)) {
                contador++;
            }
        }

        return contador;
    }

    public double pesoTotalCiudad(String ciudad) {
        return sumarPeso(0, ciudad);
    }

    private double sumarPeso(int i, String ciudad) {

        if (i == listadoPaquetes.size()) {
            return 0;
        }

        double pesoActual = 0;

        if (listadoPaquetes.get(i).getCuidadRecepcion().equalsIgnoreCase(ciudad)) {
            pesoActual = listadoPaquetes.get(i).getPeso();
        }

        return pesoActual + sumarPeso(i + 1, ciudad);
    }

    public List<Paqueteria> buscarPorCedulaEstado(String cedula, String estado) {

        List<Paqueteria> resultado = new ArrayList<>();

        for (Paqueteria p : listadoPaquetes) {

            if (p.getCedula().equalsIgnoreCase(cedula)) {
                if (p.getEstado().equalsIgnoreCase(estado)) {
                    resultado.add(p);
                }
            }
        }

        return resultado;
    }

    public boolean actualizarEstado(int tracking, String nuevoEstado) {

        for (Paqueteria p : listadoPaquetes) {

            if (p.getTracking() == tracking) {
                p.setEstado(nuevoEstado);
                return true;
            }
        }

        return false;
    }
}

