package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BandaServiceSpec extends Specification {

    BandaService bandaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Banda(...).save(flush: true, failOnError: true)
        //new Banda(...).save(flush: true, failOnError: true)
        //Banda banda = new Banda(...).save(flush: true, failOnError: true)
        //new Banda(...).save(flush: true, failOnError: true)
        //new Banda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //banda.id
    }

    void "test get"() {
        setupData()

        expect:
        bandaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Banda> bandaList = bandaService.list(max: 2, offset: 2)

        then:
        bandaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        bandaService.count() == 5
    }

    void "test delete"() {
        Long bandaId = setupData()

        expect:
        bandaService.count() == 5

        when:
        bandaService.delete(bandaId)
        sessionFactory.currentSession.flush()

        then:
        bandaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Banda banda = new Banda()
        bandaService.save(banda)

        then:
        banda.id != null
    }
}
