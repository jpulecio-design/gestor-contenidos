import java.util.ArrayList;

public class Lector extends UsuarioBase {
    private ArrayList<Articulo> articulos;

    public Lector(int idUsuario, String nombreUsuario, String rolUsuario) {
        super(idUsuario, nombreUsuario, rolUsuario);
        this.articulos = new ArrayList<>();
    }

    public Articulo consultarArticulo(int id) {
        return null;
    }

    public void agregarComentario(Comentario comentario){
        
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
}
