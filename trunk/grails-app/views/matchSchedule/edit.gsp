
<%@ page import="ladder.MatchSchedule" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'matchSchedule.label', default: 'MatchSchedule')}" />
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
            <g:hasErrors bean="${matchScheduleInstance}">
            <div class="errors">
                <g:renderErrors bean="${matchScheduleInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <g:hiddenField name="id" value="${matchScheduleInstance?.id}" />
                <g:hiddenField name="version" value="${matchScheduleInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="defaultWinner"><g:message code="matchSchedule.defaultWinner.label" default="Default Winner" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'defaultWinner', 'errors')}">
                                    <g:select name="defaultWinner" from="${matchScheduleInstance.constraints.defaultWinner.inList}" value="${matchScheduleInstance?.defaultWinner}" valueMessagePrefix="matchSchedule.defaultWinner" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="defaultReason"><g:message code="matchSchedule.defaultReason.label" default="Default Reason" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'defaultReason', 'errors')}">
                                    <g:select name="defaultReason.id" from="${ladder.DefaultReason.list()}" optionKey="id" value="${matchScheduleInstance?.defaultReason?.id}" noSelection="['null': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="status"><g:message code="matchSchedule.status.label" default="Status" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'status', 'errors')}">
                                    <g:select name="status" from="${matchScheduleInstance.constraints.status.inList}" value="${matchScheduleInstance?.status}" valueMessagePrefix="matchSchedule.status"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="comments"><g:message code="matchSchedule.comments.label" default="Comments" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'comments', 'errors')}">
                                    <g:textField name="comments" maxlength="50" value="${matchScheduleInstance?.comments}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="planMatchDate"><g:message code="matchSchedule.planMatchDate.label" default="Plan Match Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'planMatchDate', 'errors')}">
                                    <g:datePicker name="planMatchDate" precision="day" value="${matchScheduleInstance?.planMatchDate}" noSelection="['': '']" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="message"><g:message code="matchSchedule.message.label" default="Message" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'message', 'errors')}">
                                    
<ul>
<g:each in="${matchScheduleInstance?.message?}" var="m">
    <li><g:link controller="message" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="message" action="create" params="['matchSchedule.id': matchScheduleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'message.label', default: 'Message')])}</g:link>

                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="challengerScore"><g:message code="matchSchedule.challengerScore.label" default="Challenger Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'challengerScore', 'errors')}">
                                    <g:textField name="challengerScore" value="${fieldValue(bean: matchScheduleInstance, field: 'challengerScore')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="ladder"><g:message code="matchSchedule.ladder.label" default="Ladder" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'ladder', 'errors')}">
                                    <g:select name="ladder.id" from="${ladder.Ladder.list()}" optionKey="id" value="${matchScheduleInstance?.ladder?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="defenderScore"><g:message code="matchSchedule.defenderScore.label" default="Defender Score" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'defenderScore', 'errors')}">
                                    <g:textField name="defenderScore" value="${fieldValue(bean: matchScheduleInstance, field: 'defenderScore')}" />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="matchDate"><g:message code="matchSchedule.matchDate.label" default="Match Date" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'matchDate', 'errors')}">
                                    <g:datePicker name="matchDate" precision="day" value="${matchScheduleInstance?.matchDate}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="reportBy"><g:message code="matchSchedule.reportBy.label" default="Report By" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'reportBy', 'errors')}">
                                    <g:select name="reportBy.id" from="${ladder.Player.list()}" optionKey="id" value="${matchScheduleInstance?.reportBy?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="defender"><g:message code="matchSchedule.defender.label" default="Defender" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'defender', 'errors')}">
                                    <g:select name="defender.id" from="${ladder.Team.list()}" optionKey="id" value="${matchScheduleInstance?.defender?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="challenger"><g:message code="matchSchedule.challenger.label" default="Challenger" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'challenger', 'errors')}">
                                    <g:select name="challenger.id" from="${ladder.Team.list()}" optionKey="id" value="${matchScheduleInstance?.challenger?.id}"  />
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="loser"><g:message code="matchSchedule.loser.label" default="Loser" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'loser', 'errors')}">
                                    
                                </td>
                            </tr>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                  <label for="winner"><g:message code="matchSchedule.winner.label" default="Winner" /></label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'winner', 'errors')}">
                                    
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
