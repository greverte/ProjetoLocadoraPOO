
package br.com.fatecpg.locadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Filme {
    
    private long id ;
    private String nome;
    private String genero;
    private Double preco;

    public Filme(long id, String nome, String genero, Double preco) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.preco = preco;
    }
    

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
}

public static ArrayList<Usuarios> getList() throws Exception{
        ArrayList<Filme> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/ProjetoPoo";
        Connection con = DriverManager.getConnection(url, "poo", "poo");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM FILMES");
        while(rs.next()){
            Filme f = new Filme();
            f.setId(rs.getLong("FILME_ID"));
            f.setNome(rs.getString("FILME_NOME"));
            f.setGenero(rs.getString("FILME_GENERO"));
            f.setPreco(rs.getString("FILME_PRECO"));
            
            list.add(f);
        }
    rs.close();st.close();con.close();
    return list;
    }

}

public static ArrayList<FIlme> getFilmes throws Exception (){
String POO = "SELECT *FROM FILMES";
ArrayList<Filme> filmes = new ArrayList<>();
ArrayList<Object[]> list = Conexao.getQuery(POO, new Object)

}
