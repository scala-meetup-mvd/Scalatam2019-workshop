# Colecciones

Scala posee una rica libreria de colecciones que se dividen en dos grandes grupos: inmutables y mutables.
Las colecciones *mutables* pueden ser modificadas o extendidas "en el lugar", lo que significa que cambiar, agregar, o remover elementos de la coleccion es un efecto secundario.
Las colecciones *inmutables* en cambio, nunca cambian: las opeaciones de agregar, remover, o modificar elementos devuelven una nueva coleccion, dejando la original intacta.

En general, las colecciones de Scala tienen una version mutable y una inmutable. Por ejemplo: 
 Seq (indexadas o lineales), Set, Map

## Colecciones mutables

Algunas de las colecciones mutables que tiene Scala son:
HashMap, TreeMap, Stack, LinkedList, Queue, Array, ArrayBuffer, HashSet

## Colecciones inmutables

Algunas de las colecciones inmutables que tiene Scala son:
HashSet, HashMap, Vector, String, Range, List, Stream

## Un vistazo al API de colecciones

La mayoria de las colecciones tienen bastante comportamiento en comun. Por ejemplo, se pueden crear con una sintaxis uniforme, escribiendo el nombre de la clase de la coleccion seguida de sus elementos:

```tut
    Traversable(1, 2, 3)
    Iterable("x", "y", "z")
    Map("x" -> 24, "y" -> 25, "z" -> 26)
    Set(Color.red, Color.green, Color.blue)
    SortedSet("hello", "world")
    Buffer(x, y, z)
    IndexedSeq(1.0, 2.0)
    LinearSeq(a, b, c)
```

El mismo principio se aplica para implementaciones especificas:

```tut
    List(1, 2, 3)
    HashMap("x" -> 24, "y" -> 25, "z" -> 26)
```

All collections support the API provided by `Traversable`, but specialize types wherever this makes sense. For instance the `map` method in class `Traversable` returns another `Traversable` as its result. But this result type is overridden in subclasses. For instance, calling `map` on a `List` yields again a `List`, calling it on a `Set` yields again a `Set` and so on.

Todas las colecciones soportan el API de `Traversable`, pero especializan los tipos cuando tiene sentido.
Por ejemplo, el metodo `map` de la clase `Traversable` devuelve otro `Traversable` como resultado, pero esto es sobreescrito en las subclases, entonces hacer `map` en una `List` devuelve `List` y en un `Set` devuelve un `Set`.

```tut
    scala> List(1, 2, 3) map (_ + 1)
    res0: List[Int] = List(2, 3, 4)
    scala> Set(1, 2, 3) map (_ * 2)
    res0: Set[Int] = Set(2, 4, 6)
```

La mayoria de las clases en la jerarquia de colecciones existen en tres variantes: base, mutable, e inmutable. (Excepto `Buffer` que solo existe como mutable)

## Operaciones sobre colecciones

https://docs.scala-lang.org/overviews/collections/trait-traversable.html

El trait `Traversable` define varias opeaciones cobre colleciones, entre las mas interesantes estan:

### Map

    map
    flatMap

### Seleccion de sub colecciones

    filter
    take
    takeWhile
    slice

### Generacion de sub colecciones

    groupBy
    splitAt
    partition

### Folds

    fold
    foldRight
    foldLeft

### Folds especificos

    sum
    product
    min
    max



```tut
  List("En", "un", "lugar", "de", "la", "mancha")
  .filter( word => word.length > 3)
  .map( word => word.toUpperCase)
  ```