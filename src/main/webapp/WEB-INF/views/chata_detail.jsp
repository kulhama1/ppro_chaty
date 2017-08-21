<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${cottage.name}</title>
        <style>
div.container {
    width: 100%;
    border: 1px solid gray;
}
div.obrazky{
    margin-left: 550px;
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
    max-width: 450px;
    margin: 0;
    padding: 1em;
    border-right: 1px solid gray;
}

nav ul {
    list-style-type: none;
    padding: 0;
}
   
nav ul a {
    text-decoration: none;
}

article {
    padding: 1em;
    overflow: hidden;
}
</style>
    </head>   
    <body>
        <div class="container">

<header>
   <h1>${cottage.name}</h1>
</header>

<article>
  <h2>O chalupě: </h2>
  <nav>
      <p><strong>Druh chalupy:</strong> ${group.name}</p>
        <p><strong>Cena:</strong> ${cottage.price}</p>
        <p><strong>Město:</strong> ${cottage.city}</p>
        <p><strong>Počet míst:</strong> ${cottage.number_of_place}</p>
        <p><strong>Popis chalupy:</strong> ${cottage.description}</p>
        <p>${group.description}</p>
        
  </nav>
        <div class="obrazky">
        <c:forEach var="image" items="${images}" varStatus="count">
            <img src="${image.image_src}" htmlEscape="true" title="${image.image_alt}" /></a>
        </c:forEach>
  </div>      
</article>

<footer>Copyright &copy; 2017 - Martin Kulhánek</footer>

    </body>
</html>
