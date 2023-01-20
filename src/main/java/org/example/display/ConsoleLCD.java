package org.example.display;

import org.example.data.Product;

public class ConsoleLCD implements DisplayDevice {

    @Override
    public void displayProductInfo(Product product) {
        System.out.println(product.name()+": "+product.value()+"zl added to shopping cart");
    }

    @Override
    public void displayNotFoundMessage() {
        System.out.println("Product not found");
    }

    @Override
    public void displayInvalidBarcodeMessage() {
        System.out.println("Invalid bar code");
    }
}
