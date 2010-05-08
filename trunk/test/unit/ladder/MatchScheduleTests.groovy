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
        mixLadder=ls.createLadder("mix double",1,2,3,4,10)
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

        def maxLev=Level.findAll().max()
        println("maxLel:-setup${maxLev}")
	
	def firstAvailableLP=mixLadder.firstAvailable()
	println("firstAvaialbleLP:${firstAvailableLP}")
    }

    protected void tearDown() {
        super.tearDown()
    }
    
    protected void fillTeam(){
        def teams=Team.findAll()
        println("teams:${teams}")
        for(i in 0..8){
    
            mixLadder.addTeam(teams[i])
        }
	
    }


    
    void testGenerateResultMessage(){
	println("mixLadder:before testGenerateResultMessage:${mixLadder}")
        //top team
        def p=Player.findByUserName("1first1_1last1")
        Team d=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	    
        p=Player.findByUserName("3first1_3last1")
        Team c=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	    
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
        Team d=Team.fetchTeamByLadderAndPlayer(mixLadder,pd)
	    
        def pc=Player.findByUserName("3first1_3last1")
        Team c=Team.fetchTeamByLadderAndPlayer(mixLadder,pc)
	    
	    
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
         c=Team.fetchTeamByLadderAndPlayer(mixLadder,pc)
	    
	    
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
        Team d=Team.fetchTeamByLadderAndPlayer(mixLadder,pd)
	    
        def pc=Player.findByUserName("2first1_2last1")
        Team c=Team.fetchTeamByLadderAndPlayer(mixLadder,pc)
	    
	    
        //top team defender lost
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

     void testReportMatch_middleTeam_win(){
        println("mixLadder:before testReportMatch_topTeam_win:${mixLadder}")
        def pd=Player.findByUserName("3first1_3last1")
        Team d=Team.fetchTeamByLadderAndPlayer(mixLadder,pd)

        def pc=Player.findByUserName("5first1_5last1")
        Team c=Team.fetchTeamByLadderAndPlayer(mixLadder,pc)


        // team defender win
        def m=new MatchSchedule(defender:d,challenger:c,
	    defenderScore:8,challengerScore:3,matchDate:new Date(110,03,20)
	    ,reportBy:pd,ladder:d.ladder)
        println("m:${m}")
        matchService.reportResults(m)
        println("ladder:${Ladder.findAll()}")
	assertEquals("CHALLENGER",d.status)
	assertEquals("L1:P2:3first1.3last1\n&3first2.3last2",d.position.info())

	assertEquals("DEFENDER",c.status)
	assertEquals("L2:P2:5first1.5last1\n&5first2.5last2",c.position.info())

    }

    void testReportMatch_middleTeam_lost(){
        println("mixLadder:before testReportMatch_topTeam_win:${mixLadder}")
        def pd=Player.findByUserName("3first1_3last1")
        Team d=Team.fetchTeamByLadderAndPlayer(mixLadder,pd)

        def pc=Player.findByUserName("5first1_5last1")
        Team c=Team.fetchTeamByLadderAndPlayer(mixLadder,pc)


        // team defender lost by default
        def m=new MatchSchedule(defender:d,challenger:c,
	    defenderScore:3,challengerScore:3,matchDate:new Date(110,03,20)
	    ,reportBy:pc,ladder:d.ladder,defaultWinner:"CHALLENGER",defaultReason:new DefaultReason(code:"fail to meet challenge for rematch"))
        println("m:${m}")
        matchService.reportResults(m)
        println("ladder:${Ladder.findAll()}")
	assertEquals("DEFENDER",d.status)
	assertEquals("L2:P2:3first1.3last1\n&3first2.3last2",d.position.info())

	assertEquals("CHALLENGER",c.status)
	assertEquals("L1:P2:5first1.5last1\n&5first2.5last2",c.position.info())

    }
 void testReportMatch_bottomTeam_lost(){
        println("mixLadder:before testReportMatch_topTeam_win:${mixLadder}")
        def pd=Player.findByUserName("6first1_6last1")//L2P3
        Team d=Team.fetchTeamByLadderAndPlayer(mixLadder,pd)

        def pc=Player.findByUserName("9first1_9last1")//L3P3
        Team c=Team.fetchTeamByLadderAndPlayer(mixLadder,pc)


        // team defender win by default
        def m=new MatchSchedule(defender:d,challenger:c,
	    defenderScore:0,challengerScore:0,matchDate:new Date(110,03,20)
	    ,reportBy:pc,ladder:d.ladder,defaultWinner:"DEFENDER",defaultReason:new DefaultReason(code:"fail to meet challenge for rematch"))

        println("m:${m}")
        matchService.reportResults(m)
        println("ladder:${Ladder.findAll()}")
	assertEquals("CHALLENGER",d.status)
	assertEquals("L2:P3:6first1.6last1\n&6first2.6last2",d.position.info())

	assertEquals("BOTH",c.status)
	assertEquals("L3:P3:9first1.9last1\n&9first2.9last2",c.position.info())

    }

    void testReportMatch_bottomTeam_win(){
        println("mixLadder:before testReportMatch_topTeam_win:${mixLadder}")
        def pd=Player.findByUserName("6first1_6last1")
        Team d=Team.fetchTeamByLadderAndPlayer(mixLadder,pd)

        def pc=Player.findByUserName("9first1_9last1")
        Team c=Team.fetchTeamByLadderAndPlayer(mixLadder,pc)


        // team defender lost by default
        def m=new MatchSchedule(defender:d,challenger:c,
	    defenderScore:3,challengerScore:8,matchDate:new Date(110,03,20)
	    ,reportBy:pc,ladder:d.ladder,defaultWinner:"CHALLENGER",defaultReason:new DefaultReason(code:"fail to meet challenge for rematch"))
        println("m:${m}")
        matchService.reportResults(m)
        println("ladder:${Ladder.findAll()}")
	assertEquals("BOTH",d.status)
	assertEquals("L3:P3:6first1.6last1\n&6first2.6last2",d.position.info())

	assertEquals("CHALLENGER",c.status)
	assertEquals("L2:P3:9first1.9last1\n&9first2.9last2",c.position.info())

    }
    
     void testListDefendersAbove(){
	     //top team
	             def p=Player.findByUserName("1first1_1last1")
		     Team t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals(0,t.listDefendersAbove().size())
	     
	     //2nd level
	     p=Player.findByUserName("2first1_2last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[1first1.1last1\n&1first2.1last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("3first1_3last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[1first1.1last1\n&1first2.1last2]",t.listDefendersAbove().toString())
	     
	     //3rd level
	     p=Player.findByUserName("4first1_4last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[2first1.2last1\n&2first2.2last2, 3first1.3last1\n&3first2.3last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("5first1_5last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[2first1.2last1\n&2first2.2last2, 3first1.3last1\n&3first2.3last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("6first1_6last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[2first1.2last1\n&2first2.2last2, 3first1.3last1\n&3first2.3last2]",t.listDefendersAbove().toString())	     
	     
	     //4th level
	     p=Player.findByUserName("7first1_7last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[4first1.4last1\n&4first2.4last2, 5first1.5last1\n&5first2.5last2, 6first1.6last1\n&6first2.6last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("8first1_8last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[4first1.4last1\n&4first2.4last2, 5first1.5last1\n&5first2.5last2, 6first1.6last1\n&6first2.6last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("9first1_9last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[4first1.4last1\n&4first2.4last2, 5first1.5last1\n&5first2.5last2, 6first1.6last1\n&6first2.6last2]",t.listDefendersAbove().toString())
		     
					     
     }
     
     void testValidteScore(){
	     def ms=new MatchSchedule(defenderScore:8,challengerScore:5)
	      //println("testValidte:${LadderUtils.dumpme(ms)}")
	     assertEquals(true,ms.validateScore())
	     
	     ms=new MatchSchedule(defenderScore:8,challengerScore:8,defaultReason:"abc",defaultWinner:"DEFENDER")
	     assertEquals(true,ms.validateScore())
	     
	     ms=new MatchSchedule(defenderScore:0,challengerScore:0)
	     assertEquals(false,ms.validateScore())
	     
	     ms=new MatchSchedule(defenderScore:8,challengerScore:8)
	     assertEquals(false,ms.validateScore())
	     
	     ms=new MatchSchedule(defenderScore:8,challengerScore:8,defaultReason:"abc")
	     assertEquals(false,ms.validateScore())
	     
	    ms=new MatchSchedule(defenderScore:5,challengerScore:8,defaultWinner:"DEFENDER")
	     assertEquals(false,ms.validateScore())
     }
     /**
     void testWinOver(){
	     //top team
	             def p=Player.findByUserName("1first1_1last1")
		     Team t1=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals(0,t.listDefendersAbove().size())
	     
	     //2nd level
	     p=Player.findByUserName("2first1_2last1")
	     Team t2=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     t.2status="BOTH"
	     t2.save()
	     assertEquals("[1first1.1last1\n&1first2.1last2]",t2.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("3first1_3last1")
	     Team t3=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     t3.status="CHALLENGER"
	     t3.save()
	     assertEquals("[1first1.1last1\n&1first2.1last2]",t3.listDefendersAbove().toString())
	     
	     t1.winOver(t2)
	     assertEquals(t1.position)
	     
	     //3rd level
	     p=Player.findByUserName("4first1_4last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[2first1.2last1\n&2first2.2last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("5first1_5last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     t.status="CHALLENGER"
	     t.save()
	     assertEquals("[2first1.2last1\n&2first2.2last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("6first1_6last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     t.status="DEFENDER"
	     t.save()
	     assertEquals("[2first1.2last1\n&2first2.2last2]",t.listDefendersAbove().toString())	     
	     
	     //4th level
	     p=Player.findByUserName("7first1_7last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[4first1.4last1\n&4first2.4last2, 6first1.6last1\n&6first2.6last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("8first1_8last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[4first1.4last1\n&4first2.4last2, 6first1.6last1\n&6first2.6last2]",t.listDefendersAbove().toString())
	     
	     p=Player.findByUserName("9first1_9last1")
	     t=Team.fetchTeamByLadderAndPlayer(mixLadder,p)
	     assertEquals("[4first1.4last1\n&4first2.4last2, 6first1.6last1\n&6first2.6last2]",t.listDefendersAbove().toString())
		     
					     
     }
     **/
}
