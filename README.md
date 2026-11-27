# Patrones Creacionales - Documentación y Diagramas

Este proyecto implementa tres patrones de diseño creacionales fundamentales en Java:
1. **Abstract Factory** (Fábrica Abstracta)
2. **Singleton** (Instancia Única)
3. **Factory Method** (Método Fábrica)

---

## Tabla de Contenidos

- [Patrón Abstract Factory](#patrón-abstract-factory)
- [Patrón Singleton](#patrón-singleton)
- [Patrón Factory Method](#patrón-factory-method)
- [Cómo Ejecutar](#cómo-ejecutar)

---

## Patrón Abstract Factory

### Propósito
Proveer una interfaz para crear familias de objetos relacionados o dependientes sin especificar sus clases concretas.

### Diagrama de Clases

```mermaid
classDiagram
    %% Abstract Products
    class Silla {
        <<interface>>
        +sentarse() void
    }
    class Mesa {
        <<interface>>
        +usar() void
    }
    class Sofa {
        <<interface>>
        +descansar() void
    }

    %% Concrete Products - Modern Family
    class SillaModerna {
        +sentarse() void
    }
    class MesaModerna {
        +usar() void
    }
    class SofaModerno {
        +descansar() void
    }

    %% Concrete Products - Classic Family
    class SillaClasica {
        +sentarse() void
    }
    class MesaClasica {
        +usar() void
    }
    class SofaClasico {
        +descansar() void
    }

    %% Abstract Factory
    class FabricaMuebles {
        <<interface>>
        +crearSilla() Silla
        +crearMesa() Mesa
        +crearSofa() Sofa
    }

    %% Concrete Factories
    class FabricaModerna {
        +crearSilla() Silla
        +crearMesa() Mesa
        +crearSofa() Sofa
    }
    class FabricaClasica {
        +crearSilla() Silla
        +crearMesa() Mesa
        +crearSofa() Sofa
    }

    %% Client
    class Sala {
        -silla: Silla
        -mesa: Mesa
        -sofa: Sofa
        +Sala(FabricaMuebles)
        +mostrar() void
    }

    %% Relationships
    Silla <|.. SillaModerna
    Silla <|.. SillaClasica
    Mesa <|.. MesaModerna
    Mesa <|.. MesaClasica
    Sofa <|.. SofaModerno
    Sofa <|.. SofaClasico

    FabricaMuebles <|.. FabricaModerna
    FabricaMuebles <|.. FabricaClasica

    FabricaModerna ..> SillaModerna : creates
    FabricaModerna ..> MesaModerna : creates
    FabricaModerna ..> SofaModerno : creates

    FabricaClasica ..> SillaClasica : creates
    FabricaClasica ..> MesaClasica : creates
    FabricaClasica ..> SofaClasico : creates

    Sala --> FabricaMuebles : uses
    Sala --> Silla : has
    Sala --> Mesa : has
    Sala --> Sofa : has
```

### Estructura del Código

| Componente | Clase/Interfaz | Descripción |
|------------|----------------|-------------|
| **AbstractProduct** | `Silla`, `Mesa`, `Sofa` | Interfaces que definen los tipos de productos |
| **ConcreteProduct (Modern)** | `SillaModerna`, `MesaModerna`, `SofaModerno` | Implementaciones para estilo moderno |
| **ConcreteProduct (Classic)** | `SillaClasica`, `MesaClasica`, `SofaClasico` | Implementaciones para estilo clásico |
| **AbstractFactory** | `FabricaMuebles` | Interfaz con métodos de creación |
| **ConcreteFactory** | `FabricaModerna`, `FabricaClasica` | Fábricas que crean familias completas |
| **Client** | `Sala` | Usa la fábrica sin conocer clases concretas |

### Flujo de Ejecución

```mermaid
sequenceDiagram
    participant Main
    participant Sala
    participant FabricaModerna
    participant SillaModerna
    participant MesaModerna
    participant SofaModerno

    Main->>Sala: new Sala(new FabricaModerna())
    Sala->>FabricaModerna: crearSilla()
    FabricaModerna->>SillaModerna: new SillaModerna()
    Sala->>FabricaModerna: crearMesa()
    FabricaModerna->>MesaModerna: new MesaModerna()
    Sala->>FabricaModerna: crearSofa()
    FabricaModerna->>SofaModerno: new SofaModerno()
    Main->>Sala: mostrar()
    Sala->>SillaModerna: sentarse()
    Sala->>MesaModerna: usar()
    Sala->>SofaModerno: descansar()
```

### Ventajas
- **Consistencia**: Garantiza que los productos de una familia combinan entre sí
- **Desacoplamiento**: El cliente no conoce clases concretas
- **Extensibilidad**: Fácil agregar nuevas familias (ej. estilo Industrial, Rústico)
- **Principio Open/Closed**: Abierto para extensión, cerrado para modificación

---

## Patrón Singleton

### Propósito
Garantizar que una clase tenga una única instancia y proporcionar un punto de acceso global a ella.

### Diagrama de Clases

```mermaid
classDiagram
    class CajaRegistradora {
        -instancia: CajaRegistradora
        -totalVentas: double
        -CajaRegistradora()
        +obtenerInstancia() CajaRegistradora
        +registrarVenta(double) void
        +getTotalVentas() double
    }

    class MainSingleton {
        +main(String[]) void
    }

    MainSingleton --> CajaRegistradora : uses
```

### Estructura del Código

| Componente | Clase/Método | Descripción |
|------------|--------------|-------------|
| **Instancia única** | `private static CajaRegistradora instancia` | Variable estática que guarda la única instancia |
| **Constructor privado** | `private CajaRegistradora()` | Impide instanciación externa con `new` |
| **Método de acceso** | `public static obtenerInstancia()` | Punto de acceso global (lazy initialization) |
| **Estado compartido** | `totalVentas` | Dato que se acumula en la única instancia |

### Flujo de Ejecución

```mermaid
sequenceDiagram
    participant Main
    participant CajaRegistradora

    Main->>CajaRegistradora: obtenerInstancia()
    alt Primera llamada
        CajaRegistradora->>CajaRegistradora: new CajaRegistradora()
        CajaRegistradora-->>Main: instancia
    else Llamadas subsiguientes
        CajaRegistradora-->>Main: misma instancia
    end
    Main->>CajaRegistradora: registrarVenta(8000)
    Main->>CajaRegistradora: obtenerInstancia()
    Main->>CajaRegistradora: registrarVenta(6000)
    Main->>CajaRegistradora: getTotalVentas()
    Note right of CajaRegistradora: Total: 14000\n(caja1 == caja2: true)
```

### Consideraciones Importantes

⚠️ **Esta implementación básica NO es thread-safe**

Para entornos multi-hilo, usar:

```java
// Opción 1: Double-checked locking
public static CajaRegistradora obtenerInstancia() {
    if (instancia == null) {
        synchronized (CajaRegistradora.class) {
            if (instancia == null) {
                instancia = new CajaRegistradora();
            }
        }
    }
    return instancia;
}

// Opción 2: Enum (recomendado por Joshua Bloch)
public enum CajaRegistradora {
    INSTANCIA;
    private double totalVentas = 0.0;
    public void registrarVenta(double monto) { totalVentas += monto; }
    public double getTotalVentas() { return totalVentas; }
}
```

### Ventajas
- **Control de acceso**: Único punto de acceso global
- **Memoria**: Una sola instancia en memoria
- **Estado compartido**: Todas las partes del sistema ven los mismos datos

---

## Patrón Factory Method

### Propósito
Definir una interfaz para crear un objeto, pero dejar que las subclases decidan qué clase instanciar.

### Diagrama de Clases

```mermaid
classDiagram
    %% Product
    class Transporte {
        <<interface>>
        +entregar() void
    }

    %% Concrete Products
    class Camion {
        +entregar() void
    }
    class Barco {
        +entregar() void
    }

    %% Creator (Abstract)
    class Logistica {
        #crearTransporte() Transporte
        +planificarEntrega() void
    }

    %% Concrete Creators
    class LogisticaTerrestre {
        +crearTransporte() Transporte
    }
    %% Futura extensión
    class LogisticaMaritima {
        +crearTransporte() Transporte
    }

    %% Client
    class MainFactoryMethod {
        +main(String[]) void
    }

    %% Relationships
    Transporte <|.. Camion
    Transporte <|.. Barco

    Logistica <|-- LogisticaTerrestre
    Logistica <|-- LogisticaMaritima

    LogisticaTerrestre ..> Camion : creates
    LogisticaMaritima ..> Barco : creates

    MainFactoryMethod --> Logistica : uses
    Logistica --> Transporte : uses
```

### Estructura del Código

| Rol | Clase/Interfaz | Descripción |
|-----|----------------|-------------|
| **Product** | `Transporte` | Interfaz común para todos los productos |
| **ConcreteProduct** | `Camion`, `Barco` | Implementaciones concretas |
| **Creator** | `Logistica` (abstract) | Define `planificarEntrega()` y declara `crearTransporte()` abstracto |
| **ConcreteCreator** | `LogisticaTerrestre` | Implementa `crearTransporte()` retornando `Camion` |
| **Client** | `MainFactoryMethod` | Usa `Logistica` sin conocer productos concretos |

### Flujo de Ejecución

```mermaid
sequenceDiagram
    participant Main
    participant LogisticaTerrestre
    participant Logistica
    participant Camion

    Main->>LogisticaTerrestre: new LogisticaTerrestre()
    Main->>LogisticaTerrestre: planificarEntrega()
    LogisticaTerrestre->>Logistica: planificarEntrega() (heredado)
    Logistica->>LogisticaTerrestre: crearTransporte() (polimorfismo)
    LogisticaTerrestre->>Camion: new Camion()
    Logistica->>Camion: entregar()
```

### Extensibilidad - Agregar Transporte Marítimo

```java
// 1. Nueva ConcreteCreator (sin tocar Logistica)
public class LogisticaMaritima extends Logistica {
    @Override
    protected Transporte crearTransporte() {
        return new Barco();  // ConcreteProduct existente
    }
}

// 2. Uso en cliente (sin modificar Logistica ni Main)
Logistica logistica = new LogisticaMaritima();
logistica.planificarEntrega();  // Entrega por mar
```

### Ventajas
- **Desacoplamiento**: Creator no conoce ConcreteProduct
- **Extensibilidad**: Nuevos productos = nuevas subclases Creator
- **Single Responsibility**: Cada Creator decide su producto
- **Polimorfismo**: Cliente usa Creator abstracto

---

## Cómo Ejecutar

### Requisitos
- Java 11 o superior
- Maven (opcional, para compilación)

### Compilación y Ejecución Directa

```bash
# Compilar todos los archivos
javac -d out src/main/java/com/patrones/**/*.java

# Ejecutar Abstract Factory
java -cp out com.patrones.abstractfactory.Muebles

# Ejecutar Singleton
java -cp out com.patrones.singleton.MainSingleton

# Ejecutar Factory Method
java -cp out com.patrones.factorymethod.MainFactoryMethod
```

### Con Maven (si existe pom.xml)

```bash
mvn compile exec:java -Dexec.mainClass="com.patrones.abstractfactory.Muebles"
mvn compile exec:java -Dexec.mainClass="com.patrones.singleton.MainSingleton"
mvn compile exec:java -Dexec.mainClass="com.patrones.factorymethod.MainFactoryMethod"
```

### Salida Esperada

#### Abstract Factory
```
=== DEMOSTRACIÓN PATRÓN ABSTRACT FACTORY ===

--- Sala MODERNA ---
Te sientas en una silla moderna de metal y plástico
Pones el computador en una mesa moderna de vidrio
Descansas en un sofá moderno gris de líneas rectas

--- Sala CLÁSICA ---
Te sientas en una silla clásica de madera tallada
Cenas en una mesa clásica de roble
Descansas en un sofá clásico de terciopelo con botones

=== FIN DE LA DEMOSTRACIÓN ===
```

#### Singleton
```
=== DEMOSTRACIÓN PATRÓN SINGLETON ===

Caja 1 obtenida. Registrando venta de $8,000...
Caja 2 obtenida. Registrando venta de $6,000...

--- RESULTADOS ---
Total en caja: $14000.0
¿Es la misma caja? (caja1 == caja2): true

=== FIN DE LA DEMOSTRACIÓN ===
```

#### Factory Method
```
=== DEMOSTRACIÓN PATRÓN FACTORY METHOD ===

Entregando por tierra en camión.

=== FIN DE LA DEMOSTRACIÓN ===
```

---

## Resumen Comparativo

| Aspecto | Abstract Factory | Singleton | Factory Method |
|---------|-----------------|-----------|----------------|
| **Problema** | Familias de productos relacionados | Una sola instancia global | Delegar creación a subclases |
| **Alcance** | Múltiples productos | Una clase | Un producto por Creator |
| **Flexibilidad** | Cambiar familia completa | Acceso global controlado | Extender con nuevos productos |
| **Complejidad** | Media | Baja | Media |
| **Uso típico** | UI toolkits, temas, configuraciones | Logging, configuración, cache | Frameworks, librerías |

---

## Referencias

- **Design Patterns: Elements of Reusable Object-Oriented Software** - Gang of Four (GoF)
- **Head First Design Patterns** - Freeman & Robson
- **Effective Java** - Joshua Bloch (Item 3: Singleton con enum)

---

*Documentación generada para el curso de Programación II - Patrones Creacionales*