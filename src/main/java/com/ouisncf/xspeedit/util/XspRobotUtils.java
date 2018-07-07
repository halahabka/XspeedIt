package com.ouisncf.xspeedit.util;

import com.ouisncf.xspeedit.model.Carton;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Contient toutes les méthodes utiles du projet
 * @author hhabka
 * @version 1.0
 **/
public class XspRobotUtils {

    /**
     * Convertit un string en liste d'integer.
     * @param articlesStr Le string contenant les tailles
     * @return Collection d'Integer
     */
    public static List<Integer> stringToList(String articlesStr) {
        List<Integer> articleList = new ArrayList<>();

        Matcher intMatcher = Pattern.compile("[1-9]").matcher(articlesStr);
        while (intMatcher.find()) {
            articleList.add(Integer.parseInt(intMatcher.group()));
        }

        if(articleList.isEmpty() || (articlesStr.length() != articleList.size())){
            throw new IllegalArgumentException("Erreur dans l'entrée");
        }
        return articleList;
    }
    /**
     * Convertit la liste des cartons en string
     * @param cartons 
     * @return String
     */
    public static String cartonsToString(List<Carton> cartons) {
        //Si la liste ne contient aucun Carton
        if (cartons.isEmpty()) {
            return "Aucun Carton!";
        }
        StringBuilder output = new StringBuilder(cartons.get(0).toString());
        for (int i = 1; i < cartons.size(); i++) {
            output.append(XspRobotConstants.SEPARATEUR).append(cartons.get(i));
        }
        return output.toString();
    }

}
