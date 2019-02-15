/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzahut;

/**
 *
 * @author p1700594
 */
public class Pizza {
    private String nom;
    private String ingredients;
    private float tarif;

    public Pizza() {
    }

    public Pizza(String nom, String ingredients, float tarif) {
        this.nom = nom;
        this.ingredients = ingredients;
        this.tarif = tarif;
    }
    

    public String getNom() {
        return nom;
    }

    public String getIngredients() {
        return ingredients;
    }

    public float getTarif() {
        return tarif;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public void setTarif(float tarif) {
        this.tarif = tarif;
    }

    
    
}
