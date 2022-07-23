/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator.Interfaces;

import Model.InvoiceHeader;
import java.util.ArrayList;

/**
 *
 * @author Khaled
 */
public interface FileOperationsInterface {
     ArrayList<InvoiceHeader> readFile();
     void writeFile(ArrayList<InvoiceHeader> invoiceHeaders);
     void deleteFile(String filePath);
}
