package com.patrones.builder;

/**
 * Clase principal (Cliente) del patrón Builder.
 *
 * DEMUESTRA:
 * 1. Crear un objeto con solo las partes obligatorias
 * 2. Crear otro objeto activando varias partes opcionales
 * 3. Que el código se lee como una frase y no hay que recordar el orden de parámetros
 */
public class MainBuilder {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN PATRÓN BUILDER ===");
        System.out.println();

        // PC básico: solo lo obligatorio
        Computador basico = new Computador.Builder("Intel Core i3", 8)
                .build();

        // PC gamer: muchas partes opcionales
        Computador gamer = new Computador.Builder("AMD Ryzen 7", 32)
                .conAlmacenamiento(1000)
                .conTarjetaGrafica("NVIDIA RTX 4070")
                .conWifi()
                .conBluetooth()
                .build();

        System.out.println("--- PC BÁSICO ---");
        basico.mostrar();

        System.out.println();
        System.out.println("--- PC GAMER ---");
        gamer.mostrar();

        System.out.println();
        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
}