package ladder

import grails.test.*

class LevelTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockForConstraintsTests(Level)
    }

    protected void tearDown() {
        super.tearDown()
    }

    def genLevel={int _level,Ladder _ladder,SortedSet _levelPositions->
        return new Level(level:_level,ladder:_ladder,levelposition:_levelPositions)
    }

    public void testCompare(){
        def genLadder=(new LadderTests()).&genLadder
        def l1=genLevel(1,genLadder("mix doubles",null),null)
        def l2=genLevel(2,genLadder("mix doubles",null),null)
        def l3=genLevel(1,genLadder("singles",null),null)
        assertEquals(-1,l1.compareTo(l2
            ))
        assertEquals(1,l2.compareTo(l1))
        try{
            l1.compareTo(l3)
            fail("exception is expected")
        }catch(Exception e){

        }
        
        //        assertEquals(0,l1.compareTo(l3))
    }
}
