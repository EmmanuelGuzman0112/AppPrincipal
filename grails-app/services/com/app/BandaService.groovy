package com.app

import grails.gorm.services.Service

@Service(Banda)
interface BandaService {

    Banda get(Serializable id)

    List<Banda> list(Map args)

    Long count()

    void delete(Serializable id)

    Banda save(Banda banda)

}