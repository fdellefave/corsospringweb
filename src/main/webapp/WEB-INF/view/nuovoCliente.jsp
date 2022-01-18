<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Nuovo cliente</title>
</head>
<body>
<h1>Nuovo cliente</h1>
<%--@elvariable id="datiCliente" type="it"--%>
<form:form method="POST" action="aggiungi" modelAttribute="datiCliente">
    <div>
        <form:label path="nome">Nome</form:label>
        <form:input path="nome"/>
    </div>
    <div>
        <form:label path="cognome">Cognome</form:label>
        <form:input path="cognome"/>
    </div>
    <div>
        <form:label path="codiceFiscale">Codice Fiscale</form:label>
        <form:input path="codiceFiscale"/>
    </div>
    <div>
        <form:label path="telefono">Telefono</form:label>
        <form:input path="telefono"/>
    </div>
    <div>
        <form:label path="email">Email</form:label>
        <form:input path="email"/>
    </div>
    <div>
        <input type="submit" value="registrati">
    </div>
</form:form>
</body>
</html>
