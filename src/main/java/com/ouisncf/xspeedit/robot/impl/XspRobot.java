package com.ouisncf.xspeedit.robot.impl;

import com.ouisncf.xspeedit.model.Carton;
import com.ouisncf.xspeedit.robot.AbstractRobot;
import com.ouisncf.xspeedit.util.XspRobotConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Robot qui trie par ordre descendant puis remplie les cartons en reparcourant chaque fois ceux 
 * qu'il a déjà rempli
 * @author hhabka
 * @version 1.0
 **/
public final class XspRobot extends AbstractRobot {
	/**
	 * Constructeur de robot en initialisationt la liste des articles à traiter et 
	 * la taille de cartons maximum
	 * @param articles
	 */
    public XspRobot(String articles) {
        super(articles, XspRobotConstants.CORTON_MAX_TAILLE);
    }
    
    /**
     * Emballe les cartons d'une façon optimisée.Utilise l'algorithme FirstFitDecreasing
     * @return List<Carton>
     * 					Liste des cartons emballés
     **/
    @Override
    public List<Carton> emballer() {
        List<Carton> cartons = new ArrayList<>();
        //Trier les articles en ordre de taille décroissante
        Collections.sort(articles, Collections.reverseOrder());
        for (Integer articleActuel : articles) {
            boolean traite = false; // true si l'article a été déjà placé dans un carton
            int cartonActuel = 0;
            while (!traite) {
                if (cartonActuel == cartons.size()) {
                    Carton newCarton = new Carton();
                    newCarton.addArticle(articleActuel);
                    cartons.add(newCarton);
                    traite = true;
                } else if (cartons.get(cartonActuel).getTaille() + articleActuel <= cartonMaxTaille) {
                    cartons.get(cartonActuel).addArticle(articleActuel);
                    traite = true;
                } else {
                	cartonActuel++;
                }
            }
        }
        return cartons;
    }
}
