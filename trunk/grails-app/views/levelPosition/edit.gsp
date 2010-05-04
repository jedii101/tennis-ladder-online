
<%@ page import="ladder.LevelPosition" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'levelPosition.label', default: 'LevelPosition')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
            <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${levelPositionInstance}">
            <div class="errors">
                <g:renderErrors bean="${levelPositionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${levelPositionInstance?.id}" />
                <g:hiddenField name="version" value="${levelPositionInstance?.version}" />
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
                                    ${levelPositionInstance?.ladder?.info()}"
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="level"><g:message code="levelPosition.level.label" default="Level" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'level', 'errors')}">
                                    ${levelPositionInstance?.level?.lev}"
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="pos"><g:message code="levelPosition.pos.label" default="Pos" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'pos', 'errors')}">
                                    ${fieldValue(bean: levelPositionInstance, field: 'pos')}
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="name"><g:message code="levelPosition.name.label" default="Name" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: levelPositionInstance, field: 'name', 'errors')}">
                                    ${levelPositionInstance?.name}
                                </td>
                            </tr>
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
