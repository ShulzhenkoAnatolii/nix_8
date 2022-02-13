<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action = "${pageContext.request.contextPath}/courses/update/${id}" method = "post" modelAttribute="course">
    <br />
    name: <form:select items="${courseNames}" var="name" path="name" />
    <input type = "submit" value = "Submit" />
</form:form>
</body>
</html>