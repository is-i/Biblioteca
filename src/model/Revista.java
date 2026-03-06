package model;

import service.Reglas;

/**
 * HERENCIA: Revista extiende Material
 * Visibilidad default/package-private: 'edicion' no tiene modificador.
 */
public class Revista extends Material {
    int edicion; // default (package-private)

    public Revista(String titulo, int edicion) {
        super(titulo);
        this.edicion = edicion;
    }

    @Override
    public String getTipo() { return "Revista"; }

    @Override
    public int calcularCostoBase() {
        return Reglas.COSTO_DIA_REVISTA;
    }

    @Override
    public String toString() {
        return super.toString() + " (Edición=" + edicion + ")";
    }
}
