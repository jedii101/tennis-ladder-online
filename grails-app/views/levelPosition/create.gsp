
<%@ page import="ladder.LevelPosition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'levelPosition.label', default: 'LevelPosition')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
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
                                    <label for="team"><g:message code="levelPosition.team.label" default="Team" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'team', 'errors')}">
                                    <g:select name="team.id" from="${ladder.Team.list()}" optionKey="id" value="${levelPositionInstance?.team?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ladder"><g:message code="levelPosition.ladder.label" default="Ladder" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'ladder', 'errors')}">
                                    <g:select name="ladder.id" from="${ladder.Ladder.list()}" optionKey="id" value="${levelPositionInstance?.ladder?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="level"><g:message code="levelPosition.level.label" default="Level" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'level', 'errors')}">
                                    <g:select name="level.id" from="${ladder.Level.list()}" optionKey="id" value="${levelPositionInstance?.level?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="pos"><g:message code="levelPosition.pos.label" default="Pos" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'pos', 'errors')}">
                                    <g:textField name="pos" value="${fieldValue(bean: levelPositionInstance, field: 'pos')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="name"><g:message code="levelPosition.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'name', 'errors')}">
                                    <g:textField name="name" value="${levelPositionInstance?.name}" />
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
