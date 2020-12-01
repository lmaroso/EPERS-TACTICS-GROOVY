package epers.tactics

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PartyController {

    PartyService partyService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond partyService.list(params), model:[partyCount: partyService.count()]
    }

    def show(Long id) {
        respond partyService.get(id)
    }

    def create() {
        respond new Party(params)
    }

    def save(Party party) {
        if (party == null) {
            notFound()
            return
        }

        try {
            partyService.save(party)
        } catch (ValidationException e) {
            respond party.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'party.label', default: 'Party'), party.id])
                redirect party
            }
            '*' { respond party, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond partyService.get(id)
    }

    def update(Party party) {
        if (party == null) {
            notFound()
            return
        }

        try {
            partyService.save(party)
        } catch (ValidationException e) {
            respond party.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'party.label', default: 'Party'), party.id])
                redirect party
            }
            '*'{ respond party, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        partyService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'party.label', default: 'Party'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'party.label', default: 'Party'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
