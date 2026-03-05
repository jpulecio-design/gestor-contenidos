import java.util.ArrayList;
import java.util.Date;

public class Articulo {
    private int idArticulo;
    private String tituloArticulo;
    private String contenidoTextual;
    private Date fechaCreacion;
    private EstadoArticulo estadoArticulo;
    private Editor editor;
    private Lector lector;
    private Date fechaPublicacion;
    private ArrayList<Comentario> comentarios;
    private ArrayList<HistorialModificacion> historial;


    public Articulo(int idArticulo, String tituloArticulo, String contenidoTextual, Editor editor, Lector lector) {
        this.idArticulo = idArticulo;
        this.tituloArticulo = tituloArticulo;
        this.contenidoTextual = contenidoTextual;
        this.fechaCreacion = new Date();
        this.estadoArticulo = EstadoArticulo.BORRADOR;
        this.editor = editor;
        this.lector = lector;
        this.fechaPublicacion = null;
        this.comentarios = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getTituloArticulo() {
        return tituloArticulo;
    }

    public void setTituloArticulo(String tituloArticulo) {
        this.tituloArticulo = tituloArticulo;
    }

    public String getContenidoTextual() {
        return contenidoTextual;
    }

    public void setContenidoTextual(String contenidoTextual) {
        this.contenidoTextual = contenidoTextual;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoArticulo getEstadoArticulo() {
        return estadoArticulo;
    }

    public void setEstadoArticulo(EstadoArticulo estadoArticulo) {
        this.estadoArticulo = estadoArticulo;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public ArrayList<HistorialModificacion> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<HistorialModificacion> historial) {
        this.historial = historial;
    }
    
}
