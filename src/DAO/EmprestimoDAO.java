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
            ResultSet res = stmt.executeQuery("SELECT te.id as 'id_emprestimo', te.tb_amigos_id, a.nome as 'amigo', te.tb_ferramentas_id, f.nome as 'ferramenta',  DATE_FORMAT(data_emprestimo, '%d/%m/%Y') as 'data_emprestimo', DATE_FORMAT(data_devolucao, '%d/%m/%Y') as 'data_devolucao'\n"
                    + "FROM tb_emprestimos_ativos AS te\n"
                    + "LEFT JOIN tb_amigos a ON a.id = te.tb_amigos_id\n"
                    + "LEFT JOIN tb_ferramentas f ON f.id = te.tb_ferramentas_id\n"
                    + "ORDER by data_devolucao ASC");
            while (res.next()) {

                int id = res.getInt("id_emprestimo");
                int id_amigo = res.getInt("tb_amigos_id");
                int id_ferramenta = res.getInt("tb_ferramentas_id");
                String nomeAmigo = res.getString("amigo");
                String nomeFerramenta = res.getString("ferramenta");
                String data_emprestimo = res.getString("data_emprestimo");
                String data_devolucao = res.getString("data_devolucao");

                Emprestimo objEmprestimo = new Emprestimo(id, id_amigo, nomeAmigo, id_ferramenta, nomeFerramenta, data_emprestimo, data_devolucao);

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

    public boolean DeleteEmprestimoDB(int id) {
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

    public boolean AmigoHasEmprestimo(int id) {
        String sql = "SELECT id FROM tb_emprestimos_ativos WHERE tb_amigos_id = ?";
        boolean temResultado = false;

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                temResultado = true;
            }

            resultSet.close();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

        return temResultado;
    }

}
