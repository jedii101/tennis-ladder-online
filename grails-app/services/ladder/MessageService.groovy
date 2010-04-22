package ladder
class MessageService{
    static transactional = true
    def sendChallenge={fromTeam,toTeam,content->
    	    //defender still available?
    	    if(!toTeam.isAvailableForChallenge()){
    	    	    throw new TeamNotAvailableException("${toTeam} is not available for challenge!")
    	    }
    	    //create message

    }

    def listUnResponsedDefenders={

    }

    def acceptChallenge={

    }

    def denyOtherChallenges={

    }

    def cancelChallenges={
        
    }

    def listMessages={
        
    }

}