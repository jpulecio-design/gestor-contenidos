# gestor-contenidos

Proyecto para la materia de Estructura de Datos - Unimayor.

## Integrantes

- Karen Daniela Ramirez
- Luis Miguel Lenis
- Juan Andres Pulecio
-Juan Esteban Garcia

## ¿Que hace?

Sistema que permite gestionar articulos cientificos digitales con roles de usuario.
Los editores pueden crear, editar, publicar y archivar articulos.
Los lectores pueden consultar articulos publicados y comentarlos.

## Estructura
```
src/
├── modelo/
│   ├── UsuarioBase.java
│   ├── Editor.java
│   ├── Lector.java
│   ├── Articulo.java
│   ├── Comentario.java
│   ├── HistorialModificacion.java
│   └── EstadoArticulo.java
├── accion/
│   ├── AccionEditor.java
│   ├── AccionLector.java
│   ├── AccionComun.java
│   └── MenuConsultorContenido.java
├── util/
│   └── GestorBusquedaArticulo.java
└── App.java
```

## Tecnologias

- Java sin frameworks
- VS Code
- Git