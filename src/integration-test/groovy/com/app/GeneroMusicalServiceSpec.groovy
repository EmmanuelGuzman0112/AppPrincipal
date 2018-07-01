package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class GeneroMusicalServiceSpec extends Specification {

    GeneroMusicalService generoMusicalService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new GeneroMusical(...).save(flush: true, failOnError: true)
        //new GeneroMusical(...).save(flush: true, failOnError: true)
        //GeneroMusical generoMusical = new GeneroMusical(...).save(flush: true, failOnError: true)
        //new GeneroMusical(...).save(flush: true, failOnError: true)
        //new GeneroMusical(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //generoMusical.id
    }

    void "test get"() {
        setupData()

        expect:
        generoMusicalService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<GeneroMusical> generoMusicalList = generoMusicalService.list(max: 2, offset: 2)

        then:
        generoMusicalList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        generoMusicalService.count() == 5
    }

    void "test delete"() {
        Long generoMusicalId = setupData()

        expect:
        generoMusicalService.count() == 5

        when:
        generoMusicalService.delete(generoMusicalId)
        sessionFactory.currentSession.flush()

        then:
        generoMusicalService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        GeneroMusical generoMusical = new GeneroMusical()
        generoMusicalService.save(generoMusical)

        then:
        generoMusical.id != null
    }
}
