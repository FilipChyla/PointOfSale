package org.example.data;

import org.example.ProductNotFoundException;

import java.rmi.NoSuchObjectException;

public interface Database {
    Product getByBarcode(int barcode) throws ProductNotFoundException;
}
