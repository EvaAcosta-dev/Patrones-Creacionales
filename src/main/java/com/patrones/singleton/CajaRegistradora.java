package com.patrones.singleton;

/**
 * Patrón Singleton
 * PROPÓSITO: Garantizar que una clase tenga una única instancia y proporcionar
 * un punto de acceso global a ella.
 * 
 * CUÁNDO USARLO:
 * - Cuando debe haber exactamente una instancia de una clase y debe ser accesible
 *   para todos los clientes desde un punto de acceso conocido
 * - Cuando la única instancia debe ser extensible mediante subclases y los clientes
 *   deben poder usar una instancia extendida sin modificar su código
 * 
 * CARACTERÍSTICAS:
 * - Constructor privado para evitar instanciación externa
 * - Método estático de acceso global (obtenerInstancia)
 * - Instancia única almacenada en variable estática privada
 * - Inicialización perezosa (lazy initialization): la instancia se crea solo cuando se necesita
 * 
 * NOTA: Esta implementación básica NO es thread-safe.
 * Para entornos multi-hilo, usar double-checked locking o enum.
 */
public class CajaRegistradora {

    // ATRIBUTOS

    /**
     * Única instancia compartida de la clase (patrón Singleton).
     * Se inicializa como null 
     */
    private static CajaRegistradora instancia;
    private double totalVentas = 0.0;

    // CONSTRUCTOR

    /**
     * Constructor PRIVADO para evitar que código externo cree nuevas instancias
     * usando 'new CajaRegistradora()'.
     * Solo la propia clase puede instanciarse a sí misma.
     */
    private CajaRegistradora() {
    }
    /**
     * Punto de acceso global único para obtener la instancia de la caja registradora.
     * 
     * 1. Verifica si la instancia ya existe
     * 2. Si no existe (null), la crea
     * 3. Retorna la instancia (la existente o la recién creada)
     * 
     * return La única instancia de CajaRegistradora
     */
    public static CajaRegistradora obtenerInstancia() {
        if (instancia == null) {
            // Primera llamada: crea la única instancia
            instancia = new CajaRegistradora();
        }
        // Llamadas siguientes: retorna la misma instancia ya creada
        return instancia;
    }
    /**
     * Registra una venta sumando su monto al total y Como hay una sola instancia, todas las llamadas modifican el mismo total.
     *  monto Valor de la venta a registrar
     */
    public void registrarVenta(double monto) {
        totalVentas += monto;
    }

    //Obtiene el total acumulado de ventas y retorna Total de ventas registradas en esta caja
    
    public double getTotalVentas() {
        return totalVentas;
    }
}