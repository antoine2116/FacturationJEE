<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des articles</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>
<div class="col-12">
    <h2>Liste des articles</h2>
    <div class="row mb-2">
        <div class="col-12">
            <a href="/createArticle" class="btn btn-secondary">Créer un article</a>
        </div>
    </div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Prix</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>
                    <c:out value="${article.nom}" />
                </td>
                <td>
                    <c:out value="${article.prix}" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
