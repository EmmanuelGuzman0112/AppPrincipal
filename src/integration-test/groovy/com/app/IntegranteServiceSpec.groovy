package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class IntegranteServiceSpec extends Specification {

    IntegranteService integranteService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Integrante(...).save(flush: true, failOnError: true)
        //new Integrante(...).save(flush: true, failOnError: true)
        //Integrante integrante = new Integrante(...).save(flush: true, failOnError: true)
        //new Integrante(...).save(flush: true, failOnError: true)
        //new Integrante(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //integrante.id
    }

    void "test get"() {
        setupData()

        expect:
        integranteService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Integrante> integranteList = integranteService.list(max: 2, offset: 2)

        then:
        integranteList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        integranteService.count() == 5
    }

    void "test delete"() {
        Long integranteId = setupData()

        expect:
        integranteService.count() == 5

        when:
        integranteService.delete(integranteId)
        sessionFactory.currentSession.flush()

        then:
        integranteService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Integrante integrante = new Integrante()
        integranteService.save(integrante)

        then:
        integrante.id != null
    }
}
