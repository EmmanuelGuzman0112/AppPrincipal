package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class IntegranteController {

    IntegranteService integranteService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond integranteService.list(params), model:[integranteCount: integranteService.count()]
    }

    def show(Long id) {
        respond integranteService.get(id)
    }

    def create() {
        respond new Integrante(params)
    }

    def save(Integrante integrante) {
        if (integrante == null) {
            notFound()
            return
        }

        try {
            integranteService.save(integrante)
        } catch (ValidationException e) {
            respond integrante.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'integrante.label', default: 'Integrante'), integrante.id])
                redirect integrante
            }
            '*' { respond integrante, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond integranteService.get(id)
    }

    def update(Integrante integrante) {
        if (integrante == null) {
            notFound()
            return
        }

        try {
            integranteService.save(integrante)
        } catch (ValidationException e) {
            respond integrante.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'integrante.label', default: 'Integrante'), integrante.id])
                redirect integrante
            }
            '*'{ respond integrante, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        integranteService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'integrante.label', default: 'Integrante'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'integrante.label', default: 'Integrante'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
