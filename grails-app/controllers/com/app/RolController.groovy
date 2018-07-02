package com.app

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RolController {

    RolService rolService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond rolService.list(params), model:[rolCount: rolService.count()]
    }

    def show(Long id) {
        respond rolService.get(id)
    }

    def create() {
        respond new Rol(params)
    }

    def save(Rol rol) {
        if (rol == null) {
            notFound()
            return
        }

        try {
            rolService.save(rol)
        } catch (ValidationException e) {
            respond rol.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'rol.label', default: 'Rol'), rol.id])
                redirect rol
            }
            '*' { respond rol, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond rolService.get(id)
    }

    def update(Rol rol) {
        if (rol == null) {
            notFound()
            return
        }

        try {
            rolService.save(rol)
        } catch (ValidationException e) {
            respond rol.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'rol.label', default: 'Rol'), rol.id])
                redirect rol
            }
            '*'{ respond rol, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        rolService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'rol.label', default: 'Rol'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'rol.label', default: 'Rol'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
