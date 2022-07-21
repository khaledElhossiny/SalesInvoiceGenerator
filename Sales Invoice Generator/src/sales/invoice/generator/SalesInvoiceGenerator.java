/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator;

import GUIForms.SalesInvoiceGeneratorFrame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import sales.invoice.generator.Classes.Invoice;
import sales.invoice.generator.Classes.InvoiceDetails;


/**
 *
 * @author Khaled
 */
public class SalesInvoiceGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new SalesInvoiceGeneratorFrame();
    }
}
