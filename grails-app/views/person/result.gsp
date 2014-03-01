<%@ page import="grails1step.Person" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result</title>
    <meta name="layout" content="main"/>
</head>

<body>
<h1>Result</h1>

<p>Searched ${Person.count()} records
for items matching <em>${term}</em>.
Found <strong>${persons.size()}</strong> hits.
</p>
<ul>
    <g:each var="person" in="${persons}">
        <li>Name: ${person.name}</li>
        <li>Salary: ${person.salary} $</li>
        <li>Department: ${person.departments}</li>
    </g:each>
</ul>
<g:link action="search">Search again</g:link>
</body>
</html>