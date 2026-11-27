package com.patrones.prototype;

/**
 * Patrón Prototype (Prototipo)
 *
 * PROPÓSITO: Crear nuevos objetos copiando (clonando) una instancia existente,
 * en lugar de construirlos desde cero.
 *
 * CUÁNDO USARLO:
 * - Cuando crear un objeto es costoso o complicado y copiarlo es más fácil
 * - Cuando se necesitan muchos objetos casi iguales que solo cambian en pocos datos
 * - Cuando el cliente no debe depender de la clase concreta que está copiando
 *
 * ESTRUCTURA:
 * - Prototype (Prototipo): interfaz que declara el método clonar()
 * - ConcretePrototype (Enemigo): implementa clonar() copiándose a sí mismo
 * - Client (MainPrototype): pide copias al prototipo en vez de usar 'new'
 */
public interface Prototipo {
    /** Devuelve una copia independiente de este objeto. */
    Prototipo clonar();
}