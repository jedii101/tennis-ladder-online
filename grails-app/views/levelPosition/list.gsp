
<%@ page import="ladder.LevelPosition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'levelPosition.label', default: 'LevelPosition')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="list" action="list" params="[ladderFilter:'singles']"> single LevelPosition</g:link></span>
            <span class="menuButton"><g:link class="list" action="list" params="[ladderFilter:'mix doubles']"> mix double LevelPosition</g:link></span>
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
                        
                            <g:sortableColumn property="id" title="${message(code: 'levelPosition.id.label', default: 'Id')}" />
                        
                            <th><g:message code="levelPosition.team.label" default="Team" /></th>
                   	    
                            <th><g:message code="levelPosition.ladder.label" default="Ladder" /></th>
                   	    
                            <th><g:message code="levelPosition.level.label" default="Level" /></th>
                   	    
                            <g:sortableColumn property="pos" title="${message(code: 'levelPosition.pos.label', default: 'Pos')}" />
                        
                            <g:sortableColumn property="name" title="${message(code: 'levelPosition.name.label', default: 'Name')}" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${levelPositionInstanceList}" status="i" var="levelPositionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${levelPositionInstance.id}">${fieldValue(bean: levelPositionInstance, field: "id")}</g:link></td>
                        
                            <td>${fieldValue(bean: levelPositionInstance, field: "team")}</td>
                        
                            <td>${fieldValue(bean: levelPositionInstance, field: "ladder")}</td>
                        
                            <td>${fieldValue(bean: levelPositionInstance, field: "level")}</td>
                        
                            <td>${fieldValue(bean: levelPositionInstance, field: "pos")}</td>
                        
                            <td>${fieldValue(bean: levelPositionInstance, field: "name")}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${levelPositionInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
