package ladder
class MatchService{
    def listRedFlaggedMatches={

    }

    def autoDefault={

    }

    def reportResults(MatchSchedule ms){
	    println("ms.save()${ms.save()}")
	    println("winner:"+ms.winner)
	    println("loser:"+ms.loser)
            ms.winner.winOver(ms.loser)//position save
            println("ms.winner.save()${ms.winner.save()}")
            println("ms.loser.save()${ms.loser.save()}")
            
	    new Message(message:ms.generateResultMessage(),createBy:ms.reportBy,type:"RESULT").save()
    }

    def listMatchResults={
        
    }

    def listPendingChallenges={
        
    }

}