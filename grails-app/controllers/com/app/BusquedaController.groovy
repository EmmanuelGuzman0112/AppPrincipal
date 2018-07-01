package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class BusquedaController {

    BusquedaService busquedaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond busquedaService.list(params), model:[busquedaCount: busquedaService.count()]
    }

    def show(Long id) {
        respond busquedaService.get(id)
    }

    def create() {
        respond new Busqueda(params)
    }

    def save(Busqueda busqueda) {
        if (busqueda == null) {
            notFound()
            return
        }

        try {
            busquedaService.save(busqueda)
        } catch (ValidationException e) {
            respond busqueda.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'busqueda.label', default: 'Busqueda'), busqueda.id])
                redirect busqueda
            }
            '*' { respond busqueda, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond busquedaService.get(id)
    }

    def update(Busqueda busqueda) {
        if (busqueda == null) {
            notFound()
            return
        }

        try {
            busquedaService.save(busqueda)
        } catch (ValidationException e) {
            respond busqueda.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'busqueda.label', default: 'Busqueda'), busqueda.id])
                redirect busqueda
            }
            '*'{ respond busqueda, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        busquedaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'busqueda.label', default: 'Busqueda'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'busqueda.label', default: 'Busqueda'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
