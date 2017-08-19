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
  <h1>O chalupě: </h1>
        <p>Druh chalupy: ${group.name}</p>
        <p>Popis chalupy: ${cottage.description}</p>
        <p>${group.description}</p>
        <p>Cena: ${cottage.price}</p>
        <p>Město: ${cottage.city}</p>
        <p>Počet míst: ${cottage.number_of_place}</p>
        
</article>

<footer>Copyright &copy; 2017 - Martin Kulhánek</footer>

    </body>
</html>
