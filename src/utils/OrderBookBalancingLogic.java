package utils;

import java.util.List;
import java.util.Map;

/**
 * <h1>OrderBookBalancingLogic</h1>
 * Interface for the OrderBookBalancingLogic for the transactions to be carried out.
 * This interface contains the method to convert the holdings to the models and calculate the transactions needed to be carried out.
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public interface OrderBookBalancingLogic {
    boolean balancingByPercentage();
}
