<div id="menu">
  <nobr>
    <g:if test="${session.player}">
      <b>${session.player?.firstName} ${session.player?.lastName}</b> |
      <g:link controller="player" action="logout"><g:message code="topbar.logout" /></g:link>
    </g:if>
    <g:else>
      <g:isLoggedIn>
         <g:link controller="logout" action="index">
        <g:message code="topbar.logout" /></g:link>
      <br>
      </g:isLoggedIn>
      <g:isNotLoggedIn>
      <g:link controller="login" action="auth">
        <g:message code="topbar.login" /></g:link>
      <br>
            <g:link controller="player" action="create">
        <g:message code="topbar.signup" /></g:link>
      </g:isNotLoggedIn>
    </g:else>


  </nobr>
</div>
