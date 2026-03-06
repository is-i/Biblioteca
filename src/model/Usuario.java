package model;

import service.IdGenerator;

/**
 * Encapsulamiento: atributos private con getters/setters.
 */
public class Usuario {
    private final int id;
    private String nombre;

    public Usuario(String nombre) {
        this.id = IdGenerator.nextId();
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) return;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario ID=" + id + ", Nombre='" + nombre + "'";
    }
}
