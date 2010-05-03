package ladder

import grails.test.*
import BootStrap

class TeamTests extends GrailsUnitTestCase {
    Team team
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
	
	team=Team.findByPlayer1(Player.findByUserName("1first1_1last1"))
    }
    protected void fillTeam(){
        def teams=Team.findAll()
        println("teams:${teams}")
        for(i in 0..4){
    
            mixLadder.addTeam(teams[i])
        }
	
    }
    def generateTeam={int i,String status,Ladder ladder->
        def pt=new PlayerTests();
        def pg=pt.&generatePlayer

        def p1=pg(i+"",1)
        def p2=pg(i+"",2)

        //return new Team(player1:p1,player2:p2,status:"DEFENDER",ladder:new Ladder())
        return new Team(player1:p1,player2:p2,status:status,ladder:ladder)
    }
    

    protected void tearDown() {
        super.tearDown()
    }
    void testDefaultStatus(){
        def team=new Team()
        assertEquals("BOTH",team.status)
        team=new Team(status:"DEFENDER")
        assertEquals("DEFENDER",team.status)
    }
    void testAvailable(){
	def t=new Team(status:"BOTH")
	assertTrue(t.available())
	def t1=new Team(status:"CHALLENGER")
	assertFalse(t1.available())
	def t2=new Team(status:"DEFENDER")
	println("team:${t2.status}:${t2.canChallenge()}")
	assertTrue(t2.available())
    }
    void testCanChallenge(){
	def t=new Team(status:"BOTH")
	assertTrue(t.canChallenge())
	def t1=new Team(status:"CHALLENGER")
	assertTrue(t1.canChallenge())
	def t2=new Team(status:"DEFENDER")
	println("team:${t2.status}:${t2.canChallenge()}")
	assertFalse(t2.canChallenge())
    }
    void testValidate() {
  
        def team1 = new Team()
        assertFalse team1.validate()
        assertTrue team1.player2==null

  
        assertTrue team.validate()
        def team2=generateTeam(2,"CHALLENGER",new Ladder())
        println(team2)
        assertTrue team2.validate()
        
    }

    
    void testToName() {
        assertEquals("First.Last\n&Will.Han",new Team(player1:new Player(firstName:"first",lastName:"last")
	,player2:new Player(firstName:"will",lastName:"han")).toName())
    }
    void testFlip(){
    
    }


    void testAvailableForChallenge(){
    	    

    }
}
