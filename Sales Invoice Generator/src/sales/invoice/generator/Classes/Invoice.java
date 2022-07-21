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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import sales.invoice.generator.Interfaces.InvoiceInterface;

/**
 *
 * @author Khaled
 */
public class Invoice implements InvoiceInterface {

    private int invoiceNumber = 0;
    private String invoiceDate;
    private String invoiceCustomer;
    private float invoiceTotal;

    ArrayList<InvoiceDetails> myInvoiceDetails;

    public Invoice() {
    }

    public Invoice(int invoiceNumber, String invoiceDate, String invoiceCustomer, float invoiceTotal, ArrayList<InvoiceDetails> myDetails) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.invoiceCustomer = invoiceCustomer;
        this.invoiceTotal = invoiceTotal;
        this.myInvoiceDetails = myDetails;
    }

    public Invoice(String invoiceCustomer, float invoiceTotal, ArrayList<InvoiceDetails> myDetails) {
        if (ReadLastInvoiceNumber() != 0) {
            invoiceNumber += ReadLastInvoiceNumber();
        }
        setInvoiceDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        this.invoiceCustomer = invoiceCustomer;
        this.invoiceTotal = invoiceTotal;
        this.myInvoiceDetails = myDetails;
    }

    public void setMyInvoiceDetails(ArrayList<InvoiceDetails> myInvoiceDetails) {
        this.myInvoiceDetails = myInvoiceDetails;
    }

    public ArrayList<InvoiceDetails> getMyInvoiceDetails() {
        return myInvoiceDetails;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getInvoiceCustomer() {
        return invoiceCustomer;
    }

    public float getInvoiceTotal() {
        return invoiceTotal;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        invoiceNumber = invoiceNumber;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setInvoiceCustomer(String invoiceCustomer) {
        this.invoiceCustomer = invoiceCustomer;
    }

    public void setInvoiceTotal(float invoiceTotal) {
        this.invoiceTotal = invoiceTotal;
    }

    private void WriteInvoiceToCSV(ArrayList<Invoice> invoices) {
        try {
//            FileWriter writer = new FileWriter("c:\\data\\output.txt", true);  // appends to file
//            FileWriter writer = new FileWriter("c:\\data\\output.txt", false); // overwrites file
            FileWriter writer;
            writer = new FileWriter("C:\\Users\\Khaled\\Desktop\\Invoices.csv", false);
            for (int i = 0; i < invoices.size(); i++) {
                writer.write(String.valueOf(invoices.get(i).invoiceNumber));
                writer.write(",");
                writer.write(String.valueOf(invoices.get(i).invoiceDate));
                writer.write(",");
                writer.write(String.valueOf(invoices.get(i).invoiceCustomer));
                writer.write(",");
                writer.write(String.valueOf(invoices.get(i).invoiceTotal));
            }
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
        }
    }

    private int ReadLastInvoiceNumber() {
        int lastInvoiceNumber = 0;
        try {
            String currentLine;
            Scanner sc = new Scanner(new File("C:\\Users\\Khaled\\Desktop\\Invoices.csv"));
            while (sc.hasNext()) //returns a boolean value
            {
                currentLine = sc.nextLine();
                if (sc.hasNext() != true) {
                    lastInvoiceNumber = Integer.parseInt(currentLine.split(",")[0]);
                }
            }
            sc.close();  //closes the scanner
        } catch (FileNotFoundException ex) {
        }
        return lastInvoiceNumber;
    }

    public static Invoice ReadInvoiceFromCSV(String invoiceNumber) {
        Invoice invoice = null;
        try {
            File file = new File(
                    "C:\\Users\\Khaled\\Desktop\\Invoices.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String line;
            // Condition holds true till
            // there is character in a string
            while ((line = br.readLine()) != null) {
                if (line.split(",")[0].equals(invoiceNumber)) {
                    invoice = new Invoice(Integer.parseInt(line.split(",")[0]), line.split(",")[1], line.split(",")[2],
                            Float.parseFloat(line.split(",")[3]),
                            InvoiceDetails.ReadAllInvoiceDetails(line.split(",")[0]));
                }
                // Print the string
//                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return invoice;
    }

    public static ArrayList<Invoice> ReadAllInvoicesExcept(String invoiceNumber) {
        ArrayList<Invoice> allInvoices = new ArrayList<>();
        try {
            File file = new File(
                    "C:\\Users\\Khaled\\Desktop\\Invoices.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String line;
            // Condition holds true till
            // there is character in a string
            while ((line = br.readLine()) != null) {
                if (!line.split(",")[0].equals(invoiceNumber)) {
                    allInvoices.add(new Invoice(Integer.parseInt(line.split(",")[0]), line.split(",")[1], line.split(",")[2],
                            Float.parseFloat(line.split(",")[3]),
                            InvoiceDetails.ReadAllInvoiceDetails(line.split(",")[0])));
                }
// Print the string                
//                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return allInvoices;
    }

    public static ArrayList<Invoice> ReadAllInvoicesFromCSV() {
        ArrayList<Invoice> allInvoices = new ArrayList<>();
        try {
            File file = new File(
                    "C:\\Users\\Khaled\\Desktop\\Invoices.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String line;
            // Condition holds true till
            // there is character in a string
            while ((line = br.readLine()) != null) {
                allInvoices.add(new Invoice(Integer.parseInt(line.split(",")[0]), line.split(",")[1], line.split(",")[2],
                        Float.parseFloat(line.split(",")[3]),
                        InvoiceDetails.ReadAllInvoiceDetails(line.split(",")[0])));
                // Print the string
//                System.out.println(line);
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return allInvoices;
    }

    @Override
    public void SaveInvoice(ArrayList<Invoice> invoices) {
        //invoice is initialized with 0, constructor increments
        this.WriteInvoiceToCSV(invoices);   //Save invoice to CSV

    }

    @Override
    public void ReadInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void UpdateInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteAllInvoices() {
        File f = new File("C:\\Users\\Khaled\\Desktop\\Invoices.csv");           //file to be delete  
        if (f.delete()) //returns Boolean value  
        {
            System.out.println(f.getName() + " deleted");   //getting and printing the file name  
        }
    }

}
