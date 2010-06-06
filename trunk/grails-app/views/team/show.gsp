
<%@ page import="ladder.Team" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'team.label', default: 'Team')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
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
                            <td valign="top" class="name"><g:message code="team.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: teamInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.status.label" default="Status" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: teamInstance, field: "status")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.subStatus.label" default="Sub Status" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: teamInstance, field: "subStatus")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.position.label" default="Position" /></td>
                            
                            <td valign="top" class="value"><g:link controller="levelPosition" action="show" id="${teamInstance?.position?.id}">${teamInstance?.position?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.ladder.label" default="Ladder" /></td>
                            
                            <td valign="top" class="value"><g:link controller="ladder" action="show" id="${teamInstance?.ladder?.id}">${teamInstance?.ladder?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.player2.label" default="Player2" /></td>
                            
                            <td valign="top" class="value"><g:link controller="player" action="show" id="${teamInstance?.player2?.id}">${teamInstance?.player2?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.lastMatchDate.label" default="Last Match Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${teamInstance?.lastMatchDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.player1.label" default="Player1" /></td>
                            
                            <td valign="top" class="value"><g:link controller="player" action="show" id="${teamInstance?.player1?.id}">${teamInstance?.player1?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="team.shortStatus.label" default="Short Status" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: teamInstance, field: "shortStatus")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${teamInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
