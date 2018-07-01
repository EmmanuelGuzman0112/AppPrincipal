package com.app

import grails.gorm.services.Service

@Service(Postulacion)
interface PostulacionService {

    Postulacion get(Serializable id)

    List<Postulacion> list(Map args)

    Long count()

    void delete(Serializable id)

    Postulacion save(Postulacion postulacion)

}