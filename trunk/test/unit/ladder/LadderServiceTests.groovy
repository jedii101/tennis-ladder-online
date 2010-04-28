package ladder

import grails.test.*

class LadderServiceTests extends GrailsUnitTestCase {
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateLadder() {
    	def testLadder = []
        mockDomain(Ladder, testLadder)
        def testLevel = []
        mockDomain(Level, testLevel)
        def testLevelPosition = []
        mockDomain(LevelPosition, testLevelPosition)
        def ls=new LadderService()
        def mixLadder=ls.createLadder("mix double",1,2,3)
        println(mixLadder)
        assertNotNull(mixLadder)

    }
}
