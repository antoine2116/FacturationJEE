<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Création d'un article</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>
<div class="col-12">
    <h2>Création d'un article</h2>
    <form action="createArticle" method="post">
        <div class="col-5">
            <div class="card">
                <div class="card-body">
                    <div class="form-group">
                        <label for="nomArticle">Nom</label>
                        <input name="nomArticle" type="text" class="form-control" />
                    </div>
                    <div class="form-group">
                        <label for="prixArticle">Prix</label>
                        <input name="prixArticle" type="number" class="form-control" />
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-success float-right">Valider</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>

</body>
</html>
