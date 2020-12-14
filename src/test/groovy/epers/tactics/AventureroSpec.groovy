package epers.tactics

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class AventureroSpec extends Specification implements DomainUnitTest<Aventurero> {

    void setup() {
        def samidParty = new Party(nombre: "Samid Party", cantidadDeAventureros: 1).save()
        def vialeParty = new Party(nombre: "Viale Party", cantidadDeAventureros: 1).save()
        new Aventurero(nombre: 'Samid', party: samidParty).save()
        new Aventurero(nombre: 'Viale', party: vialeParty).save()
    }

    void "Creo un Aventurero y verifico que se haya persistido"() {
        setup:
        def samidParty = new Party(nombre: "Samid Party", cantidadDeAventureros: 1).save()
        new Aventurero(nombre: 'Nuevo Aventurero', party: samidParty).save()

        expect:
        Aventurero.count() == 3
    }

     void "Recupero un aventurero y verifico que su nombre sea correcto"() {
         setup:
         def aventurero = Aventurero.get(1)

        expect:
        aventurero.nombre == "Samid"
    }
   
    void "Recupero un aventurero utilizando la función findByNombre"() {
        expect:
        Aventurero.findByNombre("Samid").nombre == "Samid"
    }
 
    void "Actualizo el nombre de un aventurero"() {
        def aventurero = Aventurero.get(1)
        def nuevo_nombre = "Nuevo Nombre"
        aventurero.nombre = nuevo_nombre
        aventurero.save()

        expect:
        Aventurero.get(1).nombre == nuevo_nombre
    }

   void "Elimino un aventurero"() {
        def aventurero = Aventurero.get(1)
        aventurero.delete()

        assertNull Aventurero.get(1)
	}

   void "Recupero aventureros por ID y verifico que se generen secuencialmente"() {
        expect:
        Aventurero.findById(1).nombre == "Samid" && Aventurero.findById(2).nombre == "Viale"
	}
}
