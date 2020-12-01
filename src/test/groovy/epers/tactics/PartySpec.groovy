package epers.tactics

import grails.testing.gorm.DomainUnitTest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@Stepwise
class PartySpec extends Specification implements DomainUnitTest<Party> {

    //@Shared int id

    void "Creo una party y verifico que se haya persistido"() {
        setup:
        new Party(nombre: 'Robert', cantidadDeAventureros: 2).save()

        expect:
        Party.count() == 1
    }

    void "Recupero una party y verifico que su nombre sea correcto"() {
        setup:
        new Party(nombre: 'Robert', cantidadDeAventureros: 2).save()

        expect:
        Party.get(1).nombre == "Robert"
    }
}
