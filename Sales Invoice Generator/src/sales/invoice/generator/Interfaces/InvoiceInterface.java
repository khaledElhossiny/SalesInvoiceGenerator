/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales.invoice.generator.Interfaces;

import java.util.ArrayList;
import sales.invoice.generator.Classes.Invoice;

/**
 *
 * @author Khaled
 */
public interface InvoiceInterface {
    void SaveInvoice(ArrayList<Invoice> invoice);
    void ReadInvoice();
    void UpdateInvoice();
    void DeleteInvoice();
    void DeleteAllInvoices();
}
