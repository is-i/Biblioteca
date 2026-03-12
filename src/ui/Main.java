package ui;

import java.util.Scanner;
import model.Libro;
import model.Revista;
import model.Usuario;
import service.Biblioteca;

/**
 * UI por consola (menú).
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // Objetos creados fuera y agregados => AGREGACIÓN
        biblioteca.registrarUsuario(new Usuario("Ana"));
        biblioteca.registrarUsuario(new Usuario("Luis"));

        biblioteca.registrarMaterial(new Libro("Cálculo I", "Stewart", 500));
        biblioteca.registrarMaterial(new Revista("Electrónica Hoy", 42));

        int op;
        do {
            System.out.println("\n=== " + biblioteca.getNombre() + " ===");
            System.out.println("1) Listar materiales");
            System.out.println("2) Listar usuarios");
            System.out.println("3) Prestar material");
            System.out.println("4) Devolver material");
            System.out.println("5) Listar préstamos");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            op = leerEntero(sc);

            switch (op) {
                case 1 -> biblioteca.listarMateriales();
                case 2 -> biblioteca.listarUsuarios();
                case 3 -> {
                    System.out.print("ID Usuario: ");
                    String idU = sc.nextLine();
                    System.out.print("ID Material: ");
                    String idM = sc.nextLine();
                    System.out.print("Días de préstamo: ");
                    int dias = leerEntero(sc);
                    biblioteca.prestar(idU, idM, dias);
                }
                case 4 -> {
                    System.out.print("ID Préstamo: ");
                    String idP = sc.nextLine();
                    biblioteca.devolver(idP);
                }
                case 5 -> biblioteca.listarPrestamos();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción inválida.");
            }
        } while (op != 0);

        sc.close();
    }

    private static int leerEntero(Scanner sc) {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }
}
