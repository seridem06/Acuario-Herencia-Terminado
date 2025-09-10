import kotlin.math.PI
open class Acuario(
    open var largo: Int = 100,
    open var ancho: Int = 20,
    open var alto: Int = 40
) {
    // Aquí se agrega la propiedad 'forma'
    open val forma = "rectángulo"
    open var agua: Double = 0.0
        get() = volumen * 0.9


    open var volumen: Int
        get() = (largo * ancho * alto) / 1000
        set(valor) {
            alto = (valor * 1000) / (ancho * largo)
        }

    init {
        println("Inicializando acuario")
        println("Volumen: ${volumen} l")
    }

    constructor(numeroDePeces: Int) : this() {
        val volumenNecesario = numeroDePeces * 2000 * 1.1
        this.volumen = volumenNecesario.toInt()
    }

    fun imprimirTamano() {
        println(forma)
        println("Ancho: $ancho cm " +
                "Largo: $largo cm " +
                "Alto: $alto cm ")
        println("Volumen: $volumen l Agua: $agua l (${agua/volumen*100.0}% lleno)")
    }

}
class TanqueTorre (override var alto: Int, var diametro: Int): Acuario(alto = alto, ancho = diametro, largo = diametro) {
    override var volumen: Int
        // área elíptica = π * r1 * r2
        get() = (ancho/2 * largo/2 * alto / 1000 * PI).toInt()
        set(valor) {
            alto = ((valor * 1000 / PI) / (ancho/2 * largo/2)).toInt()
        }

    override var agua = volumen * 0.8
    override val forma = "cilindro"
}
