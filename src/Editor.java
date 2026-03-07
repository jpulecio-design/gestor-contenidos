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

    public void crearArticulo(Articulo articulo) {
        try {
            articulos.add(articulo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editarArticulo(Articulo articulo) {
        articulo.editarEnBorrador(articulo.getContenidoTextual());
    }

    public void publicarArticulo(Articulo articulo) {
        articulo.setEstadoArticulo(EstadoArticulo.PUBLICADO);
        articulo.setFechaPublicacion(new java.util.Date());
    }

    public int incrementarIdArticulo() {
        return articulos.size() + 1;
    }

    public Articulo buscarArticulo(int id) {
        for (Articulo articulo : articulos) {
            if (articulo.getIdArticulo() == id) {
                return articulo;
            }
        }
        return null;
    }
}
