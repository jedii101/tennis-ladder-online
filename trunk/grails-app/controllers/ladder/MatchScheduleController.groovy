package ladder
import org.mortbay.util.ajax.JSON


class MatchScheduleController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
//        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
params.max=100
        [ matchScheduleInstanceList: MatchSchedule.list( params ), matchScheduleInstanceTotal: MatchSchedule.count() ]
    }

    def show = {
        def matchScheduleInstance = MatchSchedule.get( params.id )

        if(!matchScheduleInstance) {
            flash.message = "MatchSchedule not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ matchScheduleInstance : matchScheduleInstance ] }
    }

    def delete = {
        def matchScheduleInstance = MatchSchedule.get( params.id )
        if(matchScheduleInstance) {
            try {
                matchScheduleInstance.delete()
                flash.message = "MatchSchedule ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "MatchSchedule ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "MatchSchedule not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def matchScheduleInstance = MatchSchedule.get( params.id )

        if(!matchScheduleInstance) {
            flash.message = "MatchSchedule not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ matchScheduleInstance : matchScheduleInstance ]
        }
    }

    def update = {
        def matchScheduleInstance = MatchSchedule.get( params.id )
        if(matchScheduleInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(matchScheduleInstance.version > version) {
                    
                    matchScheduleInstance.errors.rejectValue("version", "matchSchedule.optimistic.locking.failure", "Another user has updated this MatchSchedule while you were editing.")
                    render(view:'edit',model:[matchScheduleInstance:matchScheduleInstance])
                    return
                }
            }
            matchScheduleInstance.properties = params
            if(!matchScheduleInstance.hasErrors() && matchScheduleInstance.save()) {
                flash.message = "MatchSchedule ${params.id} updated"
                redirect(action:show,id:matchScheduleInstance.id)
            }
            else {
                render(view:'edit',model:[matchScheduleInstance:matchScheduleInstance])
            }
        }
        else {
            flash.message = "MatchSchedule not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        //create new matchSchedule
        def matchScheduleInstance = new MatchSchedule()
        matchScheduleInstance.properties = params
        //set winner position
        return ['matchScheduleInstance':matchScheduleInstance]
    }
    def search = {
            if (params?.search == 'clear') {
                    params.filter = ''
            }
            redirect (view: list, params: params)
    }
    def save = {
        def matchScheduleInstance = new MatchSchedule(params)
        if(!matchScheduleInstance.hasErrors()
            && matchScheduleInstance.save()) {
xx
            flash.message = "MatchSchedule ${matchScheduleInstance.id} created"
            redirect(action:show,id:matchScheduleInstance.id)
        }
        else {
            render(view:'create',model:[matchScheduleInstance:matchScheduleInstance])
        }
    }

    	def ajaxGetDefender = {
		def challenger = Team.get(params.id)
		render challenger?.cities as JSON
	}

}
