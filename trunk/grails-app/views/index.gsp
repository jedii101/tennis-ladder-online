<html>
    <head>
        <title>Welcome to Stephen Leacock Tennis Ladder championship</title>
		<meta name="layout" content="main" />
    </head>
    <body>
        <h1 style="margin-left:20px;">Welcome to Stephen Leacock Tennis Ladder championship</h1>
        <p style="margin-left:20px;width:80%">This championship opens limited to Stephen Leacock Members only,please login or register</p>
        <div class="dialog" style="margin-left:20px;width:60%;">
            <ul>
              <g:each var="c" in="${grailsApplication.controllerClasses}">
                    <li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>
              </g:each>
            </ul>
        </div>
    </body>
</html>