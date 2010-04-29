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
         mixLadder.save()
         
         def testPlayer = []
        mockDomain(Player, testPlayer)
        
        def testTeam=[]
        mockDomain(Team, testTeam)
        
        //generate teams
         def pt=new TeamTests();
        def tg=pt.&generateTeam
        
        for(i in 0..9){
        	tg(i,null,null).save()
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
    	    assertEquals(i++,it.level)
    	    
    	    }
    }
    
    void testTop(){
        assertEquals(0,mixLadder.levels.min().level)
        assertEquals("L0:P1:null",mixLadder.levels.min().levelposition.min().info())
        
    }
    
    void testFirstAvailable(){
    	    assertEquals("L0:P1:null",mixLadder.firstAvailable().info())
    	     def teams=Team.findAll()
    	     teams.each{
    	    
		mixLadder.addTeam(it)
	     }
	     println(mixLadder)
    }

    void testButtom(){
        assertEquals(2,mixLadder.levels.max().level)
        assertEquals("L2:P3:null",mixLadder.levels.max().levelposition.max().info())
    }
}
