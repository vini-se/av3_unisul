/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Ferramenta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class FerramentaDAO extends ConeccaoDAO {

    public static ArrayList<Ferramenta> MinhaLista = new ArrayList<Ferramenta>();

    public FerramentaDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_ferrametas");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException e) {
            System.out.print(e);
        }

        return maiorID;
    }

    // Retorna a Lista de ferrametas(objetos)
    public ArrayList<Ferramenta> getMinhaLista() {

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_ferramentas");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                String marca = res.getString("marca");
                Double custo_aquisicao = res.getDouble("custo_aquisicao");

                Ferramenta objetoFerramenta = new Ferramenta(id, nome, marca, custo_aquisicao);

                MinhaLista.add(objetoFerramenta);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo ferrameta
    public boolean InsertFerramentaDB(Ferramenta objeto) {
        String sql = "INSERT INTO tb_ferramentas(id,nome,marca,custo_aquisicao) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getMarca());
            stmt.setDouble(4, objeto.getCusto());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean UpdateFerramentaDB(Ferramenta objeto) {
        String sql = "UPDATE tb_ferramentas SET nome=?, marca=?, custo_aquisicao=? WHERE id=?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getMarca());
            stmt.setDouble(3, objeto.getCusto());
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    public boolean DeleteFerramentaDB(int id) {
        String sql = "DELETE FROM tb_ferramentas WHERE id=?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                // Tratar o erro de restrição de chave estrangeira aqui
                JOptionPane.showMessageDialog(null, "Não é possível excluir pois essa ferramenta está atualmente emprestada.");
            } else {
                // Lidar com outros erros SQL aqui
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
