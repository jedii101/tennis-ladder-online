

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Player</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Player List</g:link></span>
            <g:ifAnyGranted role="ROLE_ADMIN">
            <span class="menuButton"><g:link class="create" action="create">New Player</g:link></span>
            </g:ifAnyGranted>

        </div>
        <div class="body">
            <h1>Show Player</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">First Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'firstName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Last Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'lastName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">User Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'userName')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Email:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'email')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Phone:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'phone')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Enabled:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'enabled')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Email Show:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'emailShow')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Description:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'description')}</td>
                            
                        </tr>
                    

                    
                        <tr class="prop">
                            <td valign="top" class="name">Roles:</td>
                            
                            <td  valign="top" style="text-align:left;" class="value">
                                <ul>
                                <g:each var="a" in="${playerInstance.authorities}">
                                    <li>${playerInstance?.authorities?.authority}</li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:playerInstance, field:'name')}</td>
                            
                        </tr>
                    

                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                  <g:ifAnyGranted role="ROLE_ADMIN">
                  <input type="hidden" name="id" value="${playerInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                    </g:ifAnyGranted>
                </g:form>
            </div>
        </div>
    </body>
</html>
