package com.app

import grails.gorm.services.Service

@Service(InstrumentoMusico)
interface InstrumentoMusicoService {

    InstrumentoMusico get(Serializable id)

    List<InstrumentoMusico> list(Map args)

    Long count()

    void delete(Serializable id)

    InstrumentoMusico save(InstrumentoMusico instrumentoMusico)

}