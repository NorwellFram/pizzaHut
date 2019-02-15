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
    private ArrayList<Ingredient> ingredients;
    private float tarif;

    public Pizza() {
    }

    public Pizza(String nom, String ingredients, float tarif) {
        this.nom = nom;
        this.ingredients = null;
        this.tarif = tarif;
    }
    

    public String getNom() {
        return nom;
    }

    public ArrayList getIngredients() {
        return ingredients;
    }

    public float getTarif() {
        return tarif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIngredients(String ingredient) {
        this.ingredients.add(new Ingredient(ingredient));
    }
    
    public void removeIngredient(int idIngredient){
        this.ingredients.remove(idIngredient);
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    
    
}
