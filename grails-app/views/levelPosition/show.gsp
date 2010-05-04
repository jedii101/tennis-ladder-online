
<%@ page import="ladder.LevelPosition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'levelPosition.label', default: 'LevelPosition')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="levelPosition.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: levelPositionInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="levelPosition.team.label" default="Team" /></td>
                            
                            <td valign="top" class="value"><g:link controller="team" action="show" id="${levelPositionInstance?.team?.id}">${levelPositionInstance?.team?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="levelPosition.ladder.label" default="Ladder" /></td>
                            
                            <td valign="top" class="value"><g:link controller="ladder" action="show" id="${levelPositionInstance?.ladder?.id}">${levelPositionInstance?.ladder?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="levelPosition.level.label" default="Level" /></td>
                            
                            <td valign="top" class="value"><g:link controller="level" action="show" id="${levelPositionInstance?.level?.id}">${levelPositionInstance?.level?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="levelPosition.pos.label" default="Pos" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: levelPositionInstance, field: "pos")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="levelPosition.name.label" default="Name" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: levelPositionInstance, field: "name")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${levelPositionInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
