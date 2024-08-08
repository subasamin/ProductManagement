package ss16.Demo4.book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDemo book = new ProgrammingBook("cntt",1,2.0,"Duy","Java","sach");
        BookDemo book1 = new ProgrammingBook("cntt",2,2.0,"Duy","Java","sach");
        BookDemo book2 = new ProgrammingBook("cntt",3,2.0,"Duy","Java","sach");
        BookDemo book3 = new FictionBook("sao hoa",4,3.0,"Duy","vien tuong1");
        BookDemo book4 = new FictionBook("trai dat",5,3.0,"Duy","vien tuong");
        BookDemo book5 = new FictionBook("sao kim",6,3.0,"Duy","vien tuong1");
        List<BookDemo> books = new ArrayList<>();
        books.add(book);
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        int i;
        double price = 0;
        for (i = 0; i < books.size(); i++){
            price += books.get(i).getPrice();
        }
        System.out.println("Gia cua 6 quan sach la: "+price);
        int count=0;
        String word;
        for (i = 0; i < books.size(); i++){
            if (books.get(i)instanceof ProgrammingBook){
                word = ((ProgrammingBook) books.get(i)).getLanguage();
                if (word.equals("Java")){
                    count++;
                }
            }
        }
        System.out.println("So quan sach co language la Java la" +count);
        int count1=0;
        int count2=0;
        for (i = 0; i < books.size(); i++){
            if (books.get(i)instanceof FictionBook){
                if (((FictionBook) books.get(i)).getCategory().equals("vientuong1")){
                    count1++;
                }
                if(100 > (books.get(i).getPrice())){
                    count2++;
                }
            }
        }
        System.out.println("So quan sach co category vien tuong 1 la: "+count1);
        System.out.println("So sach co gia nho hon 100 la"+count2);

    }
}
