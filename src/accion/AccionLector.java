package accion;
import java.util.Date;
import java.util.Scanner;

import modelo.Articulo;
import modelo.Comentario;
import modelo.Editor;
import modelo.EstadoArticulo;
import modelo.Lector;

public class AccionLector {
    private Scanner scanner;
    private Editor editor;
    private Lector lector;

    public AccionLector(Scanner scanner, Editor editor, Lector lector) {
        this.scanner = scanner;
        this.editor = editor;
        this.lector = lector;
    }

    private boolean validarLongitudComentario(String texto) {
        return texto.length() <= 200;
    }

    public void agregarComentario() {
        try {
            if (editor.getArticulos().isEmpty()) {
                System.out.println("No hay articulos disponibles para comentar.");
                return;
            }

            System.out.print("ID del articulo a comentar: ");
            int id = Integer.parseInt(scanner.nextLine());
            Articulo articuloAcomentar = editor.buscarArticulo(id);

            if (articuloAcomentar == null) {
                System.out.println("Articulo no encontrado.");
                return;
            }

            if (articuloAcomentar.getEstadoArticulo() != EstadoArticulo.PUBLICADO) {
                System.out.println("Solo se pueden comentar articulos PUBLICADOS.");
                return;
            }

            System.out.print("Comentario: ");
            String texto = scanner.nextLine();

            if (!validarLongitudComentario(texto)) {
                System.out.println("El comentario excede 200 caracteres.");
                return;
            }

            Comentario nuevoComentario = new Comentario(articuloAcomentar, texto, new Date(), lector);
            articuloAcomentar.getComentarios().add(nuevoComentario);
            lector.agregarComentario(nuevoComentario);
            System.out.println("Comentario guardado.");
        } catch (Exception e) {
            System.out.println("Error al comentar: " + e.getMessage());
        }
    }
}