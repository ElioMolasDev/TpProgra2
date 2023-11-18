package Amazing;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class Amazing {

    public HashMap<Integer, Pedido> listaPedidos;
    public HashMap<String, Transporte> listaTransportes;
    public String cuit;
    public Double facturacion;

    public Amazing(String cuit) {
        this.cuit = cuit;
        this.listaPedidos = new HashMap<>();
        this.listaTransportes = new HashMap<>();
    }



    //    CREA UNA EMPRESA
    public Amazing crear(String cuit) {
    	
        if (cuit == null || cuit.isEmpty()) {
        	
            throw new IllegalArgumentException("El CUIT no puede ser nulo o vacío.");
        }
        
        return new Amazing(cuit);
    }

    // REGSITRA PEDIDO
    public int registrarPedido(String nombreCliente, String direccionAentregar, Integer DNI) {
    	
        Pedido ped = new Pedido(nombreCliente,  direccionAentregar,  DNI);
        
        this.listaPedidos.put(idPedido(), ped);
        
        return idPedido();
        
    }
    
//    CERRAR PEDIDO
    public double cerrarPedido(int idPedido) {
    	
    	if (existePedido(idPedido)) {

            Pedido ped = buscarPedidoConPed(idPedido, listaPedidos);

            if (ped.obtenerEstadoDePedido()) {
                ped.cerrarPed();
                return ped.precioAPagar();
            }
            else {
                throw new IllegalArgumentException("El pedido ya está cerrado.");
            }
        }
        else {
            throw new IllegalArgumentException("El ID del pedido no se encuentra.");
        }
    }

    // AGREGA PAQUETE ESPECIAL
    public int agregarPaquete(int idPedido, int volumen, int precio, int porcentaje, int adicional) {

        if (existePedido(idPedido)){
            Pedido ped = buscarPedidoConPed(idPedido, listaPedidos);

            if (ped.obtenerEstadoDePedido()) {
                ped.agregarPaq(idPedido, volumen, precio, porcentaje, adicional);
                return idPaquete();
            }
            else {
                throw new IllegalArgumentException("El pedido está cerrado.");
            }

        }
        else {
            throw new IllegalArgumentException("El ID del pedido no se encuentra.");
        }
    }

    // AGREGA PAQUETE ORDINARIO
    public int agregarPaquete(int idPedido, int volumen, int precio, int adicional) {

    	if (existePedido(idPedido)){
            Pedido ped = buscarPedidoConPed(idPedido, listaPedidos);

            if (ped.obtenerEstadoDePedido()) {
                ped.agregarPaq(idPedido, volumen, precio, adicional);
                return idPaquete();
            }
            else {
                throw new IllegalArgumentException("El pedido está cerrado.");
            }

    	}
    	else {
    		throw new IllegalArgumentException("El ID del pedido no se encuentra.");
    	}
    }
    
    // QUITA PAQUETE
    public boolean quitarPaquete(int idPaquete) {
    		
    	Pedido.quitarPaquete(idPaquete, buscarPedidoConPaq(idPaquete, listaPedidos));
    	return true;

    	}


    public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq){

        if (existeTransporte(patente)){
            throw new IllegalArgumentException("Ya exsite un transporte con esta patente en el sistema.");
        }

        Transporte t = new Automovil(patente, volMax, valorViaje, maxPaq);

        this.listaTransportes.put(patente, t);

    }

    public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra){

        if (existeTransporte(patente)){
            throw new IllegalArgumentException("Ya exsite un transporte con esta patente en el sistema.");
        }

        Transporte t = new Utilitario(patente, volMax, valorViaje, valorExtra);

        this.listaTransportes.put(patente, t);

    }

    public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq){

        if (existeTransporte(patente)){
            throw new IllegalArgumentException("Ya exsite un transporte con esta patente en el sistema.");
        }

        Transporte t = new Camion(patente, volMax, valorViaje, adicXPaq);

        this.listaTransportes.put(patente, t);

    }


    //La carga de un transporte devuelve un listado de los paquetes cargados creando un String
    //con forma de listado donde cada renglón representa un paquete.
    //" + [ NroPedido - codPaquete ] dirección"
    //por ejemplo:
    //" + [ 1002 - 101 ] Gutierrez 1147"

//    public String cargarTransporte(String patente){
//
//        if (existeTransporte(patente)) {
//            listaPedidos.forEach((Integer , Pedido) -> {
//                if (Pedido.obtenerEstadoDePedido()){
//
//                }
//            }
//        }
//
//    }

  /*  

    public double costoEntrega(String patente);
    public double facturacionTotalPedidosCerrados();
    public Map<Integer,String> pedidosNoEntregados();
*/

    //////////////////////////////////////////FUNCIONES AUXILIARES///////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////


    //  DEVUELVE EL ID DEL PEDIDO
    private static int idPedido() {
    	
        return Pedido.obtenerIdPedido();
        
    }


    //  DEVUELVE EL ID DEL PAQUETE
    private static int idPaquete() {
    	
    	 return Pedido.idPaquete();
    	 
    }


//    BUSCAR PEDIDO A PARTIR DE IDPEDIDO
    public Pedido buscarPedidoConPed(int idPedido, HashMap<Integer, Pedido> listaPedidos) {

        if (listaPedidos.containsKey(idPedido)) {

            return listaPedidos.get(idPedido);
        }
        
        else {
        	
        	throw new IllegalArgumentException("No se encuentra pedido con esa id.");
        }
    }
    
    
    
//  BUSCAR PEDIDO A PARTIR DE IDPAQUETE
    public Pedido buscarPedidoConPaq(int idPaquete, HashMap<Integer, Pedido> listaPedidos) {
    	
        for (HashMap.Entry<Integer, Pedido> entry : listaPedidos.entrySet()) {
            Pedido pedido = entry.getValue();
            
            if (pedido.existePaquete(idPaquete)) {
                // Si existe el paquete en el carrito de este pedido, devuelve el pedido.
                return pedido;
            }
        }

        throw new IllegalArgumentException("No se encuentra pedido con esa id.");
    }
  
    
    
//		BUSCA SI EXISTE PEDIDO
    private Boolean existePedido(int idPedido) {
    	
   	 if (listaPedidos.containsKey(idPedido)) {
            return true;
        }
        else {
        	throw new IllegalArgumentException("No se encuentra pedido con esa id.");
        }	
   }

   private Boolean existeTransporte (String patente) {
       return listaTransportes.containsKey(patente);
   }



  
/*
    private static Boolean existeCliente(Int idCliente);
    private static Cliente buscarCliente(Int idCliente);
    private static Boolean clienteTienePedidoAbierto(Int idCliente)
    private static Boolean existePaquete(Int idPaquete)
    private static Boolean existeTransporte(String patente)
    private static Transporte buscarTransporte(String patente)
*/





}