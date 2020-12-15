package epers.tactics

class Aventurero {

    Long id
    String nombre

    static mapping = {
    id(generator: 'org.hibernate.id.enhanced.SequenceStyleGenerator', 
        params: [sequence_name: 'start_seq', initial_value: 1])
    version false
    }

    static constraints = {
        nombre size: 3..40, blank: false
    }

    static belongsTo= [party: Party]

    String toString() {
        nombre
    }
}
