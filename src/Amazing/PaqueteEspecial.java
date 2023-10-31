package Amazing;

public class PaqueteEspecial extends Paquete {

	public PaqueteEspecial(int codPedido, int volumen, int precio, int porcentaje, int adicional, String direccionEntrega) {
		
		super(codPedido, volumen, precio, porcentaje, adicional, direccionEntrega);
		
	}
	
	public static Paquete crearPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional, String direccionEntrega) {

	        return new PaqueteEspecial(obtenerIdPaquete(), volumen, precio, porcentaje,  adicional, direccionEntrega);
	        
	}
	
	

}