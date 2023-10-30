package Amazing;

public abstract class  Paquete {
    private static int contadorPaquetes = 1; // Variable de clase para llevar un contador de pedidos
    private static int idPaquete;
    private int volumen;
    private int  precio;
    private static String direccionEntrega;
    private static int costoDeEnvio;

    public Paquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
        this.idPaquete = contadorPaquetes++;
        this.volumen = volumen;
        this.precio = precio;
        this.direccionEntrega = obtenerDireccionPedido(codPedido);
        this.costoDeEnvio = porcentaje * adicional;
    }
    public Paquete(int codPedido, int volumen, int precio, int porcentaje) {
        this.idPaquete = contadorPaquetes++;
        this.volumen = volumen;
        this.precio = precio;
        this.direccionEntrega = obtenerDireccionPedido(codPedido);
        this.costoDeEnvio = porcentaje;
    }


    //CREA PAQUETE
    public static Paquete crearPaquete(int codPedido, int volumen, int precio, int porcentaje, int adicional) {
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

        return new Paquete(idPaquete, volumen, precio, porcentaje,  adicional);
    }
    public static Paquete crearPaquete(int codPedido, int volumen, int precio, int porcentaje) {
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
        return new Paquete(idPaquete, volumen, precio, porcentaje);
    }

    public String obtenerDireccionPedido(Integer codPedido) {
        return "Pedido.obtenerDireccion(codPedido)";
    }
    public static Integer obtenerIdPaquete() {
        return idPaquete;
    }

}
