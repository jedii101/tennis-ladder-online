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
        def ls=new LadderService()
        def mixLadder=ls.createLadder("mix double",1,2,3)
        println(mixLadder)
        assertNotNull(mixLadder)

    }
}
