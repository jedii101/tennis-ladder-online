package ladder

import grails.test.*

class PlayerTests extends GrailsUnitTestCase {
    protected void setUp() {
        
        super.setUp()
        mockForConstraintsTests(Player)
    }

    protected void tearDown() {
        super.tearDown()
    }

    void testValidate() {
        def player1=generatePlayer("one",1)
        println(player1)
        assertFalse player1.validate()

    }

     def generatePlayer={String prefix,int i->
        def p1=new Player(firstName:"${prefix}first${1}",lastName:"${prefix}last${i}",userName:"${prefix}first${i}_${prefix}last${1}")
        return p1
    }
}
