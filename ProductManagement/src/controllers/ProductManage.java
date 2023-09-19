/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Product;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import view.Menu;

/**
 *
 * @author tung
 */
public class ProductManage {

    // Object used for this class
    ArrayList<Product> listProduct = null;
    ArrayList<Product> listProductFromFile = null;
    Tools tools = null;
    Validation validation = null;
    Menu menuConfirm = null;
    ArrayList<String> ask = null;

    
    
    
    // Init object
    public ProductManage() {
        // Init the Objects to control product
        listProduct = new ArrayList<>();
        listProductFromFile = new ArrayList<>();
        tools = new Tools();
        validation = new Validation();
        menuConfirm = new Menu();
        //List submenu to ask user want to continue input or not
        ask = new ArrayList<>();
        ask.add("Continue input");
        ask.add("Back");
        
        //Information for TEST
        listProduct.add(new Product("S5", "Fannn", 4, 2, "Available"));
        listProduct.add(new Product("S2", "Laptop", 25, 3, "Available"));
        listProduct.add(new Product("S1", "Television", 32, 2, "Not Available"));
        listProduct.add(new Product("S4", "Table", 4, 1, "Available"));
        listProduct.add(new Product("S7", "Guitar", 25, 1, "Not Available"));
        listProduct.add(new Product("S0", "KeyBoard", 25, 2, "Not Available"));
    }

    
    
    
    
    
    /**
     * Create a product by get input from user
     */
    public void createProduct() {
        
        int choice;
        Product product = new Product();
        boolean flag = true;

        while (flag) {
            String productID = tools.inputString("Product ID: ");
            if (validation.inputProductID(productID, listProduct)) {
                product.setProductID(productID);
                flag = false;
            } else {
                do {
                    choice = menuConfirm.getChoice(ask);
                    if (choice == 1) {
                        productID = tools.inputString("Product ID: ");
                        if (validation.inputProductID(productID, listProduct)) {
                            product.setProductID(productID);
                            flag = false;
                        } else {
                            flag = true;
                        }
                    } else {
                        return;
                    }
                } while (flag);
            }
        }

        flag = true;
        boolean subFlag = false;
        while (flag) {
            String productName = (tools.inputString("Product name: "));
            if (validation.inputProductName(productName)) {
                product.setProductName(productName);
                flag = false;
            } else {
                do {
                    choice = menuConfirm.getChoice(ask);
                    if (choice == 1) {
                        productName = tools.inputString("Product name: ");
                        if (validation.inputProductName(productName)) {
                            product.setProductName(productName);
                            flag = false;
                        } else {
                            flag = true;
                        }
                    } else {
                        return;
                    }
                } while (flag);
            }

            flag = true;
            while (flag) {
                double unitPrice = tools.inputDouble("Unit Price(0-10000): ");
                if (validation.inputUnitPrice(unitPrice)) {
                    product.setUnitPrice(unitPrice);
                    flag = false;
                } else {
                    do {
                        choice = menuConfirm.getChoice(ask);
                        if (choice == 1) {
                            unitPrice = tools.inputDouble("Unit Price(0-10000): ");
                            if (validation.inputUnitPrice(unitPrice)) {
                                product.setUnitPrice(unitPrice);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }

            }

            flag = true;
            while (flag) {
                int quantity = tools.inputInt("Quantity(0-1000): ");
                if (validation.inputQuantity(quantity)) {
                    product.setQuantity(quantity);
                    flag = false;
                } else {
                    do {
                        choice = menuConfirm.getChoice(ask);
                        if (choice == 1) {
                            quantity = tools.inputInt("Quantity(0-1000): ");
                            if (validation.inputQuantity(quantity)) {
                                product.setQuantity(quantity);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);
                }
            }

            flag = true;
            while (flag) {
                String status = tools.inputString("Status(Available or Not Available): ");
                if (validation.inputStatus(status)) {
                    product.setStatus(status.toUpperCase());
                    flag = false;
                } else {
                    do {
                        choice = menuConfirm.getChoice(ask);
                        if (choice == 1) {
                            status = tools.inputString("Status(Available or Not Available): ");
                            if (validation.inputStatus(status)) {
                                product.setStatus(status);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);
                }
            }

            if (listProduct.add(product)) {
                System.err.println("Add Successfully");
            } else {
                System.err.println("Error please try again");
            }
        }
    }

    /**
     * Check Exist product by ProductID
     */
    public void checkExistProduct() {
        String productID = "";
        productID = tools.inputString("ProductID want to check Exist:");
        if (validation.isExistProduct(productID, listProduct)) {
            System.err.println("Exist Product");
        } else {
            System.err.println("No Product Found!");
        }
    }

    /**
     * Search product by get the ProductName
     */
    public void searchProductByName() {
        ArrayList<Product> listReturn = null;
        String partName = tools.inputString("Enter Product Name: ");
        if (validation.findProductByName(partName, listProduct) != null) {
            listReturn = validation.findProductByName(partName, listProduct);

            Collections.sort(listReturn, new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getProductName().compareTo(o2.getProductName());
                }
            });
            System.out.println("+------------+---------------+----------------+---------------+----------------+----------------+");
            System.out.println("|   Number   |   ProductID   |      Name      |   UnitPrice   |    Quantity    |     Status     |");
            System.out.println("+------------+---------------+----------------+---------------+----------------+----------------+");
            int i = 0;
            for (Product product : listReturn) {
                System.out.print(String.format("|%12d", ++i));
                System.out.println(product.toString());
            }
            System.out.println("+------------+---------------+----------------+---------------+----------------+----------------+");
        } else {
            System.err.println("Have no any Product");
        }
    }

    /**
     * Update product by ProductID
     */
    public void updateProduct() {
        String productID = tools.inputString("ProductId want to update:");
        if (validation.updateProductInformation(productID, listProduct)) {
            System.err.println("SUCCESS !!!");
        } else {
            System.err.println("Product does not exist");
        }
    }

    /**
     * Remove product by ProductID
     */
    public void removeProduct() {

        String productID = tools.inputString("ProductID want to delete: ");
        if (validation.deleteProduct(productID, listProduct)) {
            System.out.println("Cancel delete success");
        } else {
            System.out.println("Product does not exist");
        }
    }

    // Declare pathName Local variable to used for save and load from file
    String pathName;

    /**
     * Save file by pathName
     */
    public void saveToFile() {
        try {
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
            String datetime = time.format(dtf);
            pathName = "./PM_" + datetime + ".dat";
            File f = new File(pathName);
            f.createNewFile();
            if (!f.exists()) {
                System.err.println("File is not Exist");
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                Collections.sort(listProduct, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getQuantity() == o2.getQuantity()) {
                            return Double.compare(o1.getUnitPrice(), o2.getUnitPrice());
                        } else {
                            return o2.getQuantity() - o1.getQuantity();
                        }
                    }
                });

                for (Product product : listProduct) {
                    bw.write(product.fileToString() + "\n");
                }
                bw.close();
                System.err.println("Save successfully !");
                System.out.println("Your file is " + pathName);

            }
        } catch (Exception e) {
            System.err.println("ERROR Try again !");
        }
    }

    /**
     * Load file from pathName
     */
    public void loadFromFile() {
        try {
            listProductFromFile.clear();
            File f = new File(pathName);
            if (!f.exists()) {
                System.err.println("File is not Exist");
            } else {
                System.out.println("Load File " + pathName);
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null && (!br.equals(""))) {
                    String[] data = line.split(", ");
                    Product pr = new Product();
                    pr.setProductID(data[0]);
                    pr.setProductName(data[1]);
                    pr.setUnitPrice(Double.parseDouble(data[2]));
                    pr.setQuantity(Integer.parseInt(data[3]));
                    pr.setStatus(data[4]);
                    listProductFromFile.add(pr);
                }
                br.close();
                System.out.println("+------------+---------------+----------------+---------------+----------------+----------------+");
                System.out.println("|   Number   |   ProductID   |      Name      |   UnitPrice   |    Quantity    |     Status     |");
                System.out.println("+------------+---------------+----------------+---------------+----------------+----------------+");
                int i = 0;
                for (Product product : listProductFromFile) {
                    System.out.print(String.format("|%12d", ++i));
                    System.out.println(product.toString());
                }
                System.out.println("+------------+---------------+----------------+---------------+----------------+----------------+");
            }

        } catch (Exception e) {
            System.err.println("ERROR Try again !");
        }
    }
}
