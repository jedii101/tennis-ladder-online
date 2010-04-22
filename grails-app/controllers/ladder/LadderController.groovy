package ladder

class LadderController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)
        [ ladderInstanceList: Ladder.list( params ), ladderInstanceTotal: Ladder.count() ]
    }

    def show = {
        def ladderInstance = Ladder.get( params.id )

        if(!ladderInstance) {
            flash.message = "Ladder not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ ladderInstance : ladderInstance ] }
    }

    def delete = {
        def ladderInstance = Ladder.get( params.id )
        if(ladderInstance) {
            try {
                ladderInstance.delete()
                flash.message = "Ladder ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Ladder ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Ladder not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def ladderInstance = Ladder.get( params.id )

        if(!ladderInstance) {
            flash.message = "Ladder not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ ladderInstance : ladderInstance ]
        }
    }

    def update = {
        def ladderInstance = Ladder.get( params.id )
        if(ladderInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(ladderInstance.version > version) {
                    
                    ladderInstance.errors.rejectValue("version", "ladder.optimistic.locking.failure", "Another user has updated this Ladder while you were editing.")
                    render(view:'edit',model:[ladderInstance:ladderInstance])
                    return
                }
            }
            ladderInstance.properties = params
            if(!ladderInstance.hasErrors() && ladderInstance.save()) {
                flash.message = "Ladder ${params.id} updated"
                redirect(action:show,id:ladderInstance.id)
            }
            else {
                render(view:'edit',model:[ladderInstance:ladderInstance])
            }
        }
        else {
            flash.message = "Ladder not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def ladderInstance = new Ladder()
        ladderInstance.properties = params
        return ['ladderInstance':ladderInstance]
    }

    def save = {
        def ladderInstance = new Ladder(params)
        if(!ladderInstance.hasErrors() && ladderInstance.save()) {
            flash.message = "Ladder ${ladderInstance.id} created"
            redirect(action:show,id:ladderInstance.id)
        }
        else {
            render(view:'create',model:[ladderInstance:ladderInstance])
        }
    }
}
