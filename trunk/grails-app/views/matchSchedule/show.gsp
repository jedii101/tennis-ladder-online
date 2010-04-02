

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show MatchSchedule</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">MatchSchedule List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New MatchSchedule</g:link></span>
        </div>
        <div class="body">
            <h1>Show MatchSchedule</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <div class="dialog">
                <table>
                    <tbody>

                    
                        <tr class="prop">
                            <td valign="top" class="name">Id:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:matchScheduleInstance, field:'id')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Plan Match Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:matchScheduleInstance, field:'planMatchDate')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Default Reason:</td>
                            
                            <td valign="top" class="value"><g:link controller="defaultReason" action="show" id="${matchScheduleInstance?.defaultReason?.id}">${matchScheduleInstance?.defaultReason?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Default Winner:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:matchScheduleInstance, field:'defaultWinner')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Comments:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:matchScheduleInstance, field:'comments')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Challeger Score:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:matchScheduleInstance, field:'challegerScore')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Challenger:</td>
                            
                            <td valign="top" class="value"><g:link controller="team" action="show" id="${matchScheduleInstance?.challenger?.id}">${matchScheduleInstance?.challenger?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Defender:</td>
                            
                            <td valign="top" class="value"><g:link controller="team" action="show" id="${matchScheduleInstance?.defender?.id}">${matchScheduleInstance?.defender?.encodeAsHTML()}</g:link></td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Defender Score:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:matchScheduleInstance, field:'defenderScore')}</td>
                            
                        </tr>
                    
                        <tr class="prop">
                            <td valign="top" class="name">Match Date:</td>
                            
                            <td valign="top" class="value">${fieldValue(bean:matchScheduleInstance, field:'matchDate')}</td>
                            
                        </tr>
                    
                    </tbody>
                </table>
            </div>
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${matchScheduleInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
        </div>
    </body>
</html>
