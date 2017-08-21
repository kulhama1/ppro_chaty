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
div.popisky{
    margin-left:15%;margin-top: 15px; height:175px;
}
p{
    border: 1px solid gray;
}

header, footer {
    padding: 1em;
    color: white;
    background-color: SteelBlue;
    clear: left;
    text-align: center;
}

nav {
    float: left;
    max-width: 160px;
    margin: 0;
    padding: 1em;
}

ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    width: 160px;
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
    text-align: center;
}
a{
    color: steelblue;
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
nav.fotky{
    max-height: 175px;
    max-width: 175px;
}

article {
    margin-left: 170px;
    border-left: 1px solid gray;
    padding: 1em;
    overflow: hidden;
}
h3{
    text-align: center;
}

</style>
    </head>
    <body>
        <div class="container">

<header>
   <h1>Chaty katalog</h1>
</header>
  
  <ul>
    <h3>Druhy chalup</h3>
    <c:forEach var="groups" items="${groups}">
        
                                    <li>
                                        <li><a href="<c:url value='/filtr/${groups.id_group}' />">${groups.name}</a></li>
                                    </li>
                                </c:forEach>
                                    <h3>Informace</h3>
                                    <li>
                                        <li><a href="<c:url value='/kontakt/' />">Kontakt</a></li>
                                        <li><a href="<c:url value='/info/' />">Info</a></li>
                                    </li>
  </ul>

<article>
                        <nav class="fotky">    
                        <c:forEach var="cottage" items="${cottages}">
                               <a href="<spring:url value="/cottages_detail/${cottage.id_cottage}/" htmlEscape="true" />" class="image">
                                        <img src="${cottage.thumbnail.thumbnail_src}" htmlEscape="true" title="${cottage.name}" width="175" height="175" float="left"/>        
                                    </a>
                         </c:forEach>          
                         </nav>
                         <c:forEach var="cottage" items="${cottages}">   
                                    <div class="popisky">
                                    <a href="<spring:url value="/cottages_detail/${cottage.id_cottage}/" htmlEscape="true" />">${cottage.name}</a><br /> 
                                    ${fn:substring(cottage.description, 0, 255)}
                                    </div>     
                        </c:forEach>
</article>

<footer>Copyright &copy; Martin Kulhánek</footer>

</div>                          
    </body>
</html>
