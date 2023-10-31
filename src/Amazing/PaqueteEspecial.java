package Amazing;

public class PaqueteEspecial extends Paquete {

	public PaqueteEspecial(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
		
		super(codPedido, volumen, precio, porcentaje, adicional);
		
	}
	
	public static Paquete crearPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {

	        return new PaqueteEspecial(obtenerIdPaquete(), volumen, precio, porcentaje,  adicional);
	        
	}

}