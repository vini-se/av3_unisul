/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.ConeccaoDAO;
import Model.Amigo;
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
public class AmigoDAO extends ConeccaoDAO {

    public ArrayList<Amigo> MinhaLista = new ArrayList<>();

    public AmigoDAO() {
    }

    public int maiorID() throws SQLException {

        int maiorID = 0;
        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT MAX(id) id FROM tb_amigos");
            res.next();
            maiorID = res.getInt("id");

            stmt.close();

        } catch (SQLException e) {
            System.out.print(e);
        }

        return maiorID;
    }

    // Retorna a Lista de Amigos(objetos)
    public ArrayList<Amigo> getListaAmigos() {

        MinhaLista.clear(); // Limpa nosso ArrayList

        try {
            Statement stmt = this.getConexao().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tb_amigos");
            while (res.next()) {

                int id = res.getInt("id");
                String nome = res.getString("nome");
                long telefone = res.getLong("telefone");
                String email = res.getString("email");

                Amigo objetoAmigo = new Amigo(id, nome, email, telefone);
                MinhaLista.add(objetoAmigo);
            }

            stmt.close();

        } catch (SQLException ex) {
        }

        return MinhaLista;
    }

    // Cadastra novo amigo
    public boolean InsertAmigoDB(Amigo objeto) {
        String sql = "INSERT INTO tb_amigos(id,nome,email,telefone) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, objeto.getId());
            stmt.setString(2, objeto.getNome());
            stmt.setString(3, objeto.getEmail());
            stmt.setString(4, Long.toString(objeto.getTelefone()));

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean UpdateAmigoDB(Amigo objeto) {
        String sql = "UPDATE tb_amigos SET nome = ?, email = ?, telefone = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setString(1, objeto.getNome());
            stmt.setString(2, objeto.getEmail());
            stmt.setString(3, Long.toString(objeto.getTelefone()));
            stmt.setInt(4, objeto.getId());

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }

    }

    public boolean DeleteAmigoDB(int id) {
        String sql = "DELETE FROM tb_amigos WHERE id = ?";
        boolean deleteSuccessful = false;

        try {
            PreparedStatement stmt = this.getConexao().prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.execute();
            stmt.close();

            deleteSuccessful = true;

        } catch (SQLException e) {
            if (e.getErrorCode() == 1451) {
                // Tratar o erro de restrição de chave estrangeira aqui
                JOptionPane.showMessageDialog(null, "Não é possível excluir pois esse amigo atualmente possui uma ferramenta emprestada.");
            } else {
                // Lidar com outros erros SQL aqui
                throw new RuntimeException(e);
            }
        }
        
        return deleteSuccessful;
    }
    
}
