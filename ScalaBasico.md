# Scala básico

## Expresiones

En Scala todo es una expresión (cada sentencia "devuelve" un valor).

```scala
scala> 1 + 1
res0: Int = 2
```

Se puede ver el resultado de evaluar expresiones usando println.

{% scalafiddle %}
```scala
scala> println(1) // 1
1

scala> println(1 + 1) // 2
2

scala> println("Hello!") // Hello!
Hello!

scala> println("Hello," + " world!") // Hello, world!
Hello, world!
```
{% endscalafiddle %}

## Valores

Se puede nombrar el resultado de expresiones con la palabra clave *val*.

```scala
scala> val x = 1 + 1
x: Int = 2

scala> println(x) // 2
2
```

Los resultados con nombre, como x en el ejemplo, son llamados *valores*. Referenciar un valor no lo vuelve a computar.

Los valores no pueden ser reasignados.

```scala
scala> x = 3 // This does not compile.
<console>:13: error: reassignment to val
       x = 3 // This does not compile.
         ^
```

Los tipos de los valores pueden ser inferidos, pero tambien se pueden anotar explicitamente de la siguiente forma:

```scala
scala> val x: Int = 1 + 1
x: Int = 2
```

Noten como la declaración de tipo Int va después del identificador.

## Variables

Las variables son como los valores, excepto que no es posible re-asignarlos. Las variables se definen con la palabra clave *var*.

```scala
scala> var x = 1 + 1
x: Int = 2

scala> x = 3 // This compiles because "x" is declared with the "var" keyword.
x: Int = 3

scala> println(x * x) // 9
9
```

Igual que con los valores, si queremos se puede especificar el tipo:

```scala
scala> var x: Int = 1 + 1
x: Int = 2
```

## Bloques

Se pueden combinar expresiones rodeándolas con { y } . A esto le llamamos un *bloque*.

El resultado de la ultima expresión del bloque es también el resultado total del bloque.

```scala
scala> println({
     | val x = 1 + 1
     | x + 1
     | }) // 3
3
```

## Funciones

Las funciones son expresiones que reciben parámetros.

Se pueden definir funciones anónimas, por ejemplo, una que retorne x + 1 para x entero:

```scala
scala> (x: Int) => x + 1
res8: Int => Int = $$Lambda$6622/1517727433@49c490e
```

A la izquierda de => esta la lista de parámetros. A la derecha esta el cuerpo de la función

También podemos asignarle un nombre a la función.

```scala
scala> val addOne = (x: Int) => x + 1
addOne: Int => Int = $$Lambda$6623/97366012@6a5970ad

scala> println(addOne(1)) // 2
2
```

Las funciones pueden tomar muchos parámetros.

```scala
scala> val add = (x: Int, y: Int) => x + y
add: (Int, Int) => Int = $$Lambda$6629/72607529@6e2abbe2

scala> println(add(1, 2)) // 3
3
```

O ninguno.

```scala
scala> val getTheAnswer = () => 42
getTheAnswer: () => Int = $$Lambda$6630/2147344356@a6b19e0

scala> println(getTheAnswer()) // 42
42
```

## Métodos

Los métodos se parecen y se comportan de forma muy similar a las funciones, pero hay un par de diferencias clave entre ellos.
Los métodos se definen con la palabra clave *def*, seguida por un nombre, una lista de parámetros, un tipo de retorno (opcional pero recomendado), y el cuerpo del método.

```scala
scala> def add(x: Int, y: Int): Int = x + y
add: (x: Int, y: Int)Int

scala> println(add(1, 2)) // 3
3
```

Notar como el tipo de retorno es declarado después de la lista de parámetros y con dos puntos.

Los métodos pueden tener mutiles listas de parámetros.

```scala
scala> def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
addThenMultiply: (x: Int, y: Int)(multiplier: Int)Int

scala> println(addThenMultiply(1, 2)(3)) // 9
9
```

O ninguna.

```scala
scala> def name: String = System.getProperty("user.name")
name: String

scala> println("Hello, " + name + "!")
Hello, gabriel!
```

Hay otras diferencias, pero para simplificar, podemos pensar que son similares a las funciones.

Los métodos también pueden tener expresiones de varias lineas.

```scala
scala> def getSquareString(input: Double): String = {
     | val square = input * input
     | square.toString
     | }
getSquareString: (input: Double)String
```

La ultima expresión en el cuerpo del método es el valor de retorno del mismo.
(Scala tiene la palabra clave *return* pero no se usa y no hace lo que uds. piensan que hace)

## Clases

Se puede definir clases con la palabra clave *class* seguida del nombre y los parámetros del constructor.

```scala
scala> class Greeter(prefix: String, suffix: String) {
     | def greet(name: String): Unit =
     | println(prefix + name + suffix)
     | }
defined class Greeter
```

El tipo de retorno del método greet es Unit, que dice que no hay nada significativo que retornar. Se usa de forma similar al void de Java y C (con la diferencia de que como toda expresión en Scala debe retornar un valor, existe un valor singleton para el tipo Unit que se escribe `()` y no lleva información )

Puedes crear una instancia de una clase con la palabra clave *new*.

```scala
scala> val greeter = new Greeter("Hello, ", "!")
greeter: Greeter = Greeter@7d7ed5e0

scala> greeter.greet("Scala developer") // Hello, Scala developer!
Hello, Scala developer!
```

## Case Classes

Scala tiene un tipo especial de clases llamadas "case" classes. Por defecto, las case classes son inmutables y son comparadas por valor.
Las case classes se definen usando las palabras clave *case class*.

```scala
scala> case class Point(x: Int, y: Int)
defined class Point
```

Se pueden instanciar sin necesidad de usar la palabra clave new.

```scala
scala> val point = Point(1, 2)
point: Point = Point(1,2)

scala> val anotherPoint = Point(1, 2)
anotherPoint: Point = Point(1,2)

scala> val yetAnotherPoint = Point(2, 2)
yetAnotherPoint: Point = Point(2,2)
```

Y son comparadas por valor.

```scala
scala> if (point == anotherPoint) {
     | println(point + " and " + anotherPoint + " are the same.")
     | } else {
     | println(point + " and " + anotherPoint + " are different.")
     | } // Point(1,2) and Point(1,2) are the same.
Point(1,2) and Point(1,2) are the same.

scala> if (point == yetAnotherPoint) {
     | println(point + " and " + yetAnotherPoint + " are the same.")
     | } else {
     | println(point + " and " + yetAnotherPoint + " are different.")
     | } // Point(1,2) and Point(2,2) are different.
Point(1,2) and Point(2,2) are different.
```

Hay mucho mas sobre las case classes que queremos presentar, y estamos convencidos de que te vas a enamorar de ellas.

## Objetos

Los objetos son instancias de una sola clase de su propia definición. Puedes pensar en ellos como singleton de sus propias clases

Puedes definir objectos con la palabra clave *object*.

```scala
scala> object IdFactory {
     | private var counter = 0
     | def create(): Int = {
     | counter += 1
     | counter
     | }
     | }
defined object IdFactory
```

Para acceder al objeto, lo referencias por su nombre.

```scala
scala> val newId: Int = IdFactory.create()
newId: Int = 1

scala> println(newId) // 1
1

scala> val newerId: Int = IdFactory.create()
newerId: Int = 2

scala> println(newerId) // 2
2
```

## Traits

Los traits son tipos que contienen campos y métodos. Se pueden combinar múltiples traits.

Los traits se definen con la palabra clave *trait*.

```scala
scala> trait Greeter {
     | def greet(name: String): Unit
     | }
defined trait Greeter
```

Los traits pueden también tener implementación por defecto.

```scala
scala> trait Greeter {
     | def greet(name: String): Unit =
     | println("Hello, " + name + "!")
     | }
defined trait Greeter
```

También puedes extender traits con la palabra clave *extends* y sobrescribir una implementación con la palabra clave *override* .

```scala
scala> class DefaultGreeter extends Greeter
defined class DefaultGreeter

scala> class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
     | override def greet(name: String): Unit = {
     | println(prefix + name + postfix)
     | }
     | }
defined class CustomizableGreeter

scala> val greeter = new DefaultGreeter()
greeter: DefaultGreeter = DefaultGreeter@2cf2ae9f

scala> greeter.greet("Scala developer") // Hello, Scala developer!
Hello, Scala developer!

scala> val customGreeter = new CustomizableGreeter("How are you, ", "?")
customGreeter: CustomizableGreeter = CustomizableGreeter@139fbe

scala> customGreeter.greet("Scala developer") // How are you, Scala developer?
How are you, Scala developer?
```

Aquí, DefaultGreeter extiende un solo trait, pero puede extender múltiples traits.

## Metodo principal (Main Method)

El metodo principal (main) es el punto de entrada de un programa. La maquina virtual de java (JVM) requiere que el método principal sea llamado `main` y que tome un solo argumento: un arrray de Strings.

Usando un objeto, puedes definir el método principal de la siguiente forma:

```scala
scala> object Main {
     | def main(args: Array[String]): Unit =
     | println("Hello, Scala developer!")
     | }
defined object Main
```
