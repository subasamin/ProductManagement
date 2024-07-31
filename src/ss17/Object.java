//package ss17.controller;
//
//import ss17.model.Product;
//
//import java.io.*;
//import java.util.Arrays;
//
//public class Object {
//    private static java.lang.Object in;
//    public final String FILE_NAME_OBJECT = "src/ss17/controller/Object.txt";
//    public static void writeFileObject(String fileName, Product object) {
//        try {
//            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
//            out.writeObject(object);
//            out.flush();
//            out.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static void readFileObject(String fileName){
//        try {
//            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
//            Product product = (Product) in.readObject();
//            System.out.println(product);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    public static void main(String[] args) {
//////        Product product = new Product(1,"iphone",1000);
////        writeFileObject("src/ss17/controller/Object.txt",product);
//        readFileObject("src/ss17/controller/Object.txt");
//
//    }
//}
