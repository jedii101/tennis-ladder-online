

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show LevelPosition</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">LevelPosition List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New LevelPosition</g:link></span>
        </div>
        <div class="body">
            <h1>Show LevelPosition</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:levelPositionInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ladder:</td>
                            
                            <td valign="top" class="value"><g:link controller="ladder" action="show" id="${levelPositionInstance?.ladder?.id}">${levelPositionInstance?.ladder?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Level:</td>
                            
                            <td valign="top" class="value"><g:link controller="level" action="show" id="${levelPositionInstance?.level?.id}">${levelPositionInstance?.level?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Pos:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:levelPositionInstance, field:'pos')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Team:</td>
                            
                            <td valign="top" class="value"><g:link controller="team" action="show" id="${levelPositionInstance?.team?.id}">${levelPositionInstance?.team?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Name:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:levelPositionInstance, field:'name')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${levelPositionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
