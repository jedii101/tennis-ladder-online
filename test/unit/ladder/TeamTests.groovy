package ladder

import grails.test.*
import BootStrap

class TeamTests extends GrailsUnitTestCase {
    Team team
    protected void setUp() {
        super.setUp()
        mockForConstraintsTests(Team)
        def p1=new Player(firstName:"first1",lastName:"last1",userName:"first1_last1")
        def p2=new Player(firstName:"first2",lastName:"last2",userName:"first2_last2")
        team=new Team(player1:p1,player2:p2,status:"DEFENDER",ladder:new Ladder())


                def genMe=this.&genLevelPosition
        def genLadder=(new LadderTests()).&genLadder
        def genLevel=(new LevelTests()).&genLevel
        Ladder mixLadder=genLadder("MIX DOUBLES",null)
        Ladder singleLadder=genLadder("SINGLES",null)
        LevelPosition lp1=genMe(1,mixLadder,genLevel(1,mixLadder,null),null)
        LevelPosition lp2=genMe(1,mixLadder,genLevel(2,mixLadder,null),null)
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
        assertEquals("First1.Last1\n&First2.Last2",team.toName())
    }
void testFlip(){
    
}


    void testAvailableForChallenge(){

    }
}
