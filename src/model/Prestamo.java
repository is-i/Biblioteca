package model;

import service.IdGenerator;

/**
 * ASOCIACIÓN:
 * - Prestamo se asocia a Usuario y Material (referencias).
 *
 * COMPOSICIÓN:
 * - Prestamo "posee" DetallePrestamo: se crea dentro y no tiene sentido sin Prestamo.
 */
public class Prestamo {
    private final String id;
    private final Usuario usuario;   // Asociación
    private final Material material; // Asociación
    private boolean activo;

    private final DetallePrestamo detalle; // Composición

    public Prestamo(Usuario usuario, Material material, int dias) {
        this.id = IdGenerator.nextId('P');
        this.usuario = usuario;
        this.material = material;
        this.activo = true;
        this.detalle = new DetallePrestamo(dias); // se crea adentro => composición
    }

    public String getId() { return id; }
    public boolean isActivo() { return activo; }
    public Usuario getUsuario() { return usuario; }
    public Material getMaterial() { return material; }
    public int getDias() { return detalle.getDias(); }

    public void cerrar() { this.activo = false; }

    @Override
    public String toString() {
        return "Préstamo ID=" + id +
               " | Usuario=" + usuario.getNombre() +
               " | Material=" + material.getTitulo() +
               " | Días=" + detalle.getDias() +
               " | Activo=" + activo;
    }

    // Clase interna: DetallePrestamo existe solo si existe Prestamo
    private static class DetallePrestamo {
        private final int dias;

        DetallePrestamo(int dias) {
            if (dias <= 0) dias = 1;
            this.dias = dias;
        }

        int getDias() { return dias; }
    }
}
