package ladder

class LevelPositionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 100, 100)
        [levelPositionInstanceList: LevelPosition.listByLadderName(params.ladderFilter?:"mix doubles"), levelPositionInstanceTotal: LevelPosition.count()]
    }
/**
    def create = {
        def levelPositionInstance = new LevelPosition()
        levelPositionInstance.properties = params
        return [levelPositionInstance: levelPositionInstance]
    }
**/
    def save = {
        def levelPositionInstance = new LevelPosition(params)
        if (levelPositionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), levelPositionInstance.id])}"
            redirect(action: "show", id: levelPositionInstance.id)
        }
        else {
            render(view: "create", model: [levelPositionInstance: levelPositionInstance])
        }
    }

    def show = {
        def levelPositionInstance = LevelPosition.get(params.id)
        if (!levelPositionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), params.id])}"
            redirect(action: "list")
        }
        else {
            [levelPositionInstance: levelPositionInstance]
        }
    }

    def edit = {
        def levelPositionInstance = LevelPosition.get(params.id)
        if (!levelPositionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [levelPositionInstance: levelPositionInstance]
        }
    }

    def update = {
        def levelPositionInstance = LevelPosition.get(params.id)
        if (levelPositionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (levelPositionInstance.version > version) {
                    
                    levelPositionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'levelPosition.label', default: 'LevelPosition')] as Object[], "Another user has updated this LevelPosition while you were editing")
                    render(view: "edit", model: [levelPositionInstance: levelPositionInstance])
                    return
                }
            }
            levelPositionInstance.properties = params
            if (!levelPositionInstance.hasErrors() && levelPositionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), levelPositionInstance.id])}"
                redirect(action: "show", id: levelPositionInstance.id)
            }
            else {
                render(view: "edit", model: [levelPositionInstance: levelPositionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), params.id])}"
            redirect(action: "list")
        }
    }
/**
    def delete = {
        def levelPositionInstance = LevelPosition.get(params.id)
        if (levelPositionInstance) {
            try {
                levelPositionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'levelPosition.label', default: 'LevelPosition'), params.id])}"
            redirect(action: "list")
        }
    }
    **/
}
