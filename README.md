# Borrador del Proyecto: KidQuest - Hábitos y Recompensas

## 1. Descripción del proyecto
**KidQuest** es una aplicación móvil nativa diseñada para la formación de hábitos en niños de 3 a 10 años mediante una estructura de "misiones y recompensas". El sistema permite a los padres asignar tareas y supervisar su cumplimiento, mientras que los niños ganan incentivos digitales (insignias y monedas) que pueden canjear por personalización de su avatar y tiempo de acceso a una zona de minijuegos educativos controlada por el adulto.

## 2. Exposición del problema
La gestión de las rutinas diarias en niños pequeños suele generar conflictos y falta de motivación. Los métodos tradicionales carecen de un ciclo de retroalimentación inmediata y segura. Según la teoría del condicionamiento operante, el refuerzo positivo es más efectivo cuando es validado por una figura de autoridad (Skinner, 1953). KidQuest resuelve esto digitalizando el proceso y asegurando que cada recompensa esté precedida por una verificación parental, promoviendo la honestidad y la disciplina de una manera lúdica.

## 3. Plataforma
El proyecto será desarrollado de forma nativa para **Android** utilizando **Kotlin** y **Android Studio**. Esta elección técnica permite aprovechar las APIs de notificaciones en tiempo real y el motor de persistencia de datos (Room/Firebase), garantizando que la comunicación entre la consola del padre y la interfaz del niño sea instantánea y robusta.

## 4. Interfaz de usuario e interfaz de administrador
La aplicación implementa una arquitectura de dos perfiles sincronizados:

* **Interfaz de Administrador (Padres):** Consola de gestión donde el padre crea tareas, asigna el valor de la recompensa y, fundamentalmente, actúa como **validador**. Recibe alertas de "Tarea Realizada" y debe confirmar con una foto o simple verificación para liberar los premios. Además, gestiona el cronómetro de la zona de juegos.
* **Interfaz de Usuario (Niño):** Un entorno inmersivo y visual (apto para no lectores de 3 a 5 años mediante iconos y audio). El niño visualiza su progreso, reclama sus insignias de honor al ser aprobadas y gasta sus monedas en la tienda o en el arcade.

## 5. Funcionalidad (Ciclo de Operación)
1.  **Asignación:** El padre define una tarea (ej. "Recoger juguetes") y le asigna una recompensa (ej. 10 monedas + Insignia de Orden).
2.  **Ejecución:** El niño marca la tarea como realizada en su perfil.
3.  **Verificación:** La tarea entra en estado "En Revisión". El padre recibe una notificación en su consola y confirma el cumplimiento.
4.  **Recompensa:** Tras la confirmación, el niño recibe automáticamente la **insignia** en su vitrina y las **monedas** en su monedero virtual.
5.  **Canje y Juego:** El niño usa sus monedas para entrar al minijuego educativo. El padre pre-configura desde su consola cuánto tiempo de juego otorga cada canje (ej. 10 monedas = 5 minutos de juego).

## 6. Diseño (Wireframes conceptuales)
* **Pantalla de Inicio:** Selector de perfil con avatares animados.
* **Dashboard Padre:** Lista de tareas pendientes de aprobación con botones de "Confirmar" o "Rechazar".
* **Home Niño:** Visualización del Avatar y lista de misiones diarias con iconos gigantes.
* **Zona Arcade:** Minijuego educativo con un cronómetro de cuenta regresiva visible en la parte superior, que bloquea el juego al agotarse el tiempo otorgado por el padre.

---
### Referencias (Formato APA)

* Android Developers. (2023). *Guía de arquitectura de aplicaciones*. Recuperado de https://developer.android.com/topic/architecture?hl=es-419
* Deterding, S., Dixon, D., Khaled, R., & Nacke, L. (2011). From game design elements to gamefulness: defining gamification. *Proceedings of the 15th International Academic MindTrek Conference*, 9-15.
* Skinner, B. F. (1953). *Science and human behavior*. Simon and Schuster.
