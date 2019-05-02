package scalatam
import scala.io.Source

object Analizador {

    def main(args: Array[String]): Unit = {
        val lineas = Source.fromFile("el-quijote.txt").getLines.toList
        analizar(lineas)
    }

    def analizar( lineas: Seq[String] ): Unit = {
        ???
    }

}