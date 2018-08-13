package main.java.processing;

import main.java.entity.ModelEntry;
import utils.CSVFileReader;
import utils.Model;

import java.util.List;

/**
 * <h1>ModelImpl</h1>
 * The implementation of the Model Interface.
 * This class calls the CSVReader class to read data from the models.csv file in the resources.
 * <p>
 *
 * {@inheritDoc}
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public class ModelImpl implements Model {
    private List<ModelEntry> models;

    @Override
    public List<ModelEntry> readModelData(String fileName) {
        models = CSVFileReader.readModelCSV(fileName);
        return models;
    }
}
