package org.example.printing;

import org.example.data.Product;

import java.math.BigDecimal;
import java.util.List;

public class ConsoleBasedPrinter implements PrintingDevice {
    @Override
    public void printReceipt(List<Product> products) {
        var wrapper = new Object() {
            BigDecimal sum = BigDecimal.ZERO;
        };

        products.forEach(product -> {
            wrapper.sum = wrapper.sum.add(product.value());
            System.out.printf("%-20s%szl\n", product.name(), product.value().toString());
        });

        System.out.println("--------");
        System.out.println("Suma: " + wrapper.sum.toString());
    }
}
