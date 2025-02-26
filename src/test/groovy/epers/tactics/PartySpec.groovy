package epers.tactics

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class PartySpec extends Specification implements DomainUnitTest<Party> {

    void setup() {
        def samid = new Aventurero(nombre: 'Samid').save()
        def viale = new Aventurero(nombre: 'Viale').save()
        def aventureros = []

        aventureros.add(samid)
        aventureros.add(viale)

        new Party(nombre: 'Samid Party', cantidadDeAventureros: 2, aventureros: aventureros ).save()
        new Party(nombre: 'Viale Party', cantidadDeAventureros: 5).save()
    }

    void "Creo una party y verifico que se haya persistido"() {
        setup:
        new Party(nombre: 'Viale Party', cantidadDeAventureros: 5).save()

        expect:
        Party.count() == 3
    }

    void "Verifico que la party tenga aventureros"() {
        expect:
        Party.get(1).aventureros.size() == 2
    }

    void "Verifico que una de las parties coincida con las que agregué"() {
        expect:
        Party.get(1).aventureros.first().nombre == "Viale"
    }


    void "Recupero una party y verifico que su nombre sea correcto"() {
        expect:
        Party.get(1).nombre == "Samid Party"
    }

    void "Recupero una party utilizando la función findByNombre"() {
        expect:
        Party.findByNombre("Samid Party").nombre == "Samid Party"
    }

    void "Recupero una party utilizando la función findByCantidadDeAventureros"() {
        expect:
        Party.findByCantidadDeAventureros(2).cantidadDeAventureros == 2
    }

    void "Actualizo el nombre de una Party"() {
        def party = Party.get(1)
        def nuevo_nombre = "Viale Party"
        party.nombre = nuevo_nombre
        party.save()

        expect:
        Party.get(1).nombre == nuevo_nombre
    }

    void "Elimino una party"() {
        def party = Party.get(1)
        party.delete()

        assertNull Party.get(1)
	}

    void "Recupero parties por ID y verifico que se generen secuencialmente"() {
        expect:
        Party.findById(1).nombre == "Samid Party" && Party.findById(2).nombre == "Viale Party"
	}

    void "Recupero todos las parties del setup"() {
        expect:
        Aventurero.list().size() == 2
    }


}
