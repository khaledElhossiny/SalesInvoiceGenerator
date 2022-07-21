/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator.Classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import sales.invoice.generator.Interfaces.InvoiceDetailsInterface;

/**
 *
 * @author Khaled
 */
public class InvoiceDetails implements InvoiceDetailsInterface {

    private int invoiceNumber;
    private String itemName;
    private float itemPrice;
    private int itemQuantity;
    private float itemTotalPrice;

    public InvoiceDetails() {
    }

    public InvoiceDetails(int invoiceNumber, String itemName, float itemPrice, int itemQuantity, float itemTotalPrice) {
        this.invoiceNumber = invoiceNumber;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.itemTotalPrice = itemTotalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemPrice(float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemTotalPrice(float itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public float getItemTotalPrice() {
        return itemTotalPrice;
    }

    @Override
    public void SaveInvoiceDetails(ArrayList<InvoiceDetails> invoiceDetails) {
        try {
//            FileWriter writer = new FileWriter("c:\\data\\output.txt", true);  // appends to file
//            FileWriter writer = new FileWriter("c:\\data\\output.txt", false); // overwrites file
            FileWriter writer;
            writer = new FileWriter("C:\\Users\\Khaled\\Desktop\\InvoiceDetails.csv", false);
            for (int i = 0; i < invoiceDetails.size(); i++) {
                writer.write(String.valueOf(invoiceDetails.get(i).invoiceNumber));
                writer.write(",");
                writer.write(String.valueOf(invoiceDetails.get(i).itemName));
                writer.write(",");
                writer.write(String.valueOf(invoiceDetails.get(i).itemPrice));
                writer.write(",");
                writer.write(String.valueOf(invoiceDetails.get(i).itemQuantity));
                writer.write(",");
                writer.write(String.valueOf(invoiceDetails.get(i).itemTotalPrice));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
        }
    }

    public static ArrayList<InvoiceDetails> ReadAllInvoicesDetails() {
        ArrayList<InvoiceDetails> allInvoiceDetails = new ArrayList<>();
        try {
            File file = new File(
                    "C:\\Users\\Khaled\\Desktop\\InvoiceDetails.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String line;
            // Condition holds true till
            // there is character in a string
            while ((line = br.readLine()) != null) {
                allInvoiceDetails.add(new InvoiceDetails(Integer.parseInt(line.split(",")[0]), line.split(",")[1], Float.parseFloat(line.split(",")[2]), Integer.parseInt(line.split(",")[3]), Float.parseFloat(line.split(",")[4])));
                // Print the string
//                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return allInvoiceDetails;
    }

    public static ArrayList<InvoiceDetails> ReadAllInvoiceDetailsExcept(String invoiceNumber) {
        ArrayList<InvoiceDetails> allInvoiceDetails = new ArrayList<>();
        try {
            File file = new File(
                    "C:\\Users\\Khaled\\Desktop\\InvoiceDetails.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String line;
            // Condition holds true till
            // there is character in a string
            while ((line = br.readLine()) != null) {
                if (!line.split(",")[0].equals(invoiceNumber)) {
                    allInvoiceDetails.add(new InvoiceDetails(Integer.parseInt(line.split(",")[0]), line.split(",")[1], Float.parseFloat(line.split(",")[2]), Integer.parseInt(line.split(",")[3]), Float.parseFloat(line.split(",")[4])));
                }
                // Print the string
//                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return allInvoiceDetails;
    }
    
    public static ArrayList<InvoiceDetails> ReadAllInvoiceDetails(String invoiceNumber) {
        ArrayList<InvoiceDetails> allInvoiceDetails = new ArrayList<>();
        try {
            File file = new File(
                    "C:\\Users\\Khaled\\Desktop\\InvoiceDetails.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String line;
            // Condition holds true till
            // there is character in a string
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(invoiceNumber)) {
                    allInvoiceDetails.add(new InvoiceDetails(Integer.parseInt(line.split(",")[0]), line.split(",")[1], Float.parseFloat(line.split(",")[2]), Integer.parseInt(line.split(",")[3]), Float.parseFloat(line.split(",")[4])));
                }
                // Print the string
//                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return allInvoiceDetails;
    }

    @Override
    public void UpdateInvoiceDetails(int InvoiceNumbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteInvoiceDetails(int invoiceNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteAllInvoiceDetails() {
        File f = new File("C:\\Users\\Khaled\\Desktop\\InvoiceDetails.csv");           //file to be delete  
        if (f.delete()) //returns Boolean value  
        {
            System.out.println(f.getName() + " deleted");   //getting and printing the file name  
        }
    }

}
