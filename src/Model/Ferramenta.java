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
    
    
    
    // Retorna a Lista de Alunos(objetos)
    public ArrayList getMinhaLista() {
        //return AlunoDAO.MinhaLista;
        return dao.getMinhaLista();
    }
    
    // Cadastra novo aluno
    public boolean InsertFerramentaBD(String marca, double custo, String nome) throws SQLException {
        int id_insert = this.maiorID() + 1;
        Ferramenta objeto = new Ferramenta(id_insert, nome, marca, custo);
        dao.InsertFerramentaBD(objeto);
        return true;

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

