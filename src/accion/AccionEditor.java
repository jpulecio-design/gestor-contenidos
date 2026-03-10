package accion;

import java.util.Date;
import java.util.Scanner;

import modelo.Articulo;
import modelo.Editor;
import modelo.EstadoArticulo;
import modelo.HistorialModificacion;
import modelo.Lector;

public class AccionEditor {
    private Scanner scanner;
    private Editor editor;
    private Lector lector;

    public AccionEditor(Scanner scanner, Editor editor, Lector lector) {
        this.scanner = scanner;
        this.editor = editor;
        this.lector = lector;
    }

    private boolean validarLongitud(Articulo articulo) {
        return articulo.getTituloArticulo().length() <= 120
                && articulo.getContenidoTextual().length() <= 10000;
    }

    private void registrarHistorial(Articulo articulo) {
        HistorialModificacion registro = new HistorialModificacion(
                new Date(), editor, editor.getNombreUsuario(), articulo.getEstadoArticulo());
        articulo.getHistorial().add(registro);
        System.out.println("Historial - Autor: " + registro.getAutorModificacion()
                + " | Estado anterior: " + registro.getEstadoAnterior()
                + " | Fecha: " + registro.getFechaModificacion());
    }

    public void crearArticulo() {
        try {
            System.out.print("Titulo: ");
            String titulo = scanner.nextLine();
            System.out.print("Contenido: ");
            String contenido = scanner.nextLine();

            int nuevoId = editor.incrementarIdArticulo();
            Articulo nuevoArticulo = new Articulo(nuevoId, titulo, contenido, editor, lector);

            if (!validarLongitud(nuevoArticulo)) {
                System.out.println("Error: titulo o contenido excede limite de caracteres.");
                return;
            }

            editor.crearArticulo(nuevoArticulo);
            System.out.println("Articulo creado con ID: " + nuevoId
                    + " | Estado: " + nuevoArticulo.getEstadoArticulo());
        } catch (Exception e) {
            System.out.println("Error al crear articulo: " + e.getMessage());
        }
    }

    public void editarArticulo() {
        try {
            System.out.print("ID del articulo a editar: ");
            int id = Integer.parseInt(scanner.nextLine());
            Articulo articuloAEditar = editor.buscarArticulo(id);

            if (articuloAEditar == null) {
                System.out.println("Articulo no encontrado.");
                return;
            }

            System.out.println("Estado actual: " + articuloAEditar.getEstadoArticulo());

            if (articuloAEditar.getEstadoArticulo() != EstadoArticulo.BORRADOR) {
                System.out.println("No se puede editar: el articulo no esta en estado BORRADOR.");
                return;
            }

            System.out.print("Nuevo contenido: ");
            String nuevoContenido = scanner.nextLine();

            registrarHistorial(articuloAEditar);
            articuloAEditar.setContenidoTextual(nuevoContenido);
            System.out.println("Articulo editado correctamente por: " + editor.getNombreUsuario());
        } catch (Exception e) {
            System.out.println("Error al editar articulo: " + e.getMessage());
        }
    }

    public void publicarArticulo() {
        try {
            System.out.print("ID del articulo a publicar: ");
            int id = Integer.parseInt(scanner.nextLine());
            Articulo articuloAPublicar = editor.buscarArticulo(id);

            if (articuloAPublicar == null) {
                System.out.println("Articulo no encontrado.");
                return;
            }

            if (articuloAPublicar.getEstadoArticulo() == EstadoArticulo.ARCHIVADO) {
                System.out.println("No se puede publicar un articulo archivado.");
                return;
            }

            if (articuloAPublicar.getEstadoArticulo() == EstadoArticulo.PUBLICADO) {
                System.out.println("El articulo ya esta publicado.");
                return;
            }

            registrarHistorial(articuloAPublicar);
            articuloAPublicar.setEstadoArticulo(EstadoArticulo.PUBLICADO);
            articuloAPublicar.setFechaPublicacion(new Date());
            System.out.println("Articulo publicado: " + articuloAPublicar.getTituloArticulo()
                    + " | Fecha: " + articuloAPublicar.getFechaPublicacion());
        } catch (Exception e) {
            System.out.println("Error al publicar: " + e.getMessage());
        }
    }

    public void archivarArticulo() {
        try {
            System.out.print("ID del articulo a archivar: ");
            int id = Integer.parseInt(scanner.nextLine());
            Articulo articuloAArchivar = editor.buscarArticulo(id);

            if (articuloAArchivar == null) {
                System.out.println("Articulo no encontrado.");
                return;
            }

            if (articuloAArchivar.getEstadoArticulo() == EstadoArticulo.BORRADOR) {
                System.out.println("No se puede archivar: el articulo debe estar PUBLICADO primero.");
                return;
            }

            if (articuloAArchivar.getEstadoArticulo() == EstadoArticulo.ARCHIVADO) {
                System.out.println("El articulo ya esta archivado.");
                return;
            }

            registrarHistorial(articuloAArchivar);
            articuloAArchivar.setEstadoArticulo(EstadoArticulo.ARCHIVADO);
            System.out.println("Articulo archivado: " + articuloAArchivar.getTituloArticulo());
        } catch (Exception e) {
            System.out.println("Error al archivar: " + e.getMessage());
        }
    }
}