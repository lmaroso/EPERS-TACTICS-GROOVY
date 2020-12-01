package epers.tactics

class Party {

    Long id
    String nombre
    Integer cantidadDeAventureros

    static constraints = {
        nombre size: 5..40, blank: false
    }

    String toString() {
        nombre
    }
}
