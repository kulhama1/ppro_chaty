<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Admin rozhraní</h1>
        
        <a href="<spring:url value="/getAllCottages" htmlEscape="true" />">Zobrazit chaty</a>
        <a href="<spring:url value="/getAllGalleries" htmlEscape="true" />">Zobrazit galerie</a>
        <a href="<spring:url value="/getAllGroups" htmlEscape="true" />">Zobrazit skupiny chat</a>
        <a href="<spring:url value="/getAllImages" htmlEscape="true" />">Zobrazit obrázky</a>
        <a href="<spring:url value="/getAllUsers" htmlEscape="true" />">Zobrazit uživatele</a>
        
    </body>
</html>

