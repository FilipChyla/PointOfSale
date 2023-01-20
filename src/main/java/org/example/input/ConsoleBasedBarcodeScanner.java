package org.example.input;

import java.util.Scanner;

public class ConsoleBasedBarcodeScanner implements InputDevice {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String scanBarcode() {
        System.out.print("Pass bar code: ");
        return scanner.nextLine();
    }
}
