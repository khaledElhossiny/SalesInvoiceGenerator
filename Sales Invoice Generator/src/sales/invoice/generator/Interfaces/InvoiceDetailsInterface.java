/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator.Interfaces;

import java.util.ArrayList;
import sales.invoice.generator.Classes.InvoiceDetails;

/**
 *
 * @author Khaled
 */
public interface InvoiceDetailsInterface {
    void SaveInvoiceDetails(ArrayList<InvoiceDetails> invoiceDetails);
    void UpdateInvoiceDetails(int InvoiceNumbers);
    void DeleteInvoiceDetails(int invoiceNumber);
    void DeleteAllInvoiceDetails();
}
