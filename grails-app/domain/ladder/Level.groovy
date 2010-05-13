package ladder
class Level  implements Comparable, EntityBase {
    int lev
    static belongsTo = [ladder:Ladder]
    static transients = [ 'name','levelTeam' ,'aboveLevel']
    SortedSet levelposition//make sure it sorted properly
    static hasMany = [levelposition:LevelPosition]
   
    static constraints = {
        levelposition(nullable:true)
    }
  
    static mapping = {
        sort "lev"
    }

    int compareTo(obj) {

        if( ladder.name!=obj.ladder.name){
            throw new     LadderSystemException("can not compare levels for different ladder!")
        }
        return lev-obj.lev
    }
    public String getName(){
        return lev
    }

    public String info(){
        return getName()
    }
    
    public String toString(){
		return info()    
    }
    
    public  int minus(Level right) {
        return this.lev-right.lev
    }

    public static List showLevelForLadder (Ladder ladder){
        return Level.withCriteria {
            eq('ladder',ladder)
            order('lev','asc') // or 'asc'
        }
    }

    public String infoLevelTeam(){
        //for each levelposition, print team name, team status
        def levelTeam=""
        //log.info(" here!")
        for (i in levelposition) { levelTeam=levelTeam+ i.team
            //"<b class='"+i.team.status+"'>"+i.team+"</b> ; "

            //log.info("leaveal team:"+levelTeam)
        }
        //levelTeam=levelposition.each(concatString(levelTeam,it.team))
        return levelTeam;
    }
    public Level belowLevel(){
        def belowLevel= Level.findByLadderAndLev(this.ladder,(this.lev+1))
	log.info("belowLevel:${LadderUtils.dumpme(belowLevel)}")
	return belowLevel
    }
    
    public Level aboveLevel(){
        def aboveLevel= Level.findByLadderAndLev(this.ladder,(this.lev-1))
	log.info("aboveLevel:${LadderUtils.dumpme(aboveLevel)}")
	return aboveLevel
        /*
        return withCriteria {
        eq('ladder',ladder)
        eq('lev',lev-1) // or 'asc'
        }.getAt(0)
         */
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
            log.info("pushLoserToEndOfLevel:it:${it}")
        }
        LevelPosition lastPos=fetchLastPosition()
        log.info("lastPos:${lastPos}")
        lastPos.setTeam(loser)
        levelposition.each{
		if(!it.save()){
			throw new LadderSystemException("not save!:${it}")	
		}
        }
        //queue lev should have 1 extract vacant spot holding the loser.
        //set the loser team to loserSpot(last position of the queue
        //            LevelPosition endOfQueue=lev.getQueueLoserSpot()
        //            endOfQueue.setTeam(loser)
        //            this.setTeam(null)
        //            lev.denseQueue
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
        LevelPosition result=
        levelposition.sort{it}.find{it->
            (null==it.team)
        }
        log.info("find:${result}")
        return result
    }
}
