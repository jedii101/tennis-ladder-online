

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Ladder List</title>
  </head>
  <body>
  <g:ifAnyGranted role="ROLE_ADMIN">
    <div class="nav">
      <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
      <span class="menuButton"><g:link class="create" action="create">New Level</g:link></span>
    </div>
  </g:ifAnyGranted>
  <div class="body">
    <h1>Ladder standing: On ${new Date()}</h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <g:if test="${flash.error}">
      <div class="errors">${flash.error}</div>
    </g:if>
    <div class="list">
      <th width="250"><br> Teams/players in:<br>
        <b class="CHALLENGER">Red(+)</b> are challengers;
        <br><b class="DEFENDER">Green(-)</b> are defenders,
        <p><b class="BOTH">Blue(?)</b> are special defenders can challenge above if no challenge recieved<p>
        <p><b>Challengers pls feel free to challenge defenders one level above you.<b><p>&nbsp;</th>
                </div>
              <div class="list">
                <table>
                  <thead>
                    <tr>
                      <th>Single Ladder
                      </th>

                    </tr>
                  </thead>
                  <tbody>
                  <g:if test="${true==singleChallenge}">

                    <tr>
                    <span class="menuButton"><g:link controller="matchSchedule" class="create" action="challenging" params='[ladderName:"singles"]'>report challenge</g:link></span>
                    </tr>
                  </g:if>
                  <g:if test="${singleDefending}">

                    <tr>
                    <span class="menuButton"><g:link controller="matchSchedule" class="create" action="defending" params='[ladderName:"singles"]'>report defending</g:link></span>
                    </tr>
                  </g:if>
                  <g:each sort="true" in="${flash.singleLevels}" status="i" var="levelInstance">
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">


                      <td>
                    <nobr>
                      <g:each sort="true" in="${levelInstance.levelposition}" status="j" var="posInstance">
                        <span class="${posInstance.team?.status}">
${fieldValue(bean:posInstance, field:'team')}${posInstance.team?.shortStatus}
                        </span>
                      </g:each>
                    </nobr>
                    </td>





                    </tr>
                  </g:each>
                  </tbody>
                </table>
              </div>
              <div class="paginateButtons">
                <g:paginate total="${flash.singleLevels.size}" />
              </div>
              <br><br>
              <div class="list">
                <table>
                  <thead>
                    <tr>



                      <th>Mix Doubles Ladder</th>






                    </tr>
                  </thead>
                  <tbody>
                  <g:if test="${mixChallenge}">
                    <tr>
                    <span class="menuButton"><g:link controller="matchSchedule" class="create" action="challenging" params='[ladderName:"mix doubles"]'>report challenge</g:link></span>
                    </tr>
                  </g:if>
                  <g:if test="${mixDefending}">
                    <tr>
                    <span class="menuButton"><g:link controller="matchSchedule" class="create" action="defending" params='[ladderName:"mix doubles"]'>report defending</g:link></span>
                    </tr>
                  </g:if>
                  <g:each sort="true" in="${flash.doubleLevels}" status="i" var="levelInstance">
                    <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">


                      <td>
                    <nobr>
                      <g:each sort="true" in="${levelInstance.levelposition}" status="j" var="posInstance">
                        <span class="${posInstance.team?.status}">
${fieldValue(bean:posInstance, field:'team')}${posInstance.team?.shortStatus}
                        </span>
                      </g:each>
                    </nobr>
                    </td>





                    </tr>
                  </g:each>
                  </tbody>
                </table>
              </div>
              <div class="paginateButtons">
                <g:paginate total="${flash.singleLevels.size}" />
              </div>

              </div>
              </body>
              </html>
