package Amazing;

public class Utilitario extends Transporte{

	private int valorExtra;
	
	public Utilitario(String patente, int volumenMaximo, double costoPorViaje, int valorExtra) {
		super(patente, volumenMaximo, costoPorViaje);
		if (valorExtra<=0) {
            throw new IllegalArgumentException("El valor extra tiene que ser un monto positivo");
        }
		this.valorExtra = valorExtra;
	}

	@Override
	public Void cargarPaquete(Paquete paquete) {
		return null;
//		agregarPaquete(paquete);
	}

//	@Override
//	public Double costoPorViaje() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
