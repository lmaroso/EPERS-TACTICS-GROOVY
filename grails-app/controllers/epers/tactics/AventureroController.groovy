package epers.tactics

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AventureroController {

    AventureroService aventureroService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond aventureroService.list(params), model:[aventureroCount: aventureroService.count()]
    }

    def show(Long id) {
        respond aventureroService.get(id)
    }

    def create() {
        respond new Aventurero(params)
    }

    def save(Aventurero aventurero) {
        if (aventurero == null) {
            notFound()
            return
        }

        try {
            aventureroService.save(aventurero)
        } catch (ValidationException e) {
            respond aventurero.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'aventurero.label', default: 'Aventurero'), aventurero.id])
                redirect aventurero
            }
            '*' { respond aventurero, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond aventureroService.get(id)
    }

    def update(Aventurero aventurero) {
        if (aventurero == null) {
            notFound()
            return
        }

        try {
            aventureroService.save(aventurero)
        } catch (ValidationException e) {
            respond aventurero.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'aventurero.label', default: 'Aventurero'), aventurero.id])
                redirect aventurero
            }
            '*'{ respond aventurero, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        aventureroService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'aventurero.label', default: 'Aventurero'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'aventurero.label', default: 'Aventurero'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
