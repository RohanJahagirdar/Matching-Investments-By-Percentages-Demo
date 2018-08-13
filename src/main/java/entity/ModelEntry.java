package main.java.entity;

/**
 *<h1>ModelEntry</h1>
 * The ModelEntry class represents the details of the holding whose percentage is to be used as model.
 * <p>
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class ModelEntry {
    private String sec;
    private int percentage;

    /**
     * Returns the name of the security.
     * @return the name of the sec in String format.
     */
    public String getSec() {
        return sec;
    }

    /**
     * Set the name of the security to the sec field.
     * @param sec the String to be set as the sec's name.
     */
    public void setSec(String sec) {
        this.sec = sec;
    }

    /**
     * Get the percentage of the current holding being held among all holdings.
     * @return the percentage that is held for this holding.
     */

    public int getPercentage() {
        return percentage;
    }


    /**
     * Set the percentage of the holding.
     * @param percentage the percentage to be set for the holding.
     */

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
