package model;

import java.util.Calendar;

/**
 * The abstract class Products represents a generic product.
 * It provides common attributes and methods for all types of products.
 */

public abstract class Products {

    private String name;
    private String url; 
	private int numberPages;
    private int totalPages;
    private String identifier;
	private Calendar datePublish;
    
    
    

	public Products(String name, int numberPages,String url , Calendar publicationDate, String identifier) {
		super();

		this.name = name;
        this.numberPages = numberPages;
        this.datePublish = publicationDate;
        this.url = url;
        this.totalPages = 0;
        this.identifier = identifier;
       
	}
    
    /**
     * Returns the name of the product.
     *
     * @return the name of the product
     */

    public Object getName() {
        return name;
    }

    /**
     * Sets the name of the product.
     *
     * @param name the name of the product
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the number of pages of the product.
     *
     * @return the number of pages of the product
     */

    public int getNumberPages() {
        return numberPages;
    }

    /**
     * Sets the number of pages of the product.
     *
     * @param numberPages the number of pages of the product
     */
    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    /**
     * Returns the publication date of the product.
     *
     * @return the publication date of the product
     */

    public Calendar getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(Calendar publicationDate) {
        this.datePublish = publicationDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public int getTotalPages() {
        return totalPages;
    }



    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    

}
    

