# Estructura-de-datos-CP2
# Lista simplemente enlazada

Este proyecto implementa una lista simplemente enlazada en Java con operaciones básicas y funciones adicionales pedidas por el ejercicio práctico.

## ¿Qué hace el proyecto?

La aplicación permite trabajar con una lista enlazada y realizar las siguientes operaciones:

- Agregar elementos al final
- Insertar elementos en una posición específica
- Eliminar un elemento por posición
- Mostrar la lista actual
- Eliminar elementos duplicados
- Rotar una posición a la derecha
- Concatenar dos listas
- Vaciar la lista
- Ejecutar casos de prueba predefinidos

## ¿Por qué es útil?

Este proyecto sirve para practicar y comprender el funcionamiento de estructuras de datos lineales, especialmente:

- nodos
- listas enlazadas
- recorrido de nodos
- manipulación de punteros o referencias
- operaciones de eliminación, rotación y concatenación

Es un ejercicio ideal para reforzar conceptos de programación orientada a objetos y algoritmos básicos sobre listas.

## Cómo comenzar

1. Abre el proyecto en VS Code.
2. Asegúrate de tener Java instalado.
3. Abre una terminal en la carpeta raíz del repositorio y compila los archivos fuente:

```bash
javac EjercicioCP2/*.java
```

4. Ejecuta la aplicación:

```bash
java -cp EjercicioCP2 Main
```

## Estructura del proyecto

Los archivos Java están dentro de la carpeta `EjercicioCP2`, en la raíz del repositorio:

```text
.
├── EjercicioCP2/
│   ├── LinkedList.java
│   ├── List.java
│   ├── Main.java
│   ├── Nodo.java
│   ├── Sistema.java
│   └── Validaciones.java
└── README.md
```

- `EjercicioCP2/Main.java`: punto de entrada del programa
- `EjercicioCP2/Sistema.java`: menú interactivo y lógica del usuario
- `EjercicioCP2/LinkedList.java`: implementación de la lista enlazada
- `EjercicioCP2/Nodo.java`: clase Nodo
- `EjercicioCP2/List.java`: interfaz de la lista
- `EjercicioCP2/Validaciones.java`: validación de entrada del usuario

## Requisitos del ejercicio

La lista implementa los siguientes métodos solicitados:

1. Eliminar elementos repetidos
2. Rotar una posición a la derecha
3. Concatenar dos listas

Ejemplos:

- `A-B-C-D` -> rotación derecha -> `D-A-B-C`
- `A-B-C-D` + `E-F-G-H` -> `A-B-C-D-E-F-G-H`

## Ayuda

Si tienes dudas sobre el funcionamiento del proyecto o alguna operación de la lista, puedes:

- revisar la lógica en `EjercicioCP2/LinkedList.java`
- ejecutar el menú de prueba desde `EjercicioCP2/Sistema.java`
- consultar los casos de prueba incluidos en la opción `9` del menú

## Autor

Proyecto desarrollado para la práctica de estructuras de datos en Java.
