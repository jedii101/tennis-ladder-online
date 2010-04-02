class MatchSchedule {
    Team defender
    Team challenger
    int defenderScore
    int challegerScore
    Date matchDate
    Date planMatchDate
    String defaultWinner
    DefaultReason defaultReason
    String comments
    static transients = [ 'winner','loser']
    static constraints = {
        defaultWinner(nullable:true)
        defaultReason(nullable:true)
        defaultWinner(inList:["DEFENDER", "CHALLENGER"] )
        comments(nullable:true)
        planMatchDate(nullable:true)
    }

    public Team getWinner(){
        if("DEFENDER".equals(defaultWinner)){
            return defender
        }
                if("CHALLENGER".equals(defaultWinner)){
            return challenger
        }
        if(defenderScore>challegerScore){
            return defender
        }
        return challenger
    }
        public Team getLoser(){
        if(defender.equals(getWinner())){
            return challenger
        }
        return defender
    }
}
