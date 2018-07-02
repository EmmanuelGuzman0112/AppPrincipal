package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InstrumentoMusicoController {

    InstrumentoMusicoService instrumentoMusicoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond instrumentoMusicoService.list(params), model:[instrumentoMusicoCount: instrumentoMusicoService.count()]
    }

    def show(Long id) {
        respond instrumentoMusicoService.get(id)
    }

    def create() {
        respond new InstrumentoMusico(params)
    }

    def save(InstrumentoMusico instrumentoMusico) {
        if (instrumentoMusico == null) {
            notFound()
            return
        }

        try {
            instrumentoMusicoService.save(instrumentoMusico)
        } catch (ValidationException e) {
            respond instrumentoMusico.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'instrumentoMusico.label', default: 'InstrumentoMusico'), instrumentoMusico.id])
                redirect instrumentoMusico
            }
            '*' { respond instrumentoMusico, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond instrumentoMusicoService.get(id)
    }

    def update(InstrumentoMusico instrumentoMusico) {
        if (instrumentoMusico == null) {
            notFound()
            return
        }

        try {
            instrumentoMusicoService.save(instrumentoMusico)
        } catch (ValidationException e) {
            respond instrumentoMusico.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'instrumentoMusico.label', default: 'InstrumentoMusico'), instrumentoMusico.id])
                redirect instrumentoMusico
            }
            '*'{ respond instrumentoMusico, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        instrumentoMusicoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'instrumentoMusico.label', default: 'InstrumentoMusico'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'instrumentoMusico.label', default: 'InstrumentoMusico'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
