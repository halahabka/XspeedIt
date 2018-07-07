package com.ouisncf.xspeedit;

import com.ouisncf.xspeedit.model.Carton;
import com.ouisncf.xspeedit.robot.impl.XspRobot;
import com.ouisncf.xspeedit.util.XspRobotUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class Main {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {     
        if(args.length == 1) {
        	System.out.println(2);
        	String articles = args[0];
            LOGGER.info("Les articles sont: {}", articles);         
            //Robot optimisé: FirstFitDecreasing
            List<Carton> cartons = new XspRobot(articles).emballer();
            LOGGER.info("Emballage par le robot XspeedIt: {} => {} cartons", XspRobotUtils.cartonsToString(cartons), cartons.size());
        } else {
            LOGGER.warn("Il manque 1 argumrent");
        }
    }    
}