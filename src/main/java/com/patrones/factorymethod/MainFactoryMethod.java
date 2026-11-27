package com.patrones.factorymethod;

/**
 * Clase principal (Cliente) Del patrón Factory Method.
 * 
 * DEMUESTRA:
 * 1. El cliente usa la clase Creator abstracta (Logistica)
 * 2. Instancia un ConcreteCreator específico (LogisticaTerrestre)
 * 3. Llama a la operación de alto nivel (planificarEntrega)
 * 4. El ConcreteCreator decide qué ConcreteProduct crear (Camion)
 
 */
public class MainFactoryMethod {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN PATRÓN FACTORY METHOD ===");
        System.out.println();

        // El cliente elige la logística concreta (ConcreteCreator)
        Logistica logistica = new LogisticaTerrestre();
        
        // Llama al algoritmo definido en la clase base
        // La subclase decide qué transporte crear
        logistica.planificarEntrega();

        System.out.println();
        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
}


