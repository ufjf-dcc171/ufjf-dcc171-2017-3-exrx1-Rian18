
package trabalholab3;

import javax.swing.JFrame;

/**
 * @author Rian Alves
 */
public class TrabalhoLab3 {

    public static void main(String[] args) {
        Janela janela = new Janela();
         
        janela.setSize(500,500);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //janela.setLocation(10, 50);
        janela.setLocationRelativeTo(null); // Tela aparece no centro 
        janela.setVisible(true);
    }
    
}
