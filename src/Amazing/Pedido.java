package Amazing;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pedido {
    private static int contadorPedidos = 1; // Variable de clase para llevar un contador de pedidos
    private static int idPedido;
    private int DNI;
    private String nombreCliente;
    private String direccionEntrega;
    private HashMap<Integer, Paquete> carritoDePaquetes;
    private Boolean pedidoCerrado;
    private int precioDePedido;

    public Pedido(String nombreCliente, String direccionEntrega, int DNI) {

    	validacionPed( nombreCliente,  direccionEntrega,  DNI);

        this.idPedido = contadorPedidos++;
        this.DNI = DNI;
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
        this.carritoDePaquetes = new HashMap<>();
        this.pedidoCerrado = false;
        this.precioDePedido = 0;
    }
    
    
    //VALIDACION PEDIDO
    private void validacionPed(String nombreCliente, String direccionEntrega, int DNI) {
    	
        if (nombreCliente == null || nombreCliente.isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o vacío.");
        }

        if (direccionEntrega == null || direccionEntrega.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede ser nula o vacía.");
        }

        if (DNI <= 0) {
            throw new IllegalArgumentException("El DNI debe ser un valor positivo.");
            
        }
    }

    // AGREGA PAQUETE A PEDIO
    public Integer agregarPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
    	PaqueteEspecial paq = new PaqueteEspecial(codPedido,  volumen,  precio,  porcentaje,  adicional);
         this.carritoDePaquetes.put(idPaquete(), paq);
         return idPaquete();
     }
 

    public Integer agregarPaquete(int codPedido, int volumen, int precio, int porcentaje) {
    	PaqueteOrdinario paq = new PaqueteOrdinario(codPedido,  volumen,  precio,  porcentaje);
         this.carritoDePaquetes.put(idPaquete(), paq);
         return idPaquete();
     }
    

    /*// QUITA PAQUETE D PEDIDO
    public void quitarPaquete(int idPaquete) {
        if (pedidoCerrado) {
            throw new IllegalArgumentException("El pedido está cerrado, no se pueden quitar paquetes.");
        }

        Paquete paqueteAQuitar = null;
        for (Paquete paquete : carritoDePaquetes) {
            if (paquete.getId() == idPaquete) {
                paqueteAQuitar = paquete;
                break;
            }
        }

        if (paqueteAQuitar != null) {
            carritoDePaquetes.remove(paqueteAQuitar);
            precioDePedido -= paqueteAQuitar.getCostoDeEnvio();
        } else {
            throw new IllegalArgumentException("El paquete con el ID especificado no se encuentra en el carrito.");
        }
    }

    // CIERRA PEDIDO
    public void cerrarPedido() {
        if (pedidoCerrado) {
            throw new IllegalArgumentException("El pedido ya está cerrado.");
        }

        pedidoCerrado = true;
    }*/
    //  DEVUELVE ID PEDIDO
    public static Integer obtenerIdPedido() {
        return idPedido;
    }

    //  DEVUELVE ID PAQUETE
    public static Integer idPaquete() {
        return Paquete.obtenerIdPaquete();
    }

    //  DEVUELVE PEDIDO A PARTIR DE ID
    public static Pedido buscarPedido(int codPedido, HashMap<Integer, Pedido> listaPedidos) {
        if (listaPedidos.containsKey(codPedido)) {
            return listaPedidos.get(codPedido);
        } else {
            return null; // Devolver null si no se encuentra el pedido
        }
    }

    // DEVUELVE PRECIO APAGAR DE CLEINTE
    public int precioAPagar() {
        return precioDePedido;
    }

    // DEVUELVE ESTADO DE PDIDO
    public Boolean obtenerEstadoDePedido() {
        return pedidoCerrado;
    }

    // DEVUELVE NOMBRE CLEINTE
    public String obtenerCliente() {
        return nombreCliente;
    }

    //DEVUELVE DIRECCION CLEINTE
    public String obtenerDireccion() {
        return direccionEntrega;
    }

}
