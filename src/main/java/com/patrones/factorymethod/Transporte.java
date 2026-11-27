package com.patrones.factorymethod;

/**
 * Patrón Factory Method (Método Fábrica)
 * 
 * PROPÓSITO: Definir una interfaz para crear un objeto, pero dejar que las subclases
 * decidan qué clase instanciar. Factory Method permite a una clase delegar la
 * instanciación a subclases.
 * 
 * CUÁNDO USARLO:
 * - Cuando una clase no puede anticipar la clase de objetos que debe crear
 * - Cuando una clase quiere que sus subclases especifiquen los objetos que crea
 * - Cuando las clases delegan responsabilidad a una de varias subclases auxiliares
 *   y se quiere localizar el conocimiento de cuál subclase auxiliar es la delegada
 * 
 * ESTRUCTURA:
 * - Product (Transporte): Define la interfaz de los objetos que crea el método fábrica
 * - ConcreteProduct (Camion, Barco): Implementan la interfaz Product
 * - Creator (Logistica): Declara el método fábrica que retorna un Product
 * - ConcreteCreator (LogisticaTerrestre): Sobrescribe el método fábrica para retornar ConcreteProduct
 */

// ============================================================
// PRODUCTO ABSTRACTO
// ============================================================

/**
 * Interfaz común (Product) que deben cumplir todos los transportes.
 * Define el contrato que la clase Creator (Logistica) usará sin conocer
 * la implementación concreta.
 */
public interface Transporte {
    /**
     * Operación principal del producto: realizar la entrega.
     * Cada transporte concreto implementa su propia lógica de entrega.
     */
    void entregar();
}