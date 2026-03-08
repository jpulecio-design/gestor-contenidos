# gestor-contenidos

Proyecto para la materia de Estructura de Datos - Unimayor.

## ¿Qué hace?

Sistema que permite gestionar artículos científicos digitales con roles de usuario.
Los editores pueden crear, editar, publicar y archivar artículos.
Los lectores pueden consultar artículos publicados y comentarlos.

## Clases

- `EstadoArticulo` - enum con los estados del artículo
- `UsuarioBase` - clase abstracta base
- `Editor` y `Lector` - tipos de usuario
- `Articulo` - entidad principal
- `Comentario` e `HistorialModificacion` - clases de soporte

## Capa de presentación

- `AccionEditor`, `AccionLector`, `AccionComun` - lógica por rol
- `MenuConsultorContenido` - menú por consola
- `App` - main

## Tecnologías

- Java sin frameworks
- VS Code
- Git