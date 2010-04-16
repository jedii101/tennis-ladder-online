

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  <g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
  <title><g:message code="default.show.label" args="[entityName]" /></title>
</head>
<body>
  <div class="nav">
    <span class="menuButton"><a class="home" href="${createLink(uri: '/')}">Home</a></span>
    <span class="menuButton"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></span>
    <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>
  </div>
  <div class="body">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="dialog">
      <table>
        <tbody>

          <tr class="prop">
            <td valign="top" class="name"><g:message code="message.id.label" default="Id" /></td>

        <td valign="top" class="value">${fieldValue(bean: messageInstance, field: "id")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="message.parent.label" default="Parent" /></td>

        <td valign="top" class="value"><g:link controller="message" action="show" id="${messageInstance?.parent?.id}">${messageInstance?.parent?.encodeAsHTML()}</g:link></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="message.to.label" default="To" /></td>

        <td valign="top" class="value"><g:link controller="team" action="show" id="${messageInstance?.to?.id}">${messageInstance?.to?.encodeAsHTML()}</g:link></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="message.schedule.label" default="Schedule" /></td>

        <td valign="top" class="value"><g:link controller="matchSchedule" action="show" id="${messageInstance?.schedule?.id}">${messageInstance?.schedule?.encodeAsHTML()}</g:link></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="message.message.label" default="Message" /></td>

        <td valign="top" class="value">${fieldValue(bean: messageInstance, field: "message")}</td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="message.created.label" default="Created" /></td>

        <td valign="top" class="value"><g:formatDate date="${messageInstance?.created}" /></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="message.createBy.label" default="Create By" /></td>

        <td valign="top" class="value"><g:link controller="player" action="show" id="${messageInstance?.createBy?.id}">${messageInstance?.createBy?.encodeAsHTML()}</g:link></td>

        </tr>

        <tr class="prop">
          <td valign="top" class="name"><g:message code="message.isSystem.label" default="Is System" /></td>

        <td valign="top" class="value"><g:formatBoolean boolean="${messageInstance?.isSystem}" /></td>

        </tr>

        </tbody>
      </table>
    </div>
    <div class="buttons">
      <g:form>
        <g:hiddenField name="id" value="${messageInstance?.id}" />
        <span class="button"><g:actionSubmit class="edit" action="edit" value="${message(code: 'default.button.edit.label', default: 'Edit')}" /></span>

        <span class="button"><g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" /></span>

      </g:form>
    </div>
  </div>
</body>
</html>
