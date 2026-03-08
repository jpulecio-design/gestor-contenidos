import java.util.Date;

public class Comentario {
    private String caracteresMaximo;
    private Date fechaCreacion;
    private Lector lector;                                      
    private Articulo articulo;

    public Comentario(Articulo articulo, String caracteresMaximo, Date fechaCreacion, Lector lector) {
        this.articulo = articulo;
        this.caracteresMaximo = caracteresMaximo;
        this.fechaCreacion = fechaCreacion;
        this.lector = lector;
    }

    public String getCaracteresMaximo() {
        return caracteresMaximo;
    }

    public void setCaracteresMaximo(String caracteresMaximo) {
        this.caracteresMaximo = caracteresMaximo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}