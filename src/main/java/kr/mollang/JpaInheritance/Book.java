package kr.mollang.JpaInheritance;


import javax.persistence.Entity;

@Entity
class Book extends Item{

    private String auther;
    private String isbn;

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
