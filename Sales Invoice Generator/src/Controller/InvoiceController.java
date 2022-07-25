/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.FileOperations;
import Model.InvoiceHeader;
import Model.InvoiceLines;
import java.util.ArrayList;

/**
 *
 * @author Khaled
 */
public class InvoiceController {

    FileOperations fileOperations;

    public InvoiceController() {
        this.fileOperations = new FileOperations();
        fileOperations.readLastInvoiceNumber();
    }

    public int getLastInvoiceNum() {
        return fileOperations.lastInvoiceNum;
    }

    public void saveInvoices(ArrayList<InvoiceHeader> invoiceHeaders) {
        if (!invoiceHeaders.isEmpty()) {
            FileOperations fileOperations = new FileOperations();
            fileOperations.deleteFile("InvoiceHeader.csv");
            fileOperations.deleteFile("InvoiceLine.csv");
            fileOperations.writeFile(invoiceHeaders);
        }
    }

    public ArrayList<InvoiceHeader> readInvoices() {
        return fileOperations.readFile(); // read all invoiceHEader on app boot/start
    }

    public double calculateInvoiceHeaderTotalPrice(InvoiceHeader invoiceHeader) {
        double total = 0;
        for (int i = 0; i < invoiceHeader.getInvoiceLines().size(); i++) {
            total += invoiceHeader.getInvoiceLines().get(i).getCount() * invoiceHeader.getInvoiceLines().get(i).getItemPrice();
        }
        return total;
    }
    
    public double calculateInvoiceLineTotalPrice(InvoiceLines invoiceLine) {
        return invoiceLine.getCount()*invoiceLine.getItemPrice();
    }
}
