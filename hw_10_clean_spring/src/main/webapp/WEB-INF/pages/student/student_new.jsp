<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action = "${pageContext.request.contextPath}/students/new" method = "post" modelAttribute="student">
    <br />
    name: <form:select items="${courseNames}" var="firstName" path="firstName" />
    <input type = "submit" value = "Submit" />
    name: <form:select items="${courseNames}" var="lastName" path="lastName" />
    <input type = "submit" value = "Submit" />
    name: <form:select items="${courseNames}" var="email" path="email" />
    <input type = "submit" value = "Submit" />
</form:form>
</body>
</html>