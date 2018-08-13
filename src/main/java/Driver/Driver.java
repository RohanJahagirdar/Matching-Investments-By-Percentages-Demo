package main.java.Driver;


import main.java.processing.BalancingLogicImpl;

public class Driver {


    public static void main(String[] args) {
        String holdingFileName = "src/resources/input/holdings.csv";
        String modelFileName = "src/resources/input/models.csv";
        String orderFileName = "src/resources/output/orders.csv";

        BalancingLogicImpl balancingLogic = new BalancingLogicImpl(holdingFileName, modelFileName, orderFileName);
        if(balancingLogic.balancingByPercentage())
            System.out.println("File created: " + orderFileName);
        else
            System.out.println("The file could not be created.");
    }
}
