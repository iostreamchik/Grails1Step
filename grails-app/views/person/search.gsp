<%@ page contentType="text/html;charset=UTF-8" %>
<html xmlns="">
<head>
    <title>Search</title>
    <meta name="layout" content="main"/>
</head>

<body>
<formset>
    <legend>Search workers</legend>
    <g:form action="result">
        <label for="name">Person Name</label>
        <g:textField name="name"/>
        <g:submitButton name="search" value="Search"/>
    </g:form>
</formset>
</body>
</html>