package com.ouisncf.xspeedit.robot;

import com.ouisncf.xspeedit.model.Carton;
import com.ouisncf.xspeedit.util.XspRobotUtils;

import java.util.List;

/**
 * Classe Abstraite pour tous les robots
 * @author hhabka
 * @version 1.0
 *
 **/
public abstract class AbstractRobot {
    /**
     * La liste d'articles
     */
    protected List<Integer> articles;
    /**
     * La taille maximum d'un carton
     */
    protected int cartonMaxTaille;
	/**
	 * Constructeur de robot en initialisationt la liste des articles à traiter et 
	 * la taille de cartons maximum
	 * @param articles
	 * @param cartonMaxTaille
	 */
    public AbstractRobot(String articles, int cartonMaxTaille) {
        this.articles = convertStringToListArticles(articles);
        this.cartonMaxTaille = cartonMaxTaille;
    }
	/**
	 * Convertit un string en liste d'entiers representants les articles
	 * @param articles
	 * @List<Integer>
	 */
    private List<Integer> convertStringToListArticles(String articles) {
        return XspRobotUtils.stringToList(articles);
    }
    /**
     * Emballe les cartons
     * @return List<Carton>
     * 					Liste des cartons emballés
     **/
    public abstract List<Carton> emballer();
}
