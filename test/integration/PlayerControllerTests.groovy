class PlayerControllerTests extends GroovyTestCase {

	Player user
    PlayerController uc

    void setUp() {
      // Save a Player
      user = new Player(userName:"Player1", firstName:"Player1FN", 
          lastName:"Player1LN",password:"123")
      user.save()
      println("@@ user saved:"+user)

      // Setup Player Controller
      uc = new PlayerController()
    }

    void tearDown() {
	    user.delete()
	}

   /**
   * Test the PlayerController.handleLogin action.
   *
   * If the login succeeds, it will put the user object into the session.
   */
   void testHandleLogin() {

     // Setup controller parameters
     uc.params.userName = user.userName

     // Call the action
     uc.handleLogin()

     // If action functioned correctly, it put a user object
     // into the session
     def sessPlayer = uc.session.user
     assert sessPlayer
     assertEquals("Expected ids to match", user.id, sessPlayer.id)
     // And the user was redirected to the Todo Page
     assertEquals "/level", uc.response.redirectedUrl
   }

   /**
   * Test the PlayerController.handleLogin action.
   *
   * If the login fails, it will redirect to login and set a flash message.
   */
     void testHandleLoginInvalidPlayer() {
     // Setup controller parameters
     uc.params.userName = "INVALID_USER_NAME"

     // Call the action
     uc.handleLogin()
     assertEquals "/player/login", uc.response.redirectedUrl
     def message = uc.flash.message
     assert message
     assert message.startsWith("Player not found")
   }

   /**
   * Test the PlayerController.login action
   *
   * If the logout action succeeds, it will remove the user object from
   * the session.
   */
   void testLogout() {
     // make it look like user is logged in
     uc.session.user = user

     uc.logout()
     def sessPlayer = uc.session.user
     assertNull("Expected session user to be null", sessPlayer)
     assertEquals "/player/login", uc.response.redirectedUrl
   }
}
