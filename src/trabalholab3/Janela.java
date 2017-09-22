/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholab3;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Rian Alves
 */
public class Janela extends JFrame {
    
    private final JLabel lblID = new JLabel("ID: ");
    private final JTextField txtID = new JTextField("", 20);
    private final JLabel lblLongitude = new JLabel("Longitude: ");
    private final JTextField txtLongitude = new JTextField("0", 20);
    private final JLabel lblLatitude = new JLabel("Latitude: ");
    private final JTextField txtLatitude= new JTextField("0", 20);
    private final JLabel lblDescricao = new JLabel("Descrição: ");
    private final JTextField txtDescricao = new JTextField("0", 20);
    private final JButton btnSalvar = new JButton("Salvar");
    private final JButton btnExcluir = new JButton("Excluir");
    private final JButton btnEditar = new JButton("Editar");
    
    private final Date data = new Date();
    
    private final JList lstLista = new JList(new DefaultListModel());
    private final ArrayList<Elemento> ele = new ArrayList<>();
    
    int i =0 ;

    public Janela() throws HeadlessException {
        super("Lista");
        setLayout(new FlowLayout());

        JPanel pnlEntrada = new JPanel();
        pnlEntrada.setLayout(new GridLayout(4,2));
        
        
        pnlEntrada.add(lblID);
        pnlEntrada.add(txtID);
        pnlEntrada.add(lblLongitude);
        pnlEntrada.add(txtLongitude);
        pnlEntrada.add(lblLatitude);
        pnlEntrada.add(txtLatitude);
        pnlEntrada.add(lblDescricao);
        pnlEntrada.add(txtDescricao);
        //pnlEntrada.add(btnExcluir,BorderLayout.SOUTH);

        add(pnlEntrada);
        
        JPanel pnlEntrada2 = new JPanel();
        pnlEntrada2.setLayout(new GridLayout(1, 3));
        
        pnlEntrada2.add(btnExcluir);
        pnlEntrada2.add(btnSalvar);
        pnlEntrada2.add(btnEditar);
        pnlEntrada2.add(lstLista);
        
        add(pnlEntrada2);
       
        add(new JScrollPane(lstLista));

        DefaultListModel modelo = (DefaultListModel) lstLista.getModel();
        
        btnSalvar.addActionListener(new ActionListener() {
            //Criamos uma classe que não tem nome, e instaciamos direto 
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Elemento elemento = new Elemento();
                
                
                while(i < 10){
                elemento.setId(Integer.parseInt(txtID.getText()));
                elemento.setLongitude(Double.parseDouble(txtLongitude.getText()));
                elemento.setLatitude(Double.parseDouble(txtLatitude.getText()));
                elemento.setData(data);
                elemento.setDescricao(txtDescricao.getText());
                
                ele.add(elemento);
                i++;
                }
                
                
                modelo.addElement(txtID.getText());
                
                txtID.setText("");
                txtLongitude.setText("");
                txtLatitude.setText("");
                txtDescricao.setText("");
                txtID.requestFocus();
                
            }
        });
        
       btnEditar.addActionListener(new ActionListener() {
            //Criamos uma classe que não tem nome, e instaciamos direto 
            @Override
            public void actionPerformed(ActionEvent e) {
                
                
                txtID.setText(String.valueOf(ele.get(i).getId()));
                txtLongitude.setText(ele.get(i).getLongitude().toString());
                txtLatitude.setText(ele.get(i).getLatitude().toString());
                txtDescricao.setText(ele.get(i).getDescricao());
                txtID.requestFocus();
                
            }
        });
        
         btnExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.List selecionados =  lstLista.getSelectedValuesList();
                
                
                for(Object selecionado : selecionados)
                {
                  
                   modelo.removeElement(selecionado);
                    
                }
            }
        });
    }
    
    
}
