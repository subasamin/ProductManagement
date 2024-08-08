package ss16.Demo4.book;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BookDemo book = new ProgrammingBook("cntt",1,2.0,"Duy","Java","sach");
        BookDemo book1 = new ProgrammingBook("cntt",2,2.0,"Duy","Java","sach");
        BookDemo book2 = new ProgrammingBook("cntt",3,2.0,"Duy","Java","sach");
        BookDemo book3 = new FictionBook("sao hoa",4,3.0,"Duy","vien tuong");
        BookDemo book4 = new FictionBook("trai dat",5,3.0,"Duy","vien tuong");
        BookDemo book5 = new FictionBook("sao kim",6,3.0,"Duy","vien tuong");
        List<BookDemo> books = new ArrayList<>();
        int i;
        double price = 0;
        for (i = 0; i < books.size(); i++){
            price += books.get(i).getPrice();
        }
        System.out.println("Gia cua 6 quan sach la: "+price);
        int index=0;
        String word;
        for (i = 0; i < books.size(); i++){
            if (books.get(i)instanceof ProgrammingBook){
                word = ((ProgrammingBook) books.get(i)).getLanguage();
                if (word.equals("Java")){
                    index++;
                }
            }
        }
        System.out.println("So quan sach co language la Java la" +index);
    }
}
