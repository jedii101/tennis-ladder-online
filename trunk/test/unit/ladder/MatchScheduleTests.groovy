package ladder

import grails.test.*

class MatchScheduleTests extends GrailsUnitTestCase {
    def ls
    def matchService=new MatchService()
    def mixLadder
    protected void setUp() {
        super.setUp()

        def testLadder = []
        mockDomain(Ladder, testLadder)
        def testLevel = []
        mockDomain(Level, testLevel)
        def testLevelPosition = []
        mockDomain(LevelPosition, testLevelPosition)
        ls=new LadderService()
        mixLadder=ls.createLadder("mix double",1,2,3)
        //replace mixLadder.save()
        new CascadeDomainSaver().saveCascade(mixLadder)
	 
        def lp=LevelPosition.findAll()
        println("lp:${lp}")
        println("ladder.findAll:${Ladder.findAll()}")
        println("level.findAll:${Level.findAll()}")
         
        def testPlayer = []
        mockDomain(Player, testPlayer)
        
        def testTeam=[]
        mockDomain(Team, testTeam)
        
        //generate teams
        def pt=new TeamTests();
        def tg=pt.&generateTeam
        
        for(i in 1..9){
            new CascadeDomainSaver().saveCascade(tg(i,"BOTH",mixLadder))
            //tg(i,null,null).save()
        }
	
	fillTeam()
	new CascadeDomainSaver().saveCascade(mixLadder)
	println("mixLadder:after setup:${mixLadder}")
	
        def testMatchSchedule = []
        mockDomain(MatchSchedule, testMatchSchedule)
        def testMessage = []
        mockDomain(Message, testMessage)
        def testDR = []
        mockDomain(DefaultReason, testDR)
    }

    protected void tearDown() {
        super.tearDown()
    }
    
    protected void fillTeam(){
        def teams=Team.findAll()
        println("teams:${teams}")
        for(i in 0..4){
    
            mixLadder.addTeam(teams[i])
        }
	
    }


    
    void testGenerateResultMessage(){
	println("mixLadder:before testGenerateResultMessage:${mixLadder}")
        //top team
        def p=Player.findByUserName("1first1_1last1")
        Team d=Team.fetchTeamByPlayer(p)
	    
        p=Player.findByUserName("3first1_3last1")
        Team c=Team.fetchTeamByPlayer(p)
	    
        println("c:${c}")
        println("d:${d}")
        println("d?.ladder:${d?.ladder}")
	    
        //win
        def m=new MatchSchedule(defender:d,challenger:c,defenderScore:8,challengerScore:3,matchDate:new Date(110,03,20))
        assertEquals("Match Result:1first1.1last1&1first2.1last2 defeated 3first1.3last1&3first2.3last2  8:3",
	    m.generateResultMessage())
	    
        //lost
        m=new MatchSchedule(defender:d,challenger:c,defenderScore:1,challengerScore:8,matchDate:new Date(110,03,20))
        assertEquals("Match Result:3first1.3last1&3first2.3last2 defeated 1first1.1last1&1first2.1last2  8:1",
	    m.generateResultMessage())
	    
        //default
        m=new MatchSchedule(defender:d,challenger:c,defenderScore:0,challengerScore:0,defaultReason:new DefaultReason(code:"15 minutes late"),defaultWinner:"CHALLENGER",matchDate:new Date(110,03,20))
        assertEquals("Match Result:3first1.3last1&3first2.3last2 defeated 1first1.1last1&1first2.1last2 By default, code:15 minutes late",
	    m.generateResultMessage())
    }
    void testPushLoserToEndOfLevel(){
	    
    }
    void testReportMatch_topTeam_win(){
        println("mixLadder:before testReportMatch_topTeam_win:${mixLadder}")
        def pd=Player.findByUserName("1first1_1last1")
        Team d=Team.fetchTeamByPlayer(pd)
	    
        def pc=Player.findByUserName("3first1_3last1")
        Team c=Team.fetchTeamByPlayer(pc)
	    
	    
        //top team defender win
        def m=new MatchSchedule(defender:d,challenger:c,
	    defenderScore:8,challengerScore:3,matchDate:new Date(110,03,20)
	    ,reportBy:pd,ladder:d.ladder)
        println("m:${m}")
        matchService.reportResults(m)
        println("ladder:${Ladder.findAll()}")
	assertEquals("DEFENDER",d.status)
	assertEquals("L0:P1:1first1.1last1\n&1first2.1last2",d.position.info())
	    
	assertEquals("DEFENDER",c.status)
	assertEquals("L1:P2:3first1.3last1\n&3first2.3last2",c.position.info())
	
	pc=Player.findByUserName("2first1_2last1")
         c=Team.fetchTeamByPlayer(pc)
	    
	    
        //top team defender win
         m=new MatchSchedule(defender:d,challenger:c,
	    defenderScore:8,challengerScore:3,matchDate:new Date(110,03,20)
	    ,reportBy:pd,ladder:d.ladder)
        println("m:${m}")
        matchService.reportResults(m)
        println("ladder:${Ladder.findAll()}")
	assertEquals("DEFENDER",d.status)
	assertEquals("L0:P1:1first1.1last1\n&1first2.1last2",d.position.info())
	    
	assertEquals("DEFENDER",c.status)
	assertEquals("L1:P1:2first1.2last1\n&2first2.2last2",c.position.info())
        println("mixLadder:after testReportMatch_topTeam_win:${mixLadder}")
    }

    void testReportMatch_topTeam_lost(){

        def pd=Player.findByUserName("1first1_1last1")
        Team d=Team.fetchTeamByPlayer(pd)
	    
        def pc=Player.findByUserName("2first1_2last1")
        Team c=Team.fetchTeamByPlayer(pc)
	    
	    
        //top team defender win
        def m=new MatchSchedule(defender:d,challenger:c,
	    defenderScore:1,challengerScore:8,matchDate:new Date(110,03,20)
	    ,reportBy:pd,ladder:d.ladder)
        println("m:${m}")
        matchService.reportResults(m)
        println("ladder:${Ladder.findAll()}")
	assertEquals("DEFENDER",d.status)
	assertEquals("L1:P1:1first1.1last1\n&1first2.1last2",d.position.info())
	    
	assertEquals("DEFENDER",c.status)
	assertEquals("L0:P1:2first1.2last1\n&2first2.2last2",c.position.info())

    }

}
