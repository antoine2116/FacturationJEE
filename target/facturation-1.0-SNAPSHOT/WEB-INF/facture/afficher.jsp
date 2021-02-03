<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>
        Détails facture <:out value="${facture.numero}" />
    </title>
    <%@include file="../commons/header.jsp"%>
</head>
<body>
<div class="col-12">
    <h2>Détails de la facture N° <c:out value="${facture.numero}" /></h2>
    <div class="row">
        <div class="col-8">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-6">
                            <p>
                                Date facturation :  <fmt:formatDate pattern="dd/MM/yyyy" type="date" value="${facture.date}" />
                            </p>
                            <p>
                                Numéro de facture :  <c:out value="${facture.numero}" />
                            </p>
                        </div>
                        <div class="col-6">
                            <p>
                                <c:out value="${facture.client.nom}" />
                            </p>
                            <p>
                                <c:out value="${facture.client.adresse}" />
                            </p>
                        </div>
                    </div>
                    <div class="form-group">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Article</th>
                                <th>Quantité</th>
                                <th>Prix</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${facture.lignesFacture}" var="ligne">
                                <tr>
                                    <td>
                                        <c:out value="${ligne.article.nom}" />
                                    </td>
                                    <td>
                                        <c:out value="${ligne.qte}" />
                                    </td>
                                    <td>
                                        <c:out value="${ligne.prix}" />
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="form-group">
                        <div class="float-right">
                            Total :
                            <span class="font-weight-bold">
                                <c:out value="${facture.prix}" />
                            </span>
                            euros
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
