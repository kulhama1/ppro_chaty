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
<form:form method="post" modelAttribute="image" action="/SkolniProjectChaty/addImage" enctype="multipart/form-data">
<table>
		<tr>
			<th colspan="5">Add Image</th>
		</tr>
		<tr>
		<form:hidden path="id" />
          <td><label path="soubor">soubor: </label></td>
          <td><input type="file" name="file" id="file" /> <br/></td>
                </tr>
		<tr>
	  <td><form:label path="image_src">Image_src:</form:label></td>
          <td><form:input path="image_src" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="description">Description:</form:label></td>
          <td><form:input path="description" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="thumbnail_src">Thumbnail_src:</form:label></td>
          <td><form:input path="thumbnail_src" size="30" maxlength="30"></form:input></td>
		</tr>
                <tr>
	  <td><form:label path="id_gallery">Id_gallery</form:label></td>
          <td><form:input path="id_gallery" size="30" maxlength="30"></form:input></td>
		</tr>
		<tr>
			<td colspan="5"><input type="submit"
				class="blue-button" /></td>
		</tr>
	</table> 
</form:form>
</br>
<h3>Image List</h3>
<c:if test="${!empty listOfImages}">
	<table class="tg">
	<tr>
		<th width="80">Id</th>
		<th width="120">Image alt</th>
		<th width="120">Image src</th>
                <th width="120">Description</th>
                <th width="120">Thumbnail src</th>
                <th width="120">Id gallery</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listOfImages}" var="image">
		<tr>
			<td>${image.id}</td>
			<td>${image.image_alt}</td>
			<td>${image.image_src}</td>
			<td>${image.description}</td>
			<td>${image.thumbnail_src}</td>
			<td>${image.id_gallery}</td>
                        
			<td><a href="<c:url value='/updateImage/${image.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/deleteImage/${image.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>