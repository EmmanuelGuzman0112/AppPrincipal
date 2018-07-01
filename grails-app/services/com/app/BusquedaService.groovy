package com.app

import grails.gorm.services.Service

@Service(Busqueda)
interface BusquedaService {

    Busqueda get(Serializable id)

    List<Busqueda> list(Map args)

    Long count()

    void delete(Serializable id)

    Busqueda save(Busqueda busqueda)

}