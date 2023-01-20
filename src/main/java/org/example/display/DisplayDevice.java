package org.example.display;

import org.example.data.Product;

public interface DisplayDevice {
    void displayProductInfo(Product product);
    void displayNotFoundMessage();
    void displayInvalidBarcodeMessage();
}
