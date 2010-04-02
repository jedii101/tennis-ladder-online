

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>MatchSchedule List</title>
  </head>
  <body>
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
      <span class="menuButton"><g:link class="create" action="create">New MatchSchedule</g:link></span>
    </div>
    <div class="body">
      <h1>MatchSchedule List</h1>
      <g:if test="${flash.message}">
        <div class="message">${flash.message}</div>
      </g:if>
      <div class="list">
        <table>
          <thead>
            <tr>

              <g:sortableColumn property="id" title="Id" />
              <g:sortableColumn property="matchDate" title="Date" />
              <g:sortableColumn property="challenger" title="Challenger" />
              <g:sortableColumn property="challegerScore" title="score" />
              <g:sortableColumn property="defender" title="Defender" />
              <g:sortableColumn property="defenderScore" title="score" />
              <th>Default Reason</th>

              <g:sortableColumn property="defaultWinner" title="Default Winner" />

              <g:sortableColumn property="comments" title="Comments" />



            </tr>
          </thead>
          <tbody>
            <g:each in="${matchScheduleInstanceList}" status="i" var="matchScheduleInstance">
              <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                <td><g:link action="show" id="${matchScheduleInstance.id}">${fieldValue(bean:matchScheduleInstance, field:'id')}</g:link></td>
                <td>${fieldValue(bean:matchScheduleInstance, field:'matchDate')}</td>
                <td>${fieldValue(bean:matchScheduleInstance, field:'challenger')}</td>
                <td>${fieldValue(bean:matchScheduleInstance, field:'challegerScore')}</td>
                <td>${fieldValue(bean:matchScheduleInstance, field:'defender')}</td>
                <td>${fieldValue(bean:matchScheduleInstance, field:'defenderScore')}</td>
                <td>${fieldValue(bean:matchScheduleInstance, field:'defaultReason')}</td>

                <td>${fieldValue(bean:matchScheduleInstance, field:'defaultWinner')}</td>

                <td>${fieldValue(bean:matchScheduleInstance, field:'comments')}</td>



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
