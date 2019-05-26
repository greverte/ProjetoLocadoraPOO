  <%@page import="db.Filme"%>
<%-- 
    Document   : usuarios
    Created on : 25/05/2019, 17:15:35
    Author     : john
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%
    String error = null;
 
        
    if(request.getParameter("excluirfilme") !=null){
        try{
            long id = Long.parseLong(request.getParameter("id"));
            Filme.ExcluirFilme(id);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
        }
            
        }
        
    
    if(request.getParameter("novoFilme") != null){
        String nome = request.getParameter("nome");
        String genero = request.getParameter("genero");
        Double preco = Double.parseDouble(request.getParameter("preco"));
    
        try{
        Filme.AddFilme(nome, genero, preco );
        response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
            
        }
    }



 %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciar Filmes</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <h1>Gerenciar Filmes</h1>
        
        <fieldset>
            <legend>Adicionar Filme</legend>
            <form>
                Nome:<input type="text" name="nome"/>
                Gênero <select name="genero">
                            <option value="comedia">Comédia</option>
                            <option value="suspense">Suspense</option>
                            <option value="terror">Terror</option>
                            <option value="drama">Drama</option>
                        </select>
                Preço:<input type="number" name="preco" step="0.01"/>
    
                <input type="submit" name="novoFilme" value="Adicionar"/>
            </form>
        </fieldset>
        <%if(error != null){%>
        <h3><%=error%></h3>
        <%}%>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Gênero</th>
                <th>Preço</th>
                <th>Opções</th>
            </tr>
            <%for(Filme f: Filme.getTodosFilmes()){%>
            <tr>
                <td><%=f.getId()%></td>
                <td><%=f.getNome()%></td>
                <td><%=f.getGenero()%></td>
                <td><%=f.getPreco()%></td>
                
                <td>
                    <form>
                    <input type="hidden" name="id" value="<%=f.getId()%>"/>
                    <input type="submit" name="excluirfilme" value="Remover"/>
                    </form>
                    
                    
                    

                    
                </td>
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>