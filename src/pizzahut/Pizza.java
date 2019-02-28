/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzahut;

import java.util.ArrayList;

/**
 *
 * @author p1700594
 */
public class Pizza {
    private String nom;
    private Ingredient[] ingredients;
    private int nbIngredient;
    private float tarif;

    public Pizza() {
    }

    public Pizza(String nom, String ingredient, float tarif) {
        this.nom = nom;
        nbIngredient=1;
        this.ingredients = new Ingredient[nbIngredient];
        this.tarif = tarif;
        
        Ingredient i=new Ingredient(ingredient);
        this.ingredients[0]=i;
    }
    

    public String getNom() {
        return nom;
    }

    public Ingredient[] getIngredients() {
        return ingredients;
    }

    public float getTarif() {
        return tarif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addIngredients(String ingredient) {
        nbIngredient++;
        Ingredient[] temp=new Ingredient[nbIngredient];
        for(int i=0;i<ingredients.length;i++){
            temp[i]=ingredients[i];
        }
        temp[nbIngredient-1]=new Ingredient(ingredient);
        ingredients=temp;
    }
    
    public void removeIngredient(int idIngredient){
        Ingredient[] temp=new Ingredient[nbIngredient-1];
        for(int i=0;i<ingredients.length;i++){
            if(i!=idIngredient){
                temp[i]=ingredients[i];
            }   
        }
        ingredients=temp;
        nbIngredient--;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    
    
}
