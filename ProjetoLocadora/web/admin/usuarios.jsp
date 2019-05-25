<%-- 
    Document   : usuarios
    Created on : 25/05/2019, 17:15:35
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usúarios</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <h1>Usuários Cadastrados</h1>
       
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Função</th>
                <th>RG</th>
            </tr>
            <%for(Usuarios x: Usuarios.getTodos()){%>
            <tr>
                <td><%=x.getId()%></td>
                <td><%=x.getNome()%></td>
                <td><%=x.getRole()%></td>
                <td><%=x.getRg()%></td>
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>
