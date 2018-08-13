package main.java.entity;

import java.math.BigDecimal;

/**
 *
 *<h1>ModelEntry</h1>
 * The TransactionDetails class represents the type of transaction to be done and the amount to be transacted.
 * <p>
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class TransactionDetails {
    private TransactionType transactionType;
    private BigDecimal amount;

    /**
     * Get the type of transaction to be done on an holding. Can be SELL or BUY.
     * @return SELL or BUY transaction type.
     */
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * Set the transactionType for the transaction. Can be SELL or BUY.
     * @param transactionType one of TransactionType.SELL or TransactionType.BUY
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * Get the amount of the security that is to be transacted.
     * @return the amount to be transacted.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Set the amount of the transaction.
     * @param amount the amount to be set for the transaction.
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
