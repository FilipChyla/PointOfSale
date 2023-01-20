package org.example;

import org.example.data.MockDatabase;
import org.example.display.ConsoleLCD;
import org.example.input.ConsoleBasedBarcodeScanner;
import org.example.printing.ConsoleBasedPrinter;

public class Main {
    public static void main(String[] args) {
        PointOfSale pointOfSale = new PointOfSale(new ConsoleBasedBarcodeScanner(), new ConsoleLCD(), new ConsoleBasedPrinter(), new MockDatabase());

        while (pointOfSale.isActive()){
            pointOfSale.scanProduct();
        }
    }
}