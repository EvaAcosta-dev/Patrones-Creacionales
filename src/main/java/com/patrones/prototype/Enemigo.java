package com.patrones.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * PROTOTIPO CONCRETO: Enemigo de un videojuego.
 *
 * Rol en el patrón Prototype: ConcretePrototype
 * - Implementa clonar() creando un nuevo Enemigo con los mismos datos
 * - Hace copia PROFUNDA de la lista de habilidades: si solo copiara la referencia,
 *   el clon y el original compartirían la misma lista (copia superficial) y
 *   modificar uno afectaría al otro.
 */
public class Enemigo implements Prototipo {

    private String nombre;
    private int vida;
    private List<String> habilidades;

    // Constructor "costoso": aquí se define el enemigo base completo
    public Enemigo(String nombre, int vida, List<String> habilidades) {
        this.nombre = nombre;
        this.vida = vida;
        this.habilidades = habilidades;
    }

    // Constructor de copia (privado): lo usa clonar()
    private Enemigo(Enemigo original) {
        this.nombre = original.nombre;
        this.vida = original.vida;
        this.habilidades = new ArrayList<>(original.habilidades); // copia profunda
    }

    @Override
    public Enemigo clonar() {
        return new Enemigo(this);
    }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setVida(int vida) { this.vida = vida; }
    public void agregarHabilidad(String habilidad) { habilidades.add(habilidad); }

    public void mostrar() {
        System.out.println(nombre + " | Vida: " + vida + " | Habilidades: " + habilidades);
    }
}