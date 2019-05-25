
package br.com.fatecpg.locadora;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Usuarios {
    private long id;
    private String nome;
    private String role;
    private String login;
    private long passwordHash;
    
    public Usuarios() {
    }
    

    public Usuarios(long id, String nome, String role, String login, long passwordHash) {
        this.id = id;
        this.nome = nome;
        this.role = role;
        this.login = login;
        this.passwordHash = passwordHash;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(long passwordHash) {
        this.passwordHash = passwordHash;
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
                    (long) row[4]
            );
            return x;
        }
        
    }


public static ArrayList<Usuarios> getList() throws Exception{
        ArrayList<Usuarios> list = new ArrayList<>();
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        String url = "jdbc:derby://localhost:1527/ProjetoPoo";
        Connection con = DriverManager.getConnection(url, "poo", "poo");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM USUARIOS");
        while(rs.next()){
            Usuarios x = new Usuarios();
            x.setId(rs.getLong("USUARIO_ID"));
            x.setNome(rs.getString("USUARIO_NAME"));
            x.setRole(rs.getString("USUARIO_ROLE"));
            
            list.add(x);
        }
    rs.close();st.close();con.close();
    return list;
    }

}
