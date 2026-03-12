package model;

import service.IdGenerator;

/**
 * Encapsulamiento: atributos private con getters/setters.
 */
public class Usuario {
    private final String id;
    private String nombre;

    public Usuario(String nombre) {
        this.id = IdGenerator.nextId('U');
        this.nombre = nombre;
    }

    public String getId() { return id; }
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
