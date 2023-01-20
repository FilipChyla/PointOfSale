package org.example;

import org.example.data.Database;
import org.example.data.Product;
import org.example.display.DisplayDevice;
import org.example.input.InputDevice;
import org.example.printing.PrintingDevice;

import java.util.ArrayList;
import java.util.List;

public class PointOfSale {
    private final InputDevice inputDevice;
    private final DisplayDevice displayDevice;
    private final PrintingDevice printingDevice;
    private final Database database;

    private boolean isActive = true;
    List<Product> shoppingList = new ArrayList<>();

    public PointOfSale(InputDevice inputDevice, DisplayDevice displayDevice, PrintingDevice printingDevice, Database database) {
        this.inputDevice = inputDevice;
        this.displayDevice = displayDevice;
        this.printingDevice = printingDevice;
        this.database = database;
    }

    public void scanProduct() {
        String barcode = inputDevice.scanBarcode();
        actBasedOnBarcode(barcode);
    }

    private void actBasedOnBarcode(String barcode) {
        if (barcode.isEmpty()) {
            displayDevice.displayInvalidBarcodeMessage();
        } else if (barcode.equals("exit")) {
            printingDevice.printReceipt(shoppingList);
            shutDown();
        } else {
            try {
                Product product = database.getByBarcode(Integer.parseInt(barcode));
                shoppingList.add(product);
                displayDevice.displayProductInfo(product);
            } catch (ProductNotFoundException e) {
                displayDevice.displayNotFoundMessage();
            }
        }
    }

    private void shutDown() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }
}
