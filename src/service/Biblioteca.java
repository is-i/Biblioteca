package service;

import java.util.ArrayList;
import model.Material;
import model.Prestamo;
import model.Usuario;

/**
 * AGREGACIÓN:
 * - Biblioteca mantiene listas (ArrayList) de Material/Usuario/Prestamo.
 *
 * USO (dependency):
 * - Biblioteca usa CalculadoraCosto para obtener el costo total.
 */
public class Biblioteca {
    private final String nombre;

    private final ArrayList<Material> materiales = new ArrayList<>();
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final ArrayList<Prestamo> prestamos = new ArrayList<>();

    private final CalculadoraCosto calculadoraCosto = new CalculadoraCosto(); // uso

    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }

    public void registrarMaterial(Material m) {
        if (m == null) return;
        materiales.add(m);
    }

    public void registrarUsuario(Usuario u) {
        if (u == null) return;
        usuarios.add(u);
    }

    public void listarMateriales() {
        if (materiales.isEmpty()) {
            System.out.println("No hay materiales registrados.");
            return;
        }
        System.out.println("\n--- Materiales ---");
        for (Material m : materiales) { // polimorfismo
            System.out.println(m);
        }
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
            return;
        }
        System.out.println("\n--- Usuarios ---");
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public void listarPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("No hay préstamos.");
            return;
        }
        System.out.println("\n--- Préstamos ---");
        for (Prestamo p : prestamos) {
            System.out.println(p);
        }
    }

    public void prestar(int idUsuario, int idMaterial, int dias) {
        Usuario u = buscarUsuario(idUsuario);
        Material m = buscarMaterial(idMaterial);

        if (u == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }
        if (m == null) {
            System.out.println("Material no encontrado.");
            return;
        }
        if (!m.estaDisponible()) {
            System.out.println("El material NO está disponible (ya está prestado).");
            return;
        }
        if (dias > Reglas.DIAS_MAX_PRESTAMO) {
            System.out.println("Días exceden el máximo permitido (" + Reglas.DIAS_MAX_PRESTAMO + ").");
            return;
        }

        Prestamo p = new Prestamo(u, m, dias);
        prestamos.add(p);

        m.prestar(); // interfaz Prestable (Material implementa Prestable)

        int costoBase = m.calcularCostoBase();              // polimorfismo
        int total = calculadoraCosto.calcularTotal(costoBase, dias); // uso

        System.out.println("Préstamo creado: ID=" + p.getId());
        System.out.println("Costo base = " + costoBase + " | Total = " + total);
    }

    public void devolver(int idPrestamo) {
        Prestamo p = buscarPrestamo(idPrestamo);
        if (p == null) {
            System.out.println("Préstamo no encontrado.");
            return;
        }
        if (!p.isActivo()) {
            System.out.println("Ese préstamo ya fue cerrado.");
            return;
        }

        Material m = p.getMaterial();
        m.devolver();
        p.cerrar();

        System.out.println("Préstamo " + idPrestamo + " devuelto y cerrado.");
    }

    private Usuario buscarUsuario(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) return u;
        }
        return null;
    }

    private Material buscarMaterial(int id) {
        for (Material m : materiales) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    private Prestamo buscarPrestamo(int id) {
        for (Prestamo p : prestamos) {
            if (p.getId() == id) return p;
        }
        return null;
    }
}
