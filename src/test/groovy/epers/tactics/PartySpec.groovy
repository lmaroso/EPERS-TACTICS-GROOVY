package epers.tactics

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class PartySpec extends Specification implements DomainUnitTest<Party> {

    void setup() {
        new Party(nombre: 'Samid Party', cantidadDeAventureros: 2).save()
        new Party(nombre: 'Viale Party', cantidadDeAventureros: 5).save()
    }

    void "Creo una party y verifico que se haya persistido"() {
        setup:
        new Party(nombre: 'Viale Party', cantidadDeAventureros: 5).save()

        expect:
        Party.count() == 3
    }

    void "Recupero una party y verifico que su nombre sea correcto"() {
        expect:
        Party.get(1).nombre == "Samid Party"
    }

    void "Recupero una party utilizando la función findByNombre"() {
        expect:
        Party.findByNombre("Samid Party").nombre == "Samid Party"
    }

    void "asd"() {
        expect:
        Party.findByCantidadDeAventureros(2).cantidadDeAventureros == 2
    }

    void "papaia"() {
        def party = Party.get(1)
        party.nombre = "Viale Party"
        party.save()

        expect:
        Party.get(1).nombre == "Viale Party"
    }

    void "banana"() {
        def party = Party.get(1)
        party.delete()

        // expect:
        assertNull Party.get(1)
	}

    void "test de id"() {
        expect:
        Party.findById(1).nombre == "Samid Party" && Party.findById(2).nombre == "Viale Party"
	}
}
