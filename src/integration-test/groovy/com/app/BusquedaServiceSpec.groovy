package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BusquedaServiceSpec extends Specification {

    BusquedaService busquedaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Busqueda(...).save(flush: true, failOnError: true)
        //new Busqueda(...).save(flush: true, failOnError: true)
        //Busqueda busqueda = new Busqueda(...).save(flush: true, failOnError: true)
        //new Busqueda(...).save(flush: true, failOnError: true)
        //new Busqueda(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //busqueda.id
    }

    void "test get"() {
        setupData()

        expect:
        busquedaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Busqueda> busquedaList = busquedaService.list(max: 2, offset: 2)

        then:
        busquedaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        busquedaService.count() == 5
    }

    void "test delete"() {
        Long busquedaId = setupData()

        expect:
        busquedaService.count() == 5

        when:
        busquedaService.delete(busquedaId)
        sessionFactory.currentSession.flush()

        then:
        busquedaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Busqueda busqueda = new Busqueda()
        busquedaService.save(busqueda)

        then:
        busqueda.id != null
    }
}
