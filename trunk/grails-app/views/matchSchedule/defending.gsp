
<%@ page import="ladder.MatchSchedule" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  <g:set var="entityName" value="${message(code: 'matchSchedule.label', default: 'Defending Report')}" />
  <title><g:message code="default.create.label" args="[entityName]" /></title>
</head>
<body>

  <div class="body">
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${matchScheduleInstance}">
      <div class="errors">
        <g:renderErrors bean="${matchScheduleInstance}" as="list" />
      </div>
    </g:hasErrors>
    <g:form action="saveDefending" method="post" useToken="true" >
      <g:hiddenField name="defender.id" value="${matchScheduleInstance?.defender?.id}" />
      <g:hiddenField name="status" value="${matchScheduleInstance?.status}" />
      <g:hiddenField name="reportBy.id" value="${matchScheduleInstance?.reportBy?.id}" />
      <g:hiddenField name="ladder.id" value="${matchScheduleInstance?.ladder?.id}" />
      <div class="dialog">
        
        <table>
          <tbody>

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
              <label for="defender"><g:message code="matchSchedule.defender.label" default="Defender" /></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'defender', 'errors')}">
          <g:select name="defender.id" from="${ladder.Team.list()}" optionKey="id" value="${matchScheduleInstance?.defender?.id}" disabled="true" />
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
              <label for="challenger"><g:message code="matchSchedule.challenger.label" default="Challenger" /></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'challenger', 'errors')}">
          <g:select name="challenger.id" from="${challengers}" optionKey="id" value="${matchScheduleInstance?.challenger?.id}"  />
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
              <label for="reportBy"><g:message code="matchSchedule.reportBy.label" default="Report By" /></label>
            </td>
            <td valign="top" class="value ${hasErrors(bean: matchScheduleInstance, field: 'reportBy', 'errors')}">
          <g:select name="reportBy.id" from="${ladder.Player.list()}" optionKey="id" value="${matchScheduleInstance?.reportBy?.id}"  disabled="true" />
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
             <hr size = 5 width=100% align="left" color="red">
            Only fill in following when default happens!
           </td>
          </tr>
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




          </tbody>
        </table>
      </div>
      <div class="buttons">
        <span class="button"><g:submitButton name="report" class="saveChallenge" value="${message(code: 'default.button.create.label', default: 'Report')}" /></span>
      </div>
    </g:form>
  </div>
</body>
</html>