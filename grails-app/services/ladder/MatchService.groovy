package ladder
class MatchService{
    def listRedFlaggedMatches={

    }

    def autoDefault={

    }

    def reportResults(MatchSchedule ms){
	    log.info("ms.save()${ms.save(flush:true)}")
	    log.info("winner:"+ms.winner)
	    log.info("loser:"+ms.loser)
            ms.winner.winOver(ms.loser)//position save
            log.info("ms.winner.save()${ms.winner.save(flush:true)}")
            log.info("ms.loser.save()${ms.loser.save(flush:true)}")
            
	    new Message(message:ms.generateResultMessage(),createBy:ms.reportBy,type:"RESULT").save()
    }

    def listMatchResults={
        
    }

    def listPendingChallenges={
        
    }

}