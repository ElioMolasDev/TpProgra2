package Amazing;

public abstract class  Paquete {
    private static int contadorPaquetes = 1; // Variable de clase para llevar un contador de pedidos
    private static int idPaquete;
    private int volumen;
    private int  precio;
    private String direccionEntrega;
    private int costoDeEnvio;

    public Paquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
    	
    	validacionPaq1( codPedido,  volumen,  precio,  porcentaje,  adicional);
    	
        this.idPaquete = contadorPaquetes++;
        this.volumen = volumen;
        this.precio = precio;
        this.direccionEntrega = "algo";
        this.costoDeEnvio = ( (porcentaje * adicional) / 100) + adicional;
    }
    public Paquete(int codPedido, int volumen, int precio, int porcentaje) {
    	
    	validacionPaq2( codPedido,  volumen,  precio,  porcentaje);
    	
        this.idPaquete = contadorPaquetes++;
        this.volumen = volumen;
        this.precio = precio;
        this.direccionEntrega = "algo";
        this.costoDeEnvio = porcentaje;
    }


    //CREA PAQUETE

    private void validacionPaq1(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
    	
    	if (codPedido < 0) {
            throw new IllegalArgumentException("El ID del pedido no puede ser negativo.");
        }

        if (volumen <= 0) {
            throw new IllegalArgumentException("El volumen del paquete debe ser mayor que cero.");
        }

        if (precio <= 0) {
            throw new IllegalArgumentException("El precio del paquete debe ser mayor que cero.");
        }

        if (porcentaje <= 0) {
            throw new IllegalArgumentException("El porcentaje/adicional del paquete debe ser mayor que cero.");
        }

        if (adicional < 0) {
            throw new IllegalArgumentException("El adicional del paquete no puede ser negativo.");
        }
    }
 
    private void validacionPaq2(int codPedido, int volumen, int precio, int porcentaje) {
    	
        if (codPedido < 0) {
            throw new IllegalArgumentException("El ID del pedido no puede ser negativo.");
        }

        if (volumen <= 0) {
            throw new IllegalArgumentException("El volumen del paquete debe ser mayor que cero.");
        }

        if (precio <= 0) {
            throw new IllegalArgumentException("El precio del paquete debe ser mayor que cero.");
        }

        if (porcentaje <= 0) {
            throw new IllegalArgumentException("El porcentaje/adicional del paquete debe ser mayor que cero.");
        }
    }
    
    
   
//    public String obtenerDireccionPedido() {
//        return Pedido.obtenerDireccion();
//    }
//    
    
    public static int obtenerIdPaquete() {
        return idPaquete;
    }
    
    public int obtenerVolumen() {
    	return volumen;
    }

}