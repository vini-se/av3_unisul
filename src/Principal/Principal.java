/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Principal;
import View.TelaPrincipal;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here        
        TelaPrincipal objetoTela = new TelaPrincipal();        
        objetoTela.setVisible(true); 
    }
    
}

