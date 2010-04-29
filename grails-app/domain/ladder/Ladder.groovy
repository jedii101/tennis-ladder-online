package ladder
class Ladder extends EntityBase{
    String name
    static hasMany = [levels:Level]
    static constraints = {
    }

    public String info(){
        return name
    }
    

    
    public void addTeam(Team team){
    //add team to last available level position
    }
    
    public LevelPosition getFirstAvailable(){
    
        def mylevels= Level.list([sort: 'level', order: 'asc',
        fetch: [levelposition: 'eager']])
        
        println(mylevels)
        
        mylevels.each{
        LevelPosition lp=it.firstAvailablePosition()
        println(lp)
        	if(null!=lp){
        		return lp 
        	}
      	
        }
        throw new LadderSystemException("no more position available:${this}")
    }

}
