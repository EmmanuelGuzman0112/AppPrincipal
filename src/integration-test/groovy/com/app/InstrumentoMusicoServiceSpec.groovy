package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InstrumentoMusicoServiceSpec extends Specification {

    InstrumentoMusicoService instrumentoMusicoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new InstrumentoMusico(...).save(flush: true, failOnError: true)
        //new InstrumentoMusico(...).save(flush: true, failOnError: true)
        //InstrumentoMusico instrumentoMusico = new InstrumentoMusico(...).save(flush: true, failOnError: true)
        //new InstrumentoMusico(...).save(flush: true, failOnError: true)
        //new InstrumentoMusico(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //instrumentoMusico.id
    }

    void "test get"() {
        setupData()

        expect:
        instrumentoMusicoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<InstrumentoMusico> instrumentoMusicoList = instrumentoMusicoService.list(max: 2, offset: 2)

        then:
        instrumentoMusicoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        instrumentoMusicoService.count() == 5
    }

    void "test delete"() {
        Long instrumentoMusicoId = setupData()

        expect:
        instrumentoMusicoService.count() == 5

        when:
        instrumentoMusicoService.delete(instrumentoMusicoId)
        sessionFactory.currentSession.flush()

        then:
        instrumentoMusicoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        InstrumentoMusico instrumentoMusico = new InstrumentoMusico()
        instrumentoMusicoService.save(instrumentoMusico)

        then:
        instrumentoMusico.id != null
    }
}
