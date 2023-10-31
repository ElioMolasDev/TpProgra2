package Amazing;

public class PaqueteOrdinario extends Paquete {

	public PaqueteOrdinario(int codPedido, int volumen, int precio, int porcentaje) {
		
		super(codPedido, volumen, precio, porcentaje);
		
	}
	
	public static Paquete crearPaquete(int codPedido, int volumen, int precio, int porcentaje) {

	        return new PaqueteOrdinario(obtenerIdPaquete(), volumen, precio, porcentaje);
	        
	}
	
}
