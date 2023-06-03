package DAO;

import Model.Emprestimo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vinic
 */
public class EmprestimoDAO extends ConeccaoDAO {

    public static ArrayList<Emprestimo> MinhaLista = new ArrayList<Emprestimo>();


    ;

    public EmprestimoDAO() {
    }

    public ArrayList<Emprestimo> getMinhaLista() {

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT te.id as 'id_emprestimo', a.nome as 'amigo', f.nome as 'ferramenta', data_devolucao\n"
                    + "FROM tb_emprestimos_ativos AS te\n"
                    + "LEFT JOIN tb_amigos a ON a.id = te.tb_amigos_id\n"
                    + "LEFT JOIN tb_ferramentas f ON f.id = te.tb_ferramentas_id\n"
                    + "ORDER BY data_devolucao ASC");
            while (res.next()) {

                int id = res.getInt("id_emprestimo");
                String nomeAmigo = res.getString("amigo");
                String nomeFerramenta = res.getString("ferramenta");
                String data_devolucao = res.getString("data_devolucao");

                Emprestimo objEmprestimo = new Emprestimo(id, nomeAmigo, nomeFerramenta, data_devolucao);

                MinhaLista.add(objEmprestimo);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_emprestimos_ativos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException e) {
            System.out.print(e);
        }

        return maiorID;
    }

    public boolean InsertEmprestimoDB(Emprestimo objeto) {
        String sql = "INSERT INTO tb_emprestimos_ativos(id,tb_amigos_id,tb_ferramentas_id,data_emprestimo, data_devolucao) VALUES(?,?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setInt(2, objeto.getAmigo_id());
            stmt.setInt(3, objeto.getFerramenta_id());
            stmt.setString(4, objeto.getData_emprestimo());
            stmt.setString(5, objeto.getData_devolucao());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean UpdateEmprestimoDB(int id, String data_devolucao) {
        String sql = "UPDATE tb_emprestimos_ativos SET data_devolucao = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, data_devolucao);
            stmt.setInt(2, id);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }
    
    public boolean DeleteEmprestimoDB(int id){
        String sql = "DELETE FROM tb_emprestimos_ativos WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

}
