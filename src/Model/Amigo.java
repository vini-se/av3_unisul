/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.AmigoDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class Amigo {
    
    private int id;
    private String nome;
    private String email;
    private long telefone;
    private final AmigoDAO dao; 
    

    public Amigo() {
        this.dao = new AmigoDAO();
    }
    
    public Amigo(int id, String nome, String email, long telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.dao = new AmigoDAO();
    }
    
    // Retorna a Lista de Amigos(objetos)
    public ArrayList<Amigo> getListaAmigos() {
        //return amigoDAO.MinhaLista;
        return dao.getListaAmigos();
    }
    
    // Cadastra novo amigo
    public boolean InsertAmigoDB(String email, long telefone, String nome) throws SQLException {
        int id_insert = this.maiorID() + 1;
        Amigo objeto = new Amigo(id_insert, nome, email, telefone);
        dao.InsertAmigoDB(objeto);
        return true;
    }

    // Altera amigo
    public boolean UpdateAmigoDB(int id, String email, long telefone, String nome) throws SQLException {
        Amigo objeto = new Amigo(id, nome, email, telefone);
        dao.UpdateAmigoDB(objeto);
        return true;
    }
    
    public boolean DeleteAmigoDB(Amigo obj) throws SQLException {
        dao.DeleteAmigoDB(obj);
        return true;
    }

    public int maiorID() throws SQLException{
        return dao.maiorID();
    }  
      
    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    
    
}
