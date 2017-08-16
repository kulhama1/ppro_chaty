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
    background-color: steelblue;
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
        <li><a class="active" href="<spring:url value="/getAllGalleries" htmlEscape="true" />">Galerie</a></li>
        <li><a href="<spring:url value="/getAllGroups" htmlEscape="true" />">Skupiny chat</a></li>
        <li><a href="<spring:url value="/getAllImages" htmlEscape="true" />">Obrázky</a></li>
        <li><a href="<spring:url value="/getAllUsers" htmlEscape="true" />">Uživatelé</a></li>
        </ul>
        <div style="margin-left:15%;padding:1px 16px;height:1000px;">
        <h2>Galerie</h2>
<form:form method="post" modelAttribute="gallery" action="/SkolniProjectChaty/addUpdateGallery">
<table>
		<tr>
			<th colspan="3">Update Gallery ${gallery.name}</th>
		</tr>
		<tr>
		<form:hidden path="id_gallery" />
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name" size="30" maxlength="30"></form:input>
                    <form:errors path="name" /></td>
                </tr>
                <tr>
                <td><form:label path="description">Description:</form:label></td>
                <td><form:textarea path="description" />
                    <form:errors path="description" /></td></td>
		</tr>
                <tr>
                    <td><form:label path="images">images</form:label></td>
                    <td><form:checkboxes path="images" items="${gallery.images}" itemLabel="image_alt" itemValue="id"/>
                    <form:errors path="images" /></td>
                </tr>
                <tr>
                    <td><form:label path="id_thumbnail_gallery">id_thumbnail</form:label></td>
                    <td><form:select path="id_thumbnail_gallery">
                        <form:option value="-1" label="--- Select ---"/>
                        <form:options items="${gallery.images}" itemLabel="image_alt" itemValue="id" />
                     </form:select>
                    <form:errors path="id_thumbnail_gallery" /></td>
                </tr>
                
		<tr>
			<td colspan="3"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
        </div>
</body>
</html>