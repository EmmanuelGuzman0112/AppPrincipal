package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PostulacionController {

    PostulacionService postulacionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond postulacionService.list(params), model:[postulacionCount: postulacionService.count()]
    }

    def show(Long id) {
        respond postulacionService.get(id)
    }

    def create() {
        respond new Postulacion(params)
    }

    def save(Postulacion postulacion) {
        if (postulacion == null) {
            notFound()
            return
        }

        try {
            postulacionService.save(postulacion)
        } catch (ValidationException e) {
            respond postulacion.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'postulacion.label', default: 'Postulacion'), postulacion.id])
                redirect postulacion
            }
            '*' { respond postulacion, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond postulacionService.get(id)
    }

    def update(Postulacion postulacion) {
        if (postulacion == null) {
            notFound()
            return
        }

        try {
            postulacionService.save(postulacion)
        } catch (ValidationException e) {
            respond postulacion.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'postulacion.label', default: 'Postulacion'), postulacion.id])
                redirect postulacion
            }
            '*'{ respond postulacion, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        postulacionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'postulacion.label', default: 'Postulacion'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'postulacion.label', default: 'Postulacion'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
