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
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 *
 * @author p1700594
 */
public class Fenetre extends JFrame implements ActionListener{
    private ArrayList<Pizza> listePizza;
    private ArrayList<JLabel> listeLabel;
    private ArrayList<JComboBox> com; 
    private ArrayList<JLabel> idPizza;
    private ArrayList<Ingredient> listeIngredient;
    private Vector vect;
    private JLabel prix;
    
    private JButton raz;
    private JButton calc;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem aj, sup, mod;
    
    private int idPizzaModifiee;
    
    JPanel pan;
    GridBagConstraints cont;

    public Fenetre() {
        this.setTitle("Convert");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        
        aj.addActionListener(this);
        sup.addActionListener(this);
        mod.addActionListener(this);
        raz.addActionListener(this);
        calc.addActionListener(this);
    }
    
    public void init(){
        pan=new JPanel();
        cont= new GridBagConstraints();
        
        
        
        
        listePizza=new ArrayList();
        listeLabel=new ArrayList();
        com=new ArrayList();
        idPizza=new ArrayList();
        
        raz=new JButton("RAZ");
        raz.setBackground(Color.red);
        calc= new JButton("Calculer");
        calc.setBackground(Color.green);
        prix=new JLabel("0.0 $");
        
        menuBar=new JMenuBar();
        menu=new JMenu("Pizza");
        aj=new JMenuItem("Ajouter");
        sup=new JMenuItem("Supprimer");
        mod=new JMenuItem("Modifier");
        menuBar.add(menu);
        menu.add(aj);
        menu.add(sup);
        menu.add(mod);
        
        
        
        vect=new Vector();
        for(int i=0;i<10;i++){
             vect.add(i);
        }
        

        
        
        placement();
        
    }
    
    public void ajout(){
        AjPizza ajp=new AjPizza(this);
        Pizza p=ajp.showDialog();
        
        listePizza.add(p);
        listeLabel.add(new JLabel(p.getNom()+" "+p.getIngredients()+" "+p.getTarif()));
        idPizza.add(new JLabel(listePizza.size()+": "));
        com.add(new JComboBox(vect));
        placement();
    }
    
    public void suppression(){
        SupPizza supp=new SupPizza(this);
        int id=supp.showDialog();
        listePizza.remove(id-1);
        listeLabel.remove(id-1);
        com.remove(id-1);
        idPizza.clear();
        for(int i=0; i<listePizza.size();i++){
            idPizza.add(new JLabel(i+1+": "));
        }
        placement();
    }
    
    public void modification(){
        SelectModPizza selmod=new SelectModPizza(this);
        Pizza pizza=selmod.showDialog();
        
        listePizza.get(idPizzaModifiee).setNom(pizza.getNom());
        listePizza.get(idPizzaModifiee).setTarif(pizza.getTarif());
        listePizza.get(idPizzaModifiee).setIngredients(pizza.getIngredients().toString());
        
        listeLabel.get(idPizzaModifiee).setText(pizza.getNom()+" "+pizza.getIngredients()+" "+pizza.getTarif());
        
    }
    
    public void remiseAZero(){
        for(int i=0; i<com.size();i++){
            com.get(i).setSelectedIndex(0);
        }
        prix.setText("0.0 $");
        prix.repaint();
    }
    
    public void calcul(){
        float total=0;
        for(int i=0;i<com.size();i++){
            total+=Integer.parseInt(com.get(i).getSelectedItem().toString())*listePizza.get(i).getTarif();
        }
        prix.setText(String.valueOf(total)+" $");
        prix.repaint();
    }
    
    public int getNbPizza(){
        return listePizza.size();
    }
    
    public ArrayList<Pizza> getListePizza(){
        return listePizza;
    }
    
    public void setIdPizzaModifiee(int i){
        idPizzaModifiee=i;
    }

    public ArrayList<Ingredient> getListeIngredient() {
        return listeIngredient;
    }

    public void setListeIngredient(ArrayList<Ingredient> listeIngredient) {
        this.listeIngredient = listeIngredient;
    }
    
    
    
    public void placement(){
        pan.removeAll();
        pan.setLayout(new GridBagLayout());
        cont.fill=GridBagConstraints.BOTH;
        
        //cont.gridheight=1+listePizza.size();
        //cont.gridwidth=3;
        
        this.setJMenuBar(menuBar);
        
        
        for(int i=0; i<listePizza.size();i++){
            cont.gridx=0;
            cont.gridy=i;
            pan.add(idPizza.get(i),cont);
            cont.gridx=1;
            cont.gridy=i;
            pan.add(listeLabel.get(i),cont);
            cont.gridx=2;
            cont.gridy=i;
            pan.add(com.get(i),cont);
            
        }
        
        cont.gridx=2;
        cont.gridy=listePizza.size();
        pan.add(raz,cont);
        
        cont.gridx=2;
        cont.gridy=listePizza.size()+1;
        pan.add(calc,cont);
        
        cont.gridx=2;
        cont.gridy=listePizza.size()+2;
        pan.add(prix,cont);
        
        
        
        this.setContentPane(pan);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==aj){
            ajout();
        }
        if(e.getSource()==sup){
            suppression();
        }
        if(e.getSource()==mod){
            modification();
        }
        if(e.getSource()==raz){
            remiseAZero();
        }
        if(e.getSource()==calc){
            calcul();
        }
    }
    
    
    
}
