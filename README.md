# gestor-contenidos

Proyecto para la materia de Estructura de Datos - Unimayor.

## ¿Que hace?

Sistema que permite gestionar artículos científicos digitales con roles de usuario.
Los editores pueden crear, editar, publicar y archivar artículos.
Los lectores pueden consultar artículos publicados y comentarlos.

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