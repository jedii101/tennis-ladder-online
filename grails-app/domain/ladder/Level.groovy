package ladder
class Level extends EntityBase implements Comparable {
    int level
    static belongsTo = [ladder:Ladder]
    SortedSet levelposition
    static transients = [ 'name','levelTeam' ,'aboveLevel']
    static hasMany = [levelposition:LevelPosition]
   
    static constraints = {
        levelposition(nullable:true)
    }
  

    int compareTo(obj) {
    	    if( ladder.name!=obj.ladder.name){
    	    	throw new     LadderSystemException("can not compare levels for different ladder!")
    	    }	
        return level-obj.level
    }
    public String getName(){
        return level
    }

    public String info(){
        return getName()
    }
    public  int minus(Level right) {
        return this.level-right.level
    }

    public static List showLevelForLadder (Ladder ladder){
        return Level.withCriteria {
            eq('ladder',ladder)
            order('level','asc') // or 'asc'
        }
    }

    public String getLevelTeam(){
        //for each levelposition, print team name, team status
        def levelTeam=""
        //println(" here!")
        for (i in levelposition) { levelTeam=levelTeam+ i.team
            //"<b class='"+i.team.status+"'>"+i.team+"</b> ; "

            //println("leaveal team:"+levelTeam)
        }
        //levelTeam=levelposition.each(concatString(levelTeam,it.team))
        return levelTeam;
    }

    public Level getAboveLevel(){
        return withCriteria {
            eq('ladder',ladder)
            eq('level',level-1) // or 'asc'
        }.getAt(0)
    }

    public String concatString(String original,String append){
        return original+append;
    }

    public void pushLoserToEndOfLevel(Team loser){
        LevelPosition vacantPos=null
        //densify the queue
        levelposition.each{
            if(null==it.team){
                vacantPos=it
            }else
            if(null!=vacantPos){
                vacantPos.setTeam(it.team)
                vacantPos=it
            }
        }
        LevelPosition lastPos=fetchLastPosition()
        lastPos.setTeam(loser)
        levelposition.each{
            it.save()
        }
        //queue level should have 1 extract vacant spot holding the loser.
        //set the loser team to loserSpot(last position of the queue
        //            LevelPosition endOfQueue=level.getQueueLoserSpot()
        //            endOfQueue.setTeam(loser)
        //            this.setTeam(null)
        //            level.denseQueue
    }

    public LevelPosition fetchLastPosition(){
        LevelPosition bigPos=null

        levelposition.each{
            if(null==bigPos){
                bigPos=it
            }else{
                if(bigPos.compareTo(it)<0){
                    bigPos=it
                }
            }
        }
        return bigPos
    }

    
    public LevelPosition firstAvailablePosition(){
    	    levelposition.each{
    	    	    if(null==it.team){
    	    	    	    return it
    	    	    }
    	    }
    }
}
