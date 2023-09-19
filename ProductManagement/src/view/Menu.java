/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tung
 */
public class Menu {

    /**
     * Get choice from A list menu
     *
     * @param listMenu
     * @return
     */
    public int getChoice(ArrayList<String> listMenu) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {
            try {
                int i = 0;
                for (String str : listMenu) {
                    System.out.println(++i + "_" + str);
                }
                System.out.println("Please choose an option from 1..." + listMenu.size());
                choice = sc.nextInt();
                if (choice == 0 || choice >= (listMenu.size() + 1) || choice < 0) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.err.println("Your choice is not valid");
                System.out.println("Try Again !!!");
                sc.nextLine();
            }
        }

        return choice;
    }

}
