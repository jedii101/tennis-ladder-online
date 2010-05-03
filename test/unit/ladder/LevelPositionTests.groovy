package ladder

import grails.test.*

class LevelPositionTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockForConstraintsTests(LevelPosition)
    }

    protected void tearDown() {
        super.tearDown()
    }

    def genLevelPosition={int _pos,Ladder _ladder,Level _level,Team _team->
        return new LevelPosition(pos:_pos,ladder:_ladder,level:_level,team:_team)
    }
    public void testSave(){
	    def testLevelPosition = []
        mockDomain(LevelPosition, testLevelPosition)
	 def lp1=new LevelPosition(pos:99)
	 lp1.save()
	  def lp=LevelPosition.findAll()
	 println("lp:${lp}")
    }

    public void testCompare(){
        def genMe=this.&genLevelPosition
        def genLadder=(new LadderTests()).&genLadder
        def genLevel=(new LevelTests()).&genLevel
        Ladder mixLadder=genLadder("MIX DOUBLES",null)
        Ladder singleLadder=genLadder("SINGLES",null)
        LevelPosition lp1=genMe(1,mixLadder,genLevel(1,mixLadder,null),null)
        LevelPosition lp2=genMe(1,mixLadder,genLevel(2,mixLadder,null),null)
        LevelPosition lp3=genMe(1,singleLadder,genLevel(1,singleLadder,null),null)
        assertEquals(-1,lp1.compareTo(lp2))
        assertEquals(1,lp2.compareTo(lp1))
        try{
            assertEquals(0,lp1.compareTo(lp3))
            fail("exception expected!")
        }catch(Exception e){

        }
    }
}
