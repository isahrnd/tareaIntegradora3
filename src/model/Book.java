package model;
import java.util.Calendar;

import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Book extends Products{
    
    private int UnitSold;
    private Calendar datePublish;
    private BookGenre bookGenre;
    private String bookReview;
    private double price;
    private double totalsold;         

    public Book (String name, int numberPages, Calendar datePublish, String url, String bookReview, int i, double price, String identifier){
        super(name, numberPages, url, datePublish, identifier);

        switch (i) {
            case 1:
                this.bookGenre = BookGenre.SCIENCE_FICTION;
                break;
            case 2: 
                this.bookGenre = BookGenre.FANTASY;
                break;
            case 3:
                this.bookGenre = BookGenre  .HISTORICAL_NOVELS;
                break;
        
            default:
                break;
        }
        this.bookReview = bookReview; 
        this.price = price;
        this.datePublish = datePublish;
        this.totalsold = 0;
    }

    public String getBookReview() {
        return bookReview;
    }

    public void setBookReview(String Bookreview) {
        this.bookReview = bookReview;
    }

    public BookGenre getBookGenre() {
        return bookGenre;
    }

    public void setGenreBook(Book genreBook) {
        this.bookGenre = bookGenre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public Calendar getPublicationDate() {
        return datePublish;
    }



    public void setPublicationDate(Calendar publicationDate) {
        this.datePublish = datePublish;
    }

    public String toString(){

        String msg = "";

        msg = "" + getName() + "  |  " + " Book " ;

        return msg;
        
    }



    public String getName() {
        return null;
    }

    public double getTotalsold() {
        return totalsold;
    }



    public void setTotalsold(double totalsold) {
        this.totalsold = totalsold;
    }

    public void add(Book products) {
    }


    

}

