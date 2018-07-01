package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PerfilController {

    PerfilService perfilService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond perfilService.list(params), model:[perfilCount: perfilService.count()]
    }

    def show(Long id) {
        respond perfilService.get(id)
    }

    def create() {
        respond new Perfil(params)
    }

    def save(Perfil perfil) {
        if (perfil == null) {
            notFound()
            return
        }

        try {
            perfilService.save(perfil)
        } catch (ValidationException e) {
            respond perfil.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'perfil.label', default: 'Perfil'), perfil.id])
                redirect perfil
            }
            '*' { respond perfil, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond perfilService.get(id)
    }

    def update(Perfil perfil) {
        if (perfil == null) {
            notFound()
            return
        }

        try {
            perfilService.save(perfil)
        } catch (ValidationException e) {
            respond perfil.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'perfil.label', default: 'Perfil'), perfil.id])
                redirect perfil
            }
            '*'{ respond perfil, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        perfilService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'perfil.label', default: 'Perfil'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'perfil.label', default: 'Perfil'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
