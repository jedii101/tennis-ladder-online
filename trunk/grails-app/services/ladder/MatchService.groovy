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
            ms.winner.lastMatchDate=ms.matchDate
            ms.loser.lastMatchDate=ms.matchDate
            log.info("ms.winner.save()${ms.winner.save(flush:true)}")
            log.info("ms.loser.save()${ms.loser.save(flush:true)}")
            
	    new Message(message:ms.generateResultMessage(),createBy:ms.reportBy,type:"RESULT").save(flush:true)
    }

    def listMatchResults={
        
    }

    def listPendingChallenges={
        
    }

}