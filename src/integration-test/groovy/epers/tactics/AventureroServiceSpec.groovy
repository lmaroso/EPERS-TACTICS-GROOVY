package epers.tactics

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AventureroServiceSpec extends Specification {

    /*AventureroService aventureroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Aventurero(...).save(flush: true, failOnError: true)
        //new Aventurero(...).save(flush: true, failOnError: true)
        //Aventurero aventurero = new Aventurero(...).save(flush: true, failOnError: true)
        //new Aventurero(...).save(flush: true, failOnError: true)
        //new Aventurero(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //aventurero.id
    }

    void "test get"() {
        setupData()

        expect:
        aventureroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Aventurero> aventureroList = aventureroService.list(max: 2, offset: 2)

        then:
        aventureroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        aventureroService.count() == 5
    }

    void "test delete"() {
        Long aventureroId = setupData()

        expect:
        aventureroService.count() == 5

        when:
        aventureroService.delete(aventureroId)
        sessionFactory.currentSession.flush()

        then:
        aventureroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Aventurero aventurero = new Aventurero()
        aventureroService.save(aventurero)

        then:
        aventurero.id != null
    }*/
}
