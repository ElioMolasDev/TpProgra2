package Amazing;

public class Automovil extends Transporte{
	private int maxPaq;
	
	public Automovil(String patente, int volumenMaximo, double costoPorViaje, int maxPaq) {
		super(patente, volumenMaximo, costoPorViaje);
		if (maxPaq<=0) {
            throw new IllegalArgumentException("La cantidad de paquetes tiene que ser mayor a 0");
        }
		this.maxPaq = maxPaq;	
	}

	@Override
	public Void cargarPaquete(Paquete paquete) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
