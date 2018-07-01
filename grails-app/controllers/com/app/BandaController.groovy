package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BandaController {

    BandaService bandaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond bandaService.list(params), model:[bandaCount: bandaService.count()]
    }

    def show(Long id) {
        respond bandaService.get(id)
    }

    def create() {
        respond new Banda(params)
    }

    def save(Banda banda) {
        if (banda == null) {
            notFound()
            return
        }

        try {
            bandaService.save(banda)
        } catch (ValidationException e) {
            respond banda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'banda.label', default: 'Banda'), banda.id])
                redirect banda
            }
            '*' { respond banda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond bandaService.get(id)
    }

    def update(Banda banda) {
        if (banda == null) {
            notFound()
            return
        }

        try {
            bandaService.save(banda)
        } catch (ValidationException e) {
            respond banda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'banda.label', default: 'Banda'), banda.id])
                redirect banda
            }
            '*'{ respond banda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        bandaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'banda.label', default: 'Banda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'banda.label', default: 'Banda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
