package accion;

import java.util.Scanner;

import modelo.Articulo;
import modelo.Comentario;
import modelo.Editor;
import modelo.EstadoArticulo;
import modelo.HistorialModificacion;
import modelo.UsuarioBase;

public class AccionComun {
    private Scanner scanner;
    private Editor editor;
    private UsuarioBase usuarioActivo;

    public AccionComun(Scanner scanner, Editor editor, UsuarioBase usuarioActivo) {
        this.scanner = scanner;
        this.editor = editor;
        this.usuarioActivo = usuarioActivo;
    }

    public void setUsuarioActivo(UsuarioBase usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }

    public void listarArticulos() {
        try {
            if (editor.getArticulos().isEmpty()) {
                System.out.println("No hay articulos registrados.");
                return;
            }

            boolean hayArticulos = false;
            for (Articulo articulo : editor.getArticulos()) {
                if (usuarioActivo.esLector()
                        && articulo.getEstadoArticulo() != EstadoArticulo.PUBLICADO) {
                    continue; // si no esta lo salta al siguientes articulo sin mostrarlo
                }
                hayArticulos = true;
                System.out.println("\n--- Articulo ---");
                System.out.println("ID       : " + articulo.getIdArticulo());
                System.out.println("Título   : " + articulo.getTituloArticulo());
                System.out.println("Contenido: " + articulo.getContenidoTextual());
                System.out.println("Estado   : " + articulo.getEstadoArticulo());
                System.out.println("Creado   : " + articulo.getFechaCreacion());

                if (!articulo.getHistorial().isEmpty()) {
                    System.out.println("Historial de cambios:");
                    for (HistorialModificacion h : articulo.getHistorial()) {
                        System.out.println("  - Autor: " + h.getAutorModificacion()
                                + " | Estado anterior: " + h.getEstadoAnterior()
                                + " | Fecha: " + h.getFechaModificacion());
                    }
                }
            }

            if (!hayArticulos) {
                System.out.println("No hay articulos publicados disponibles.");
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    public void verComentarios() {
        try {
            if (editor.getArticulos().isEmpty()) {
                System.out.println("No hay articulos registrados.");
                return;
            }

            System.out.print("ID del articulo: ");
            int id = Integer.parseInt(scanner.nextLine());
            Articulo articulo = editor.buscarArticulo(id);

            if (articulo == null) {
                System.out.println("Articulo no encontrado.");
                return;
            }

            if (usuarioActivo.esLector()
                    && articulo.getEstadoArticulo() != EstadoArticulo.PUBLICADO) {
                System.out.println("Acceso denegado: el articulo no esta publicado.");
                return;
            }

            if (articulo.getComentarios().isEmpty()) {
                System.out.println("Este articulo no tiene comentarios.");
                return;
            }

            System.out.println("\n--- Comentarios: " + articulo.getTituloArticulo() + " ---");
            for (Comentario comentario : articulo.getComentarios()) {
                System.out.println("Lector : " + comentario.getLector().getNombreUsuario());
                System.out.println("Texto  : " + comentario.getCaracteresMaximo());
                System.out.println("Fecha  : " + comentario.getFechaCreacion());
                System.out.println("---");
            }
        } catch (Exception e) {
            System.out.println("Error al ver comentarios: " + e.getMessage());
        }
    }

    public void buscarArticulo() {
        try {
            if (editor.getArticulos().isEmpty()) {
                System.out.println("No hay articulos registrados para buscar.");
                return;
            }

            System.out.print("Palabra a buscar en titulo o contenido: ");
            String palabra = scanner.nextLine().toLowerCase();

            boolean encontrado = false;
            for (Articulo articulo : editor.getArticulos()) {
                if (usuarioActivo.esLector()
                        && articulo.getEstadoArticulo() != EstadoArticulo.PUBLICADO) {
                    continue;
                }
                if (articulo.getTituloArticulo().toLowerCase().contains(palabra)
                        || articulo.getContenidoTextual().toLowerCase().contains(palabra)) {
                    System.out.println("\nID       : " + articulo.getIdArticulo());
                    System.out.println("Titulo   : " + articulo.getTituloArticulo());
                    System.out.println("Contenido: " + articulo.getContenidoTextual());
                    System.out.println("Estado   : " + articulo.getEstadoArticulo());
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontraron articulos con la palabra: " + palabra);
            }
        } catch (Exception e) {
            System.out.println("Error en busqueda: " + e.getMessage());
        }
    }
}