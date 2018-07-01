package com.app

import grails.gorm.services.Service

@Service(Integrante)
interface IntegranteService {

    Integrante get(Serializable id)

    List<Integrante> list(Map args)

    Long count()

    void delete(Serializable id)

    Integrante save(Integrante integrante)

}