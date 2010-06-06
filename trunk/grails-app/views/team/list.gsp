
<%@ page import="ladder.Team" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'team.label', default: 'Team')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.list.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                            <g:sortableColumn property="id" title="${message(code: 'team.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="status" title="${message(code: 'team.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="subStatus" title="${message(code: 'team.subStatus.label', default: 'Sub Status')}" />
                        
                            <th><g:message code="team.position.label" default="Position" /></th>
                   	    
                            <th><g:message code="team.ladder.label" default="Ladder" /></th>
                   	    
                            <th><g:message code="team.player2.label" default="Players" /></th>
                   	    
                            <g:sortableColumn property="lastMatchDate" title="${message(code: 'team.lastMatchDate.label', default: 'Last Match Date')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${teamInstanceList}" status="i" var="teamInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${teamInstance.id}">${fieldValue(bean: teamInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: teamInstance, field: "status")}</td>
                        
                            <td>${fieldValue(bean: teamInstance, field: "subStatus")}</td>
                        
                            <td>${fieldValue(bean: teamInstance, field: "position")}</td>
                        
                            <td>${fieldValue(bean: teamInstance, field: "ladder")}</td>
                        
                            <td>${teamInstance.toName()}</td>
                        
                            <td><g:formatDate date="${teamInstance.lastMatchDate}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${teamInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
