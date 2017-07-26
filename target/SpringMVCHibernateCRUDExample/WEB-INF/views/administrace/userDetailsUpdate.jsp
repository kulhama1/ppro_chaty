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
        <li><a href="<spring:url value="/getAllGroups" htmlEscape="true" />">Skupiny chat</a></li>
        <li><a href="<spring:url value="/getAllImages" htmlEscape="true" />">Obrázky</a></li>
        <li><a class="active" href="<spring:url value="/getAllUsers" htmlEscape="true" />">Uživatelé</a></li>
        </ul>
        <div style="margin-left:15%;padding:1px 16px;height:1000px;">
        <h2>Uživatelé</h2>
<form:form method="post" modelAttribute="userAccount" action="/SkolniProjectChaty/addUpdateUser">
<table>
		<tr>
			<th colspan="3">Update User: ${UserAccount.user.name}</th>
		</tr>
                </tr>
		<tr>
		<form:hidden path="user.id_user" />
                <form:hidden path="user.id_address" />
	  <td><form:label path="user.login">Login</form:label></td>
          <td><form:input path="user.login" id="login" size="30" maxlength="30"></form:input>
              <form:errors path="user.login" /></td>
		</tr>
                <tr>
	  <td><form:label path="user.name">Name</form:label></td>
          <td><form:input path="user.name" id="username" size="30" maxlength="30"></form:input>
              <form:errors path="user.name" /></td>
		</tr>
                <tr>
	  <td><form:label path="user.surname">Surname</form:label></td>
          <td><form:input path="user.surname" size="30" maxlength="30"></form:input>
              <form:errors path="user.surname" /></td>
		</tr>
                <tr>
	  <td><form:label path="user.email">Email</form:label></td>
          <td><form:input path="user.email" size="30" maxlength="30"></form:input>
              <form:errors path="user.email" /></td>
		</tr>
                <tr>
              <form:hidden path="user.password" />
              <form:hidden path="user.salt" />
	  <td><form:label path="password">Password</form:label></td>
          <td><form:input path="password" size="30" maxlength="30"></form:input>
              <form:errors path="password" /></td>
		</tr>
                <tr>
	  <td><form:label path="password_check">Password_check</form:label></td>
          <td><form:input path="password_check" size="30" maxlength="30"></form:input>
              <form:errors path="password_check" /></td>
		</tr>
                <tr>
	  <td><form:label path="user.website">Website</form:label></td>
          <td><form:input path="user.website" size="30" maxlength="30"></form:input>
              <form:errors path="user.website" /></td>
		</tr>
                <tr>
	  <td><form:label path="user.phone">Phone</form:label></td>
          <td><form:input path="user.phone" size="30" maxlength="30"></form:input>
              <form:errors path="user.phone" /></td>
		</tr>
                <tr>
	  <td><form:label path="user.rights">Rights</form:label></td>
          <td><form:input path="user.rights" size="30" maxlength="30"></form:input>
          <form:errors path="user.rights" /></td>
                <form:hidden path="user.token" />
		</tr>
                <tr>
                <form:hidden path="address.id_address" />
	  <td><form:label path="address.address">Adresa</form:label></td>
          <td><form:input path="address.address" size="30" maxlength="30"></form:input>
              <form:errors path="address.address" /></td>
		</tr>
                <tr>
	  <td><form:label path="address.city">Mesto</form:label></td>
          <td><form:input path="address.city" size="30" maxlength="30"></form:input>
              <form:errors path="address.city" /></td>
		</tr>
                <tr>
	  <td><form:label path="address.postal_code">PSC</form:label></td>
          <td><form:input path="address.postal_code" size="30" maxlength="30"></form:input>
              <form:errors path="address.postal_code" /></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
</div>
</body>
</html>