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
    
        def levels= Level.list([sort: 'level', order: 'asc',
        fetch: [levelposition: 'eager']])
        levels.each{
        	if(null!=it.firstAvailablePosition()){
        		return it.firstAvailablePosition() 
        	}
        	throw new LadderSystemException("no more position available:${this}")
        	
        }
    }

}
