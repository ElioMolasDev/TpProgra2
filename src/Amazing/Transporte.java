package Amazing;

import java.util.ArrayList;
import java.util.List;
public abstract class Transporte {
    private String patente;
    private double costoPorViaje;
    private double volumenMaximo;
    private List<Paquete> paquetesAEntregar;
    private boolean disponible;
    private double costoTotal;

    public Transporte(String patente, double volumenMaximo, double costoPorViaje, String tipoDeTransporte) {
        this.patente = patente;
        this.volumenMaximo = volumenMaximo;
        this.costoPorViaje = costoPorViaje;
        this.tipoDeTransporte = tipoDeTransporte;
        this.cantidadMaximaDePaquetes = 0; // se define cuando se crea
      /*  this.paquetesAEntregar = new ArrayList<>();*/
        this.disponible = true;
        this.costoTotal = 0.0;
    }


    public static Transporte crearTransporte(String patente, double volumenMaximo, double costoPorViaje, String tipoDeTransporte) {
        if (patente == null || patente.isEmpty()) {
            throw new IllegalArgumentException("La patente no puede ser nula o vacía.");
        }

        if (volumenMaximo <= 0) {
            throw new IllegalArgumentException("El volumen máximo debe ser mayor que cero.");
        }

        if (costoPorViaje <= 0) {
            throw new IllegalArgumentException("El costo por viaje debe ser mayor que cero.");
        }

        if (tipoDeTransporte == null || tipoDeTransporte.isEmpty()) {
            throw new IllegalArgumentException("El tipo de transporte debe estar definido.");
        }

        return new Transporte(patente, volumenMaximo, costoPorViaje, tipoDeTransporte);
    }

    // DEVUELVE PAQUETES Q FALTAN ENTREGAR
//    public List<Paquete> faltaEntregar() {
//    }

    // DEVUELVE SI ESTA DISPONIBLE
    public boolean estaDisponible() {
        return disponible;
    }

    // CALCUAL COSTO TOTAL
 /*   public double costoPorViaje() {
        if (tipoDeTransporte.equals("Utilitario") && paquetesAEntregar.size() > 10) {
            costoTotal += 100; // SI CUMPLE CON UTILITARIO AUMENTA
        }
        return costoTotal;
    }*/
}
