package main.java.entity;

import java.math.BigDecimal;

/**
 *<h1>HoldingEntry</h1>
 * The HoldingEntry class represents the details of a particular holding.
 * <p>
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class HoldingEntry {
    private String sec;
    private BigDecimal amount;

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
     * Get the amount that is being held for this holding.
     * @return the amount that is held for this holding.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Set the amount of the holding.
     * @param amount the amount to be set for the holding.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
