package ss17.controller;

import ss17.model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static ss17.controller.Validate.*;

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
                int id = Integer.parseInt(parts[0]);
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
        String id;
        do {
            System.out.println("Nhập id");
            id = scanner.next();
            if (ValidateID(id)) {
                System.out.println("Nhap id thanh cong");
            }
            while (ValidateID(id) == false) {
                System.out.println("ID không hợp lệ. Xin mời bạn nhập lại !");
                id = scanner.next();
                if (ValidateID(id)) {
                    System.out.println("Nhap id thanh cong");
                }
            }
        }
        while (productsMap.containsKey(id));

        String name;
        do {
            System.out.println("Nhập name product");
            name = scanner.next();
            if (ValidateName(name)) {
                System.out.println("Nhap name thanh cong");
            }
            while (ValidateName(name) == false) {
                System.out.println("Name không hợp lệ. Xin mời bạn nhập lại !");
                name = scanner.next();
                if (ValidateName(name)) {
                    System.out.println("Nhap name thanh cong");
                }
            }
        }
        while (productsMap.containsValue(name));

        System.out.println("Nhap price");
        String price = scanner.next();
        if (ValidatePrice(price)) {
            System.out.println("Nhap price thanh cong");
        }
        while (ValidatePrice(price) == false) {
            System.out.println("Price không hợp lệ. Xin mời bạn nhập lại !");
            price = scanner.next();
            if (ValidatePrice(price)) {
                System.out.println("Nhap price thanh cong");
            }
        }
        productsMap.put(Integer.parseInt(id), new Product(Integer.parseInt(id), name, Double.parseDouble(price)));
        System.out.println("Thêm thành công sản phẩm");
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

