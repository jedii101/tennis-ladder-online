import org.grails.plugins.springsecurity.service.AuthenticateService


/**
 * User controller.
 */
class PlayerController {

    def authenticateService

    // the delete, save and update actions only accept POST requests
    static Map allowedMethods = [delete: 'POST', save: 'POST', update: 'POST']

    def index = {
        redirect action: list, params: params
    }

    def list = {
        params.max = Math.min( params.max ? params.max.toInteger() : 50,  100)
        [ playerInstanceList: Player.list( params ), playerInstanceTotal: Player.count() ]
    }

    def show = {
        def playerInstance = Player.get(params.id)
        if (!playerInstance) {
            flash.message = "Player not found with id $params.id"
            redirect action: list
            return
        }
        List roleNames = []
        println("@@"+playerInstance.authorities)
        for (role in playerInstance.authorities) {
            roleNames << role.authority
        }
        roleNames.sort { n1, n2 ->
            n1 <=> n2
        }
        [playerInstance: playerInstance, roleNames: roleNames]
    }

    /**
     * Person delete action. Before removing an existing playerInstance,
     * he should be removed from those authorities which he is involved.
     */
    def delete = {

        def playerInstance = Player.get(params.id)
        if (playerInstance) {
            def authPrincipal = authenticateService.principal()
            //avoid self-delete if the logged-in user is an admin
            if (!(authPrincipal instanceof String) && authPrincipal.userName == playerInstance.userName) {
                flash.message = "You can not delete yourself, please login as another admin and try again"
            }
            else {
                //first, delete this playerInstance from People_Authorities table.
                Authority.findAll().each { it.removeFromPeople(playerInstance) }
                playerInstance.delete()
                flash.message = "Player $params.id deleted."
            }
        }
        else {
            flash.message = "Player not found with id $params.id"
        }

        redirect action: list
    }

    def edit = {

        def playerInstance = Player.get(params.id)
        //@@NOTE: reset password since it should not be able to edited.
        playerInstance.password=""
        if (!playerInstance) {
            flash.message = "Player not found with id $params.id"
            redirect action: list
            return
        }

        return buildPersonModel(playerInstance)
    }

    /**
     * Person update action.
     */
    def update = {

        def playerInstance = Player.get(params.id)
        if (!playerInstance) {
            flash.message = "Player not found with id $params.id"
            redirect action: edit, id: params.id
            return
        }

        long version = params.version.toLong()
        if (playerInstance.version > version) {
            playerInstance.errors.rejectValue 'version', "playerInstance.optimistic.locking.failure",
				"Another user has updated this Player while you were editing."
            render view: 'edit', model: buildPersonModel(playerInstance)
            return
        }

        def oldPassword = playerInstance.password
        playerInstance.properties = params
        if (!params.password.equals(oldPassword)) {
            playerInstance.password = authenticateService.encodePassword(params.password)
        }
        if (playerInstance.save()) {
            Authority.findAll().each { it.removeFromPeople(playerInstance) }
            addRoles(playerInstance)
            redirect action: show, id: playerInstance.id
        }
        else {
            render view: 'edit', model: buildPersonModel(playerInstance)
        }
    }

    def create = {
        [playerInstance: new Player(params), authorityList: Authority.list()]
    }

    /**
     * Person save action.
     */
    def save = {

        def playerInstance = new Player()
        playerInstance.properties = params
        println("@@ player save"+params)
        if(playerInstance.password!=playerInstance.pass){
            flash.message = "Password not match!"
            //@@NOTE: clear password since it can not be re-edited
            playerInstance.password=""
            render view: 'create', model: [authorityList: Authority.list(), playerInstance: playerInstance]
            return
        }

        //default user role to user:
        //if(playerInstance.r)


        playerInstance.password = authenticateService.encodePassword(params.password)
        if (playerInstance.save()) {
            addRoles(playerInstance)
            //save message
            def message=new Message(createBy:playerInstance,message:"Account Created: ${playerInstance.userName}",created:new Date())
            message.save()
            flash.message=message.format()
            println("message saved:"+message.format())
            redirect action: show, id: playerInstance.id
        }
        else {
            //@@NOTE: clear password since it can not be re-edited
            playerInstance.password=""
            render view: 'create', model: [authorityList: Authority.list(), playerInstance: playerInstance]
        }
    }

    private void addRoles(playerInstance) {
	    boolean found=false
        for (String key in params.keySet()) {
            if (key.contains('ROLE') && 'on' == params.get(key)) {
                Authority.findByAuthority(key).addToPeople(playerInstance)
		found=true;
            }
        }
	if(!found){
		//use default role: ROLE_USER
		println("use default ROLE: ROLE_USER")
			Authority.findByAuthority("ROLE_USER").addToPeople(playerInstance)
	}
    }

    private Map buildPersonModel(playerInstance) {

        List roles = Authority.list()
        roles.sort { r1, r2 ->
            r1.authority <=> r2.authority
        }
        Set userRoleNames = []
        for (role in playerInstance.authorities) {
            userRoleNames << role.authority
        }
        LinkedHashMap<Authority, Boolean> roleMap = [:]
        for (role in roles) {
            roleMap[(role)] = userRoleNames.contains(role.authority)
        }

        return [playerInstance: playerInstance, roleMap: roleMap]
    }
}
