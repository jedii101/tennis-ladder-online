

class LevelPositionController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        flash.ladder=flash.ladder?:Ladder.get(params.id?:"1")
        
        params.max = Math.min( params.max ? params.max.toInteger() : 50,  100)
       // println("findAllByLadder"+LevelPosition.findAllByLadder( Ladder.get(1) ))
         flash.singleList= LevelPosition.listOfLevelPositon( Ladder.get(1) )
         flash.doubleList=LevelPosition.listOfLevelPositon( Ladder.get(2) )
        // [ doubleList: LevelPosition.findAllByLadder( Ladder.get(2) ), doubleListTotal:0 ]
         
        //[ singleList: LevelPosition.findAllByLadder( Ladder.get(1) ), singleListTotal: LevelPosition.countByLadder(Ladder.get(1)) ]
        //[ doubleList: LevelPosition.findAllByLadder( Ladder.get(2) ), doubleListTotal: LevelPosition.countByLadder(Ladder.get(2)) ]

    }

    def show = {
        def levelPositionInstance = LevelPosition.get( params.id )

        if(!levelPositionInstance) {
            flash.message = "LevelPosition not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ levelPositionInstance : levelPositionInstance ] }
    }

    def delete = {
        def levelPositionInstance = LevelPosition.get( params.id )
        if(levelPositionInstance) {
            try {
                levelPositionInstance.delete()
                flash.message = "LevelPosition ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "LevelPosition ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "LevelPosition not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def levelPositionInstance = LevelPosition.get( params.id )

        if(!levelPositionInstance) {
            flash.message = "LevelPosition not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ levelPositionInstance : levelPositionInstance ]
        }
    }

    def update = {
        def levelPositionInstance = LevelPosition.get( params.id )
        if(levelPositionInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(levelPositionInstance.version > version) {
                    
                    levelPositionInstance.errors.rejectValue("version", "levelPosition.optimistic.locking.failure", "Another user has updated this LevelPosition while you were editing.")
                    render(view:'edit',model:[levelPositionInstance:levelPositionInstance])
                    return
                }
            }
            levelPositionInstance.properties = params
            if(!levelPositionInstance.hasErrors() && levelPositionInstance.save()) {
                flash.message = "LevelPosition ${params.id} updated"
                redirect(action:show,id:levelPositionInstance.id)
            }
            else {
                render(view:'edit',model:[levelPositionInstance:levelPositionInstance])
            }
        }
        else {
            flash.message = "LevelPosition not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        flash.ladder=Ladder.get(params.id?:"2")
        println(params.id)
        println("flash.ladder:"+flash.ladder)
        def levelPositionInstance = new LevelPosition(ladder:flash.ladder)
        levelPositionInstance.properties = params
        return ['levelPositionInstance':levelPositionInstance]
    }

    def save = {
        def levelPositionInstance = new LevelPosition(params)
        flash.ladder=flash.ladder?:Ladder.get(params.id?:"1")
        levelPositionInstance.ladder=flash.ladder
        if(!levelPositionInstance.hasErrors() && levelPositionInstance.save()) {
            flash.message = "LevelPosition ${levelPositionInstance.id} created"
            redirect(action:show,id:levelPositionInstance.id)
        }
        else {
            render(view:'create',model:[levelPositionInstance:levelPositionInstance])
        }
    }
}
