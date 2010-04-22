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
    }

    protected void tearDown() {
        super.tearDown()
    }
void testValidate() {
  
  def team1 = new Team()
  assertFalse team1.validate()
  assertTrue team1.player2==null

  
  assertTrue team.validate()
  assertEquals("First1.Last1\n&First2.Last2",team.toName())
}

    
    void testToName() {

    }
}
