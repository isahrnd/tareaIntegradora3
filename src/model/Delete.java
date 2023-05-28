package model;

public interface Delete {

    /**
     * Returns a string representation of the magazines.
     *
     * @return A string containing the information of the magazines.
     */
    public String printMagazine();

    /**
     * Deletes a magazine based on its position.
     *
     * @param position The position of the magazine to be deleted.
     * @return {@code true} if the magazine was successfully deleted, {@code false} otherwise.
     */
    public boolean magazineDelete(String position); 
    
}
