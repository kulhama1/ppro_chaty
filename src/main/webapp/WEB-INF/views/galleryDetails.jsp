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
<form:form method="post" modelAttribute="gallery" action="/SkolniProjectChaty/addGallery">
<table>
		<tr>
			<th colspan="3">Add Gallery</th>
		</tr>
		<tr>
		<form:hidden path="id_gallery" />
          <td><form:label path="id_thumbnail_gallery">Id_thumbnail_gallery:</form:label></td>
          <td><form:input path="id_thumbnail_gallery" size="30" maxlength="30"></form:input></td>
                </tr>
		<tr>
	  <td><form:label path="name">Name:</form:label></td>
          <td><form:input path="name" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="description">Description:</form:label></td>
          <td><form:input path="description" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			<td colspan="3"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Gallery List</h3>
<c:if test="${!empty listOfGalleries}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Id thumbnail gallery</th>
		<th width="120">Name</th>
                <th width="120">Description</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfGalleries}" var="gallery">
		<tr>
			<td>${gallery.id_gallery}</td>
			<td>${gallery.id_thumbnail_gallery}</td>
			<td>${gallery.name}</td>
			<td>${gallery.description}</td>
                        
			<td><a href="<c:url value='/updateGallery/${gallery.id_gallery}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteGallery/${gallery.id_gallery}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>