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
}    