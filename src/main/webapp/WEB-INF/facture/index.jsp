<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Liste des factures</title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>
<div class="col-12">
    <h2>Liste des factures</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Numéro</th>
            <th>Date</th>
            <th>Client</th>
            <th>Prix</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${factures}" var="facture">
            <tr>
                <td>
                    <c:out value="${facture.numero}" />
                </td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${facture.date}" />
                </td>
                <td>
                    <c:out value="${facture.client.nom}" />
                </td>
                <td>
                    <c:out value="${facture.prix}" />
                </td>
                <td>
                    <a href="/afficherFacture?id=<c:out value="${facture.id}"/>"/>
                        Afficher
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
