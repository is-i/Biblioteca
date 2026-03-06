package model;

import service.Reglas;

/**
 * HERENCIA: Libro extiende Material
 */
public class Libro extends Material {
    private String autor;
    private int paginas;

    public Libro(String titulo, String autor, int paginas) {
        super(titulo);
        this.autor = autor;
        this.paginas = paginas;
    }

    @Override
    public String getTipo() { return "Libro"; }

    @Override
    public int calcularCostoBase() {
        return Reglas.COSTO_DIA_LIBRO;
    }

    @Override
    public String toString() {
        return super.toString() + " (Autor=" + autor + ", Páginas=" + paginas + ")";
    }
}
