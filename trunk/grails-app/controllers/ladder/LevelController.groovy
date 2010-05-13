package ladder

class LevelController {
    def authenticateService
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    static allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        def me=authenticateService.userDomain()
        def myMixTeam=Team.fetchTeamByLadderAndPlayer(Ladder.findByName("mix doubles"),me)
        def mySingleTeam=Team.fetchTeamByLadderAndPlayer(Ladder.findByName("singles"),me)

        def mixChallenge=(myMixTeam?.canChallenge())?:false
        def mixDefending=(myMixTeam?.available())?:false

        def singleChallenge=(mySingleTeam?.canChallenge())?:false
        def singleDefending=(mySingleTeam?.available())?:false
        log.info("mySingleTeam:${LadderUtils.dumpme(mySingleTeam)}")
        log.info("singleDefending:${singleDefending}")

        log.info("myMixTeam:${LadderUtils.dumpme(myMixTeam)}")
        log.info("mixDefending:${mixDefending}")
        params.max = Math.min( params.max ? params.max.toInteger() : 10,  100)

        log.info("level list:params:${LadderUtils.dumpme(params)}")
        //[ levelInstanceList: Level.list( params ), levelInstanceTotal: Level.count() ]
        flash.singleLevels=Level.showLevelForLadder(Ladder.findByName("singles"))
        flash.doubleLevels=Level.showLevelForLadder(Ladder.findByName("mix doubles"))
        return [ mixChallenge : mixChallenge, mixDefending:mixDefending,
            singleChallenge:singleChallenge,singleDefending:singleDefending]
    }

    def show = {
        def levelInstance = Level.get( params.id )

        if(!levelInstance) {
            flash.message = "Level not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ levelInstance : levelInstance ] }
    }

    def delete = {
        def levelInstance = Level.get( params.id )
        if(levelInstance) {
            try {
                levelInstance.delete()
                flash.message = "Level ${params.id} deleted"
                redirect(action:list)
            }
            catch(org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "Level ${params.id} could not be deleted"
                redirect(action:show,id:params.id)
            }
        }
        else {
            flash.message = "Level not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def levelInstance = Level.get( params.id )

        if(!levelInstance) {
            flash.message = "Level not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ levelInstance : levelInstance ]
        }
    }

    def update = {
        def levelInstance = Level.get( params.id )
        if(levelInstance) {
            if(params.version) {
                def version = params.version.toLong()
                if(levelInstance.version > version) {
                    
                    levelInstance.errors.rejectValue("version", "level.optimistic.locking.failure", "Another user has updated this Level while you were editing.")
                    render(view:'edit',model:[levelInstance:levelInstance])
                    return
                }
            }
            levelInstance.properties = params
            if(!levelInstance.hasErrors() && levelInstance.save()) {
                flash.message = "Level ${params.id} updated"
                redirect(action:show,id:levelInstance.id)
            }
            else {
                render(view:'edit',model:[levelInstance:levelInstance])
            }
        }
        else {
            flash.message = "Level not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def levelInstance = new Level()
        levelInstance.properties = params
        return ['levelInstance':levelInstance]
    }

    def save = {
        def levelInstance = new Level(params)
        if(!levelInstance.hasErrors() && levelInstance.save()) {
            flash.message = "Level ${levelInstance.id} created"
            redirect(action:show,id:levelInstance.id)
        }
        else {
            render(view:'create',model:[levelInstance:levelInstance])
        }
    }
}
