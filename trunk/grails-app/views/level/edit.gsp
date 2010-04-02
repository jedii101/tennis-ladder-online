

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Level</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Level List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Level</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Level</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${levelInstance}">
            <div class="errors">
                <g:renderErrors bean="${levelInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${levelInstance?.id}" />
                <input type="hidden" name="version" value="${levelInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="levelposition">Levelposition:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelInstance,field:'levelposition','errors')}">
                                    
<ul>
<g:each var="l" in="${levelInstance?.levelposition?}">
    <li><g:link controller="levelPosition" action="show" id="${l.id}">${l?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="levelPosition" params="['level.id':levelInstance?.id]" action="create">Add LevelPosition</g:link>

                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ladder">Ladder:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelInstance,field:'ladder','errors')}">
                                    <g:select optionKey="id" from="${Ladder.list()}" name="ladder.id" value="${levelInstance?.ladder?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="level">Level:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:levelInstance,field:'level','errors')}">
                                    <input type="text" id="level" name="level" value="${fieldValue(bean:levelInstance,field:'level')}" />
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
