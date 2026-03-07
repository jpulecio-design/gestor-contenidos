import java.util.Date;
import java.util.Scanner;

public class AccionLector {
    private Scanner scanner;
    private Editor editor;
    private Lector lector;

    public AccionLector(Scanner scanner, Editor editor, Lector lector) {
        this.scanner = scanner;
        this.editor = editor;
        this.lector = lector;
    }

    public void agregarComentario() {
        try {
            if (editor.getArticulos().isEmpty()) {
                System.out.println("No hay artículos disponibles para comentar.");
                return;
            }

            System.out.print("ID del artículo a comentar: ");
            int id = Integer.parseInt(scanner.nextLine());
            Articulo articuloAcomentar = editor.buscarArticulo(id);

            if (articuloAcomentar == null) {
                System.out.println("Artículo no encontrado.");
                return;
            }

            if (articuloAcomentar.getEstadoArticulo() != EstadoArticulo.PUBLICADO) {
                System.out.println("Solo se pueden comentar artículos PUBLICADOS.");
                return;
            }

            System.out.print("Comentario: ");
            String texto = scanner.nextLine();
            Comentario nuevoComentario = new Comentario(articuloAcomentar, texto, new Date(), lector);
            nuevoComentario.guardarComentario();
            articuloAcomentar.getComentarios().add(nuevoComentario);
            lector.agregarComentario(nuevoComentario);
        } catch (Exception e) {
            System.out.println("Error al comentar: " + e.getMessage());
        }
    }
}