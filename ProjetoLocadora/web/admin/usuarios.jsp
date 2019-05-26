    <%-- 
    Document   : usuarios
    Created on : 25/05/2019, 17:15:35
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String error = null;
 
        
    if(request.getParameter("excluirusuario") !=null){
        try{
            long id = Long.parseLong(request.getParameter("id"));
            Usuarios.ExcluirUsuario(id);
            response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
        }
            
        }
        
    
    if(request.getParameter("novocliente") != null){
        String nome = request.getParameter("nome");
        String role = request.getParameter("role");
        String rg = (request.getParameter("rg"));
        String login = request.getParameter("login");
        long senha = request.getParameter("senha").hashCode();
        try{
        Usuarios.AddUsuario(nome, role, rg, login, senha);
        response.sendRedirect(request.getRequestURI());
        }catch(Exception e){
            error = e.getMessage();
            
        }
    }



 %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usúarios</title>
    </head>
    <body>
        <%@include file="../WEB-INF/jspf/header.jspf" %>
        <h1>Usuários Cadastrados</h1>
        
        <fieldset>
            <legend>Novo Usuário</legend>
            <form>
                Nome:<input type="text" name="nome"/>
                Função: <select name="role">
                            <option value="Administrador">Admin</option>
                            <option value="Cliente">Cliente</option>
                        </select>
                RG:<input type="text" name="rg"/>
                Login:<input type="text" name="login"/>
                Senha:<input type="password" name="senha"/>
                <input type="submit" name="novocliente" value="Adicionar"/>
            </form>
        </fieldset>
        <%if(error != null){%>
        <h3><%=error%></h3>
        <%}%>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Função</th>
                <th>RG</th>
                <th>Login</th>
                <th>Opções</th>
            </tr>
            <%for(Usuarios x: Usuarios.getTodos()){%>
            <tr>
                <td><%=x.getId()%></td>
                <td><%=x.getNome()%></td>
                <td><%=x.getRole()%></td>
                <td><%=x.getRg()%></td>
                <td><%=x.getLogin()%></td>
                <td>
                    <form>
                    <input type="hidden" name="id" value="<%=x.getId()%>"/>
                    <input type="submit" name="excluirusuario" value="Remover"/>
                    </form>
                    
                    
                    

                    
                </td>
            </tr>
            
            <%}%>
        </table>
        
    </body>
</html>
