<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<style>           
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
<form:form method="post" modelAttribute="user" action="/SkolniProjectChaty/addUser">
<table>
		<tr>
			<th colspan="3">Add User</th>
		</tr>
		<tr>
		<form:hidden path="id_user" />
          <td><form:label path="id_address">id_address:</form:label></td>
          <td><form:input path="id_address" size="30" maxlength="30"></form:input>
          <form:errors path="id_address" /></td>
                </tr>
		<tr>
	  <td><form:label path="login">Login</form:label></td>
          <td><form:input path="login" size="30" maxlength="30"></form:input>
          <form:errors path="login" /></td>
		</tr>
                <tr>
	  <td><form:label path="name">Name</form:label></td>
          <td><form:input path="name" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="surname">Surname</form:label></td>
          <td><form:input path="surname" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="email">Email</form:label></td>
          <td><form:input path="email" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="password">Password</form:label></td>
          <td><form:input path="password" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="salt">Salt</form:label></td>
          <td><form:input path="salt" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="website">Website</form:label></td>
          <td><form:input path="website" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="phone">Phone</form:label></td>
          <td><form:input path="phone" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="rights">Rights</form:label></td>
          <td><form:input path="rights" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="token">Token</form:label></td>
          <td><form:input path="token" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>User List</h3>
<c:if test="${!empty listOfUsers}">
	<table class="tg">
	<tr>
		<th width="80">Id_user</th>
		<th width="120">Id_address</th>
		<th width="120">login</th>
                <th width="120">name</th>
                <th width="120">surname</th>
                <th width="120">email</th>
                <th width="120">password</th>
                <th width="120">salt</th>
                <th width="120">website</th>
                <th width="120">phone</th>
                <th width="120">rights</th>
                <th width="120">token</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfUsers}" var="user">
		<tr>
			<td>${user.id_user}</td>
			<td>${user.id_address}</td>
			<td>${user.login}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>${user.salt}</td>
                        <td>${user.website}</td>
                        <td>${user.phone}</td>
                        <td>${user.rights}</td>
                        <td>${user.token}</td>
                        
			<td><a href="<c:url value='/updateUser/${user.id_user}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteUser/${user.id_user}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>