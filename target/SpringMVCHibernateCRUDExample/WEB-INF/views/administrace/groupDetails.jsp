<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style> 
    body {
    margin: 0;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 15%;
    background-color: #f1f1f1;
    position: fixed;
    height: 100%;
    overflow: auto;
}
li a {
    display: block;
    color: #000;
    padding: 8px 16px;
    text-decoration: none;
}

li a.active {
    background-color: SteelBlue;
    color: white;
}

li a:hover:not(.active) {
    background-color: #25A6E1;
    color: white;
}
.blue-button{
	background: #25A6E1;
	filter: progid: DXImageTransform.Microsoft.gradient( startColorstr='#25A6E1',endColorstr='#188BC0',GradientType=0);
	padding:3px 5px;
	color:#fff;
	font-family:'Helvetica Neue',sans-serif;
	font-size:12px;
	border-radius:2px;
	-moz-border-radius:2px;
	-webkit-border-radius:4px;
	border:1px solid #1A87B9
}     
table {
  font-family: "Helvetica Neue", Helvetica, sans-serif;
   width: 50%;
}
th {
  background: SteelBlue;
  color: white;
}
 td,th{
                border: 1px solid gray;
                width: 25%;
                text-align: left;
                padding: 5px 10px;
            }
</style>
</head>
<body>
    <ul>
        <li><a href="<spring:url value="/" htmlEscape="true" />">Home Page</a></li>
        <li><a href="<spring:url value="/getAllCottages" htmlEscape="true" />">Chaty</a></li>
        <li><a href="<spring:url value="/getAllGalleries" htmlEscape="true" />">Galerie</a></li>
        <li><a class="active" href="<spring:url value="/getAllGroups" htmlEscape="true" />">Skupiny chat</a></li>
        <li><a href="<spring:url value="/getAllImages" htmlEscape="true" />">Obrázky</a></li>
        <li><a href="<spring:url value="/getAllUsers" htmlEscape="true" />">Uživatelé</a></li>
        </ul>
        <div style="margin-left:15%;padding:1px 16px;height:1000px;">
        <h2>Druhy chaty</h2>
<form:form method="post" modelAttribute="group" action="/SkolniProjectChaty/addGroup">
<table>
		<tr>
			<th colspan="3">Add Group</th>
		</tr>
		<tr>
		<form:hidden path="id_group" />
          <td><form:label path="name">Name:</form:label></td>
          <td><form:input path="name" size="30" maxlength="30"></form:input>
          <form:errors path="name" /></td>
                </tr>
		<tr>
	  <td><form:label path="description">Description:</form:label></td>
          <td><form:input path="description" size="30" maxlength="30"></form:input>
              <form:errors path="description" /> </td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Group List</h3>
<c:if test="${!empty listOfGroups}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Name</th>
		<th width="120">Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfGroups}" var="group">
		<tr>
			<td>${group.id_group}</td>
			<td>${group.name}</td>
			<td>${group.description}</td>
                        
			<td><a href="<c:url value='/updateGroup/${group.id_group}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteGroup/${group.id_group}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>
</body>
</html>