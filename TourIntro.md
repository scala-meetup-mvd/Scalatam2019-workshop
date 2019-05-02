# Un tour por Scala

## Introduccion

Scala es un lenguaje de programación moderno multi-paradigma diseñado para expresar patrones de programación comunes de una forma concisa, elegante, y de tipado seguro. Integra fácilmente características de lenguajes orientados a objetos y funcionales.

## Scala es orientado a objetos

Scala es un lenguaje puramente orientado a objetos en el sentido de que todo es un objeto. Los tipos y comportamientos de objetos son descritos por clases y traits (que podría ser traducido como un “rasgo”). Las clases pueden ser extendidas a través de subclases y un mecanismo flexible de composición mezclada que provee un claro remplazo a la herencia múltiple.

## Scala es funcional

Scala es también un lenguaje funcional en el sentido que toda función es un valor. Scala provee una sintaxis ligera para definir funciones anónimas. Soporta funciones de primer orden, permite que las funciones sean anidadas, y soporta currying. Las clases caso de Scala y las construcciones incorporadas al lenguaje para reconocimiento de patrones modelan tipos algebráicos usados en muchos lenguajes de programación funcionales.

Además, la noción de reconocimiento de patrones de Scala se puede extender naturalmente al procesamiento de datos XML con la ayuda de patrones de expresiones regulares. En este contexto, seq comprehensions resultan útiles para formular consultas. Estas características hacen a Scala ideal para desarrollar aplicaciones como Web Services.
Scala estáticamente tipado

Scala cuenta con un expresivo sistema de tipado que fuerza estáticamente las abstracciones a ser usadas en una manera coherente y segura. En particular, el sistema de tipado soporta:

    Clases genéricas
    anotaciones variables,
    límites de tipado superiores e inferiores,
    clases internas y tipos abstractos como miembros de objetos,
    tipos compuestos
    auto-referencias explicitamente tipadas
    implicit conversions
    métodos polimórficos

El mecanismo de inferencia de tipos locales se encarga de que el usuario no tengan que anotar el programa con información redundante de tipado. Combinadas, estas características proveen una base poderosa para el reuso seguro de abstracciones de programación y para la extensión segura (en cuanto a tipos) de software.

## Scala es extensible

En la práctica el desarrollo de aplicaciones específicas para un dominio generalmente requiere de “Lenguajes de dominio específico” (DSL). Scala provee una única combinación de mecanismos del lenguaje que simplifican la creación de construcciones propias del lenguaje en forma de librerías:

    cualquier método puede ser usado como un operador de infijo o postfijo
    las closures son construidas automáticamente dependiendo del tipo esperado (tipos objetivo).

El uso conjunto de ambas características facilita la definición de nuevas sentencias sin tener que extender la sintaxis y sin usar facciones de meta-programación como tipo macros.

Scala está diseñado para interoperar bien con el popular Entorno de ejecución de Java 2 (JRE). En particular, la interacción con el lenguaje orientado a objetos Java es muy sencillo. Scala tiene el mismo esquema de compilación (compilación separada, carga de clases dinámica) que java y permite acceder a las miles de librerías de gran calidad existentes.
