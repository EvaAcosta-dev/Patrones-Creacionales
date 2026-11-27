package com.patrones.singleton;

/**
 * Clase principal para demostrar el funcionamiento del patrón Singleton.
 * 
 * DEMUESTRA:
 * 1. Obtener la instancia única mediante obtenerInstancia()
 * 2. Registrar ventas desde diferentes referencias
 * 3. Verificar que ambas referencias apuntan a la MISMA instancia (==)
 * 4. Confirmar que el total se acumula correctamente en la única instancia
 */
public class MainSingleton {
    public static void main(String[] args) {
        System.out.println("-DEMOSTRACIÓN PATRÓN SINGLETON ");
        System.out.println();

        // Primera obtención de la instancia - CREA la instancia
        CajaRegistradora caja1 = CajaRegistradora.obtenerInstancia();
        System.out.println("Caja 1 obtenida. Registrando venta de $8,000...");
        caja1.registrarVenta(8000);

        // Segunda obtención de la instancia - RETORNA la MISMA instancia
        CajaRegistradora caja2 = CajaRegistradora.obtenerInstancia();
        System.out.println("Caja 2 obtenida. Registrando venta de $6,000...");
        caja2.registrarVenta(6000);

        System.out.println();
        System.out.println("--- RESULTADOS ---");
        // Ambas referencias (caja1 y caja2) apuntan al MISMO objeto
        System.out.println("Total en caja: $" + caja1.getTotalVentas());
        System.out.println("¿Es la misma caja? (caja1 == caja2): " + (caja1 == caja2));
        
        System.out.println();
        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
}