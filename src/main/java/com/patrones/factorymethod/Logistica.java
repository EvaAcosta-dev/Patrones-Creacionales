package com.patrones.factorymethod;

/**
 * CREADOR - Clase abstracta
 * 
 * Define el algoritmo general (planificarEntrega) y delega la creación del objeto
 * concreto a las subclases mediante el método fábrica (crearTransporte).
 * Rol en el patrón Factory Method: Creator
 * - Declara el método fábrica abstracto crearTransporte()
 * - Implementa operaciones que usan el producto (planificarEntrega)
 * - No conoce la clase concreta del producto que se creará
 * - Permite agregar nuevos tipos de transporte sin modificar esta clase
 */
public abstract class Logistica {

    // MÉTODO FÁBRICA (Factory Method) - ABSTRACTO

    /**
     * Método fábrica que deben implementar las subclases concretas.
     * CARACTERÍSTICAS:
     * - protected: accesible solo para subclases y mismo paquete
     * - abstract: obliga a las subclases a proporcionar una implementación
     * return Una instancia de Transporte 
     */
    protected abstract Transporte crearTransporte();

    /* 
     * FLUJO:
     * 1. Llama a crearTransporte() - la subclase decide QUÉ crear
     * 2. Usa el transporte retornado - llama a entregar()
     * La clase base no sabe n qué transporte concreto se crea.
     */
    public void planificarEntrega() {
        // Delegación: la subclase crea el objeto concreto
        Transporte transporte = crearTransporte();
        
        transporte.entregar();
    }
}