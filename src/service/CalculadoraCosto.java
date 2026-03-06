package service;

/**
 * Clase de servicio usada (dependency/uso) por Biblioteca.
 */
public class CalculadoraCosto {

    public int calcularTotal(int costoBase, int dias) {
        int costoTotal = 0;
        if (dias > Reglas.DIAS_GRATIS) {
            int diasConCosto = dias - Reglas.DIAS_GRATIS;
            costoTotal = diasConCosto * costoBase;
        }
        return costoTotal;
    }
}
