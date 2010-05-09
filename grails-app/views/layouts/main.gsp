<%! import ladder.* %> 
<html>
  <head>
    <title><g:layoutTitle default="Grails" /></title>
    <link rel="stylesheet" href="${createLinkTo(dir:'css',file:'main.css')}" />
    <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <g:layoutHead />
  <g:javascript library="application" />
</head>
<body>
  <div id="page">
    <div id="spinner" class="spinner" style="display:none;">
      <img src="${createLinkTo(dir:'images',file:'spinner.gif')}" alt="Spinner" />
    </div>
    <div id="topbar">
      <g:render template="/common/topbar" />
    </div>

    <div id="header">
      <h1>Stephen Leacock Tennis Ladder Championship</h1>
    </div>
    <g:ifAnyGranted role="ROLE_ADMIN,ROLE_USER">
      <div class="nav">

        <span class="menuButton"><a class="home" href="${createLink(uri: '/level/list')}">Ladder Standing</a></span>
        <span class="menuButton"><a class="list"   href="${createLink(uri: '/player/list')}">Player List</a></span>
        <span class="menuButton"><a class="list"   href="${createLink(uri: '/message/list')}">Recend Messages</a></span>
        <span class="menuButton"><a class="rules"   href="${createLink(uri: '/info/rules.html')}">Rules</a></span>
        <span class="menuButton"><a class="help"   href="${createLink(uri: '/info/help')}">Help</a></span>

      </div>
    </g:ifAnyGranted>
    <div id="content">
      <g:layoutBody />
    </div>
    <div id="footer">
      <g:render template="/common/footer" />
    </div>
  </div>
</body>	
</html>