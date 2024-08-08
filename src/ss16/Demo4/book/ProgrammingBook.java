package ss16.Demo4.book;

public class ProgrammingBook extends BookDemo {
    private String language;
    private String framework;

    public ProgrammingBook(String name, int bookCode, Double price, String author, String language, String framework) {
        super(name, bookCode, price, author);
        this.language = language;
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

}
