
package db;

import java.util.ArrayList;




public class Usuarios {
    private long id;
    private String nome;
    private String role;
    private String login;
    private long passwordHash;
    private long rg;

    public Usuarios(long id, String nome, String role, String login, long passwordHash, long rg) {
        this.id = id;
        this.nome = nome;
        this.role = role;
        this.login = login;
        this.passwordHash = passwordHash;
        this.rg = rg;
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

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }



public static ArrayList<Usuarios> getTodos()
            throws Exception{
        
        String SQL = "SELECT * FROM USUARIOS";
        ArrayList<Usuarios> todos = new ArrayList<>();
        ArrayList<Object[]> list = Conexao.getQuery(SQL, new Object[]{});
       for(int i=0; i<list.size(); i++){
            Object row[] = list.get(i);
            Usuarios x = new Usuarios(
                    (long) row[0],
                    (String) row[1],
                    (String) row[2],
                    (String) row[3],
                    (long) row[4],
                    (long) row[5]
                    );
                    todos.add(x);
                    
        }
        return todos;
        
    }
public static void AddUsuario(String nome, String role, String rg, String login, long senha) throws Exception{
    
    String SQL = "INSERT INTO USUARIOS VALUES("
            + "default"
            + ", ?"
            + ", ?"
            + ", ?"
            + ", ?"
            + ", ?"
            + ")";
            
          
    
    Object parameters[] = {nome, role, login, senha, rg};
    Conexao.execute(SQL, parameters);
            
}
public static void ExcluirUsuario(long id) throws Exception{
    
    String SQL = "DELETE FROM USUARIOS WHERE USUARIO_ID = ?";       
    Object parameters[] = {id};
    Conexao.execute(SQL, parameters);
            
}
public static void AlterarUsuario(long id, String nome, String role, long rg, String login, long senha) throws Exception{
    
    String SQL = "UPDATE USUARIOS("
            + "default"
            + ", USUARIO_NOME = ?"
            + ", USUARIO_ROLE = ?"
            + ", USUARIO_RG = ?"
            + ", USUARIO_LOGIN = ?"
            + ", USUARIO_PASSWORDHASH = ?"
            + "WHERE USUARIO_ID = ?"
            + ")";
            
          
    
    Object parameters[] = {id, nome, role, rg, login, senha};
    Conexao.execute(SQL, parameters);
}

public static Usuarios teste(long id)
            throws Exception{
        
        String SQL = "SELECT * FROM USUARIOS WHERE USUARIO_LOGIN = ?";
               
        Object parameters[] = {id};
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
}