
package br.com.fatecpg.locadora;


public class Filmes {
    
    private long id ;
    private String nome;
    private String genero;
    private Double preco;

    public Filmes(long id, String nome, String genero, Double preco) {
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
