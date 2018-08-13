package utils;

import main.java.entity.HoldingEntry;

import java.math.BigDecimal;
import java.util.List;

/**
 * <h1>Holding</h1>
 * Interface for the holdings.
 * This interface contains the method to read the details of a holding from a csv file, whose name is provided.
 * It also contains method to calculate the total amount held.
 *
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public interface Holding {
    List<HoldingEntry> readHoldingData(String fileName);
    BigDecimal getTotalHoldingAmount();
}
