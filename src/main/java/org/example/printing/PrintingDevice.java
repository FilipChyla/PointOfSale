package org.example.printing;

import org.example.data.Product;

import java.util.List;

public interface PrintingDevice {
    void printReceipt(List<Product> products);
}
