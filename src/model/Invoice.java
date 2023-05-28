package model;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Represents an invoice for a transaction.
 */
public class Invoice {
    
    private String id;
    private Calendar dateSold;
    private String name;
    private double transactionQuantity;

    /**
     * Constructs an Invoice object with the specified identifier, name, and transaction quantity.
     *
     * @param id                the identifier of the invoice
     * @param name              the name associated with the invoice
     * @param transactionQuantity the quantity of the transaction
     */

    public Invoice(String identifier, Object name2, Object valueSuscription) {
    }
    public void invoice(String id, String name, double transactionQuantity){

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) + 1; 
        int year = calendar.get(Calendar.YEAR);
        Calendar datePublication = new GregorianCalendar(year, month, day);


        this.dateSold = datePublication;
        this.transactionQuantity = transactionQuantity;
        this.id = id;
        this.name = name; 

        /**
     * Returns the identifier of the invoice.
     *
     * @return the identifier of the invoice
     */
}
public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public Calendar getDateSold() {
    return dateSold;
}

public void setDateSold(Calendar dateSold) {
    this.dateSold = dateSold;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public double getTransactionQuantity() {
    return transactionQuantity;
}

public void setTransactionQuantity(double transactionQuantity) {
    this.transactionQuantity = transactionQuantity;
}

}
