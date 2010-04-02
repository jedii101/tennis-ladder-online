

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Level</title>         
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Level List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Level</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${levelInstance}">
            <div class="errors">
                <g:renderErrors bean="${levelInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
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
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
