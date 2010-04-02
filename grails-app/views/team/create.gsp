

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Team</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Team List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Team</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${teamInstance}">
            <div class="errors">
                <g:renderErrors bean="${teamInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status">Status:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamInstance,field:'status','errors')}">
                                    <g:select id="status" name="status" from="${teamInstance.constraints.status.inList}" value="${teamInstance.status}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ladder">Ladder:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamInstance,field:'ladder','errors')}">
                                    <g:select optionKey="id" from="${Ladder.list()}" name="ladder.id" value="${teamInstance?.ladder?.id}" noSelection="['2':'mix']"></g:select>
                                </td>
                            </tr> 
                        
          
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="player1">Player1:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamInstance,field:'player1','errors')}">
                                    <g:select optionKey="id" from="${Player.list()}" name="player1.id" value="${teamInstance?.player1?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="player2">Player2:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:teamInstance,field:'player2','errors')}">
                                    <g:select optionKey="id" from="${Player.list()}" name="player2.id" value="${teamInstance?.player2?.id}" noSelection="['':'-N/A-']"></g:select>
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
