# Opciones de base de datos para la app de card trading

## Requisitos funcionales del dominio

- Catálogo local de cartas con filtros rápidos (juego, rareza, estado, precio).
- Inventario del usuario (colección personal, cantidad, estado de cada carta).
- Operaciones de mercado: anuncios de venta/intercambio, favoritos, historial de transacciones.
- Soporte offline-first para poder consultar y editar sin conexión.
- Sincronización posterior con backend cuando vuelva la conectividad.

## Opciones evaluadas

### 1) Room (SQLite + Jetpack)

**Ventajas**
- Integración nativa Android con corrutinas, Flow y arquitectura Jetpack.
- Esquema fuertemente tipado con entidades, DAO y migraciones versionadas.
- Ideal para queries complejas sobre filtros de cartas y búsquedas locales.

**Riesgos / trade-offs**
- Mayor trabajo inicial de modelado y migraciones.
- Si se quiere compartir la capa de datos con iOS/KMP, no es la opción más portable.

**Cuándo elegirla**
- Si el foco inicial es Android nativo y se prioriza estabilidad, tooling y mantenibilidad.

### 2) SQLDelight

**Ventajas**
- SQL explícito y validado en compilación.
- Excelente opción si se planea Kotlin Multiplatform a futuro.
- Buen control de performance para pantallas con filtros avanzados.

**Riesgos / trade-offs**
- Curva de aprendizaje mayor para el equipo si no trabaja SQL-first.
- Menor integración "out of the box" con componentes Android frente a Room.

**Cuándo elegirla**
- Si el roadmap contempla compartir la capa de persistencia entre Android/iOS.

### 3) Realm Kotlin

**Ventajas**
- API orientada a objetos y simple para prototipos rápidos.
- Buen rendimiento para colecciones locales y sincronización en escenarios concretos.

**Riesgos / trade-offs**
- Menor estandarización en ecosistema Android que SQLite/Room.
- Dependencia mayor del proveedor y menos interoperabilidad con SQL tradicional.

**Cuándo elegirla**
- Si el equipo prioriza rapidez de desarrollo en un modelo puramente objeto.

## Recomendación inicial

Para esta primera fase del proyecto, **Room** es la opción recomendada:

1. Encaja con una arquitectura Android modular y offline-first.
2. Simplifica testing y mantenimiento para un equipo Android estándar.
3. Permite evolucionar a sincronización con backend sin rehacer el modelo local.

Se deja **SQLDelight** documentado como alternativa estratégica si más adelante se decide migrar a Kotlin Multiplatform.
