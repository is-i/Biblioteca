# Biblioteca (Mini-Proyecto POO en Java)

## Laboratorio 06 — Entrega modelo
Proyecto sencillo por consola en **Java** con **POO** y organizado en paquetes.

### Estructura
```
Biblioteca/
  README.md
  docs/
    UML.png
  src/
    model/
    service/
    ui/
```

### Compilación y ejecución
Ubíquese en la carpeta `src` y ejecute:

```bash
javac ui/Main.java
java ui.Main
```

---

## Pruebas manuales (5)

> Nota: Los IDs se generan automáticamente. Primero use **Listar usuarios** y **Listar materiales** para ver IDs reales.

### Prueba 1 — Listar materiales
1) En el menú, elija `1`.
**Resultado esperado:** se listan Libro y Revista con `Disponible=true`.

### Prueba 2 — Prestar un material disponible
1) Elija `2` para ver IDs de usuarios.
2) Elija `1` para ver IDs de materiales.
3) Elija `3` e ingrese:
   - ID Usuario (por ejemplo el de “Ana”)
   - ID Material (por ejemplo el de “Cálculo I”)
   - Días = `5`
**Resultado esperado:** “Préstamo creado…” y el material queda `Disponible=false`.

### Prueba 3 — Intentar prestar un material ya prestado
1) Repita la opción `3` con el mismo ID de material ya prestado.
**Resultado esperado:** mensaje “El material NO está disponible (ya está prestado).”

### Prueba 4 — Devolver un préstamo
1) Elija `5` para ver el ID del préstamo activo.
2) Elija `4` y escriba ese ID.
**Resultado esperado:** “devuelto y cerrado” y el material vuelve a `Disponible=true`.

### Prueba 5 — Validación por días máximos
1) Elija `3` (prestar)
2) Ingrese un número de días mayor a 15 (por ejemplo 20).
**Resultado esperado:** “Días exceden el máximo permitido (15).”

---

## Evidencias por requisito

### 1) Relaciones entre clases
- **Uso (dependency):** `service.Biblioteca` usa `service.CalculadoraCosto`
  - `private final CalculadoraCosto calculadora = new CalculadoraCosto();`
  - `calculadora.calcularTotal(...)`

- **Asociación:** `model.Prestamo` se asocia a `model.Usuario` y `model.Material`
  - `private final Usuario usuario;`
  - `private final Material material;`

- **Agregación:** `service.Biblioteca` agrega listas (ArrayList) de `Material`, `Usuario`, `Prestamo`
  - `private final ArrayList<Material> materiales = new ArrayList<>();` etc.

- **Composición:** `model.Prestamo` compone `DetallePrestamo`
  - `private final DetallePrestamo detalle;`
  - `detalle = new DetallePrestamo(dias);`
  - `DetallePrestamo` es clase interna (existe solo dentro del préstamo).

### 2) Visibilidad, alcance, control de acceso
- Encapsulamiento con `private` (ej.: `titulo`, `nombre`).
- `protected` para atributo compartido por subclases: `Material.disponible`.
- `default` (package-private) en `Revista.edicion`.

### 3) Herencia
- `Libro extends Material`
- `Revista extends Material`

### 4) Polimorfismo
- Lista `ArrayList<Material>` contiene objetos `Libro` y `Revista`.
- Se invocan métodos sobrescritos: `calcularCostoBase(dias)` y `getTipo()`.

### 5) Clases abstractas
- `Material` es `abstract` y define métodos abstractos.

### 6) Interfaces
- `Prestable` (métodos `prestar`, `devolver`, `estaDisponible`)
- `Material implements Prestable`

### 7) Modificador static
- `service.IdGenerator.nextId()` (static)
- `service.Reglas` con `public static final ...`

---

## Diagrama UML
El diagrama UML correspondiente al código está en:
- `docs/UML.png`
