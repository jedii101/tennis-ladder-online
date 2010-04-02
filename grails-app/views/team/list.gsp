

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Team List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create">New Team</g:link></span>
        </div>
        <div class="body">
            <h1>Team List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <g:sortableColumn property="status" title="Status" />
                        
                   	        <th>Ladder</th>
                   	    
                   	        
                   	    
                   	        <th>Player1</th>
                   	    
                   	        <th>Player2</th>
                   	    
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${teamInstanceList}" status="i" var="teamInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${teamInstance.id}">${fieldValue(bean:teamInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:teamInstance, field:'status')}</td>
                        
                            <td>${fieldValue(bean:teamInstance, field:'ladder')}</td>
                        
                           
                        
                            <td>${fieldValue(bean:teamInstance, field:'player1')}</td>
                        
                            <td>${fieldValue(bean:teamInstance, field:'player2')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${teamInstanceTotal}" />
            </div>
        </div>
    </body>
</html>
