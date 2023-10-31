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

    // AGREGA PAQUETE ESPECIAL  A PEDIO
    public int agregarPaq(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
    	
    	PaqueteEspecial paq = new PaqueteEspecial(codPedido,  volumen,  precio,  porcentaje,  adicional, obtenerDireccion());
    	
    	this.carritoDePaquetes.put(idPaquete(), paq);
    	
        return idPaquete();
     }
 
    // AGREGA PAQUETE ORDINARIO  A PEDIO
    public int agregarPaq(int codPedido, int volumen, int precio, int porcentaje) {
    	
    	PaqueteOrdinario paq = new PaqueteOrdinario(codPedido,  volumen,  precio,  porcentaje, obtenerDireccion());
    	
         this.carritoDePaquetes.put(idPaquete(), paq);
         
         return idPaquete();
     }
    

    // QUITA PAQUETE D PEDIDO
    public static void quitarPaquete(int idPaquete, Pedido pedido) {
    	
        if (pedido.obtenerEstadoDePedido()) {
            throw new IllegalArgumentException("El pedido está cerrado, no se pueden quitar paquetes.");
        }

        if (pedido.existePaquete(idPaquete)) {
            pedido.carritoDePaquetes.remove(idPaquete);
        } 
        
        else {
            throw new IllegalArgumentException("No se encuentra paquete con esa id.");
        }
    }

    // CIERRA PEDIDO
    public void cerrarPed() {

        pedidoCerrado = true;
        
    }
        
    //  DEVUELVE ID PEDIDO
    public static int obtenerIdPedido() {
        return idPedido;
    }

    //  DEVUELVE ID PAQUETE
    public static int idPaquete() {
        return Paquete.obtenerIdPaquete();
    }

    //  EXISTE PAQUETE
    public boolean existePaquete(int idPaquete) {
        return carritoDePaquetes.containsKey(idPaquete);
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
    

    //DEVUELVE CARRITO DE PAQUETES
    public HashMap<Integer, Paquete> obtenerCarritoDePaquetes() {
        return carritoDePaquetes;
    }

}
