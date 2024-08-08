package ss16.Demo4.book;

public class BookDemo {
    private String name;
    private int bookCode;
    private Double price;
    private String author;

    public BookDemo(String name, int bookCode, Double price, String author) {
        this.name = name;
        this.bookCode = bookCode;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookCode() {
        return bookCode;
    }

    public void setBookCode(int bookCode) {
        this.bookCode = bookCode;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void getAmount(){}
}
