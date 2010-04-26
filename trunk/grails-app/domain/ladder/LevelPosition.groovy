package ladder
class LevelPosition implements Comparable {
    int pos
    Ladder ladder
    static belongsTo = [level:Level]
    Team team
    static transients = [ 'name','abovePositions','atLadderTop','inBottomQueue','loserTeam' ]
    static constraints = {
        //teams.size <=level
    }

    int compareTo(obj) {
    	        	  if( ladder.name!=obj.ladder.name){
    	    	throw new     LadderSystemException("can not compare levels for different ladder!")
    	    }	
        return ((this.level-obj.level)!=0)?(this.level-obj.level):(pos-obj.pos)
    }

    public String getName(){
        return "L"+level?.name+":P"+pos
    }

    public String toString(){
        println("nono")
        return getName()+team
    }

    public static List listOfLevelPositon (Ladder ladder){
        return LevelPosition.withCriteria {
            eq('ladder',ladder)
            order('level','asc') // or 'asc'
            order('pos', 'asc') // or 'asc'
        }
    }
    public  List getAbovePositions (){
        Level levelAbove=levelPosition.level.aboveLevel
        return LevelPosition.withCriteria {
            eq('level',levelAbove)
            order('pos', 'asc') // or 'asc'
        }
    }

    public boolean isAtLadderTop(){
        return level.level==1
    }
    public boolean isInBottomQueue(){
        return level.level==1000
    }
    public void setLoserTeam(Team loser){
        //if(isInBottomQueue()){
        this.setTeam(null)
            level.pushLoserToEndOfLevel(loser)
//            return
//        }
//        this.team=loser
    }
}
