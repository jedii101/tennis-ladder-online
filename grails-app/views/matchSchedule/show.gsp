
<%@ page import="ladder.MatchSchedule" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'matchSchedule.label', default: 'MatchSchedule')}" />
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
                            <td valign="top" class="name"><g:message code="matchSchedule.id.label" default="Id" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "id")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.defaultWinner.label" default="Default Winner" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "defaultWinner")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.defaultReason.label" default="Default Reason" /></td>
                            
                            <td valign="top" class="value"><g:link controller="defaultReason" action="show" id="${matchScheduleInstance?.defaultReason?.id}">${matchScheduleInstance?.defaultReason?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.status.label" default="Status" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "status")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.comments.label" default="Comments" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "comments")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.planMatchDate.label" default="Plan Match Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${matchScheduleInstance?.planMatchDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.message.label" default="Message" /></td>
                            
                            <td valign="top" style="text-align: left;" class="value">
                                <ul>
                                <g:each in="${matchScheduleInstance.message}" var="m">
                                    <li><g:link controller="message" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
                                </g:each>
                                </ul>
                            </td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.challengerScore.label" default="Challenger Score" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "challengerScore")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.ladder.label" default="Ladder" /></td>
                            
                            <td valign="top" class="value"><g:link controller="ladder" action="show" id="${matchScheduleInstance?.ladder?.id}">${matchScheduleInstance?.ladder?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.defenderScore.label" default="Defender Score" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "defenderScore")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.matchDate.label" default="Match Date" /></td>
                            
                            <td valign="top" class="value"><g:formatDate date="${matchScheduleInstance?.matchDate}" /></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.reportBy.label" default="Report By" /></td>
                            
                            <td valign="top" class="value"><g:link controller="player" action="show" id="${matchScheduleInstance?.reportBy?.id}">${matchScheduleInstance?.reportBy?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.defender.label" default="Defender" /></td>
                            
                            <td valign="top" class="value"><g:link controller="team" action="show" id="${matchScheduleInstance?.defender?.id}">${matchScheduleInstance?.defender?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.challenger.label" default="Challenger" /></td>
                            
                            <td valign="top" class="value"><g:link controller="team" action="show" id="${matchScheduleInstance?.challenger?.id}">${matchScheduleInstance?.challenger?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.loser.label" default="Loser" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "loser")}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name"><g:message code="matchSchedule.winner.label" default="Winner" /></td>
                            
                            <td valign="top" class="value">${fieldValue(bean: matchScheduleInstance, field: "winner")}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <g:hiddenField name="id" value="${matchScheduleInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>
                    <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
