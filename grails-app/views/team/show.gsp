

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Team</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Team List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Team</g:link></span>
        </div>
        <div class="body">
            <h1>Show Team</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:teamInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Status:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:teamInstance, field:'status')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Ladder:</td>
                            
                            <td valign="top" class="value"><g:link controller="ladder" action="show" id="${teamInstance?.ladder?.id}">${teamInstance?.ladder?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
 
                    
                        <tr class="prop">
                            <td valign="top" class="name">Player1:</td>
                            
                            <td valign="top" class="value"><g:link controller="player" action="show" id="${teamInstance?.player1?.id}">${teamInstance?.player1?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Player2:</td>
                            
                            <td valign="top" class="value"><g:link controller="player" action="show" id="${teamInstance?.player2?.id}">${teamInstance?.player2?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    

                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${teamInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
