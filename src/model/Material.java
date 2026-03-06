package model;

import service.IdGenerator;

/**
 * CLASE ABSTRACTA:
 * - Define comportamiento común de los materiales.
 * - Implementa la interfaz Prestable.
 */
public abstract class Material implements Prestable {
    private final int id;
    private String titulo;

    // protected: visible en subclases (evidencia de visibilidad)
    protected boolean disponible = true;

    protected Material(String titulo) {
        this.id = IdGenerator.nextId(); // static: generador de IDs
        this.titulo = titulo;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) return;
        this.titulo = titulo;
    }

    public abstract String getTipo();

    // Polimorfismo: cada subclase define su costo base
    public abstract int calcularCostoBase();

    @Override
    public void prestar() { disponible = false; }

    @Override
    public void devolver() { disponible = true; }

    @Override
    public boolean estaDisponible() { return disponible; }

    @Override
    public String toString() {
        return "[" + getTipo() + "] ID=" + id + ", Título='" + titulo + "', Disponible=" + disponible;
    }
}
