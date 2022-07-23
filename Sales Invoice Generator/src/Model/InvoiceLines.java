/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Khaled
 */
public class InvoiceLines {

    private String itemName;
    private float itemPrice;
    private int invoiceNum, count;

    public InvoiceLines(int invoiceNum, String itemName, float itemPrice, int count) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.invoiceNum = invoiceNum;
        this.count = count;
    }

    public int getInvoiceNum() {
        return invoiceNum;
    }

    public String getItemName() {
        return itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public int getCount() {
        return count;
    }

}
