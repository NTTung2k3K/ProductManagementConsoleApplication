/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import static controllers.Tools.sc;
import view.Menu;
import model.Product;
import java.util.ArrayList;

/**
 *
 * @author tung
 */
public class Validation {

    // Object need to use
    Tools tools = null;
    Menu menu = null;

    // Init value for object
    public Validation() {
        //Init tools for check Valid
        tools = new Tools();
        //Init menu for Ask user YES,NO question
        menu = new Menu();
    }

    /**
     * Check a string has a space
     *
     * @param name
     * @return
     */
    public boolean hasSpaces(String name) {
        char[] charProductName = name.toCharArray();
        for (char word : charProductName) {
            if (word == ' ') {
                System.out.println("Your product name has space");
                return true;
            }
        }
        return false;
    }

    /**
     * Check a string is valid length If string has length greater than 5 then
     * it is valid
     *
     * @param productName
     * @return
     */
    public boolean isValidLength(String productName) {
        if (productName.length() >= 5) {
            return true;
        } else {
            System.out.println("Your product name must at least five character");
            return false;
        }
    }

    /**
     * Get input productName for Update Product If string has length greater
     * than 5 then it is valid
     *
     * @param productName
     * @return
     */
    public boolean inputProductNameForUpdate(String productName) {
        if (productName.equals(" ")) {
            return false;
        } else if (isValidLength(productName.trim()) == true && hasSpaces(productName.trim()) == false) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get input Double for Update Product If enter blank the system will be
     * remained old information
     *
     * @param msg
     * @return
     */
    public Double inputDoubleForUpdate(String msg) {
        Double infor = 0.0;
        System.out.print(msg);
        while (true) {
            try {
                String temp = sc.nextLine();
                if (temp.equals("")) {
                    infor = null;
                    break;
                } else {
                    infor = Double.parseDouble(temp);
                    break;
                }
            } catch (Exception e) {
                System.err.println("Your input is not valid");
                System.err.println("Try Again");
            }
        }
        return infor;

    }

    /**
     * Get input Integer for Update product If enter blank the system will be
     * remained old information
     *
     * @param msg
     * @return
     */
    public Integer inputIntForUpdate(String msg) {
        System.out.print(msg);
        int infor = 0;
        while (true) {
            try {
                String temp = sc.nextLine();
                if (temp.equals("")) {
                    return null;
                } else {
                    infor = Integer.parseInt(temp);
                    break;
                }
            } catch (Exception e) {
                System.err.println("Your input is not valid");
                System.err.println("Try Again");
            }
        }
        return infor;
    }

    /**
     * Get input ProductName ProductName valid if it has valid length and do not
     * has space
     *
     * @param productName
     * @return
     */
    public boolean inputProductName(String productName) {
        if (isValidLength(productName.trim()) == true && hasSpaces(productName.trim()) == false) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Check String is a valid length
     *
     * @param productName
     * @return
     */
    public boolean isValidLengthForUpdate(String productName) {
        if (productName.length() >= 5 || productName.equals(" ")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get input ProductID if product is Exist the system will return false
     *
     * @param productID
     * @param listProduct
     * @return
     */
    public boolean inputProductID(String productID, ArrayList<Product> listProduct) {
        for (Product product : listProduct) {
            if (productID.equalsIgnoreCase(product.getProductID())) {
                System.out.println("Exist ProductID");
                return false;
            }
        }
        return true;

    }

    /**
     * Get input UnitPrice If unitPrice is on range the system will return true
     *
     * @param unitPrice
     * @return
     */
    public boolean inputUnitPrice(double unitPrice) {
        if (unitPrice >= 0 && unitPrice <= 10000) {
            return true;
        } else {
            System.out.println("Unit price must in range (0-10000)");
            return false;
        }
    }

    /**
     * Get input Quantity If quantity is on range the system will return true
     *
     * @param quantity
     * @return
     */
    public boolean inputQuantity(int quantity) {
        if (quantity >= 0 && quantity <= 1000) {
            return true;
        } else {
            System.out.println("Quantity must in range (0 - 1000)");
            return false;
        }
    }

    /**
     * Get input Status Only 2 value Available and Not Available
     *
     * @param status
     * @return
     */
    public boolean inputStatus(String status) {
        if (status.equalsIgnoreCase("Available") || status.equalsIgnoreCase("Not Available")) {
            return true;
        } else {
            System.out.println("Status must Available or Not Available");
            return false;
        }
    }

    /**
     * Check product Exist or Not
     *
     * @param productID
     * @param listProduct
     * @return
     */
    public boolean isExistProduct(String productID, ArrayList<Product> listProduct) {
        for (Product product : listProduct) {
            if (product.getProductID().equalsIgnoreCase(productID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find product By name if product is Exist, The system will return a list
     * else return null
     *
     * @param productName
     * @param listProduct
     * @return
     */
    public ArrayList<Product> findProductByName(String productName, ArrayList<Product> listProduct) {
        ArrayList<Product> resultList = new ArrayList<>();
        for (Product product : listProduct) {
            if (product.getProductName().contains(productName)
                    || product.getProductName().contains(productName.toLowerCase())
                    || product.getProductName().equalsIgnoreCase(productName)
                    || product.getProductName().startsWith(productName)
                    || product.getProductName().toLowerCase().startsWith(productName)
                    || product.getProductName().endsWith(productName)
                    || product.getProductName().toLowerCase().endsWith(productName)) 
            {
                resultList.add(product);
            }
        }
        if (resultList.size() > 0) {
            return resultList;
        } else {
            return null;
        }
    }

    /**
     * Update product Information if enter blank the system will remain old
     * information
     *
     * @param productId
     * @param listProduct
     * @return
     */
    public boolean updateProductInformation(String productId, ArrayList<Product> listProduct) {
        for (Product product : listProduct) {
            if (product.getProductID().equalsIgnoreCase(productId)) {
                System.err.println("If you enter a blank \" \" the system will remain old information");
                boolean flag = true;
                while (flag) {
                    String productID = tools.inputString("Product ID (old:" + product.getProductID() + "):");
                    if (productID.equals("")) {
                        product.setProductID(product.getProductID());
                        flag = false;
                    } else if (inputProductID(productID, listProduct)) {
                        product.setProductID(productID);
                        flag = false;
                    } else {
                        System.err.println("Try Again !!!");
                        flag = true;
                    }
                }

                flag = true;
                while (flag) {
                    String productName = (tools.inputString("Product name (old:" + product.getProductName() + "):"));
                    if (productName.equals("")) {
                        product.setProductName(product.getProductName());
                        flag = false;
                    } else if (inputProductNameForUpdate(productName)) {
                        product.setProductName(productName);
                        flag = false;
                    } else {
                        System.err.println("Try again");
                        flag = true;
                    }
                }

                flag = true;
                while (flag) {
                    Double unitPrice = inputDoubleForUpdate("Unit Price(0-10000) (old:" + product.getUnitPrice() + "):");
                    if (unitPrice == null) {
                        product.setUnitPrice(product.getUnitPrice());
                        flag = false;
                    } else if (inputUnitPrice(unitPrice)) {
                        product.setUnitPrice(unitPrice);
                        flag = false;
                    } else {
                        System.err.println("Try Again");
                        flag = true;
                    }

                }

                flag = true;
                while (flag) {
                    Integer quantity = inputIntForUpdate("Quantity(0-1000) (old:" + product.getQuantity() + "):");
                    if (quantity == null) {
                        product.setQuantity(product.getQuantity());
                        flag = false;
                    } else if (inputQuantity(quantity)) {
                        product.setQuantity(quantity);
                        flag = false;
                    } else {
                        System.err.println("Try Again");
                        flag = true;
                    }
                }

                flag = true;
                while (flag) {
                    String status = tools.inputString("Status (old:" + product.getStatus() + ")" + " (Available or Not Available):");

                    if (status.equals("")) {
                        product.setStatus(product.getStatus());
                        flag = false;
                    } else if (inputStatus(status)) {
                        product.setStatus(status.toUpperCase());
                        flag = false;
                    } else {
                        System.err.println("Try Again");
                        flag = true;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Delete product by ProductID
     *
     * @param productID
     * @param listProduct
     * @return
     */
    public boolean deleteProduct(String productID, ArrayList<Product> listProduct) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getProductID().equalsIgnoreCase(productID)) {
                System.out.println("Do you want to delete " + listProduct.get(i).getProductName());
                ArrayList<String> commit = new ArrayList<>();
                commit.add("NO");
                commit.add("YES");
                int choice = menu.getChoice(commit);
                if (choice == 2) {
                    listProduct.remove(listProduct.get(i));
                    System.err.println("Delete success");
                } else if (choice == 1) {
                    return true;
                }
            }
        }
        return false;
    }

}
