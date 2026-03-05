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
        if (caracteresMaximo.length() <= 200) {
            this.caracteresMaximo = caracteresMaximo;
        } else {
            System.out.println("El comentario excede 200 caracteres");
        }
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

    public boolean validarLongitud() {
        return caracteresMaximo.length() <= 200;
    }

    public void guardarComentario() {
        if (validarLongitud()) {
            System.out.println("Comentario guardado: " + caracteresMaximo);
        } else {
            System.out.println("No se puede guardar, excede 200 caracteres");
        }
    }
}
