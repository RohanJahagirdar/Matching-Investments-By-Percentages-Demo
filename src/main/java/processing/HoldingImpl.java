package main.java.processing;

import main.java.entity.HoldingEntry;
import utils.CSVFileReader;
import utils.Holding;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>HoldingImpl</h1>
 * The implementation of the Holding Interface.
 * This class calls the CSVReader class to read data from the holdings.csv file in the resources.
 * It also computes the total amount held across all securities.
 * <p>
 *
 * {@inheritDoc}
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class HoldingImpl implements Holding {
    private List<HoldingEntry> holdings;

    @Override
    public List<HoldingEntry> readHoldingData(String fileName) {
        holdings = new ArrayList<>();
        holdings = CSVFileReader.readHoldingCSV(fileName);
        return holdings;
    }

    @Override
    public BigDecimal getTotalHoldingAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(HoldingEntry holdingEntry : holdings) {
            totalAmount = totalAmount.add(holdingEntry.getAmount());
        }
        return totalAmount;
    }
}
