package ladder

class LadderService {
    def createLadder(String _name,int...numberOfPositionsForEachLevel) {
        Ladder ladder=new Ladder(name:_name)
        int currentLevel=0

        numberOfPositionsForEachLevel.each(){
            Level l=new Level(lev:currentLevel++,ladder:ladder)
            for(_pos in 1..it){
                LevelPosition lp=new LevelPosition(pos:_pos,ladder:ladder,level:l)
                l.addToLevelposition(lp)
            }
	    //l.save()
            ladder.addToLevels(l)
        }
        return ladder

    }
    //put those disabled teams to the bottom of ladder
    def disableTeam(Team t){
        /**
        def positions=LevelPosition.findAllByLadder(ladder)
        def teams=Team.findAllByLadder(ladder)
        def List disabled
        for
         **/
	    
    }
    
    public List listTeamsForChallenge(Team thisTeam){
        //this team must be challenger or both
        if(thisTeam.canChallenge()){
            //get level above this team
            Level levelAbove=Level.findByLev(thisTeam.position.level.lev-1)
            if(levelAbove==null){
		return null   
            }
            def abovePositions=LevelPosition.findAllByLevel(levelAbove)
	    abovePositions.each{
                log.info("abovePositions:${it.info()}")
	    }
	    //list defenders & both above
            //List teamsAvailableBeChallenged=new ArrayList()
            def availablePositionsAbove=
	    abovePositions.findAll{it.team.available()}
	    def teams=new ArrayList()
	    availablePositionsAbove.each{
                teams.add(it.team)
	    }
	    return teams.sort{it.toName()}
        }
    }
    
    public List listTeamsForDefending(Team thisTeam){
        //this team must be challenger or both
        if(thisTeam.available()){
            //get level below this team
            Level levelBelow=Level.findByLev(thisTeam.position.level.lev+1)
            if(levelBelow==null){
		return null   
            }
            def belowPositions=LevelPosition.findAllByLevel(levelBelow)
	    belowPositions.each{
                log.info("belowPositions:${it.info()}")
	    }
	    //list defenders & both above
            //List teamsAvailableBeChallenged=new ArrayList()
            def belowPositionsCanChallenge=
	    belowPositions?.findAll{it.team?.canChallenge()}
	    def teams=new ArrayList()
	    belowPositionsCanChallenge.each{
                teams.add(it.team)
	    }
	    return teams.sort{it.toName()}
	}
    }
	
    public void fillTeams(Ladder ladder){
		
        Team.findAllByLadder(ladder)?.findAll{it->it.position==null}.each{ladder.addTeam(it)}
    }

    public void refreshStatus(){
        List teamsStatusExpired=new ArrayList()
        Ladder.findAll().each{
            ladder->
            Team.findAllByLadder(ladder)?.
            findAll{it->it.expired()}
            .each{
                log.info("reset team staus:${it}")
                it.status="BOTH"
                it.save(flush:true)
            }
        }
    }
    

}