package com.patrones.abstractfactory;
// ABSTRACT FACTORY: crea FAMILIAS de objetos que van juntos.
// Ejemplo: una tienda de muebles con dos estilos (moderno y clásico).
// Cada estilo es una familia con una silla, una mesa y un sofá que combinan entre sí.

// 1) Productos abstractos: qué tipos de mueble existen
interface Silla { void sentarse(); }
interface Mesa { void usar(); }
interface Sofa { void descansar(); }

// 2) Productos concretos de la familia MODERNA
class SillaModerna implements Silla {
    public void sentarse() { 
        System.out.println("Te sientas en una silla moderna de metal y plástico"); }
}
class MesaModerna implements Mesa {
    public void usar() { 
        System.out.println("Pones el computador en una mesa moderna de vidrio"); }
}
class SofaModerno implements Sofa {
    public void descansar() { 
        System.out.println("Descansas en un sofá moderno gris de líneas rectas"); }
}

// 3) Productos concretos de la familia CLÁSICA
class SillaClasica implements Silla {
    public void sentarse() { 
        System.out.println("Te sientas en una silla clásica de madera tallada"); }
}
class MesaClasica implements Mesa {
    public void usar() { 
        System.out.println("Cenas en una mesa clásica de roble"); }
}
class SofaClasico implements Sofa {
    public void descansar() { 
        System.out.println("Descansas en un sofá clásico de terciopelo con botones"); }
}

// 4) La fábrica abstracta: un método por cada mueble de la familia
interface FabricaMuebles {
    Silla crearSilla();
    Mesa crearMesa();
    Sofa crearSofa();
}

// 5) Fábricas concretas: cada una crea TODOS los muebles de un mismo estilo
class FabricaModerna implements FabricaMuebles {
    public Silla crearSilla() { return new SillaModerna(); }
    public Mesa crearMesa() { return new MesaModerna(); }
    public Sofa crearSofa() { return new SofaModerno(); }
}

class FabricaClasica implements FabricaMuebles {
    public Silla crearSilla() { return new SillaClasica(); }
    public Mesa crearMesa() { return new MesaClasica(); }
    public Sofa crearSofa() { return new SofaClasico(); }
}

// 6) El cliente: arma una sala sin saber de qué estilo es.
//    Solo conoce las interfaces, nunca las clases concretas.
class Sala {
    private Silla silla;
    private Mesa mesa;
    private Sofa sofa;

    Sala(FabricaMuebles fabrica) {
        this.silla = fabrica.crearSilla();   // todos salen de LA MISMA fábrica,
        this.mesa = fabrica.crearMesa();     // por eso siempre combinan
        this.sofa = fabrica.crearSofa();
    }

    void mostrar() {
        silla.sentarse();
        mesa.usar();
        sofa.descansar();
    }
}

public class Muebles {
    public static void main(String[] args) {
        System.out.println("--- Sala MODERNA ---");
        new Sala(new FabricaModerna()).mostrar();

        System.out.println("\n--- Sala CLÁSICA ---");
        new Sala(new FabricaClasica()).mostrar();
    }
}