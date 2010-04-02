<html>
	<head>
		<title>Welcome to Stephen Leacock Tennis Ladder Championship</title>
		<meta name="layout" content="main" />
	</head>
	<body>
            <div class="body">
            <g:if test="${flash.message}">
                    <div class="message">
                            ${flash.message}
                    </div>
            </g:if>
            <p>
                    Welcome to Stephen Leacock Tennis Ladder Championship Online
            </p>
            <g:form controller="login" action="handleLogin">

              <div class="dialog">
                  <table>
                      <tbody>

                          <tr class='prop'>
                          <td valign='top' class='nameClear'>
                             <label for="login">Login:</label>
                          </td>
                          <td valign='top' class='valueClear ${hasErrors(bean:user,field:'userName','errors')}'>
                             <input type="text" name="userName" />
                          </td>
                       </tr>
                       <tr class='prop'>
                          <td valign='top' class='nameClear'>
                             <label for="password">Password:</label>
                          </td>
                          <td valign='top' class='valueClear ${hasErrors(bean:user,field:'password','errors')}'>
                             <input type="password" name="password" />
                          </td>
                       </tr>

                      </tbody>
                   </table>
              </div>
              <div class="buttons">
                  <span class="button"><input class="save" type="submit" value="Login"></span>
              </div>
            </g:form>
            </div>
	</body>
</html>
