package ss17.controller;

import ss17.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ProductController {
    public static HashMap<Integer, Product> productsMap = new HashMap<>();
    public static final String FILE_NAME = "src/ss17/Product.csv";

    public static void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            List<String> list = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                list.add(line);

            }
            for (int i = 1; i < list.size(); i++) {
                String[] parts = list.get(i).split(",");
                int id =Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                productsMap.put(id, new Product(id, name, price));
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            bw.append("id,name,price");
            bw.append("\n");
            for (int i: productsMap.keySet()) {
                bw.append(Integer.toString(productsMap.get(i).getId()));
                bw.append(',');
                bw.append(productsMap.get(i).getName());
                bw.append(',');
                bw.append(Double.toString(productsMap.get(i).getPrice()));
                bw.append('\n');
            }
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void findProducts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap id product can hien thi");
        int id = scanner.nextInt();
        System.out.println(productsMap.get(id));
    }

    public static void displayProducts() {
        for (Product product : productsMap.values()) {
            System.out.println(product);
        }
    }

    public static void addProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap thong tin product can them");
        int id;
        do {
            System.out.println("Nhap id");
            id = scanner.nextInt();
        }
        while (productsMap.containsKey(id));
        System.out.println("Nhap name product");
        String name = scanner.next();
        System.out.println("Nhap price");
        double price = scanner.nextDouble();
        productsMap.put(id, new Product(id, name, price));
        System.out.println("Da them thanh cong product");
    }

    public static void removeProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id product can xoa");
        int id = parseInt(sc.nextLine());
        if (productsMap.containsKey(id)) {
            productsMap.remove(id);
        }
        System.out.println("Da xoa product voi id la" + id);
    }
}
