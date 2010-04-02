<div id="menu">
  <nobr>
    <g:if test="${session.player}">
      <b>${session.player?.firstName} ${session.player?.lastName}</b> |
      <g:link controller="player" action="logout"><g:message code="topbar.logout" /></g:link>
    </g:if>
    <g:else>
      <g:link controller="player" action="login">
        <g:message code="topbar.login" /></g:link>
      <br>
      <g:link controller="player" action="signup">
        <g:message code="topbar.signup" /></g:link>
    </g:else>


  </nobr>
</div>
