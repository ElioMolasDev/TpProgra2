package Amazing;

public class Camion extends Transporte{

	private double adicXPaq;
	
	public Camion(String patente, int volumenMaximo, double costoPorViaje, int adicXPaq) {
		super(patente, volumenMaximo, costoPorViaje);
		if (adicXPaq<=0) {
            throw new IllegalArgumentException("El adicional por paquete tiene que ser un monto positivo");
        }
		this.adicXPaq = adicXPaq;
	}

	@Override
	public Void cargarPaquete(Paquete paquete) {
		// TODO Auto-generated method stub
		return null;
	}

}
