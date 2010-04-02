class Team  implements Comparable {
    Player player1
    Player player2
    //    LevelPosition position
    String status
    
    static transients = [ 'defenders','shortStatus' ]
    Ladder ladder
    static constraints = {
        status(inList:["DEFENDER", "CHALLENGER","BOTH"] )
//        lastMatchSchedule(nullable:true)
//        position(nullable:true)
        player2(nullable:true)

    }

    public String toName(){
	return player1.getName()+(null==player2?"":"&"+player2.getName())
    }
    
   
    public void flip(){
        if("DEFENDER".equals(status)){
            status="CHALLENGER"
        }else{
            status="DEFENDER"
        }
    }

    public void winOver(Team loser){
        LevelPosition winnerPosition=fetchPosition()
        println("position:"+winnerPosition)
        LevelPosition loserPosition=loser.fetchPosition()

        //winner become challenger, loser become defender.
        this.status="CHALLENGER"//unless it's at top of ladder
        loser.status="DEFENDER"

        if(winnerPosition.compareTo(loserPosition)<0){//defender won
            //nothing needds to be done for normal case

            //if challenger in queue, drop to the last position.
            loserPosition.setLoserTeam(loser)
        }else{//challenger won

            loserPosition.setTeam(this)
            loserPosition.save()
            winnerPosition.setLoserTeam(loser)
            //winnerPosition.save()
        }
        if(winnerPosition.isAtLadderTop()||loserPosition.isAtLadderTop()){
            this.status="DEFENDER"
        }
        if(loserPosition.isInBottomQueue()||loserPosition.isInBottomQueue()){
            loser.status="BOTH"
        }
    }

    int compareTo(obj) {
        //lastMatchSchedule.matchDate.compareTo(obj.lastMatchSchedule.matchDate)
        return 1
    }

    public String toString(){
        return toName()
        //+"("+status+")"
    }

    public  List getDefenders (){
        //list teams one level above. TODO?status='DEFENDER'
        
        List positionsAbove=position.abovePositions
        List defenderList=new ArrayList()
        positionsAbove.each{
            defenderList.add(it.team)
        }
        return defenderList


    }

    public LevelPosition fetchPosition(){
        return LevelPosition.withCriteria {
            eq('team',this)
        }.getAt(0)
    }

    public String getShortStatus(){
        if("DEFENDER".equals(status)){
            return "-"
        }
        if("BOTH".equals(status)){
            return "?"
        }
        return "+"
    }

//    public MatchSchedule getLastMatchSchedule(){
//        return MatchSchedule.withCriteria {
//            eq('level',levelAbove)
//            order('pos', 'asc') // or 'asc'
//        }.getAt(0)
//    }
}
