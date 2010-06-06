package ladder

import grails.test.*

class PlayerTests extends GrailsUnitTestCase {
    protected void setUp() {
        
        super.setUp()
        mockForConstraintsTests(Player)
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

    void testValidate() {
        def player1=generatePlayer("one",1)
        println(player1)
        assertTrue player1.validate()
	
	player1=new Player(firstName:"one",lastName:"tow")

        assertFalse player1.validate()

    }

     def generatePlayer={String prefix,int i->
        def p1=new Player(firstName:"${prefix}first${i}",lastName:"${prefix}last${i}"
	,userName:"${prefix}first${i}_${prefix}last${i}",email:"will.han@gmail.com",phone:"4165538722",password:"bcd",authorities:"ROLE_USER")
        return p1
    }
}
