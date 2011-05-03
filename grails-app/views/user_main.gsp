<html>
  <head>
    <title>Welcome to Stephen Leacock Tennis Ladder championship</title>
    <meta name="layout" content="main" />
  </head>
  <body>
    <h1 style="margin-left:20px;">Welcome to Stephen Leacock Tennis Ladder championship 2011</h1>
    <br>
    This championship opens limited to Stephen Leacock Members only,please login or register
    <br>
      <div class="dialog" style="margin-left:20px;width:60%;">
    <ul>

  <g:if test="${session.player}">
    <b>${session.player?.firstName} ${session.player?.lastName}</b> |
    <g:link controller="player" action="logout"><g:message code="topbar.logout" /></g:link>
  </g:if>
  <g:else>
    <g:isLoggedIn>
      <g:link controller="logout" action="index" >
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
    </ul></div>
    <br><br><br><br>

  <div class="dialog" style="margin-left:20px;width:60%;">
    <ul>
      <img src="${createLinkTo(dir:'images',file:'ladder_2010.png')}" alt="HTML tutorial" width="700" height="500" />
    </ul>
  </div>
</body>
</html>