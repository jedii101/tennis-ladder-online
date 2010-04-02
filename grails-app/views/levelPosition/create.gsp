

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create LevelPosition</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list" id="1">single List</g:link></span>
            <span class="menuButton"><g:link class="list" action="list" id="2">mix double List</g:link></span>
        </div>
        <div class="body">
            <h1>Create LevelPosition</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${levelPositionInstance}">
            <div class="errors">
                <g:renderErrors bean="${levelPositionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ladder">Ladder:${flash.ladder}</label>
                                </td>

                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="level">Level:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelPositionInstance,field:'level','errors')}">
                                    <g:select optionKey="id" from="${Level.findAllByLadder(flash.ladder)}" name="level.id" value="${levelPositionInstance?.level?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pos">Pos:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelPositionInstance,field:'pos','errors')}">
                                    <input type="text" id="pos" name="pos" value="${fieldValue(bean:levelPositionInstance,field:'pos')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="team">Team:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelPositionInstance,field:'team','errors')}">
                                    <g:select optionKey="id" from="${Team.findAllByLadder(flash.ladder)}" name="team.id" value="${levelPositionInstance?.team?.id}" ></g:select>
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
