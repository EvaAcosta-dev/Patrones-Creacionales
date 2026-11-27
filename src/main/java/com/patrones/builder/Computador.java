package com.patrones.builder;

/**
 * Patrón Builder (Constructor)
 *
 * PROPÓSITO: Separar la construcción de un objeto complejo de su representación,
 * para ir armándolo paso a paso y poder omitir las partes opcionales.
 *
 * CUÁNDO USARLO:
 * - Cuando el objeto tiene muchos atributos y varios son opcionales
 * - Cuando el constructor tendría demasiados parámetros (constructor telescópico)
 * - Cuando se quiere un código legible: .conRam(16).conWifi()
 *
 * ESTRUCTURA:
 * - Product (Computador): el objeto complejo que se construye (inmutable)
 * - Builder (Computador.Builder): clase interna con un método por cada parte
 *   y un método build() que entrega el producto final
 * - Client (MainBuilder): arma el objeto encadenando llamadas
 */
public class Computador {

    // Partes obligatorias
    private final String procesador;
    private final int ramGB;

    // Partes opcionales
    private final int almacenamientoGB;
    private final String tarjetaGrafica;
    private final boolean wifi;
    private final boolean bluetooth;

    // El constructor es PRIVADO: la única forma de crear un Computador es con el Builder
    private Computador(Builder b) {
        this.procesador = b.procesador;
        this.ramGB = b.ramGB;
        this.almacenamientoGB = b.almacenamientoGB;
        this.tarjetaGrafica = b.tarjetaGrafica;
        this.wifi = b.wifi;
        this.bluetooth = b.bluetooth;
    }

    public void mostrar() {
        System.out.println("Computador -> Procesador: " + procesador
                + " | RAM: " + ramGB + " GB"
                + " | Disco: " + almacenamientoGB + " GB"
                + " | Gráfica: " + (tarjetaGrafica == null ? "integrada" : tarjetaGrafica)
                + " | WiFi: " + (wifi ? "sí" : "no")
                + " | Bluetooth: " + (bluetooth ? "sí" : "no"));
    }

    // ============================================================
    // BUILDER (clase interna estática)
    // ============================================================
    public static class Builder {

        // Obligatorios
        private final String procesador;
        private final int ramGB;

        // Opcionales con valores por defecto
        private int almacenamientoGB = 256;
        private String tarjetaGrafica = null;
        private boolean wifi = false;
        private boolean bluetooth = false;

        // Solo se piden en el constructor las partes obligatorias
        public Builder(String procesador, int ramGB) {
            this.procesador = procesador;
            this.ramGB = ramGB;
        }

        // Cada paso devuelve "this" para poder encadenar llamadas (interfaz fluida)
        public Builder conAlmacenamiento(int gb) {
            this.almacenamientoGB = gb;
            return this;
        }

        public Builder conTarjetaGrafica(String modelo) {
            this.tarjetaGrafica = modelo;
            return this;
        }

        public Builder conWifi() {
            this.wifi = true;
            return this;
        }

        public Builder conBluetooth() {
            this.bluetooth = true;
            return this;
        }

        // Paso final: entrega el producto terminado
        public Computador build() {
            return new Computador(this);
        }
    }
}