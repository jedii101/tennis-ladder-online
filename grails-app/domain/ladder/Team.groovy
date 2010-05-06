package ladder
class Team  implements Comparable, EntityBase {
    Player player1
    Player player2
    
    String status
    Date lastMatchDate//default doesn't need to care this
    
    static transients = [ 'defenders','shortStatus' ]
    Ladder ladder
    LevelPosition position
    static constraints = {
        status(inList:["DEFENDER", "CHALLENGER","BOTH","ON-CHALLENGE","DISABLED","VACATION"] )
//        lastMatchSchedule(nullable:true)
        position(nullable:true)
	ladder(nullable:true)
        player2(nullable:true)
	lastMatchDate(nullable:true)

    }
    
    public String getStatus(){
    	return status?:"BOTH"	    
    }

    public String toName(){
//    	    println("@@"+player1)
	return player1.getName()+
	(null==player2?"":"\n&"+player2.getName())
    }
    
   
    public void flip(){
        if("DEFENDER".equals(status)){
            status="CHALLENGER"
        }else{
            status="DEFENDER"
        }
    }

    public void winOver(Team loser){
        LevelPosition winnerPosition=position
        println("position:"+winnerPosition)
        LevelPosition loserPosition=loser.position

        //winner become challenger, loser become defender.
        this.status="CHALLENGER"//unless it's at top of ladder
        loser.status="DEFENDER"
	this.lastMatchDate=new Date()
	loser.lastMatchDate=new Date()

        if(winnerPosition.compareTo(loserPosition)<0){//defender won
            //nothing needds to be done for normal case

            //if challenger in queue, drop to the last position.
            loserPosition.team=loser
	    loserPosition.save()
        }else{//challenger won

            loserPosition.team=this
	    position=loserPosition
            loserPosition.save()
            winnerPosition.team=loser
	    loser.position=winnerPosition//doing this for unit testing
            winnerPosition.save()
        }
	println("loserPosition:${loserPosition}")
	println("winnerPosition:${winnerPosition}")
        if(winnerPosition.atLadderTop()||loserPosition.atLadderTop()){
            this.status="DEFENDER"
        }
        if(loserPosition.inBottomQueue()||loserPosition.inBottomQueue()){
            loser.status="BOTH"
        }
	//this.save()
	//loser.save()
    }

    int compareTo(obj) {
        //lastMatchSchedule.matchDate.compareTo(obj.lastMatchSchedule.matchDate)
        return 1
    }

    public String toString(){
        return toName()
        //+"("+status+")"
    }

    public List listDefendersAbove (){
        //list teams one level above. TODO?status='DEFENDER'
        
        List positionsAbove=position.abovePositions
        List defenderList=new ArrayList()
        positionsAbove.each{
            defenderList.add(it.team)
        }
        return defenderList
    }

    /**
    public LevelPosition fetchPosition(){
	  
        return LevelPosition.withCriteria {
            eq('team',this)
        }.getAt(0)
	
	return LevelPosition.findByTeam(this)
    }
    **/

    public String getShortStatus(){
        if("DEFENDER".equals(status)){
            return "(-)"
        }
        if("BOTH".equals(status)){
            return "(?)"
        }
	if("VACATION".equals(status)){
            return "(*)"
        }
	if("ON-CHALLENGE".equals(status)){
            return "(!)"
        }
	 if("DISABLED".equals(status)){
            return "(\\)"
        }
        return "(+)"
    }
    
    public boolean availableForChallenge(){

    	    if ("DEFENDER".equals(status)||"BOTH".equals(status)){
    	    	    def found=MatchSchedule.findAllByDefenderAndStatus(this,"CHALLENGE")
    	    	    if(found){
    	    	    	    return true
    	    	    }else{
    	    	    	    return false
    	    	    }
    	    }
    	    return false
	  
    }
    
    public boolean canChallenge(){
	    return (status==~/CHALLENGER|BOTH/)&&(!position.atLadderTop())
    }
    
    public boolean available(){
	    return (status==~/DEFENDER|BOTH/)&&(!position.inBottomQueue())
    }
/*
    public LevelPosition getPosition(){
        return position?:LevelPosition.findByTeam(this)
    }
    
    public void setPosition(LevelPosition p){
	    position=p
    }
    */

    public static Team fetchTeamByLadderAndPlayer(Ladder l,Player p){
	    println("ladder before:${LadderUtils.dumpme(l)}")
	    def team=Team.findByLadderAndPlayer1(l,p)?:Team.findByLadderAndPlayer2(l,p)
	    if(team==null){
		println("ladder:${LadderUtils.dumpme(l)}")
		println("player:${LadderUtils.dumpme(p)}")
	    }
	    return team
    }

//    public MatchSchedule getLastMatchSchedule(){
//        return MatchSchedule.withCriteria {
//            eq('level',levelAbove)
//            order('pos', 'asc') // or 'asc'
//        }.getAt(0)
//    }
}
