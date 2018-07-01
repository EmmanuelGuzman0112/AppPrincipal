package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RolServiceSpec extends Specification {

    RolService rolService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Rol(...).save(flush: true, failOnError: true)
        //new Rol(...).save(flush: true, failOnError: true)
        //Rol rol = new Rol(...).save(flush: true, failOnError: true)
        //new Rol(...).save(flush: true, failOnError: true)
        //new Rol(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //rol.id
    }

    void "test get"() {
        setupData()

        expect:
        rolService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Rol> rolList = rolService.list(max: 2, offset: 2)

        then:
        rolList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        rolService.count() == 5
    }

    void "test delete"() {
        Long rolId = setupData()

        expect:
        rolService.count() == 5

        when:
        rolService.delete(rolId)
        sessionFactory.currentSession.flush()

        then:
        rolService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Rol rol = new Rol()
        rolService.save(rol)

        then:
        rol.id != null
    }
}
