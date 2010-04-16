

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Player</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Player List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Player</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Player</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${playerInstance}">
            <div class="errors">
                <g:renderErrors bean="${playerInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${playerInstance?.id}" />
                <input type="hidden" name="version" value="${playerInstance?.version}" />
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
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'userName','errors')}">
                                    <input type="hidden" id="userName" name="userName" value="${fieldValue(bean:playerInstance,field:'userName')}"/>
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
                                    <label for="enabled">Enabled:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'enabled','errors')}">
                                    <g:checkBox name="enabled" value="${playerInstance?.enabled}" ></g:checkBox>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="emailShow">Email Show:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'emailShow','errors')}">
                                    <g:checkBox name="emailShow" value="${playerInstance?.emailShow}" ></g:checkBox>
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
                                    <label for="authorities">Authorities:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'authorities','errors')}">
                                    <g:select name="authorities"
from="${Authority.list()}"
size="5" multiple="yes" optionKey="id"
value="${playerInstance?.authorities}" />

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'name','errors')}">
                                    <input type="text" name="name" id="name" value="${fieldValue(bean:playerInstance,field:'name')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pass">Pass:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:playerInstance,field:'pass','errors')}">
                                    <input type="text" name="pass" id="pass" value="${fieldValue(bean:playerInstance,field:'pass')}" />
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
