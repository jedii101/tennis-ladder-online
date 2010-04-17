

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Player</title>         
    </head>
    <body>
        <div class="nav">
          <g:isLoggedIn>
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Player List</g:link></span>
          </g:isLoggedIn>
        </div>
        <div class="body">
            <h1>Create Player:${fieldValue(bean:playerInstance,field:'name')}<br> </h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${playerInstance}">
            <div class="errors">
                <g:renderErrors bean="${playerInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="firstName">First Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'firstName','errors')}">
                                    <input size="20" maxlength="20" type="text" id="firstName" name="firstName" value="${fieldValue(bean:playerInstance,field:'firstName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastName">Last Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'lastName','errors')}">
                                    <input size="20" maxlength="20"  type="text" id="lastName" name="lastName" value="${fieldValue(bean:playerInstance,field:'lastName')}"/>
                                </td>
                            </tr> 
                        
                                                      <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastName">User ID:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'lastName','errors')}">
                                    ${fieldValue(bean:playerInstance,field:'userName')}
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email">Email:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'email','errors')}">
                                    <input size="50" maxlength="50" type="text" id="email" name="email" value="${fieldValue(bean:playerInstance,field:'email')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="phone">Phone:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'phone','errors')}">
                                  <input type="text" id="phone" name="phone" size="10" maxlength="10" value="${fieldValue(bean:playerInstance,field:'phone')}"/>
                                </td>
                            </tr> 
                        
                           
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="description">Description:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'description','errors')}">
                                    <input size="50" maxlength="50"  type="text" id="description" name="description" value="${fieldValue(bean:playerInstance,field:'description')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password">Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'password','errors')}">
                                    <input size="20" maxlength="20"  type="text" id="password" name="password" value="${fieldValue(bean:playerInstance,field:'password')}"/>
                                </td>
                            </tr> 
                        
                            
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pass">Password confirm:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'pass','errors')}">
                                    <input size="20" maxlength="20"  type="text" name="pass" id="pass" value="${fieldValue(bean:playerInstance,field:'pass')}" />
                                </td>
                            </tr> 
                        <g:ifAnyGranted role="ROLE_ADMIN">
					<g:each in="${authorityList}">
					<tr>
						<td valign="top" class="name" align="left">${it.authority.encodeAsHTML()}</td>
						<td align="left"><g:checkBox name="${it.authority}"/></td>
					</tr>
					</g:each>
                        </g:ifAnyGranted>
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
