public abstract class UsuarioBase {
    protected int idUsuario;
    protected String nombreUsuario;
    protected String rolUsuario;

    public UsuarioBase(int idUsuario, String nombreUsuario, String rolUsuario) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.rolUsuario = rolUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public boolean esEditor() {
        return this.rolUsuario.equals("EDITOR");
    }

    public boolean esLector() {
        return this.rolUsuario.equals("LECTOR");
    }
}
