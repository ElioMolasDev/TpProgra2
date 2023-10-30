package Amazing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public abstract class Transporte {
    private String patente;
    private double costoPorViaje;
    private int volumenMaximo;
    private LinkedList <Paquete> paquetesAEntregar;
    private boolean disponible;
    private double costoTotal;

    public Transporte(String patente, int volumenMaximo, double costoPorViaje) {
    	if (patente == null || patente.isEmpty()) {
            throw new IllegalArgumentException("La patente no puede ser nula o vacía.");
        }

        if (volumenMaximo <= 0) {
            throw new IllegalArgumentException("El volumen máximo debe ser mayor que cero.");
        }

        if (costoPorViaje <= 0) {
            throw new IllegalArgumentException("El costo por viaje debe ser mayor que cero.");
        }
        this.patente = patente;
        this.volumenMaximo = volumenMaximo;
        this.costoPorViaje = costoPorViaje;
        this.disponible = true;
        this.costoTotal = 0.0;
        
    }
    
    public abstract Void cargarPaquete(Paquete paquete);


}
