/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OUTILS;

/**
 *
 * @author hamza
 */
public class Outils {

    public static String numToString(int num) {
        switch (num) {
            case 1:
                return "Janv";
            case 2:
                return "Fev";
            case 3:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "Mai";
            case 6:
                return "Juin";
            case 7:
                return "Juil";
            case 8:
                return "Aout";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nouv";
            case 12:
                return "Dec";
        }
        return "";
    }
}
