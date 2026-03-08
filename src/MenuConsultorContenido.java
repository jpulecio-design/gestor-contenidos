import java.util.Scanner;

public class MenuConsultorContenido {
    private Scanner scanner;
    private Editor editor;
    private Lector lector;
    private UsuarioBase usuarioActivo;
    private AccionEditor accionEditor;
    private AccionLector accionLector;
    private AccionComun accionComun;

    public MenuConsultorContenido() {
        this.scanner = new Scanner(System.in);
        this.editor = new Editor(1, "Pendiente", "EDITOR");
        this.lector = new Lector(2, "Pendiente", "LECTOR");
        this.usuarioActivo = seleccionarUsuario();
        this.accionEditor = new AccionEditor(scanner, editor, lector);
        this.accionLector = new AccionLector(scanner, editor, lector);
        this.accionComun = new AccionComun(scanner, editor, usuarioActivo);
    }

    private UsuarioBase seleccionarUsuario() {
        System.out.println("\n===== Seleccion de Rol =====");
        System.out.println("1. Editor");
        System.out.println("2. Lector");
        System.out.print("Opcion: ");
        try {
            int opcion = Integer.parseInt(scanner.nextLine());
            if (opcion != 1 && opcion != 2) {
                System.out.println("Opcion no valida. Oprima 1 para Editor o 2 para Lector.");
                return seleccionarUsuario();
            }
            System.out.print("Ingresa tu nombre: ");
            String nombre = scanner.nextLine();
            if (opcion == 1) {
                editor.setNombreUsuario(nombre);
                editor.setRolUsuario("EDITOR");
                System.out.println("Bienvenido Editor " + nombre + ".");
                return editor;
            } else {
                lector.setNombreUsuario(nombre);
                lector.setRolUsuario("LECTOR");
                System.out.println("Bienvenido Lector " + nombre + ".");
                return lector;
            }
        } catch (NumberFormatException e) {
            System.out.println("Opcion no valida. Oprima 1 para Editor o 2 para Lector.");
            return seleccionarUsuario();
        }
    }

    public void iniciar() {
        boolean ejecutando = true;
        while (ejecutando) {
            mostrarMenu();
            int opcion = leerOpcion();
            ejecutando = procesarOpcion(opcion);
        }
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n======= Menu Gestion de Contenidos =======");
        System.out.println("Usuario: " + usuarioActivo.getNombreUsuario()
                + " | Rol: " + usuarioActivo.getRolUsuario());
        System.out.println(usuarioActivo.describirRol());
        System.out.println("1. Crear articulo         (Editor)");
        System.out.println("2. Editar articulo        (Editor - solo BORRADOR)");
        System.out.println("3. Publicar articulo      (Editor)");
        System.out.println("4. Archivar articulo      (Editor - solo PUBLICADO)");
        System.out.println("5. Listar articulos       (Todos)");
        System.out.println("6. Ver comentarios        (Todos)");
        System.out.println("7. Agregar comentario     (Lector)");
        System.out.println("8. Buscar por palabra     (Todos)");
        System.out.println("9. Cambiar de rol");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
        
    }

    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: ingresa un numero valido.");
            return -1;
        }
    }

    private boolean procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                validarYEjecutarEditor(() -> accionEditor.crearArticulo());
                break;
            case 2:
                validarYEjecutarEditor(() -> accionEditor.editarArticulo());
                break;
            case 3:
                validarYEjecutarEditor(() -> accionEditor.publicarArticulo());
                break;
            case 4:
                validarYEjecutarEditor(() -> accionEditor.archivarArticulo());
                break;
            case 5:
                accionComun.listarArticulos();
                break;
            case 6:
                accionComun.verComentarios();
                break;
            case 7:
                validarYEjecutarLector(() -> accionLector.agregarComentario());
                break;
            case 8:
                accionComun.buscarArticulo();
                break;
            case 9:
                usuarioActivo = seleccionarUsuario();
                accionComun.setUsuarioActivo(usuarioActivo);
                break;
            case 0:
                System.out.println("Cerrando sistema...");
                return false;
            default:
                System.out.println("Opcion no valida.");
        }
        return true;
    }

    private void validarYEjecutarEditor(Runnable accion) {
        if (!usuarioActivo.esEditor()) {
            System.out.println("Acceso denegado: solo un Editor puede realizar esta accion.");
            return;
        }
        accion.run();
    }

    private void validarYEjecutarLector(Runnable accion) {
        if (!usuarioActivo.esLector()) {
            System.out.println("Acceso denegado: solo un Lector puede realizar esta accion.");
            return;
        }
        accion.run();
    }
}