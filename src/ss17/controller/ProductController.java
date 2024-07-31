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
    public static final String FILE_NAME = "src/ss17/controller/Product.csv";
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
            for (Product product : productsMap.values()) {
                bw.append(Integer.toString(product.getId()));
                bw.append(',');
                bw.append(product.getName());
                bw.append(',');
                bw.append(Double.toString(product.getPrice()));
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
        System.out.println("Nhập id product cần hiển thị thông tin");
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
        System.out.println("Nhập thông tin product cần thêm");
        int id;
        do {
            System.out.println("Nhập id");
            id = scanner.nextInt();
        }
        while (productsMap.containsKey(id));
        System.out.println("Nhập name product");
        String name = scanner.next();
        System.out.println("Nhập price");
        double price = scanner.nextDouble();
        productsMap.put(id, new Product(id, name, price));
        System.out.println("Đã thêm thành công product");
    }
    public static void removeProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id product cần xoá");
        int id = parseInt(sc.nextLine());
        if (productsMap.containsKey(id)) {
            productsMap.remove(id);
        }
        System.out.println("Đã xoá product với id là " + id);
    }
}
