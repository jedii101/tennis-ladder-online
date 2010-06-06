package ladder

import grails.test.*
//import BootStrap

class TeamTests extends GrailsUnitTestCase {
    Team team
    def ls
    def matchService
    def mixLadder
    protected void setUp() {
        super.setUp()
	        mockLogging(Ladder)
        mockLogging(Level)
        mockLogging(LevelPosition)
        mockLogging(Team)
        mockLogging(Player)
        mockLogging(LadderService)
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
    void testExpired(){
    Team d1=new Team(status:"DEFENDER",lastMatchDate:(new Date()-3))
    println(d1.expired())
    assertEquals(true,d1.expired())
    d1=new Team(status:"DEFENDER",lastMatchDate:(new Date()-2))
    assertEquals(false,d1.expired())
    d1=new Team(status:"BOTH",lastMatchDate:(new Date()-2))
    assertEquals(false,d1.expired())
    d1=new Team(status:"BOTH",lastMatchDate:(new Date()-4))
    assertEquals(false,d1.expired())
    d1=new Team(status:"CHALLENGER",lastMatchDate:(new Date()-3))
    assertEquals(true,d1.expired())
    }



}
