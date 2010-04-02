

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit MatchSchedule</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">MatchSchedule List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New MatchSchedule</g:link></span>
        </div>
        <div class="body">
            <h1>Edit MatchSchedule</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${matchScheduleInstance}">
            <div class="errors">
                <g:renderErrors bean="${matchScheduleInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${matchScheduleInstance?.id}" />
                <input type="hidden" name="version" value="${matchScheduleInstance?.version}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="planMatchDate">Plan Match Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'planMatchDate','errors')}">
                                    <g:datePicker name="planMatchDate" value="${matchScheduleInstance?.planMatchDate}" noSelection="['':'']"></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="defaultReason">Default Reason:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'defaultReason','errors')}">
                                    <g:select optionKey="id" from="${DefaultReason.list()}" name="defaultReason.id" value="${matchScheduleInstance?.defaultReason?.id}" noSelection="['null':'']"></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="defaultWinner">Default Winner:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'defaultWinner','errors')}">
                                    <g:select id="defaultWinner" name="defaultWinner" from="${matchScheduleInstance.constraints.defaultWinner.inList}" value="${matchScheduleInstance.defaultWinner}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="comments">Comments:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'comments','errors')}">
                                    <input type="text" id="comments" name="comments" value="${fieldValue(bean:matchScheduleInstance,field:'comments')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="challegerScore">Challeger Score:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'challegerScore','errors')}">
                                    <input type="text" id="challegerScore" name="challegerScore" value="${fieldValue(bean:matchScheduleInstance,field:'challegerScore')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="challenger">Challenger:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'challenger','errors')}">
                                    <g:select optionKey="id" from="${Team.list()}" name="challenger.id" value="${matchScheduleInstance?.challenger?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="defender">Defender:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'defender','errors')}">
                                    <g:select optionKey="id" from="${Team.list()}" name="defender.id" value="${matchScheduleInstance?.defender?.id}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="defenderScore">Defender Score:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'defenderScore','errors')}">
                                    <input type="text" id="defenderScore" name="defenderScore" value="${fieldValue(bean:matchScheduleInstance,field:'defenderScore')}" />
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="matchDate">Match Date:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:matchScheduleInstance,field:'matchDate','errors')}">
                                    <g:datePicker name="matchDate" value="${matchScheduleInstance?.matchDate}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
