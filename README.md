<<<<<<< HEAD
# 🐉 DragonQuest – Mini Proyecto 2  
**Materia:** Programación Orientada a Eventos  
**Profesor:** Joshua Triana  
**Universidad del Valle**

---

## Integrantes  
- **Juan Esteban Aguirre Castañeda** – 202459676  
- **Kevin Julián López Moreno** – 202380379  

---

## Descripción del Proyecto  
**DragonQuest** es un **juego de combate por turnos** desarrollado en **Java**, en el que cuatro héroes se enfrentan a cuatro enemigos.  
Cada personaje cuenta con atributos como **HP**, **MP**, **ataque**, **defensa** y **velocidad**.  
Durante el combate, los héroes pueden **atacar, defenderse, usar habilidades o ítems**, mientras que los enemigos actúan mediante una **IA básica**.  

El juego se ejecuta en consola y busca aplicar los conceptos fundamentales de la **Programación Orientada a Eventos (POE)**, incluyendo:
- Herencia  
- Polimorfismo  
- Clases abstractas e interfaces  
- Encapsulamiento  
- Organización modular por paquetes
- Interfaz gráfica con **Swing**
---

## Estructura del Proyecto

```plaintext
dragonquest/
│
├── main.java           → Clase principal (main)
│
├── combate/
│   └── Batalla.java               → Control del flujo de combate y turnos
│
├── config/                            → Manejo de configuración general del juego
│   ├── ConfiguracionJuego.java        → Lee y aplica valores desde config.properties
│   └── ConfiguracionJuegoManager.java → Control centralizado de opciones (volumen, dificultad, etc.)
│
├── estados/
│   └── EstadoAlterado.java        → Enum con estados (normal, paralizado, dormido, etc.)
│
├── gui/                               → Contiene toda la interfaz gráfica (Java Swing)
│   ├── VentanaPrincipal.java          → Ventana inicial del juego (menú principal con opciones)
│   ├── VentanaCombate.java            → Ventana principal de combate con paneles de héroes y enemigos
│   ├── PanelHeroe.java                → Muestra la información de cada héroe (nombre, HP, MP, estados)
│   ├── PanelEnemigo.java              → Muestra la información de cada enemigo
│   ├── VentanaHabilidades.java        → Permite seleccionar y usar habilidades disponibles
│   ├── VentanaInventario.java         → Permite seleccionar y usar ítems del inventario
│   ├── PanelMensajes.java             → Panel auxiliar que muestra eventos del combate (ataques, curaciones, etc.)
│
├── habilidades/
│   ├── Habilidad.java             → Clase base abstracta para las habilidades
│   ├── Curacion.java              → Habilidad de curar HP
│   ├── CuracionGrupal.java              → Habilidad de curar HP al grupo
│   ├── Dormir.java              → Habilidad de Dormir al enemigo
│   ├── GolpeCritico.java              → Habilidad para que un golpe fisico tenga chance de ser un golpe critico
│   ├── Paralisis.java              → Habilidad de paralizar al enemigo
│   ├── RemoverEstado.java              → Habilidad para remover cualquier estado negativo 
│   ├── Veneno.java              → Habilidad de curar HP
│   ├── Aturdimiento.java              → Habilidad de envenenar al enemigo
│   └── DanioMagico.java           → Habilidad ofensiva mágica
│
├── imagenes/
│   └── fondo_azul.png
│
├── items/
│   ├── Item.java                  → Clase base abstracta para ítems
│   ├── InventarioGrupo.java              → Clase auxiliar simple para pares
│   ├── PocionCuracion.java                → Restaura HP
│   ├── Antidoto.java              → Habilidad para eliminar el estado envenenado
│   └── PocionMagia.java                  → Restaura MP
│
├── sonidos/
│   ├── heal.wav               
│   ├── hit.wav
│   ├── musica_batalla.wav
│   ├── musica_menu.wav
│   └── status.wav
│
└── personajes/
    ├── Personaje.java             → Clase base abstracta con atributos y métodos comunes
    ├── Heroe.java                 → Subclase que representa a los héroes
    └── Enemigo.java               → Subclase que representa a los enemigos
```
---

## Instrucciones para Colaboradores
**Si otro desarrollador desea contribuir:**

**Clonar el repositorio:**

- git clone https://github.com/Jeac2506/mini_proyecto_2 cd mini_Proyecto_2


**Crear una nueva rama:**

- git checkout -b nombre-rama


**Realizar los cambios y hacer commit:**

- git add .
- git commit -m "Descripción del cambio"


**Subir los cambios y crear un Pull Request:**

- git push origin nombre-rama

- Luego abrir el PR en GitHub para revisión.

---

## Análisis del Diseño
- **¿Qué pasa si dos personajes tienen la misma velocidad?**

Si dos personajes tienen la misma velocidad, el sistema mantiene el orden de aparición dentro de la lista de turno.
Esto significa que el personaje agregado primero actuará antes que el segundo.

## ¿Qué sistema se usa para definir las habilidades (y que puedan tener efectos distintos)?

El código usa una clase abstracta **Habilidad** que obliga a cada habilidad a implementar el método **ejecutar().**
Gracias a eso, cada habilidad (por ejemplo **Curacion, DanioMagico,** etc.) puede tener comportamientos únicos, sin alterar la estructura base.

public abstract class Habilidad {
    protected String nombre;
    protected int costoMP;
    public abstract void ejecutar(Personaje usuario, List<Personaje> enemigos, List<Personaje> aliados, Scanner sc);
}

## ¿Cómo se podrían representar los distintos tipos de personajes o enemigos?

**Se logra mediante herencia y especialización:**

Heroe y Enemigo heredan de Personaje.

Cada subclase redefine su comportamiento (tomarTurno(), atacar(), etc.).

En el futuro podrían agregarse clases como:

class Mago extends Heroe { ... }
class Guerrero extends Heroe { ... }
class JefeFinal extends Enemigo { ... }

## ¿Cómo se garantiza que el código sea extensible (por ejemplo, para el Mini Proyecto 2)?

**El proyecto está diseñado siguiendo principios de extensibilidad:**

- Cada componente (combate, personajes, habilidades, ítems, estados) está en su propio paquete.

- Las clases abstractas (Personaje, Habilidad, Item) definen contratos que pueden ser ampliados fácilmente.

- Para futuras versiones se podrán agregar:

- Nuevas habilidades y efectos de estado.

- Tipos de personajes con comportamientos distintos.

- Un sistema de niveles o experiencia.

- Una interfaz gráfica (GUI) o base de datos sin alterar la lógica central.
---

## Posibles Extensiones Futuras

- Añadir más tipos de enemigos y habilidades.

- Guardar y cargar partidas.

- Crear una interfaz gráfica (GUI) para el combate.

<<<<<<< HEAD
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
# MiniProyecto3-MVC-
APLICACION DEL MVC AL MINIPROYECTO 2
>>>>>>> 8d57256c10a5709676afeef810d8aaaa476924f4
=======
>>>>>>> 93cdd03b6f2f9c6ae45ee213097440d94943e37a
=======
=======
>>>>>>> old-main
=======
=======
>>>>>>> 388c091ba9dacb6e91231d922263518b84bfddcb
