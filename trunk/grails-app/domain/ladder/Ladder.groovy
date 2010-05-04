package ladder
class Ladder implements EntityBase{
    String name
    static hasMany = [levels:Level]
    static constraints = {
    }

    public String info(){
        return name
    }
    
    public String toString(){
	    return info()
    }
    

    
    public void addTeam(Team team){
    //add team to last available level position
    	team.ladder=this
    	firstAvailable().team=team
    }
    
    public LevelPosition firstAvailable(){
    /*
        def mylevels= Level.list([sort: 'level', order: 'asc',
        fetch: [levelposition: 'eager']])
        
        println("mylevels:${mylevels}")
      */  
      def firstAvailableLevel=
        levels.sort().find{
         null!=it.firstAvailablePosition()
        }
        if(null==firstAvailableLevel){
        throw new LadderSystemException("no more position available:${this}")
        }
        return firstAvailableLevel.firstAvailablePosition()
    }

}
