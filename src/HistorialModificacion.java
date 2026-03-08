import java.util.Date;

public class HistorialModificacion {
    private Date fechaModificacion;
    private Editor editor;
    private String autorModificacion;
    private EstadoArticulo estadoAnterior;

    public HistorialModificacion(Date fechaModificacion, Editor editor, String autorModificacion,
            EstadoArticulo estadoAnterior) {
        this.fechaModificacion = fechaModificacion;
        this.editor = editor;
        this.autorModificacion = autorModificacion;
        this.estadoAnterior = estadoAnterior;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public String getAutorModificacion() {
        return autorModificacion;
    }

    public void setAutorModificacion(String autorModificacion) {
        this.autorModificacion = autorModificacion;
    }

    public EstadoArticulo getEstadoAnterior() {
        return estadoAnterior;
    }

    public void setEstadoAnterior(EstadoArticulo estadoAnterior) {
        this.estadoAnterior = estadoAnterior;
    }
}
