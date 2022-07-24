/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import sales.invoice.generator.Interfaces.FileOperationsInterface;

/**
 *
 * @author Khaled
 */
public class FileOperations implements FileOperationsInterface {

    public static int lastInvoiceNum = 0;

    @Override
    public ArrayList<InvoiceHeader> readFile() {
        ArrayList<InvoiceHeader> invoiceHeaders = new ArrayList<>();
        try {
            String invoiceHeadersCurrentLine, invoiceLinesCurrentLine;
            Scanner invoiceHeadersScanner = new Scanner(new File("InvoiceHeader.csv"));
            while (invoiceHeadersScanner.hasNext()) //returns a boolean value
            {
                Scanner invoiceLinesScanner = new Scanner(new File("InvoiceLine.csv"));
                ArrayList<InvoiceLines> invoiceLines = new ArrayList<>();
                invoiceHeadersCurrentLine = invoiceHeadersScanner.nextLine();
                while (invoiceLinesScanner.hasNext()) //returns a boolean value
                {
                    invoiceLinesCurrentLine = invoiceLinesScanner.nextLine();
                    if (invoiceLinesCurrentLine.split(",")[0].equals(invoiceHeadersCurrentLine.split(",")[0])) {
                        invoiceLines.add(new InvoiceLines(Integer.parseInt(invoiceLinesCurrentLine.split(",")[0]),
                                invoiceLinesCurrentLine.split(",")[1], Float.parseFloat(invoiceLinesCurrentLine.split(",")[2]),
                                Integer.parseInt(invoiceLinesCurrentLine.split(",")[3])));

                    }
                }
                invoiceHeaders.add(new InvoiceHeader(Integer.parseInt(invoiceHeadersCurrentLine.split(",")[0]),
                        invoiceHeadersCurrentLine.split(",")[1], invoiceHeadersCurrentLine.split(",")[2], invoiceLines));
                invoiceLinesScanner.close();
            }
            invoiceHeadersScanner.close();
        } catch (FileNotFoundException ex) {
        }
        return invoiceHeaders;
    }

    @Override
    public void writeFile(ArrayList<InvoiceHeader> invoiceHeaders) {
        try {
//            FileWriter writer = new FileWriter("c:\\data\\output.txt", true);  // appends to file
//            FileWriter writer = new FileWriter("c:\\data\\output.txt", false); // overwrites file
            FileWriter invoiceHeadersWriter = new FileWriter("C:\\Users\\Khaled\\Desktop\\InvoiceHeader.csv", true);
            FileWriter invoiceLinesWriter = new FileWriter("C:\\Users\\Khaled\\Desktop\\InvoiceLine.csv", true);
            for (int i = 0; i < invoiceHeaders.size(); i++) {
                invoiceHeadersWriter.write(String.valueOf(invoiceHeaders.get(i).getInvoiceNum()));
                invoiceHeadersWriter.write(",");
                invoiceHeadersWriter.write(String.valueOf(invoiceHeaders.get(i).getInvoiceDate()));
                invoiceHeadersWriter.write(",");
                invoiceHeadersWriter.write(String.valueOf(invoiceHeaders.get(i).getCustomerName()));
                invoiceHeadersWriter.write("\n");
                for (int j = 0; j < invoiceHeaders.get(i).getInvoiceLines().size(); j++) {
                    invoiceLinesWriter.write(String.valueOf(invoiceHeaders.get(i).getInvoiceLines().get(j).getInvoiceNum()));
                    invoiceLinesWriter.write(",");
                    invoiceLinesWriter.write(invoiceHeaders.get(i).getInvoiceLines().get(j).getItemName());
                    invoiceLinesWriter.write(",");
                    invoiceLinesWriter.write(String.valueOf(invoiceHeaders.get(i).getInvoiceLines().get(j).getItemPrice()));
                    invoiceLinesWriter.write(",");
                    invoiceLinesWriter.write(String.valueOf(invoiceHeaders.get(i).getInvoiceLines().get(j).getCount()));
                    invoiceLinesWriter.write("\n");
                }
            }
            invoiceHeadersWriter.close();
            invoiceLinesWriter.close();
        } catch (IOException e) {
        }
    }

    @Override
    public void deleteFile(String filePath) {
        File myFile = new File(filePath);
        if (myFile.delete()) {
            System.out.println("Deleted the file: " + myFile.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public int readLastInvoiceNumber() {
        try {
            String currentLine;
            //Read InvoiceLines
            Scanner scanner = new Scanner(new File("C:\\Users\\Khaled\\Desktop\\InvoiceHeader.csv"));
            while (scanner.hasNext()) //returns a boolean value
            {
                currentLine = scanner.nextLine();
                if (!currentLine.isEmpty()) {
                    if (scanner.hasNext() != true) {
                        lastInvoiceNum = Integer.parseInt(currentLine.split(",")[0]);
                        lastInvoiceNum++;
                    }
                } else {
                    lastInvoiceNum = 1;
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            lastInvoiceNum = 1;
        }
        return lastInvoiceNum;
    }

}
