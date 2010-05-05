
<%@ page import="ladder.MatchSchedule" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'matchSchedule.label', default: 'MatchSchedule')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'matchSchedule.id.label', default: 'Id')}" />
                        
                            <g:sortableColumn property="defaultWinner" title="${message(code: 'matchSchedule.defaultWinner.label', default: 'Default Winner')}" />
                        
                            <th><g:message code="matchSchedule.defaultReason.label" default="Default Reason" /></th>
                   	    
                            <g:sortableColumn property="status" title="${message(code: 'matchSchedule.status.label', default: 'Status')}" />
                        
                            <g:sortableColumn property="comments" title="${message(code: 'matchSchedule.comments.label', default: 'Comments')}" />
                        
                            <g:sortableColumn property="planMatchDate" title="${message(code: 'matchSchedule.planMatchDate.label', default: 'Plan Match Date')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${matchScheduleInstanceList}" status="i" var="matchScheduleInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${matchScheduleInstance.id}">${fieldValue(bean: matchScheduleInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: matchScheduleInstance, field: "defaultWinner")}</td>
                        
                            <td>${fieldValue(bean: matchScheduleInstance, field: "defaultReason")}</td>
                        
                            <td>${fieldValue(bean: matchScheduleInstance, field: "status")}</td>
                        
                            <td>${fieldValue(bean: matchScheduleInstance, field: "comments")}</td>
                        
                            <td><g:formatDate date="${matchScheduleInstance.planMatchDate}" /></td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${matchScheduleInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
