package com.patrones.factorymethod;

/**
 * PRODUCTO CONCRETO: Camión
 * 
 * Implementación concreta de la interfaz Transporte para entregas terrestres.
 * 
 * Rol en el patrón Factory Method: ConcreteProduct
 * - Implementa la interfaz Transporte
 * - Es instanciado por el ConcreteCreator (LogisticaTerrestre)
 * - La clase Creator Logistica no conoce esta clase concreta
 */
public class Camion implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entregando por tierra en camión.");
    }
}