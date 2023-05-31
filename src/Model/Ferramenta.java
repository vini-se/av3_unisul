/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.FerramentaDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinic
 */
public class Ferramenta {
    
    private int id;
    private String nome;
    private String marca;
    private double custo;
    private final FerramentaDAO dao; 
    

    public Ferramenta() {
        this.dao = new FerramentaDAO();
    }

    public Ferramenta(int id, String nome, String marca, double custo) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.custo = custo;
        this.dao = new FerramentaDAO();
    }
    
    
    
    // Retorna a Lista de Ferramenta(objetos)
    public ArrayList<Ferramenta> getListaFerramentas() {
        //return ferramentaDAO.MinhaLista;
        return dao.getMinhaLista();
    }
    
    // Cadastra novo ferramenta
    public boolean InsertFerramentaDB(String marca, double custo, String nome) throws SQLException {
        int id_insert = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id_insert, nome, marca, custo);
        dao.InsertFerramentaDB(objeto);
        return true;
    }

    public boolean UpdateFerramentaDB(int id, String marca, double custo, String nome) throws SQLException {
        Ferramenta objeto = new Ferramenta(id, nome, marca, custo);
        dao.UpdateFerramentaDB(objeto);
        return true;
    }

    public boolean DeleteFerramentaDB(int id) throws SQLException {
        return dao.DeleteFerramentaDB(id);
    }

    public int maiorID() throws SQLException{
      return dao.maiorID();
    }  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
      
    
}

