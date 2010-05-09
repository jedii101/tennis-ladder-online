package ladder

class MatchScheduleController {
	def authenticateService
        def matchService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [matchScheduleInstanceList: MatchSchedule.list(params), matchScheduleInstanceTotal: MatchSchedule.count()]
    }
    private MatchSchedule preFillSchedule(){
	    def _ladder = Ladder.findByName( params.ladderName )
	    def _reportPlayer=authenticateService.userDomain()

	    def ms= new MatchSchedule(ladder:_ladder,reportBy:_reportPlayer)

	    return ms
    }
    

    def challenging = {
	     println("new challenge report:")
        def matchScheduleInstance = preFillSchedule()
        println("matchScheduleInstance:${LadderUtils.dumpme(matchScheduleInstance)}")
        
	Team myTeam=Team.fetchTeamByLadderAndPlayer(matchScheduleInstance.ladder,matchScheduleInstance.reportBy)
        println("myTeam:${LadderUtils.dumpme(myTeam)}")
        if(!myTeam?.canChallenge()){
            flash.message = "you don't have the right to challenge!"
            redirect(action: "list")
        }
        matchScheduleInstance.challenger=myTeam
	def defendersAbove=myTeam.listDefendersAbove()//defenders drop down
         println("defendersAbove:${defendersAbove}")
        matchScheduleInstance.properties = params
	
        return [matchScheduleInstance: matchScheduleInstance,defenders:defendersAbove]
    }

def defending = {
	     println("new defending report:")
        def matchScheduleInstance = preFillSchedule()
        println("matchScheduleInstance:${LadderUtils.dumpme(matchScheduleInstance)}")

	Team myTeam=Team.fetchTeamByLadderAndPlayer(matchScheduleInstance.ladder,matchScheduleInstance.reportBy)
        println("myTeam:${LadderUtils.dumpme(myTeam)}")
        if(!myTeam?.available()){
            flash.message = "you are not supposed to defend!"
            redirect(controller:"level",action: "list")
        }
        matchScheduleInstance.defender=myTeam
	def challengerBelow=myTeam.listChallengersBelow()//defenders drop down
         println("challengerBelow:${challengerBelow}")
        matchScheduleInstance.properties = params

        return [matchScheduleInstance: matchScheduleInstance,challengers:challengerBelow]
    }

    def create = {
        def matchScheduleInstance = new MatchSchedule()
        matchScheduleInstance.properties = params
        return [matchScheduleInstance: matchScheduleInstance]
    }

    def save={
        saveMode("create")
    }

    def saveChallenge={
        saveMode("challenging")
    }

    def saveDefending={
        saveMode("defending")
    }
    private saveMode(String mode)  {
        println("save:${LadderUtils.dumpme(params)};mode:${mode}")
        def matchScheduleInstance = new MatchSchedule(params)
        if(!matchScheduleInstance.validateScore()){
            println("failed score validation!")
            flash.error = "System can not decide the winner, please verify the score or default"
            redirect(controller:'level',action:'list')
            return
        }

        if (matchService.reportResults(matchScheduleInstance)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'matchSchedule.label', default: 'MatchSchedule'), matchScheduleInstance.id])}"
            if("create".equals(mode)){
                redirect(action: "show", id: matchScheduleInstance.id)
            }else{
                redirect(controller:'level',action:'list')
            }
        }
        else {
            render(view: "${mode}", model: [matchScheduleInstance: matchScheduleInstance])
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
