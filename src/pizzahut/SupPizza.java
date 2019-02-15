/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzahut;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author p1700594
 */
public class SupPizza extends JDialog implements ActionListener{
    private JComboBox<Integer> com;
    private JLabel pizza;
    private JButton val, annul;
    private Integer[] vect;
    private int idPizza=0;
    JPanel pan;
    GridBagConstraints cont;

    public SupPizza(Fenetre fen){
        
        super(fen,true);
        
        
        this.setTitle("Ajouter une Pizza");
        vect=new Integer[fen.getNbPizza()];
        init(fen);
        
        
        
        annul.addActionListener(this);
        val.addActionListener(this);
    }
    
    public void init(Fenetre fen){
        pan=new JPanel();
        cont= new GridBagConstraints();
        
        pan.setLayout(new GridBagLayout());
        cont.fill=GridBagConstraints.BOTH;
        
        pizza=new JLabel("Pizza a supprimer");
        val=new JButton("Supprimer");
        annul=new JButton("Annuler");
        for(int i=0;i<fen.getNbPizza();i++){
            vect[i]=(Integer) i+1;
        }
        
       
        
        com=new JComboBox<>(vect);
        
        cont.gridx=0;
        cont.gridy=0;
        pan.add(pizza,cont);
        
        cont.gridx=1;
        cont.gridy=0;
        pan.add(com,cont);
        
        cont.gridx=1;
        cont.gridy=1;
        pan.add(annul,cont);
        
        cont.gridx=1;
        cont.gridy=2;
        pan.add(val,cont);
        
        this.setContentPane(pan);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==val){
            this.setVisible(false);
            idPizza=(int) com.getSelectedItem();
        }
        if(e.getSource()==annul){
            this.setVisible(false);
            idPizza=0;
        }
    }
    
    public int showDialog(){
        this.setVisible(true); //on ouvre la fenêtre
        return idPizza; //on retourne le résultat
    }
}
