package ss16.Demo4.book;

public class FictionBook extends BookDemo {
    private String category;

    public FictionBook(String name, int bookCode, Double price, String author, String category) {
        super(name, bookCode, price, author);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
