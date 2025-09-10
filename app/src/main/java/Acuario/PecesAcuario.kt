package acuario

interface AccionPez {
    fun comer()
}

abstract class Pez {
    abstract var color: String
}

class Tiburon : Pez(), AccionPez {
    override var color = "gris"
    override fun comer() {
        println("cazar y comer peces")
    }
}

class PezPayaso : Pez(), AccionPez {
    override var color = "dorado"
    override fun comer() {
        println("comer algas")
    }
}