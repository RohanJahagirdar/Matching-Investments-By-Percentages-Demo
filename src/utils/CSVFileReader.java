package utils;

import main.java.entity.HoldingEntry;
import main.java.entity.ModelEntry;
import main.java.entity.TransactionDetails;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * <h1>CSVFileReader</h1>
 * This class reads data from the holdings.csv and the models.csv files from the resources.
 * It also writes the output orders in the orders.csv file.
 * <p>
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class CSVFileReader {
    //static String filePath = "data/input/";
    private static final String FILE_HEADER = "Sec,Transaction,Amount";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    /**
     * Parses and reads the details of the holdings from the file provided.
     * This method returns the details of holdings in the form of a list of HoldingEntry.
     * @param inFileName name of the file in the resources to be used to read the details of current holdings from.
     * @return A list of HoldingEntry objects where each object contains the details of a particular holding.
     */
    public static List<HoldingEntry> readHoldingCSV(String inFileName) {
        List<HoldingEntry> holdingList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(inFileName));
            String line = null;
            Scanner scanner = null;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                HoldingEntry holdingEntry = new HoldingEntry();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0) {
                        holdingEntry.setSec(data);
                    }
                    else if (index == 1){
                        holdingEntry.setAmount(new BigDecimal(data));
                    }
                    index++;
                }
                index = 0;
                holdingList.add(holdingEntry);
            }
            reader.close();
        } catch (IOException e) {
        }

        return holdingList;
    }

    /**
     * Parses and reads the details of the models from the file provided.
     * This method returns the details of models in the form of a list of ModelEntry.
     * @param inFileName name of the file in the resources to be used to read the details of file to model from.
     * @return A list of ModelEntry objects where each object contains the details of a particular sec to model percentages from.

     */
    public static List<ModelEntry> readModelCSV(String inFileName) {
        List<ModelEntry> modelList = new ArrayList<>();
        try {
            /*BufferedReader reader = new BufferedReader(
                    new FileReader(filePath + inFileName));*/

            BufferedReader reader = new BufferedReader(
                    new FileReader(inFileName));
            String line = null;
            Scanner scanner = null;
            int index = 0;
            while ((line = reader.readLine()) != null) {
                ModelEntry modelEntry = new ModelEntry();
                scanner = new Scanner(line);
                scanner.useDelimiter(",");
                while (scanner.hasNext()) {
                    String data = scanner.next();
                    if (index == 0) {
                        modelEntry.setSec(data);
                    }
                    else if (index == 1){
                        modelEntry.setPercentage(Integer.parseInt(data));
                    }
                    index++;
                }
                index = 0;
                modelList.add(modelEntry);
            }
            reader.close();
            //System.out.println(modelList);
        } catch (IOException e) {
        }
        return modelList;
    }


    /**
     * Writes the details of the transactions to be carried out to the file provided in CSV format.
     * @param orderMap Map of details of each sec, the kind of transaction to be carried out and the amount to be transacted.
     * @param outputFileName name of the file to write the output to. It will be created in the out folder in resources.
     * @return true if the file was created successfully, false otherwise.
     */
    public static boolean writeOrderCSV(Map<String, TransactionDetails> orderMap, String outputFileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(outputFileName);
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);

            for(Map.Entry<String, TransactionDetails> cursor : orderMap.entrySet()) {
                String key = cursor.getKey();
                TransactionDetails transactionDetails = cursor.getValue();
                fileWriter.append(key);
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(transactionDetails.getTransactionType().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(transactionDetails.getAmount().toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (IOException e) {
            //e.printStackTrace();
            return false;
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                //e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
