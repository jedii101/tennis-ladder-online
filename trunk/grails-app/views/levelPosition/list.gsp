

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>LevelPosition List</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="create" action="create" id="1">new single LevelPosition</g:link></span>
            <span class="menuButton"><g:link class="create" action="create" id="2">new mix double LevelPosition</g:link></span>
        </div>
        <div class="body">
            <h1>single ladder List</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="list">
                <table>
                    <thead>
                        <tr>
                        
                   	        <g:sortableColumn property="id" title="Id" />
                        
                   	        <th>Ladder</th>
                   	    
                   	        <th>Level</th>
                   	    
                   	        <g:sortableColumn property="pos" title="Pos" />
                        
                   	        <th>Team</th>
                   	    
                   	        <g:sortableColumn property="name" title="Name" />
                        
                        </tr>
                    </thead>
                    <tbody>
                    <g:each in="${flash.singleList}" status="i" var="levelPositionInstance">
                        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                        
                            <td><g:link action="show" id="${levelPositionInstance.id}">${fieldValue(bean:levelPositionInstance, field:'id')}</g:link></td>
                        
                            <td>${fieldValue(bean:levelPositionInstance, field:'ladder')}</td>
                        
                            <td>${fieldValue(bean:levelPositionInstance, field:'level')}</td>
                        
                            <td>${fieldValue(bean:levelPositionInstance, field:'pos')}</td>
                        
                            <td>${fieldValue(bean:levelPositionInstance, field:'team')}</td>
                        
                            <td>${fieldValue(bean:levelPositionInstance, field:'name')}</td>
                        
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div class="paginateButtons">
                <g:paginate total="${LevelPosition.countByLadder(Ladder.get(1))}" />
            </div>
        </div>

    </body>
</html>
