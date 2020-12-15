package epers.tactics

class Party {

    Long id
    String nombre
    Integer cantidadDeAventureros

    static mapping = {
    id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator', 
        params: [sequence_name: 'start_seq', initial_value: 1])
     version false
    }

    static constraints = {
        nombre size: 5..40, blank: false
    }

    static hasMany = [aventureros: Aventurero]

    String toString() {
        nombre
    }
}
