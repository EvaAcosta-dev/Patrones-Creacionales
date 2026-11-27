package com.patrones.factorymethod;

/**
 * CREADOR CONCRETO (ConcreteCreator): Logística Terrestre
 * 
 * Implementa el método fábrica para crear el producto concreto Camion.
 * 
 * Rol en el patrón Factory Method: ConcreteCreator
 * - Sobrescribe crearTransporte() para retornar Camion (ConcreteProduct)
 * - Decide QUÉ producto concreto instanciar
 * - Puede tener múltiples ConcreteCreator para diferentes productos (ej. LogisticaMaritima -> Barco)
 */
public class LogisticaTerrestre extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        // Instancia el producto concreto correspondiente a esta logística
        return new Camion();
    }
}