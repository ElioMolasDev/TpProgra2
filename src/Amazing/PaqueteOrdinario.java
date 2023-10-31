package Amazing;

public class PaqueteOrdinario extends Paquete {

	public PaqueteOrdinario(int codPedido, int volumen, int precio, int adicional, String direccionEntrega) {
		
		super(codPedido, volumen, precio, adicional, direccionEntrega);
		this.costoDeEnvio = adicional;
		
	}
	
	public static Paquete crearPaquete(int codPedido, int volumen, int precio, int adicional, String direccionEntrega) {

	        return new PaqueteOrdinario(obtenerIdPaquete(), volumen, precio, adicional, direccionEntrega);
	        
	}
	
}
