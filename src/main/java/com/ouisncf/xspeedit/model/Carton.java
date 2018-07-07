package com.ouisncf.xspeedit.model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *Modèle de l'objet Carton avec ses fonctions
 * @author hhabka
 * @version 1.0
 * 
 **/
public class Carton {

    private int tailleActuelle;
    private List<Integer> articles;
    
    /**
     * Surcharger le constructeur par défaut pour construire l'array de cartons
     */
    public Carton() {
    	articles = new ArrayList<>();
    }

    /**
     * Ajoute un article au carton
     * @param article 
     * 				article à ajouter
     */
    public void addArticle(Integer article) {
    	articles.add(article);
        tailleActuelle += article;
    }

    /**
     * Retourne la taille actuelle du carton
     * @return la taille actuelle.
     */
    public int getTaille() {
        return tailleActuelle;
    }
    
    /**
     * Permet d'afficher le contenu d'un carton lors d'un toString()
     * @return String
     * 
     */
    @Override
    public String toString() {
        StringBuilder resultat = new StringBuilder();
        for(Integer article : articles){
        	resultat.append(article);
        }
        return resultat.toString();
    }
}
