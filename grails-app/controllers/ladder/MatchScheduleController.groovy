package ladder

class MatchScheduleController {
	def authenticateService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [matchScheduleInstanceList: MatchSchedule.list(params), matchScheduleInstanceTotal: MatchSchedule.count()]
    }
    private MatchSchedule preFillSchedule(){
	    def _ladder = Ladder.get( params.id )
	    def _reportPlayer=authenticateService.userDomain()
	    return new MatchSchedule(ladder:_ladder,reportBy:_reportPlayer)
    }
    

    def challenging = {
	     println("new challenge report:")
        def matchScheduleInstance = preFillSchedule()
	Team myTeam=Team.findByLadderAndPlayer(matchScheduleInstance.ladder,matchScheduleInstance.reportBy)
	def defendersAbove=
        matchScheduleInstance.properties = params
	
        return [matchScheduleInstance: matchScheduleInstance]
    }

    def defending = {
        def matchScheduleInstance = new MatchSchedule()
        matchScheduleInstance.properties = params
        return [matchScheduleInstance: matchScheduleInstance]
    }

    def create = {
        def matchScheduleInstance = new MatchSchedule()
        matchScheduleInstance.properties = params
        return [matchScheduleInstance: matchScheduleInstance]
    }

    def save = {
        def matchScheduleInstance = new MatchSchedule(params)
        if (matchScheduleInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), matchScheduleInstance.id])}"
            redirect(action: "show", id: matchScheduleInstance.id)
        }
        else {
            render(view: "create", model: [matchScheduleInstance: matchScheduleInstance])
        }
    }

    def show = {
        def matchScheduleInstance = MatchSchedule.get(params.id)
        if (!matchScheduleInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), params.id])}"
            redirect(action: "list")
        }
        else {
            [matchScheduleInstance: matchScheduleInstance]
        }
    }

    def edit = {
        def matchScheduleInstance = MatchSchedule.get(params.id)
        if (!matchScheduleInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [matchScheduleInstance: matchScheduleInstance]
        }
    }

    def update = {
        def matchScheduleInstance = MatchSchedule.get(params.id)
        if (matchScheduleInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (matchScheduleInstance.version > version) {
                    
                    matchScheduleInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'matchSchedule.label', default: 'MatchSchedule')] as Object[], "Another user has updated this MatchSchedule while you were editing")
                    render(view: "edit", model: [matchScheduleInstance: matchScheduleInstance])
                    return
                }
            }
            matchScheduleInstance.properties = params
            if (!matchScheduleInstance.hasErrors() && matchScheduleInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), matchScheduleInstance.id])}"
                redirect(action: "show", id: matchScheduleInstance.id)
            }
            else {
                render(view: "edit", model: [matchScheduleInstance: matchScheduleInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def matchScheduleInstance = MatchSchedule.get(params.id)
        if (matchScheduleInstance) {
            try {
                matchScheduleInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), params.id])}"
            redirect(action: "list")
        }
    }
}
