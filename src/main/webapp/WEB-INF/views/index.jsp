<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chaty katalog</title>
        <style>
div.container {
    width: 100%;
    border: 1px solid gray;
}

header, footer {
    padding: 1em;
    color: white;
    background-color: black;
    clear: left;
    text-align: center;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}
</style>
    </head>
    <body>
        <div class="container">

<header>
   <h1>Chaty katalog</h1>
</header>
  
<nav>
  <ul>
    <c:forEach var="groups" items="${groups}">
                                    <li>
                                        <li><a href="<c:url value='/filtr/${groups.id_group}' />">${groups.name}</a></li>
                                    </li>
                                </c:forEach>
  </ul>
</nav>

<article>
  <div class="template_wrap">
                        <c:forEach var="cottage" items="${cottages}" varStatus="count">
                            <c:if test="${((count.index mod 4) == 0)}">
                                <div class="template_row clearfix">
                            </c:if>
                            
                            <div class="template ${ ((count.index mod 4) == 0) ? "first" : ""} ${(((count.index+1) mod 4) == 0) ? "last" : ""}">
                                <div class="image-wrap">
                                    <a href="<spring:url value="/cottages_detail/${cottage.id_cottage}/" htmlEscape="true" />" class="image">
                                        <img src="<c:url value="/resources/img/dummy_thumbnail.jpeg" />" title="${cottage.name}" height="225px" width="225px" />        
                                    </a>
                                </div>
                                <div class="template_description">
                                    <a href="<spring:url value="/cottages_detail/${cottage.id_cottage}/" htmlEscape="true" />" class="template_name">${cottage.name}</a>
                                    <p>${fn:substring(cottage.description, 0, 255)}<p>
                                </div>
                            </div> 
                            
                            <c:if test="${(((count.index+1) mod 4) == 0)}">
                                </div>
                            </c:if>
                        </c:forEach>
                        </div></article>

<footer>Copyright &copy; Martin Kulhánek</footer>

</div>                          
    </body>
</html>
