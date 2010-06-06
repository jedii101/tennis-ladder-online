package ladder

import grails.test.*

class LadderTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
        mockForConstraintsTests(Ladder)
                mockLogging(Ladder)
        mockLogging(Level)
        mockLogging(LevelPosition)
        mockLogging(Team)
        mockLogging(Player)
        mockLogging(LadderService)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testSomething() {

    }

    def genLadder={String _name,List _levels->
        return new Ladder(name:_name,levels:_levels)
    }

    void testGenLadder(){
        assertNotNull(genLadder(null,null))
        assertNotNull(genLadder("mix ladder",null))
        println(genLadder("mix ladder",null))
    }
}
