package ss17.view;
import java.util.*;
import static ss17.controller.ProductController.*;
public class ManagerProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Quản lý sản phẩm");
            System.out.println("1,Hiển thị danh sách các sản phẩm");
            System.out.println("2,Tìm kiếm sản phẩm theo id");
            System.out.println("3,Thêm sản phẩm");
            System.out.println("4,Xoá sản phẩm");
            System.out.println("5,Ghi danh sách sản phẩm vào file");
            System.out.println("6,Đọc danh sách sản phẩm từ file");
            System.out.println("Nhập một số để chọn");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    findProducts();
                    break;
                case 3:
                    addProduct();
                    break;
                case 4:
                    removeProduct();
                    break;
                case 5:
                    writeFile();
                    break;
                case 6:
                    readFile();
                    break;
                default:
                    System.out.println("Xin moi chon lai");
            }
        }
        while (true);
    }
}
