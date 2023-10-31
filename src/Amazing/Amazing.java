package Amazing;
import java.util.HashMap;
import java.util.Map;

public class Amazing {

    public HashMap<Integer, Pedido> listaPedidos;
//    public HashMap<String, Transporte> listaTransportes;
    public String cuit;
    public Double facturacion;

    public Amazing(String cuit) {
        this.cuit = cuit;
        this.listaPedidos = new HashMap<>();
//        this.listaTransportes = new HashMap<>();
    }

    //    CREA UNA EMPRESA
    public Amazing crear(String cuit) {
    	
        if (cuit == null || cuit.isEmpty()) {
        	
            throw new IllegalArgumentException("El CUIT no puede ser nulo o vacío.");
        }
        
        return new Amazing(cuit);
    }

    // REGSITRA PEDIDO
    public Integer registrarPedido(String nombreCliente, String direccionAentregar, Integer DNI) {
    	
        Pedido ped = new Pedido(nombreCliente,  direccionAentregar,  DNI);
        
        this.listaPedidos.put(idPedido(), ped);
        
        return idPedido();
        
    }
    
//    CERRAR PEDIDO
    public void cerrarPedido(int idPedido) {
    	
    	if (existePedido(idPedido)){
    	
    		 buscarPedidoConPed(idPedido, listaPedidos).cerrarPed();;
    	   		
    	}
        
    }

    // AGREGA PAQUETE ESPECIAL
    public int agregarPaquete(int idPedido, int volumen, int precio, int porcentaje, int adicional) {
    	
    	if (existePedido(idPedido)){
    		
    		buscarPedidoConPed(idPedido, listaPedidos).agregarPaq(idPedido, volumen, precio, porcentaje, adicional);	
    		return idPaquete();
    	}
    	
    	else {
    		
    		throw new IllegalArgumentException("El ID del pedido no se encuentra.");
    		
    	}
    }
    // AGREGA PAQUETE ORDINARIO
    public int agregarPaquete(int idPedido, int volumen, int precio, int adicional) {
    	
    	if (existePedido(idPedido)){
    		
    		buscarPedidoConPed(idPedido, listaPedidos).agregarPaq(idPedido, volumen, precio, adicional);	
    		return idPaquete();
    	}
    	
    	else {
    		
    		throw new IllegalArgumentException("El ID del pedido no se encuentra.");
    		
    	}
    }
    
    // QUITA PAQUETE
    public int quitarPaquete(int idPaquete) {
    		
    	Pedido.quitarPaquete(idPaquete, buscarPedidoConPaq(idPaquete, listaPedidos));
    	return idPaquete;

    	}
    		
    
    

  /*  
    public void registrarAutomovil(String patente, int volMax, int valorViaje, int maxPaq);
    public void registrarUtilitario(String patente, int volMax, int valorViaje, int valorExtra);
    public void registrarCamion(String patente, int volMax, int valorViaje, int adicXPaq);
    public static String cargarTransporte(String patente);
    public double costoEntrega(String patente);
    public double facturacionTotalPedidosCerrados();
    public Map<Integer,String> pedidosNoEntregados();
*/

    //Aux:
    
    private static int idPedido() {
    	
        return Pedido.obtenerIdPedido();
        
    }
    
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
    
    

  
/*
    private static Boolean existeCliente(Int idCliente);
    private static Cliente buscarCliente(Int idCliente);
    private static Boolean clienteTienePedidoAbierto(Int idCliente)
    private static Boolean existePaquete(Int idPaquete)
    private static Boolean existeTransporte(String patente)
    private static Transporte buscarTransporte(String patente)
*/


    public static void main(String[] args) {
        Amazing empresa = new Amazing("30-456789-2");

        int p1 = empresa.registrarPedido("Angel Gutierrez",  "San Martin 321", 28324132);
        int p2 = empresa.registrarPedido("Marta Benitez",  "Pasco 1020", 19456398);
        int p3 = empresa.registrarPedido("Daniel Constanzo",  "J.Verdi 876", 35678901);
        int p4 = empresa.registrarPedido("Beatriz Espinoza",  "L.Alberdi 549", 20345678);
        int p5 = empresa.registrarPedido("Angel Gutierrez",  "Madariaga 321", 28324132);
        int p6 = empresa.registrarPedido("Beatriz Espinoza", "L.Alberdi 549", 20345678);

        int paq1= empresa.agregarPaquete(p1, 1235, 2890, 1000);
        int paq2= empresa.agregarPaquete(p4, 1290, 5500, 1100);
        int paq3= empresa.agregarPaquete(p1, 5400, 13400, 3, 400);
        int paq4= empresa.agregarPaquete(p6, 800, 2890, 1000);
        int paq5= empresa.agregarPaquete(p3, 1800, 3500, 1000);
        int paq6= empresa.agregarPaquete(p1, 3800, 13400, 3, 400);
        int paq7= empresa.agregarPaquete(p6, 17000, 28900, 1000);
        int paq8= empresa.agregarPaquete(p1, 35000, 134000, 3, 400);
        int paq9= empresa.agregarPaquete(p4, 120000, 56000, 2, 1100);
        int paq10= empresa.agregarPaquete(p6, 1500, 3890, 1000);
        

		empresa.cerrarPedido(p1);
		empresa.cerrarPedido(p3);
		
		empresa.quitarPaquete(paq10);
		   

    }


}