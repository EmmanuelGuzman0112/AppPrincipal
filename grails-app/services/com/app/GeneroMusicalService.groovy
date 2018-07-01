package com.app

import grails.gorm.services.Service

@Service(GeneroMusical)
interface GeneroMusicalService {

    GeneroMusical get(Serializable id)

    List<GeneroMusical> list(Map args)

    Long count()

    void delete(Serializable id)

    GeneroMusical save(GeneroMusical generoMusical)

}