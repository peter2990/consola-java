import java.util.regex.*;
import java.util.Scanner;

// Clase que representa un usuario
class Usuario {
    private String nombre;
    private String correo;
    private String contrasena;

    // Constructor de la clase Usuario
    public Usuario(String nombre, String correo, String contrasena) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    // Métodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    // Método para mostrar la información del usuario
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Correo: " + correo);
    }
}

// Clase que gestiona el registro de usuarios
class RegistroUsuarios {

    // Validar el nombre (solo letras y espacios)
    public static boolean validarNombre(String nombre) {
        return nombre != null && nombre.matches("^[a-zA-Z\\s]+$");
    }

    // Validar el correo electrónico con expresión regular
    public static boolean validarCorreo(String correo) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return correo != null && correo.matches(regex);
    }

    // Validar la contraseña (mínimo 8 caracteres, al menos una letra y un número)
    public static boolean validarContrasena(String contrasena) {
        String regex = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";
        return contrasena != null && contrasena.matches(regex);
    }

    // Método para registrar un usuario
    public static Usuario registrarUsuario(String nombre, String correo, String contrasena) {
        if (validarNombre(nombre) && validarCorreo(correo) && validarContrasena(contrasena)) {
            return new Usuario(nombre, correo, contrasena);
        } else {
            System.out.println("Los datos ingresados no son válidos. Por favor, intente nuevamente.");
            return null;
        }
    }
}

// Clase principal para ejecutar el programa
public class GestionUsuarios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al sistema de registro de usuarios!");

        // Solicitar datos del usuario
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Ingrese su contraseña (mínimo 8 caracteres, con al menos una letra y un número): ");
        String contrasena = scanner.nextLine();

        // Registrar al usuario
        Usuario nuevoUsuario = RegistroUsuarios.registrarUsuario(nombre, correo, contrasena);

        if (nuevoUsuario != null) {
            System.out.println("\nUsuario registrado con éxito:");
            nuevoUsuario.mostrarInformacion();
        }

        scanner.close();
    }
}
