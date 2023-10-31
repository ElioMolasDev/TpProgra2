package Amazing;

public class PaqueteOrdinario extends Paquete {

	public PaqueteOrdinario(int codPedido, int volumen, int precio, int porcentaje, String direccionEntrega) {
		
		super(codPedido, volumen, precio, porcentaje, direccionEntrega);
		
	}
	
	public static Paquete crearPaquete(int codPedido, int volumen, int precio, int porcentaje, String direccionEntrega) {

	        return new PaqueteOrdinario(obtenerIdPaquete(), volumen, precio, porcentaje, direccionEntrega);
	        
	}
	
}
