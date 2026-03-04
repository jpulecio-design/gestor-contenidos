import java.util.ArrayList;

public class Editor extends UsuarioBase {
    private ArrayList<Articulo> articulos;

    public Editor(int idUsuario, String nombreUsuario, String rolUsuario) {
        super(idUsuario, nombreUsuario, rolUsuario);
        this.articulos = new ArrayList<>();
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public static void crearArticulo(Articulo articulo) {
    }

    public static void editarArticulo(Articulo articulo) {
    }

    public static void publicarArticulo(Articulo articulo) {
    }

    public  int incrementarIdArticulo() {
        return idUsuario;
    }

    public Articulo buscarArticulo(int id) {
            for (Articulo a : articulos) {
        if (a.getIdArticulo() == id) {
            return a;
        }
    }
    return null;
    }
}
