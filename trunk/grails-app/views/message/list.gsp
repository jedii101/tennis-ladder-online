

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="layout" content="main" />
  <g:set var="entityName" value="${message(code: 'message.label', default: 'Message')}" />
  <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>

    <g:ifAnyGranted role="ROLE_ADMIN">
  <div class="nav">



      <span class="menuButton"><a class="home" href="${createLink(uri: '/secure/index.gsp')}">Home</a></span>
      <span class="menuButton"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></span>


  </div>
          </g:ifAnyGranted>
  <div class="body">
    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    <div class="list">
      <table>
        <thead>
          <tr>
        <g:ifAnyGranted role="ROLE_ADMIN">
          <g:sortableColumn property="id" title="${message(code: 'message.id.label', default: 'Id')}" />

          <th><g:message code="message.parent.label" default="Parent" /></th>

          <th><g:message code="message.to.label" default="To" /></th>

          <th><g:message code="message.schedule.label" default="Schedule" /></th>
        </g:ifAnyGranted>
        <th><g:message code="message.createBy.name" default="From" /></th>
        <g:message code="message.message" default="Message" />

        <g:message code="message.createBy.name" default="Created" />

        </tr>
        </thead>
        <tbody>
        <g:each in="${messageInstanceList}" status="i" var="messageInstance">
          <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
          <g:ifAnyGranted role="ROLE_ADMIN">
            <td><g:link action="show" id="${messageInstance.id}">${fieldValue(bean: messageInstance, field: "id")}</g:link></td>

            <td>${fieldValue(bean: messageInstance, field: "parent")}</td>

            <td>${fieldValue(bean: messageInstance, field: "to")}</td>

            <td>${fieldValue(bean: messageInstance, field: "schedule")}</td>
          </g:ifAnyGranted>


          <td>${fieldValue(bean: messageInstance, field: "createBy")}</td>
          <td>${fieldValue(bean: messageInstance, field: "message")}</td>
          <td><g:formatDate date="${messageInstance.created}" /></td>

          </tr>
        </g:each>
        </tbody>
      </table>
    </div>
    <div class="paginateButtons">
      <g:paginate total="${messageInstanceTotal}" />
    </div>
  </div>
</body>
</html>
