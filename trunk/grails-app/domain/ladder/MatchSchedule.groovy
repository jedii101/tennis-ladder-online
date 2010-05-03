package ladder
class MatchSchedule  extends EntityBase{
    Team defender
    Team challenger
    int defenderScore
    int challengerScore
    Date matchDate
    Date planMatchDate
    String defaultWinner
    DefaultReason defaultReason
    Player reportBy
    String status="RESULT"
    String comments
    
    Ladder ladder

    static hasMany = [ message : Message]
    static transients = [ 'winner','loser']
    static constraints = {
        defaultWinner(nullable:true)
        defaultReason(nullable:true)
        defaultWinner(inList:["DEFENDER", "CHALLENGER"] )
        status(inList:["CHALLENGE", "RESULT"] )
        comments(nullable:true,size:0..50)
        planMatchDate(nullable:true)
	message(nullable:true)
	challengerScore(
            validator: {//@@NOTE:validator can not rename
                val, obj ->
		int _defenderScore=obj.properties['defenderScore']
		if(_defenderScore>0 &&_defenderScore==val){
                    return ['system.cannotdecide.winner']
		}
            }
	)
    }
    public Ladder getLadder(){
	    return defender?.ladder
    }

    public Team getWinner(){
        if("DEFENDER".equals(defaultWinner)){
            return defender
        }
        if("CHALLENGER".equals(defaultWinner)){
            return challenger
        }
        if(defenderScore>challengerScore){
            return defender
        }
        if(defenderScore>0 &&defenderScore==challengerScore){
            throw new LadderSystemException("system can not decide who is the winner,MatchSchedule:${this}")
        }
        return challenger
    }
    public Team getLoser(){
        if(defender.equals(getWinner())){
            return challenger
        }
        return defender
    }
    public String generateScore(){
	    return defaultReason==null?(defenderScore>challengerScore?" ${defenderScore}:${challengerScore}":" ${challengerScore}:${defenderScore}"):"By default, code:${defaultReason}"
    }
    public String generateResultMessage(){
        String result= "Match Result:${getWinner()} defeated ${getLoser()} ${generateScore()}".replaceAll("\n","")
	
	    
    }


}
