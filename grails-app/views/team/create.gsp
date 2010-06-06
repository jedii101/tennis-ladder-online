
<%@ page import="ladder.Team" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'team.label', default: 'Team')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></span>
            <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
        </div>
        <div class="body">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${teamInstance}">
            <div class="errors">
                <g:renderErrors bean="${teamInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="status"><g:message code="team.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${teamInstance.constraints.status.inList}" value="${teamInstance?.status}" valueMessagePrefix="team.status"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="subStatus"><g:message code="team.subStatus.label" default="Sub Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'subStatus', 'errors')}">
                                    <g:select name="subStatus" from="${teamInstance.constraints.subStatus.inList}" value="${teamInstance?.subStatus}" valueMessagePrefix="team.subStatus"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="position"><g:message code="team.position.label" default="Position" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'position', 'errors')}">
                                    <g:select name="position.id" from="${ladder.LevelPosition.list()}" optionKey="id" value="${teamInstance?.position?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="ladder"><g:message code="team.ladder.label" default="Ladder" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'ladder', 'errors')}">
                                    <g:select name="ladder.id" from="${ladder.Ladder.list()}" optionKey="id" value="${teamInstance?.ladder?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="player2"><g:message code="team.player2.label" default="Player2" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'player2', 'errors')}">
                                    <g:select name="player2.id" from="${ladder.Player.list()}" optionKey="id" value="${teamInstance?.player2?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="lastMatchDate"><g:message code="team.lastMatchDate.label" default="Last Match Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'lastMatchDate', 'errors')}">
                                    <g:datePicker name="lastMatchDate" precision="day" value="${teamInstance?.lastMatchDate}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="player1"><g:message code="team.player1.label" default="Player1" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'player1', 'errors')}">
                                    <g:select name="player1.id" from="${ladder.Player.list()}" optionKey="id" value="${teamInstance?.player1?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="shortStatus"><g:message code="team.shortStatus.label" default="Short Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: teamInstance, field: 'shortStatus', 'errors')}">
                                    <g:textField name="shortStatus" value="${teamInstance?.shortStatus}" />
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
