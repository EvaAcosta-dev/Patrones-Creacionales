package com.patrones.factorymethod;

/**
 * PRODUCTO CONCRETO: Barco
 * 
 * Implementación concreta de la interfaz Transporte para entregas marítimas.
 * 
 * Rol en el patrón Factory Method: ConcreteProduct
 * - Implementa la interfaz Producto (Transporte)
 * - Podría ser instanciado por un ConcreteCreator (ej. LogisticaMaritima)
 * - La clase Creator (Logistica) no conoce esta clase concreta
 */
public class Barco implements Transporte {
    @Override
    public void entregar() {
        System.out.println("Entregando por mar en barco.");
    }
}