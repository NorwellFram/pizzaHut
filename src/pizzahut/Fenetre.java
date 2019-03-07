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
    private JMenu menuPizza, menuIngredient;
    private JMenuItem ajP, supP, modP, ajI, supI, modI;
    
    private int idPizzaModifiee;
    
    JPanel pan;
    GridBagConstraints cont;

    public Fenetre() {
        this.setTitle("Convert");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        init();
        
        ajP.addActionListener(this);
        supP.addActionListener(this);
        modP.addActionListener(this);
        ajI.addActionListener(this);
        supI.addActionListener(this);
        modI.addActionListener(this);
        raz.addActionListener(this);
        calc.addActionListener(this);
    }
    
    public void init(){
        pan=new JPanel();
        cont= new GridBagConstraints();
        
        
        
        
        listePizza=new ArrayList();
        listeLabel=new ArrayList();
        listeIngredient=new ArrayList<>();
        
        listeIngredient.add(new Ingredient("tomate"));
        listeIngredient.add(new Ingredient("fromage"));
        listeIngredient.add(new Ingredient("chorizo"));
        listeIngredient.add(new Ingredient("champignons"));
        
        com=new ArrayList();
        idPizza=new ArrayList();
        
        raz=new JButton("RAZ");
        raz.setBackground(Color.red);
        calc= new JButton("Calculer");
        calc.setBackground(Color.green);
        prix=new JLabel("0.0 $");
        
        menuBar=new JMenuBar();
        
        menuPizza=new JMenu("Pizza");
        menuIngredient=new JMenu("Ingredient");
        
        ajP=new JMenuItem("Ajouter");
        supP=new JMenuItem("Supprimer");
        modP=new JMenuItem("Modifier");
        
        ajI=new JMenuItem("Ajouter");
        supI=new JMenuItem("Supprimer");
        modI=new JMenuItem("Modifier");
        
        
        menuBar.add(menuPizza);
        menuBar.add(menuIngredient);
        
        menuPizza.add(ajP);
        menuPizza.add(supP);
        menuPizza.add(modP);
        
        menuIngredient.add(ajI);
        menuIngredient.add(supI);
        menuIngredient.add(modI);
        
        
        
        vect=new Vector();
        for(int i=0;i<10;i++){
             vect.add(i);
        }
        

        
        
        placement();
        
    }
    
    public void ajoutPizza(){
        AjPizza ajp=new AjPizza(this);
        Pizza p=ajp.showDialog();
        
        if(p!=null){
            listePizza.add(p);
            listeLabel.add(new JLabel(p.getNom()+" "+p.getIngredients()[0].getNom()+" "+p.getTarif()));
            idPizza.add(new JLabel(listePizza.size()+": "));
            com.add(new JComboBox(vect));
        }
        
        placement();
    }
    
    public void suppressionPizza(){
        SupPizza supp=new SupPizza(this);
        int id=-1;
        id=supp.showDialog();
        if(id>0){
            listePizza.remove(id-1);
            listeLabel.remove(id-1);
            com.remove(id-1);
            idPizza.clear();
            for(int i=0; i<listePizza.size();i++){
               idPizza.add(new JLabel(i+1+": "));
            }
        }
        
        placement();
    }
    
    public void modificationPizza(){
        SelectModPizza selmod=new SelectModPizza(this);
        Pizza pizza=selmod.showDialog();

        String lab=pizza.getNom()+" ";
        for(int i=0;i<pizza.getIngredients().length;i++){
            lab+=pizza.getIngredients()[i].getNom()+" ";
        }
        lab+=" "+pizza.getTarif();
        listeLabel.get(idPizzaModifiee).setText(lab);
        placement();
    }
    
    public void ajoutIngredient(){
        AjIngredient aji=new AjIngredient(this);
        Ingredient i=aji.showDialog();
        
        if(i!=null){
            listeIngredient.add(i);
        }
        placement();
    }
    
    public void suppressionIngredient(){
        SupIngredient supp=new SupIngredient(this);
        int id=-1;
        id=supp.showDialog();
        
        if(id>0){
            String ing=listeIngredient.get(id).getNom();
            for(int i=0;i<listePizza.size();i++){
                for(int j=0;j<listePizza.get(i).getIngredients().length;j++){
                    if(listePizza.get(i).getIngredients()[j].getNom()==ing){
                        listePizza.get(i).removeIngredient(j);
                        String lab=listePizza.get(i).getNom()+" ";
                        for(int k=0;k<listePizza.get(i).getIngredients().length;k++){
                            lab+=listePizza.get(i).getIngredients()[i].getNom()+" ";
                        }
                        lab+=" "+listePizza.get(i).getTarif();
                        listeLabel.get(i).setText(lab);
                        
                    }
                }
            }
            listeIngredient.remove(id);
        }
        
        placement();
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
        if(e.getSource()==ajP){
            ajoutPizza();
        }
        if(e.getSource()==supP){
            suppressionPizza();
        }
        if(e.getSource()==modP){
            modificationPizza();
        }
        if(e.getSource()==ajI){
            ajoutIngredient();
        }
        if(e.getSource()==supI){
            suppressionIngredient();
        }
        if(e.getSource()==modI){
            modificationPizza();
        }
        if(e.getSource()==raz){
            remiseAZero();
        }
        if(e.getSource()==calc){
            calcul();
        }
    }
    
    
    
}
