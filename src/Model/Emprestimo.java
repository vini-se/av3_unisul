package Model;

import DAO.EmprestimoDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vinic
 */
public class Emprestimo {

    private int id;
    private int amigo_id;
    private int ferramenta_id;
    private String nomeAmigo;
    private String nomeFerramenta;
    private String data_emprestimo;
    private String data_devolucao;
    private String deletado_em;
    private final EmprestimoDAO dao;

    public Emprestimo() {
        this.dao = new EmprestimoDAO();
    }

    public Emprestimo(int id, int amigo_id, int ferramenta_id, String data_emprestimo, String data_devolucao) {
        this.id = id;
        this.amigo_id = amigo_id;
        this.ferramenta_id = ferramenta_id;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.dao = new EmprestimoDAO();
    }

    public Emprestimo(int id, int amigo_id, String nomeAmigo, int ferramenta_id, String nomeFerramenta, String data_emprestimo ,String data_devolucao) {
        this.id = id;
        this.amigo_id = amigo_id;
        this.ferramenta_id = ferramenta_id;
        this.nomeAmigo = nomeAmigo;
        this.nomeFerramenta = nomeFerramenta;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.dao = new EmprestimoDAO();
    }

    public Emprestimo(int id, String nomeAmigo, String nomeFerramenta, String data_emprestimo, String data_devolucao, String deletado_em) {
        this.id = id;
        this.nomeAmigo = nomeAmigo;
        this.nomeFerramenta = nomeFerramenta;
        this.data_emprestimo = data_emprestimo;
        this.data_devolucao = data_devolucao;
        this.deletado_em = deletado_em;
        this.dao = new EmprestimoDAO();
    }  

    public ArrayList<Emprestimo> getListaEmprestimo() {
        return dao.getMinhaLista();
    }
    
    public ArrayList<Emprestimo> getListaPDF() {
        return dao.getListaPDF();
    }
    
    public boolean InsertEmprestimoDB(int amigo_id, int ferramenta_id, String data_emprestimo, String data_devolucao) throws SQLException {
        int insert_id = dao.maiorID() + 1;
        Emprestimo obj = new Emprestimo(insert_id, amigo_id, ferramenta_id, data_emprestimo, data_devolucao);
        dao.InsertEmprestimoDB(obj);
        return true;
    }

    public boolean UpdateEmprestimoDB(int id, String data_devolucao) throws SQLException {
        dao.UpdateEmprestimoDB(id, data_devolucao);
        return true;
    }
    
    public boolean DeleteEmprestimoDB(int id) throws SQLException {
        dao.DeleteEmprestimoDB(id);
        return true;
    }
    
    public boolean AmigosHasEmprestimo(int id) throws SQLException {
        return dao.AmigoHasEmprestimo(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmigo_id() {
        return amigo_id;
    }

    public void setAmigo_id(int amigo_id) {
        this.amigo_id = amigo_id;
    }

    public int getFerramenta_id() {
        return ferramenta_id;
    }

    public void setFerramenta_id(int ferramenta_id) {
        this.ferramenta_id = ferramenta_id;
    }

    public String getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(String data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public String getData_devolucao() {
        return data_devolucao;
    }

    public void setData_devolucao(String data_devolucao) {
        this.data_devolucao = data_devolucao;
    }

    public String getNomeAmigo() {
        return nomeAmigo;
    }

    public void setNomeAmigo(String nomeAmigo) {
        this.nomeAmigo = nomeAmigo;
    }

    public String getNomeFerramenta() {
        return nomeFerramenta;
    }

    public void setNomeFerramenta(String nomeFerramenta) {
        this.nomeFerramenta = nomeFerramenta;
    }

    public String getDeletado_em() {
        return deletado_em;
    }

    public void setDeletado_em(String deletado_em) {
        this.deletado_em = deletado_em;
    }

}
