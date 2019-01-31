/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VUES.AUTH;

/**
 *
 * @author hamza
 */
public class State {
    private static int check;

    public static int getCheck() {
        return check;
    }
    
    public static void setCheck(int check) {
        State.check = check;
    }
}