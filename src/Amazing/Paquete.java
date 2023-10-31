package Amazing;

public abstract class  Paquete {
    private static int contadorPaquetes = 1; // Variable de clase para llevar un contador de pedidos
    private static int idPaquete;
    private int volumen;
    private int  precio;
    private String direccionEntrega;
    protected int costoDeEnvio;

    public Paquete(int codPedido, int volumen, int precio, int porcentaje, int adicional, String direccionEntrega) {
    	
    	validacionPaqEsp( codPedido,  volumen,  precio,  porcentaje,  adicional, direccionEntrega);
    	
        this.idPaquete = contadorPaquetes++;
        this.volumen = volumen;
        this.precio = precio;
        this.direccionEntrega = direccionEntrega;

    }
    public Paquete(int codPedido, int volumen, int precio, int adicional, String direccionEntrega) {
    	
    	validacionPaqOrd( codPedido,  volumen,  precio,  adicional, direccionEntrega);
    	
        this.idPaquete = contadorPaquetes++;
        this.volumen = volumen;
        this.precio = precio;
        this.direccionEntrega = direccionEntrega;

    }


    //CREA PAQUETE

    private void validacionPaqEsp(int codPedido, int volumen, int precio, int porcentaje, int adicional, String direccionEntrega) {
    	
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
        
        if (direccionEntrega == null || direccionEntrega.isEmpty()) {
            throw new IllegalArgumentException("El adicional del paquete no puede ser negativo.");
        }
    }
 
    private void validacionPaqOrd(int codPedido, int volumen, int precio, int adicional, String direccionEntrega) {
    	
        if (codPedido < 0) {
            throw new IllegalArgumentException("El ID del pedido no puede ser negativo.");
        }

        if (volumen <= 0) {
            throw new IllegalArgumentException("El volumen del paquete debe ser mayor que cero.");
        }

        if (precio <= 0) {
            throw new IllegalArgumentException("El precio del paquete debe ser mayor que cero.");
        }

        if (adicional <= 0) {
            throw new IllegalArgumentException("El adicional del paquete debe ser mayor que cero.");
        }
        
        if (direccionEntrega == null || direccionEntrega.isEmpty()) {
            throw new IllegalArgumentException("El adicional del paquete no puede ser negativo.");
        }
    }
    
    
   
    public String obtenerDireccionPedido(String direccion) {
        return this.direccionEntrega = direccion;
    }
    
    
    public static int obtenerIdPaquete() {
        return idPaquete;
    }
    
    public int obtenerVolumen() {
    	return volumen;
    }
    
    
    

}