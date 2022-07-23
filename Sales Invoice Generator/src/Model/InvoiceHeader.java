/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Khaled
 */
public class InvoiceHeader {

    private int invoiceNum;
    private String invoiceDate, customerName;
    private ArrayList<InvoiceLines> invoiceLines;

    //public constructor
    public InvoiceHeader() {
        this.setInvoiceNum(FileOperations.lastInvoiceNum++);
        this.setInvoiceDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
    }

    //Constructor for writing to file
    public InvoiceHeader(String customerName, ArrayList<InvoiceLines> invoiceLines) {
        this();
        this.customerName = customerName;
        this.invoiceLines = invoiceLines;
    }

    //Constructor for reading from file
    public InvoiceHeader(int invoiceNum, String invoiceDate, String customerName, ArrayList<InvoiceLines> invoiceLines) {
        this.invoiceNum = invoiceNum;
        this.invoiceDate = invoiceDate;
        this.customerName = customerName;
        this.invoiceLines = invoiceLines;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<InvoiceLines> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceNum(int invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setInvoiceLines(ArrayList<InvoiceLines> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }
}
