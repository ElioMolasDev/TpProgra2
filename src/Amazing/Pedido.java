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
    private Boolean pedidoAbierto;
    private double precioDePedido;

    public Pedido(String nombreCliente, String direccionEntrega, int DNI) {

    	validacionPed( nombreCliente,  direccionEntrega,  DNI);

        this.idPedido = contadorPedidos++;
        this.DNI = DNI;
        this.nombreCliente = nombreCliente;
        this.direccionEntrega = direccionEntrega;
        this.carritoDePaquetes = new HashMap<>();
        this.pedidoAbierto = true;
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

    // AGREGA PAQUETE ESPECIAL  A PEDIO
    public int agregarPaq(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
    	
    	PaqueteEspecial paq = new PaqueteEspecial(codPedido,  volumen,  precio,  porcentaje,  adicional, obtenerDireccion());

        agregaPaqAPed(paq , precio);
    	
        return idPaquete();
     }
 
    // AGREGA PAQUETE ORDINARIO  A PEDIO
    public int agregarPaq(int codPedido, int volumen, int precio, int porcentaje) {
    	
    	PaqueteOrdinario paq = new PaqueteOrdinario(codPedido,  volumen,  precio,  porcentaje, obtenerDireccion());

        agregaPaqAPed(paq , precio);
         
         return idPaquete();
     }
    

    // QUITA PAQUETE DE PEDIDO
    public static void quitarPaquete(int idPaquete, Pedido pedido) {
    	
        if (!pedido.obtenerEstadoDePedido()) {
            throw new IllegalArgumentException("El pedido está cerrado, no se pueden quitar paquetes.");
        }

        if (pedido.existePaquete(idPaquete)) {
            pedido.carritoDePaquetes.remove(idPaquete);
            pedido.precioDePedido = pedido.precioDePedido -
        } 
        
        else {
            throw new IllegalArgumentException("No se encuentra paquete con esa id.");
        }
    }

    // CIERRA PEDIDO
    public void cerrarPed() {

        pedidoAbierto = false;
        
    }
        
    //  DEVUELVE ID PEDIDO
    public static int obtenerIdPedido() {
        return idPedido;
    }

    //  DEVUELVE ID PAQUETE
    public static int idPaquete() {
        return Paquete.obtenerIdPaquete();
    }

    //  DEVUELVE TRUE SI EXISTE PAQUETE
    public boolean existePaquete(int idPaquete) {
        return carritoDePaquetes.containsKey(idPaquete);
    }

    public Paquete obtenerPaquete(int idPaquete) {
        if (existePaquete(idPaquete)){
            return carritoDePaquetes.get(idPaquete);
        }
        else {
           throw new IllegalArgumentException("No se encuentra paquete con esa id.");
        }
    }
   

    // DEVUELVE PRECIO APAGAR DE CLEINTE
    public double precioAPagar() {
        return precioDePedido;
    }

    // DEVUELVE SI EL PEDIDO ESTA CERRADO
    public Boolean obtenerEstadoDePedido() {
        return pedidoAbierto;
    }

    // DEVUELVE NOMBRE CLEINTE
    public String obtenerCliente() {
        return nombreCliente;
    }

    //DEVUELVE DIRECCION CLEINTE
    public String obtenerDireccion() {
        return direccionEntrega;
    }
    

    //DEVUELVE CARRITO DE PAQUETES
    public HashMap<Integer, Paquete> obtenerCarritoDePaquetes() {
        return carritoDePaquetes;
    }

    public void agregaPaqAPed (Paquete paq , int precio) {

        this.precioDePedido += (double) precio;
        this.carritoDePaquetes.put(idPaquete(), paq);

    }

}
