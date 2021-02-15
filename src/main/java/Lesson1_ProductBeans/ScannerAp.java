package Lesson1_ProductBeans;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerAp {
    private Scanner scanner;
    private int id;

    public void scannerIdAdd() {
        scanner = new Scanner(System.in);
        System.out.println("Введите id товара, который нужно положить в корзину:\n");
        if (scanner.hasNextInt()) id = scanner.nextInt();
        else throw new RuntimeException("Введите коректный номер id:\n");
    }

    public int getId() {
        return id;
    }
}
