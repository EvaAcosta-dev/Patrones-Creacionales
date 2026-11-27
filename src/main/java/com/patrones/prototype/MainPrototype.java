package com.patrones.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal (Cliente) del patrón Prototype.
 *
 * DEMUESTRA:
 * 1. Se crea UN solo enemigo base
 * 2. Se generan varios enemigos con clonar() sin repetir toda la configuración
 * 3. Cada clon se puede modificar sin afectar al original (copia profunda)
 */
public class MainPrototype {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN PATRÓN PROTOTYPE ===");
        System.out.println();

        // Enemigo base (el prototipo)
        List<String> habilidades = new ArrayList<>();
        habilidades.add("Golpe");
        habilidades.add("Escudo");
        Enemigo orco = new Enemigo("Orco", 100, habilidades);

        // Clones: copiar es más fácil que crear de nuevo
        Enemigo orcoJefe = orco.clonar();
        orcoJefe.setNombre("Orco Jefe");
        orcoJefe.setVida(300);
        orcoJefe.agregarHabilidad("Grito de guerra");

        Enemigo orcoSoldado = orco.clonar();
        orcoSoldado.setNombre("Orco Soldado");

        System.out.println("--- RESULTADOS ---");
        orco.mostrar();
        orcoJefe.mostrar();
        orcoSoldado.mostrar();

        System.out.println();
        System.out.println("¿El original conserva sus 2 habilidades? Sí: la copia es independiente.");
        System.out.println();
        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
}