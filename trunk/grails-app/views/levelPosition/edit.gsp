

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit LevelPosition</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">LevelPosition List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New LevelPosition</g:link></span>
        </div>
        <div class="body">
            <h1>Edit LevelPosition</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${levelPositionInstance}">
            <div class="errors">
                <g:renderErrors bean="${levelPositionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${levelPositionInstance?.id}" />
                <input type="hidden" name="version" value="${levelPositionInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ladder">Ladder:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelPositionInstance,field:'ladder','errors')}">
                                    <g:select optionKey="id" from="${Ladder.list()}" name="ladder.id" value="${levelPositionInstance?.ladder?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="level">Level:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelPositionInstance,field:'level','errors')}">
                                    <g:select optionKey="id" from="${Level.list()}" name="level.id" value="${levelPositionInstance?.level?.id}" ></g:select>
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
                                    <g:select optionKey="id" from="${Team.list()}" name="team.id" value="${levelPositionInstance?.team?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name">Name:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelPositionInstance,field:'name','errors')}">
                                    <input type="text" name="name" id="name" value="${fieldValue(bean:levelPositionInstance,field:'name')}" />
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
