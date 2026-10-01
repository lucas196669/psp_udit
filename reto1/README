# Reto 1 · Monitor del catálogo de UDITflix

**Módulo:** 0490 · Programación de Servicios y Procesos
**Autor/a:** Lucas
**Reto:** ☒ Reto A (vídeos) · ☐ Reto B (contenidos)
**Tecnología:** Java + ProcessBuilder (procesos del sistema operativo)
**RA vinculado:** RA1 · Programación de aplicaciones compuestas por varios procesos

---

## 📺 Qué es esta app

Un programa de consola que simula el monitor interno de UDITflix: comprueba si cada elemento del catálogo (vídeos) está **ACTIVO** o **CAÍDO**. Para cada uno lanza un proceso externo (`ping`), muestra su PID, lee lo que responde y espera a que termine.




---

## 🧠 Antes de empezar: planifico

planifique el reto en 3 o 4 pasos que fueron crear la variable luego el catalogo y despues el catch
---

## 🎯 Objetivo del reto

Partir de lo aprendido en la píldora (lanzar un proceso) y dar el salto a gestionar varios procesos con una estructura de datos y un bucle, aplicando: creación de procesos con `ProcessBuilder`, identificación por PID, lectura de su salida, espera con `waitFor()` e interpretación de su resultado.

---

## 🛠️ Componentes y conceptos utilizados

| Componente / concepto | Para qué se usa en esta app | Con mis palabras |
|---|---|---|
| `ProcessBuilder` | Prepara la orden (`ping ...`) que se enviará al sistema operativo | Es el que construye el comando con sus opciones, pero todavía no lo ejecuta. |
| `start()` | Lanza de verdad el proceso; devuelve un `Process` sin esperarle | Es el botón de enviar: crea el proceso nuevo y mi programa sigue sin esperar a que acabe. |
| `Process` | Objeto con el que controlo el proceso que ya está en marcha | Es el mando del proceso ya lanzado: de aquí saco el PID, su salida y su código de salida. |
| `pid()` | Número que identifica al proceso en el sistema operativo | El "DNI" del proceso; el sistema operativo asigna uno distinto en cada ejecución. |
| `getInputStream()` | Canal por el que recibo lo que escribe el proceso | La tubería por la que me llega el texto que el `ping` escribiría en pantalla. |
| `BufferedReader` + `readLine()` | Leer esa salida línea a línea | Convierte esa tubería en texto que puedo leer línea a línea hasta que no queda nada (`null`). |
| `waitFor()` | Bloquea mi programa hasta que el proceso termina y devuelve su código de salida | Me hace esperar al `ping` y me dice cómo acabó: 0 = bien, distinto de 0 = fallo. |
| Matriz `String[][]` | Guarda, para cada elemento, su nombre y su dirección de comprobación | Una tabla donde cada fila es un vídeo y cada columna un dato de ese vídeo. |
| Bucle `for` | Repite el mismo proceso de comprobación para cada fila de la matriz | Recorre el catálogo fila a fila haciendo siempre los mismos pasos con datos distintos. |

**¿Qué contiene cada posición de mi matriz?**

- `matriz[i][0]` → el **nombre** del vídeo (por ejemplo, `"Animación 3D"`).
- `matriz[i][1]` → la **dirección** que se comprueba con `ping` (por ejemplo, `"127.0.0.1"` o `"kotlin.noexiste"`).

---

## 🚀 Cómo ejecutar el proyecto

1. Clonar o abrir el proyecto en IntelliJ IDEA.
2. Esperar a que indexe el proyecto.
3. Ejecutar (▶) la clase principal `MonitorCatalogo`.

⚠️ El comando `ping` usa `-n` en Windows y `-c` en Linux/Mac para el número de intentos. **Probado en: Windows** (el código usa `-n 1 -w 1000`). En Linux/Mac habría que cambiar `-n` por `-c`.

### Salida esperada

```
== UDITFLIX CATÁLOGO ==
Comprobando servicio
[VÍDEO] Animación 3D
PID: <número>
ESTADO: CAÍDO
[VÍDEO] Videojuegos
PID: <número>
ESTADO: CAÍDO
[VÍDEO] Kotlin
PID: <número>
ESTADO: CAÍDO
[VÍDEO] Android
PID: <número>
ESTADO: ACTIVO
[VÍDEO] Flutter
PID: <número>
ESTADO: ACTIVO
COMPROBACIÓN FINALIZADA
```

---

## 🔍 Mientras programo: mi diario de decisiones

| Qué intentaba | Qué pasó realmente | Qué hice / qué aprendí |
|---|---|---|
aprender. que acabe aprendiendo. dar mi maximo.a como programar en java

**Mi pregunta-brújula cuando me bloqueo:**

1. ¿Qué espero que haga esta línea?
2. ¿Qué está haciendo realmente? (imprimo valores para comprobarlo)
3. ¿En qué punto exacto se separan las dos respuestas?

---

## 🧭 De la píldora al reto: cómo di el salto

La píldora lanzaba un proceso. El reto lanza cinco.

- **¿Qué tenía la píldora que ya no me sirve tal cual?** Que la dirección y el nombre estaban escritos directamente en el código para un único proceso. Ahora la dirección tiene que salir de cada fila del catálogo.
- **¿Qué he tenido que añadir para repetirlo cinco veces?** Una matriz `String[][]` con los datos de cada vídeo y un bucle `for` que la recorre. La matriz guarda los datos y el bucle repite los pasos.
- **¿Qué parte del código es igual en todas las vueltas y qué parte cambia?** Es igual la secuencia: crear el `ProcessBuilder`, `start()`, mostrar el PID, leer la salida, `waitFor()` e interpretar el código. Cambian el nombre y la dirección (`catalogo[i][0]` y `catalogo[i][1]`) y, por tanto, el PID y el resultado.
- **Si mañana UDITflix tuviera 500 elementos en lugar de 5:** el bucle no cambia, solo habría que añadir las filas a la matriz (o cargarlas desde un fichero). Aun así, comprobarlos uno a uno tardaría mucho porque cada `ping` espera a que el anterior termine.

---

## 🧠 Qué he aprendido



- **Hilo vs. proceso:** la diferencia entre ambos es...
- **PID:** lo que representa y por qué cambia en cada ejecución es...
- **`start()` vs. `waitFor()`:** lanzar un proceso y esperarle son cosas distintas porque...
- **Código de salida:** lo que significa que sea 0 o distinto de 0 es...
- **Lo que mi programa decide sobre ACTIVO / CAÍDO se basa en...** (¿es fiable? ¿en qué casos podría equivocarse?)

---

## 🐞 Dificultades y cómo las resolví

**Dificultad 1:**

- Qué síntoma vi: no sabia muy bien como empezar
- Cuál era la causa real: me bloquee
- Cómo la encontré:centrandome
- Cómo evitaré que me vuelva a pasar:intentar no bloquearme

**Dificultad 2:** (opcional)

---

## 🪞 Autoevaluación

| Puedo explicar a un compañero... | 🔴 No | 🟡 Más o menos | 🟢 Sí |
|---|:-:|:-:|:-:|
| Qué hace `ProcessBuilder` | ☐ | ☐ | ☐ |
| Qué hace `start()` y por qué no espera | ☐ | ☐ | ☐ |
| Qué representa el PID | ☐ | ☐ | ☐ |
| Para qué sirve `getInputStream()` | ☐ | ☐ | ☐ |
| Qué hace `waitFor()` y qué devuelve | ☐ | ☐ | ☐ |
| Qué hay en cada posición de la matriz | ☐ | ☐ | ☐ |
| Qué hace el `for` en mi programa | ☐ | ☐ | ☐ |

- **Mi predicción del principio, ¿acerté?** si porque mas o menos sabia como acababa
- **Lo que haría diferente si empezara de nuevo:** ordenaria distinto el codigo
- **Lo que todavía no tengo claro y quiero preguntar en clase:** alguno de los codigos lo que hace

---

## 📂 Estructura del proyecto

```
src/main/java/org/example/   → MonitorCatalogo.java (clase con el main, el monitor de UDITflix)
README.md                    → este documento
```

## 🔗 Enlace

- GitHub: https://github.com/lucas196669/psp_udit/reto1
