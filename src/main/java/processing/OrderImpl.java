package main.java.processing;

import main.java.entity.TransactionDetails;
import utils.CSVFileReader;
import utils.Order;

import java.util.HashMap;
import java.util.Map;

/**
 * <h1>OrderImpl</h1>
 * The implementation of the Order Interface.
 * This class gets the Map of sec and the transactions to be performed.
 * It writes this to the order.csv file.
 * <p>
 *
 * {@inheritDoc}
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class OrderImpl implements Order {
    private Map<String, TransactionDetails> orderMap;

    public OrderImpl() {
        orderMap = new HashMap<>();
    }

    public Map<String, TransactionDetails> getOrderMap() {
        return orderMap;
    }

    public void setOrderMap(Map<String, TransactionDetails> orderMap) {
        this.orderMap = orderMap;
    }

    @Override
    public boolean writeOrderData(String fileName) {
        return CSVFileReader.writeOrderCSV(orderMap, fileName);
    }
}
