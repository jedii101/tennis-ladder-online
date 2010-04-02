

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Player</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Player List</g:link></span>
        </div>
        <div class="body">
            <h1>Register</h1>
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
                                    <input type="text" id="firstName" name="firstName" value="${fieldValue(bean:playerInstance,field:'firstName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastName">Last Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'lastName','errors')}">
                                    <input type="text" id="lastName" name="lastName" value="${fieldValue(bean:playerInstance,field:'lastName')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="userName">User Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'userName','errors')}">
                                    <input type="text" id="userName" name="userName" value="${fieldValue(bean:playerInstance,field:'userName')}"/>
                                </td>
                            </tr> 
                        

                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="email">Email:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'email','errors')}">
                                    <input type="text" id="email" name="email" value="${fieldValue(bean:playerInstance,field:'email')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="phone">Phone:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'phone','errors')}">
                                    <input type="text" id="phone" name="phone" value="${fieldValue(bean:playerInstance,field:'phone')}"/>
                                </td>
                            </tr> 

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="password">Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'password','errors')}">
                                    <input type="text" id="password" name="password" value="${fieldValue(bean:playerInstance,field:'password')}"/>
                                </td>
                            </tr>

                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="confirmPassword">Confirm Password:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'confirmPassword','errors')}">
                                    <input type="text" name="confirmPassword" id="confirmPassword" value="${fieldValue(bean:playerInstance,field:'confirmPassword')}" />
                                </td>
                            </tr> 



                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:${fieldValue(bean:playerInstance,field:'name')}</label>
                                </td>
                                <td>
                                </td>
                            </tr> 
                        
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
