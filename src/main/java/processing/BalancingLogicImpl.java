package main.java.processing;

import main.java.entity.HoldingEntry;
import main.java.entity.ModelEntry;
import main.java.entity.TransactionDetails;
import main.java.entity.TransactionType;
import main.java.processing.HoldingImpl;
import main.java.processing.ModelImpl;
import main.java.processing.OrderImpl;
import utils.OrderBookBalancingLogic;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>BalancingLogicImpl</h1>
 * The implementation of the BalancingLogic Interface.
 * This class computes the amount of securities to be bought or sold based on the model provided.
 * This implementation converts the amount into BigDecimal and thus may be  slow.
 * <p>
 *
 * {@inheritDoc}
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class BalancingLogicImpl implements OrderBookBalancingLogic{
    String holdingFileName, modelFileName, orderFileName;

    public  BalancingLogicImpl(String holdingFileName, String modelFileName, String orderFileName) {
        this.holdingFileName = holdingFileName;
        this.modelFileName = modelFileName;
        this.orderFileName = orderFileName;
    }

    /** Compute the transactions to be done for the current holdings based on the model file provided.
     * The computation takes the files of holdings and the model
     * @return true if file created successfully, false otherwise.
     */
    @Override
    public boolean balancingByPercentage() {

        HoldingImpl holdings = new HoldingImpl();
        ModelImpl models = new ModelImpl();
        OrderImpl orders = new OrderImpl();
        Map<String, TransactionDetails> orderBookMap = new HashMap<>();
        orderBookMap = orders.getOrderMap();
        List<HoldingEntry> holdingsList = holdings.readHoldingData(holdingFileName);
        List<ModelEntry> modelsList = models.readModelData(modelFileName);
        BigDecimal totalHoldingsAmount = holdings.getTotalHoldingAmount();

        if(holdingsList.size() > 0) {
            for (HoldingEntry singleHoldingEntry : holdingsList) {
                TransactionDetails singleTransactionDetails = new TransactionDetails();
                singleTransactionDetails.setTransactionType(TransactionType.SELL);
                singleTransactionDetails.setAmount(singleHoldingEntry.getAmount().setScale(3, BigDecimal.ROUND_HALF_UP));

                orderBookMap.put(singleHoldingEntry.getSec(), singleTransactionDetails);
            }
        }

        if(modelsList.size() > 0) {
            for (ModelEntry singleModelEntry : modelsList) {
                TransactionDetails transactionDetails = new TransactionDetails();
                if(orderBookMap.containsKey(singleModelEntry.getSec())){
                    BigDecimal existingHoldingAmount = orderBookMap.get(singleModelEntry.getSec()).getAmount();
                    BigDecimal newModelAmount = totalHoldingsAmount.multiply(
                            new BigDecimal((float)singleModelEntry.getPercentage()/100));

                    int result = existingHoldingAmount.compareTo(newModelAmount);
                    /*result == 0 both are same,
                      result ==1 existingHoldingAmount > newModelAmount,
                      result == -1 existingHoldingAmount < newModelAmount
                     */
                    if(result == 1) {
                        transactionDetails
                                .setTransactionType(TransactionType.SELL);

                        existingHoldingAmount = existingHoldingAmount.subtract(newModelAmount);
                        existingHoldingAmount = existingHoldingAmount.setScale(3, BigDecimal.ROUND_HALF_UP);
                        transactionDetails
                                .setAmount(existingHoldingAmount);

                        orderBookMap.put(singleModelEntry.getSec(), transactionDetails);
                    } else if (result == -1) {
                        transactionDetails
                                .setTransactionType(TransactionType.BUY);

                        newModelAmount = newModelAmount.subtract(existingHoldingAmount);
                        newModelAmount = newModelAmount.setScale(3, BigDecimal.ROUND_HALF_UP);

                        transactionDetails
                                .setAmount(newModelAmount);
                        orderBookMap.put(singleModelEntry.getSec(), transactionDetails);
                    } else {
                        orderBookMap.remove(singleModelEntry.getSec());
                    }
                } else {
                    transactionDetails.setTransactionType(TransactionType.BUY);
                    BigDecimal newModelAmount = totalHoldingsAmount.multiply(
                            new BigDecimal((float)singleModelEntry.getPercentage()/100));

                    newModelAmount = newModelAmount.setScale(3, BigDecimal.ROUND_HALF_UP);
                    transactionDetails.setAmount(newModelAmount);
                    orderBookMap.put(singleModelEntry.getSec(), transactionDetails);
                }
            }
        }
        return orders.writeOrderData(orderFileName);

    }
}
