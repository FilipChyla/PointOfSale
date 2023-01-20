package org.example.data;

import org.example.ProductNotFoundException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MockDatabase implements Database {
    private final List<Product> productList = Arrays.asList(new Product(1, "Pizza", BigDecimal.valueOf(11)),
                                                            new Product(2, "Skyr", BigDecimal.valueOf(4.5)),
                                                            new Product(3, "Cheese", BigDecimal.valueOf(5)),
                                                            new Product(4, "Orange juice", BigDecimal.valueOf(8)),
                                                            new Product(5, "Hot-dog", BigDecimal.valueOf(2.8)));

    @Override
    public Product getByBarcode(int barcode) throws ProductNotFoundException {
        try {
            return productList.stream().filter(product -> product.code() == barcode).toList().get(0);
        } catch (Exception e){
            throw new ProductNotFoundException();
        }
    }
}
