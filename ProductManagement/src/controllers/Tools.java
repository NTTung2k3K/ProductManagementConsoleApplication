/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Scanner;

/**
 *
 * @author tung
 */
public class Tools {

    // Using scanner for user input from keyboard
    static Scanner sc = new Scanner(System.in);

    /**
     * Get input String and check valid
     * @param msg
     * @return 
     */
    public String inputString(String msg) {
        String infor = "";
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("Your input is not valid");
                System.out.println("Try Again");
                sc.nextLine();
            }
        }
        return infor;
    }
    
    /**
     * Get input Double and check valid
     * @param msg
     * @return 
     */
    public double inputDouble(String msg) {
        double infor;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.err.println("Your input is not valid");
                System.out.println("Try Again");
                sc.nextLine();
            }
        }
        return infor;
    }
    
    /**
     * Get input Integer and check valid
     * @param msg
     * @return 
     */
    public int inputInt(String msg) {
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.err.println("Your input is not valid");
                System.out.println("Try Again");
                sc.nextLine();
            }
        }
        return infor;

    }
    

}
