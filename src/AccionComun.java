import java.util.Scanner;

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
                System.out.println("No hay artículos registrados.");
                return;
            }

            boolean hayArticulos = false;
            for (Articulo articulo : editor.getArticulos()) {
                if (usuarioActivo.esLector()
                        && articulo.getEstadoArticulo() != EstadoArticulo.PUBLICADO) {
                    continue;// consultar
                }
                hayArticulos = true;
                System.out.println("\n--- Artículo ---");
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
                System.out.println("No hay artículos publicados disponibles.");
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
    }

    public void verComentarios() {
        try {
            if (editor.getArticulos().isEmpty()) {
                System.out.println("No hay artículos registrados.");
                return;
            }

            System.out.print("ID del artículo: ");
            int id = Integer.parseInt(scanner.nextLine());
            Articulo articulo = editor.buscarArticulo(id);

            if (articulo == null) {
                System.out.println("Artículo no encontrado.");
                return;
            }

            if (usuarioActivo.esLector()
                    && articulo.getEstadoArticulo() != EstadoArticulo.PUBLICADO) {
                System.out.println("Acceso denegado: el artículo no está publicado.");
                return;
            }

            if (articulo.getComentarios().isEmpty()) {
                System.out.println("Este artículo no tiene comentarios.");
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
                System.out.println("No hay artículos registrados para buscar.");
                return;
            }

            System.out.print("Palabra a buscar en título o contenido: ");
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
                    System.out.println("Título   : " + articulo.getTituloArticulo());
                    System.out.println("Contenido: " + articulo.getContenidoTextual());
                    System.out.println("Estado   : " + articulo.getEstadoArticulo());
                    encontrado = true;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontraron artículos con la palabra: " + palabra);
            }
        } catch (Exception e) {
            System.out.println("Error en búsqueda: " + e.getMessage());
        }
    }
}