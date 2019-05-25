<%-- 
    Document   : filmes
    Created on : 25/05/2019, 17:42:30
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
    if(request.getParameter("formNewFilme")!=null){
        String name = request.getParameter("name");
        String genero = request.getParameter("genero");
        
    }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%@include file ="WEB-INF/jspf/header.jspf"%>
        
        
        <h1>FILMES</h1>
        <fieldset>
            <legend>Novo filme</legend>
            <form>
                Nome: <input type =" text" name ="name"/>
                Genero:
                <select name="genero">
                    <option value ="COMÉDIA">COMÉDIA</option>
                    <option value ="TERROR">TERROR</option>
                    <option value ="SUSPENSE">SUSPENSE</option>
                    <option value ="DRAMA">DRAMA</option>
                </select>
                Preço :<input type ="number" name="preco" step ="0.01">
                <input type="submit" name="formNewFilme" value="adicionar"/>
            </form>
        </fieldset>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>GENERO</th>
                <th>PREÇO LOC.</th>
            </tr>
            
            <tr>
                <%for(Filmes f: Filmes.getFilmes())%>
                
                <td><%=f.getId()%></td>
                <td><%=f.getName()%></td>
                <td><%=f.getGenero()%></td>
                <td><%=f.getPreco()%></td>
            </tr>
             
            
        </table>
        
    </body>
</html>
