package epers.tactics

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AventureroSpec extends Specification implements DomainUnitTest<Aventurero> {

    void setup() {
        def samidParty = new Party(nombre: "Samid Party", cantidadDeAventureros: 1).save()
        new Aventurero(nombre: 'Pepe', party: samidParty).save()
    }

    void "Creo un Aventurero y verifico que se haya persistido"() {
        expect:
        Aventurero.count() == 1
    }

    /* void "Recupero una party y verifico que su nombre sea correcto"() {
        expect:
        Aventurero.get(1).nombre == "Samid"
    }

    void "Recupero una party utilizando la función findByNombre"() {
        expect:
        Aventurero.findByNombre("Samid").nombre == "Samid"
    }

    void "papaia"() {
        def party = Aventurero.get(1)
        Aventurero.nombre = "Viale"
        Aventurero.save()

        expect:
        Aventurero.get(1).nombre == "Viale"
    }

    void "banana"() {
        def party = Aventurero.get(1)
        Aventurero.delete()

        // expect:
        assertNull Aventurero.get(1)
	}

    void "test de id"() {
        expect:
        Aventurero.findById(1).nombre == "Samid" && Aventurero.findById(2).nombre == "Viale"
	}*/
}
