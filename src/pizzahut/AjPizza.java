/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzahut;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author p1700594
 */
public class AjPizza extends JDialog implements ActionListener{
    private JLabel nom, prix, ingredients;
    private JTextField inNom,inPrix;
    private JButton annul, val, ajIng;
    private Pizza pizza=null;
    private JComboBox inIngredient;
    private String[] comboIngredient;
    JPanel pan;
    GridBagConstraints cont;
    private Fenetre fen;
    private Ingredient ingredient;
    
    public AjPizza(Fenetre fen) {
        super(fen,true);
        this.fen=fen;
        
        this.setTitle("Ajouter une Pizza");
       //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        
        annul.addActionListener(this);
        val.addActionListener(this);
    }
    
    
    public void init(){
        pan=new JPanel();
        cont= new GridBagConstraints();
        
        pan.setLayout(new GridBagLayout());
        cont.fill=GridBagConstraints.BOTH;
        
        nom=new JLabel("Nom");
        
        prix= new JLabel("Prix");
        ingredients=new JLabel("Ingredients");
        inNom=new JTextField("Nouvelle Pizza");
        inNom.setColumns(10);
        inPrix=new JTextField("0");
        inPrix.setColumns(10);
        
        for(int i=0;i<fen.getListeIngredient().size();i++){
            comboIngredient[i]=fen.getListeIngredient().get(i).toString();
        }
        
        inIngredient=new JComboBox(comboIngredient);
        ajIng=new JButton("Ajouter un ingredient");
        annul=new JButton("Annuler");
        annul.setBackground(Color.red);
        val=new JButton("Valider");
        val.setBackground(Color.green);
        
        cont.gridx=0;
        cont.gridy=0;
        pan.add(nom);
        
        cont.gridx=1;
        cont.gridy=0;
        pan.add(inNom);
        
        cont.gridx=0;
        cont.gridy=1;
        pan.add(prix);
        
        cont.gridx=1;
        cont.gridy=1;
        pan.add(inPrix);
        
        cont.gridx=0;
        cont.gridy=2;
        pan.add(ingredients);
        
        cont.gridx=0;
        cont.gridy=3;
        pan.add(inIngredient);
        
        cont.gridx=0;
        cont.gridy=4;
        pan.add(annul);
        
        cont.gridx=1;
        cont.gridy=4;
        pan.add(val);
        
        this.setContentPane(pan);
        this.pack();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==val){
            pizza=new Pizza(inNom.getText(),inIngredient.getName(),Float.parseFloat(inPrix.getText())); //nouvelle pizza
            this.setVisible(false);
        }
        if(e.getSource()==annul){
            pizza=null; //aucune pizza
            this.setVisible(false);
        }
        if(e.getSource()==ajIng){
            
        }
    }
    
    public Pizza showDialog(){
        this.setVisible(true); //on ouvre la fenêtre
        return pizza; //on retourne le résultat
    }
    
}
