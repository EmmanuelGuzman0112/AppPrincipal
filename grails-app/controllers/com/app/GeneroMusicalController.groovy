package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GeneroMusicalController {

    GeneroMusicalService generoMusicalService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond generoMusicalService.list(params), model:[generoMusicalCount: generoMusicalService.count()]
    }

    def show(Long id) {
        respond generoMusicalService.get(id)
    }

    def create() {
        respond new GeneroMusical(params)
    }

    def save(GeneroMusical generoMusical) {
        if (generoMusical == null) {
            notFound()
            return
        }

        try {
            generoMusicalService.save(generoMusical)
        } catch (ValidationException e) {
            respond generoMusical.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'generoMusical.label', default: 'GeneroMusical'), generoMusical.id])
                redirect generoMusical
            }
            '*' { respond generoMusical, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond generoMusicalService.get(id)
    }

    def update(GeneroMusical generoMusical) {
        if (generoMusical == null) {
            notFound()
            return
        }

        try {
            generoMusicalService.save(generoMusical)
        } catch (ValidationException e) {
            respond generoMusical.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'generoMusical.label', default: 'GeneroMusical'), generoMusical.id])
                redirect generoMusical
            }
            '*'{ respond generoMusical, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        generoMusicalService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'generoMusical.label', default: 'GeneroMusical'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'generoMusical.label', default: 'GeneroMusical'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
