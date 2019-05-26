/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.util.ArrayList;

/**
 *
 * @author john
 */
public class Filme {
    
    private long id;
    private String nome;
    private String genero;

    public Filme(long id, String nome, String genero, double preco) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.preco = preco;
    }
    
    public static Usuarios getUsuarios(String login, String senha)
            throws Exception{
        
        String SQL = "SELECT * FROM USUARIOS "
                + "WHERE usuario_login = ? AND usuario_passwordhash = ?";
        Object parameters[] = {login, senha.hashCode()};
        ArrayList<Object[]> list = Conexao.getQuery(SQL, parameters);
        if(list.isEmpty()){
            return null;
        }
        else{
            Object row[] = list.get(0);
            Usuarios x = new Usuarios(
                    (long) row[0],
                    (String) row[1],
                    (String) row[2],
                    (String) row[3],
                    (long) row[4],
                    (long) row[5]
            );
            return x;
        }
        
    }
    
    
    private double preco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
    public static ArrayList<Filme> getTodosFilmes()
            throws Exception{
        
        String SQL = "SELECT * FROM FILMES";
        ArrayList<Filme> todosFilmes = new ArrayList<>();
        ArrayList<Object[]> list = Conexao.getQuery(SQL, new Object[]{});
       for(int i=0; i<list.size(); i++){
            Object row[] = list.get(i);
            Filme f = new Filme(
                    (long) row[0],
                    (String) row[1],
                    (String) row[2],
                    (Double) row[3]
                    );
                    todosFilmes.add(f);
                    
        }
        return todosFilmes;
        
    }
    
    public static void AddFilme(String nome, String genero, Double preco) throws Exception{
    
    String SQL = "INSERT INTO FILMES VALUES("
            + "default"
            + ", ?"
            + ", ?"
            + ", ?"
            + ")";
            
          
    
    Object parameters[] = {nome, genero, preco};
    Conexao.execute(SQL, parameters);
            
}
    
    public static void ExcluirFilme(long id) throws Exception{
    
    String SQL = "DELETE FROM FILMES WHERE FILME_ID = ?";       
    Object parameters[] = {id};
    Conexao.execute(SQL, parameters);
    
}
    
    
}


