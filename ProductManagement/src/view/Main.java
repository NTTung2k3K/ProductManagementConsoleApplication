/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.ProductManage;
import java.util.ArrayList;

/**
 *
 * @author tung
 */
public class Main {

    public static void main(String[] args) {
        //Init object from control 
        ProductManage manageProduct = new ProductManage();
        Menu menu = new Menu();

        int choice;
        //List for Main menu
        ArrayList<String> listMenu = new ArrayList<>();
        listMenu.add("Create a Product");
        listMenu.add("Check exist Product");
        listMenu.add("Search Product information by name");
        listMenu.add("Update Product");
        listMenu.add("Save to file");
        listMenu.add("Print all lists from file");
        listMenu.add("Exit");

        //List for Update Product case 4
        ArrayList<String> subMenuUpdate = new ArrayList<>();
        subMenuUpdate.add("Update Product");
        subMenuUpdate.add("Delete Product");
        subMenuUpdate.add("Back to Menu");

        //List for Ask User continue or back
        ArrayList<String> ask = new ArrayList<>();
        ask.add("Continue");
        ask.add("Back To Menu");

        do {
            System.out.println("=================PRODUCT-MANAGER=====================");
            choice = menu.getChoice(listMenu);
            switch (choice) {
                case 1:
                    manageProduct.createProduct();
                    int choiceSub;
                    do {
                        // ask User want to continue or back to menu
                        System.out.println("______________________________________");
                        choiceSub = menu.getChoice(ask);
                        switch (choiceSub) {
                            case 1:
                                manageProduct.createProduct();
                                break;
                        }
                    } while (choiceSub > 0 && choiceSub < ask.size());
                    break;
                case 2:
                    manageProduct.checkExistProduct();
                    do {
                        // ask User want to continue or back to menu
                        System.out.println("______________________________________");
                        choiceSub = menu.getChoice(ask);
                        switch (choiceSub) {
                            case 1:
                                manageProduct.checkExistProduct();
                                break;
                        }
                    } while (choiceSub > 0 && choiceSub < ask.size());
                    break;
                case 3:
                    manageProduct.searchProductByName();
                    do {
                        // ask User want to continue or back to menu
                        System.out.println("______________________________________");
                        choiceSub = menu.getChoice(ask);
                        switch (choiceSub) {
                            case 1:
                                manageProduct.searchProductByName();
                                break;
                        }
                    } while (choiceSub > 0 && choiceSub < ask.size());
                    break;
                case 4:
                    int subChoiceUpdate;
                    do {
                        System.out.println("______________________________________");
                        subChoiceUpdate = menu.getChoice(subMenuUpdate);
                        switch (subChoiceUpdate) {
                            case 1:
                                manageProduct.updateProduct();
                                do {
                                    System.out.println("______________________________________");
                                    // ask User want to continue or back to menu
                                    choiceSub = menu.getChoice(ask);
                                    switch (choiceSub) {
                                        case 1:
                                            manageProduct.updateProduct();
                                            break;
                                    }
                                } while (choiceSub > 0 && choiceSub < ask.size());
                                break;
                            case 2:
                                manageProduct.removeProduct();
                                do {
                                    System.out.println("______________________________________");
                                    // ask User want to continue or back to menu
                                    choiceSub = menu.getChoice(ask);
                                    switch (choiceSub) {
                                        case 1:
                                            manageProduct.removeProduct();
                                            break;
                                    }
                                } while (choiceSub > 0 && choiceSub < ask.size());
                                break;
                        }
                    } while (subChoiceUpdate >= 1 && subChoiceUpdate < subMenuUpdate.size());
                    break;
                case 5:
                    manageProduct.saveToFile();
                    do {
                        System.out.println("______________________________________");
                        // ask User want to continue or back to menu
                        choiceSub = menu.getChoice(ask);
                        switch (choiceSub) {
                            case 1:
                                manageProduct.saveToFile();
                                break;
                        }
                    } while (choiceSub > 0 && choiceSub < ask.size());
                    break;
                case 6:
                    manageProduct.loadFromFile();
                    do {
                        System.out.println("______________________________________");
                        // ask User want to continue or back to menu
                        choiceSub = menu.getChoice(ask);
                        switch (choiceSub) {
                            case 1:
                                manageProduct.loadFromFile();
                                break;
                        }
                    } while (choiceSub > 0 && choiceSub < ask.size());
                    break;
                default:
                    System.err.println("BYE !!!");
                    break;
            }
            System.out.println("=====================================================");
        } while (choice > 0 && choice < listMenu.size());
    }
}
