package ladder

import grails.test.*

class LadderServiceTests extends GrailsUnitTestCase {
    def ls
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
        
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateLadder() {

        println(mixLadder)
        assertEquals(3,mixLadder.levels.size())

    }
    void testListLevels(){
        println("mixladder.levels:${mixLadder.levels}")
        int i=0
        mixLadder.levels.sort().each{
    	    assertEquals(i++,it.lev)
    	    
        }
    }
    
    void testListTeamsForChallenge(){
	   def ls= new LadderService()
        def teams=Team.findAll()
        println("teams:${teams}")
        for(i in 0..4){
    
            mixLadder.addTeam(teams[i])
        }
	def p=Player.findByUserName("2first1_2last1")
	println("Player:${p}")
	
        Team t=Team.fetchTeamByPlayer(p)
        println("t:${t}")
        assertEquals("L1:P1:2first1.2last1\n&2first2.2last2",LevelPosition.findByTeam(t).info())
        assertTrue(t.available())
        println("listTeamsForChallenge:"+ls.listTeamsForChallenge(t))
	assertEquals("[1first1.1last1\n&1first2.1last2]",ls.listTeamsForChallenge(t).toString())
	
	 p=Player.findByUserName("5first1_5last1")
	println("Player:${p}")
	
         t=Team.fetchTeamByPlayer(p)
        println("t:${t}")
        assertEquals("L2:P2:5first1.5last1\n&5first2.5last2",LevelPosition.findByTeam(t).info())
        assertTrue(t.available())
        println("listTeamsForChallenge:"+ls.listTeamsForChallenge(t))
	assertEquals("[2first1.2last1\n&2first2.2last2, 3first1.3last1\n&3first2.3last2]",ls.listTeamsForChallenge(t).toString())
    }
    void testListTeamsForDefending(){
	   def ls= new LadderService()
        def teams=Team.findAll()
        println("teams:${teams}")
        for(i in 0..4){
    
            mixLadder.addTeam(teams[i])
        }
	//top level
	def p=Player.findByUserName("1first1_1last1")
	println("Player:${p}")
	
        Team t=Team.fetchTeamByPlayer(p)
        println("t:${t}")
        
        println("listTeamsForDefending:"+ls.listTeamsForDefending(t))
	assertEquals("[2first1.2last1\n&2first2.2last2, 3first1.3last1\n&3first2.3last2]",ls.listTeamsForDefending(t).toString())
	//second level
	 p=Player.findByUserName("2first1_2last1")
	println("Player:${p}")
	
         t=Team.fetchTeamByPlayer(p)
        println("t:${t}")
        
        println("listTeamsForDefending:"+ls.listTeamsForDefending(t))
	assertEquals("[4first1.4last1\n&4first2.4last2, 5first1.5last1\n&5first2.5last2]",ls.listTeamsForDefending(t).toString())
	
	//3rd level
	p=Player.findByUserName("5first1_5last1")
	println("Player:${p}")
	
         t=Team.fetchTeamByPlayer(p)
        println("t:${t}")
        
        println("listTeamsForDefending:"+ls.listTeamsForDefending(t))
	assertNull(ls.listTeamsForDefending(t))

    }
    void testListLevelByLadderName(){
	assertNotNull(LevelPosition.listByLadderName("mix double"))
    }
    
    void testTopTeam(){
        def teams=Team.findAll()
        println("teams:${teams}")
        for(i in 0..4){
            mixLadder.addTeam(teams[i])
        }
	def p=Player.findByUserName("1first1_1last1")
	println("Player:${p}")
	
        Team topTeam=Team.fetchTeamByPlayer(p)
        println("topTeam:${topTeam}")
        assertEquals("L0:P1:1first1.1last1\n&1first2.1last2",LevelPosition.findByTeam(topTeam).info())
        assertTrue(topTeam.available())
        assertNull new LadderService().listTeamsForChallenge(topTeam)
    
    }
    
    void testTop(){
        assertEquals(0,mixLadder.levels.min().lev)
        assertEquals("L0:P1:null",mixLadder.levels.min().levelposition.min().info())
        
    }
    
    void testFirstAvailable(){
        assertEquals("L0:P1:null",mixLadder.firstAvailable().info())
        def teams=Team.findAll()
	    
        for(i in 1..5){
    
            mixLadder.addTeam(teams[i])
        }
        assertEquals("L2:P3:null",mixLadder.firstAvailable().info())
        println(mixLadder)
        /**
        shouldFailWithCause(LadderSystemException) {
    	     
        println("teams:${teams}")
        teams.each{
    	    
        mixLadder.addTeam(it)
        }
        }
         **/

    }

    void testButtom(){
        assertEquals(2,mixLadder.levels.max().lev)
        assertEquals("L2:P3:null",mixLadder.levels.max().levelposition.max().info())
    }
}
