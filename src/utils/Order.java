package utils;


/**
 *
 * <h1>Order</h1>
 * Interface for the order for the transactions to be carried out.
 * This interface contains the method to write the details of the transaction to a csv file, whose name is provided.
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */

public interface Order {

    /**
     * Method to write the details of the order to be transacted.
     * @param fileName name of the file to which the transaction details are to be written to.
     * @return true if the file was created and the details written successfully, false otherwise.
     */
    boolean writeOrderData(String fileName);
}
