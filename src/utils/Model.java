package utils;
import main.java.entity.ModelEntry;

import java.util.List;

/**
 * <h1>Model</h1>
 * Interface for the models.
 * This interface contains the method to read the details of a model from a csv file, whose name is provided.
 * The model details are used to conduct the transactions to match the percentage in the file provided.
 *
 * @author  Rohan Jahagirdar
 * @version 1.0
 * @since   2018-07-22
 */
public interface Model {
    List<ModelEntry> readModelData(String fileName);
}
