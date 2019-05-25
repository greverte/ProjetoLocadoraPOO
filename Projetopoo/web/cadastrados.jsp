<%-- 
    Document   : cadastrados
    Created on : 25/05/2019, 15:07:40
    Author     : gabri
--%>

<%@page import="db.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
        <tr>
        <th>ID</th>
        <th>Nome</th>
        </tr>
        
        
        <%for (Usuarios x: Usuarios.getList()){%>   
        <tr>
            <td><%=x.getId()%></td>
            <td><%=x.getNome()%></td>
        </tr>
        </table>
    </body>
</html>
