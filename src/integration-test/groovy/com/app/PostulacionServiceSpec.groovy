package com.app

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PostulacionServiceSpec extends Specification {

    PostulacionService postulacionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Postulacion(...).save(flush: true, failOnError: true)
        //new Postulacion(...).save(flush: true, failOnError: true)
        //Postulacion postulacion = new Postulacion(...).save(flush: true, failOnError: true)
        //new Postulacion(...).save(flush: true, failOnError: true)
        //new Postulacion(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //postulacion.id
    }

    void "test get"() {
        setupData()

        expect:
        postulacionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Postulacion> postulacionList = postulacionService.list(max: 2, offset: 2)

        then:
        postulacionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        postulacionService.count() == 5
    }

    void "test delete"() {
        Long postulacionId = setupData()

        expect:
        postulacionService.count() == 5

        when:
        postulacionService.delete(postulacionId)
        sessionFactory.currentSession.flush()

        then:
        postulacionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Postulacion postulacion = new Postulacion()
        postulacionService.save(postulacion)

        then:
        postulacion.id != null
    }
}
