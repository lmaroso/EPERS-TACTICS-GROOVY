package epers.tactics

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PartyServiceSpec extends Specification {

    /*PartyService partyService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Party(...).save(flush: true, failOnError: true)
        //new Party(...).save(flush: true, failOnError: true)
        //Party party = new Party(...).save(flush: true, failOnError: true)
        //new Party(...).save(flush: true, failOnError: true)
        //new Party(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //party.id
    }

    void "test get"() {
        setupData()

        expect:
        partyService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Party> partyList = partyService.list(max: 2, offset: 2)

        then:
        partyList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        partyService.count() == 5
    }

    void "test delete"() {
        Long partyId = setupData()

        expect:
        partyService.count() == 5

        when:
        partyService.delete(partyId)
        sessionFactory.currentSession.flush()

        then:
        partyService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Party party = new Party()
        partyService.save(party)

        then:
        party.id != null
    }*/
}
