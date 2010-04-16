

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Player List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'/message/list')}">Home</a></span>
            <g:ifAnyGranted role="ROLE_ADMIN">
            <span class="menuButton"><g:link class="create" action="create">New Player</g:link></span>
            </g:ifAnyGranted>
        </div>
        <div class="body">
            <h1>Player List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        <g:ifAnyGranted role="ROLE_ADMIN">
                   	        <g:sortableColumn property="id" title="Id" />
                        </g:ifAnyGranted>
                   	        <g:sortableColumn property="firstName" title="First Name" />
                        
                   	        <g:sortableColumn property="lastName" title="Last Name" />
                        
                   	        <g:sortableColumn property="userName" title="User Name" />
                        
                   	        <g:sortableColumn property="email" title="Email" />
                        
                   	        <g:sortableColumn property="phone" title="Phone" />
							<g:sortableColumn property="enabled" title="Enabled" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${playerInstanceList}" status="i" var="playerInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        <g:ifAnyGranted role="ROLE_ADMIN">
                            <td><g:link action="show" id="${playerInstance.id}">${fieldValue(bean:playerInstance, field:'id')}</g:link></td>
                        </g:ifAnyGranted>
                            <td>${fieldValue(bean:playerInstance, field:'firstName')}</td>
                        
                            <td>${fieldValue(bean:playerInstance, field:'lastName')}</td>
                        
                            <td>${fieldValue(bean:playerInstance, field:'userName')}</td>
                        
                            <td>${fieldValue(bean:playerInstance, field:'email')}</td>
                        
                            <td>${fieldValue(bean:playerInstance, field:'phone')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${playerInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
