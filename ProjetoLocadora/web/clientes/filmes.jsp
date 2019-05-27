<%-- 
    Document   : filmes
    Created on : 26/05/2019, 12:11:20
    Author     : john
--%>

<%@page import="db.Filme"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Filmes</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <h1>Lista Filmes</h1>
        
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Gênero</th>
                <th>Preço</th>
                
            </tr>
            <%for(Filme f: Filme.getTodosFilmes()){%>
            <tr>
                <td><%=f.getId()%></td>
                <td><%=f.getNome()%></td>
                <td><%=f.getGenero()%></td>
                <td><%=f.getPreco()%></td>
                
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>