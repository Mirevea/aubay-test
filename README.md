# Card Trading App (Aubay)

Base inicial de una aplicación Android para intercambio y compra/venta de cartas coleccionables.

## Esquema Gradle propuesto

```text
:app
:core:model
:core:database
:feature:marketplace
:feature:collection
```

### Objetivo de cada módulo

- `:app`: punto de entrada Android, navegación y composición de features.
- `:core:model`: modelos de dominio compartidos (Card, Listing, TradeOffer, UserCollectionItem).
- `:core:database`: persistencia local (DAO, entidades y repositorios de almacenamiento).
- `:feature:marketplace`: casos de uso y UI para compra/venta/intercambio.
- `:feature:collection`: casos de uso y UI para colección personal.

## Catálogo de versiones

Se centraliza en `gradle/libs.versions.toml` para:
- Plugins Android/Kotlin.
- Dependencias base.
- Librerías de persistencia candidatas (Room, SQLDelight, Realm) para facilitar decisiones técnicas.

## Análisis de base de datos

Se ha incluido un análisis inicial con recomendaciones en:

- `docs/database-options.md`

Resumen: arrancar con **Room** como base local offline-first, manteniendo **SQLDelight** como opción futura si el proyecto evoluciona a KMP.
