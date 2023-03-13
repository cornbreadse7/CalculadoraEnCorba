package org.example;
import CalculatorApp.Calculator;
import CalculatorApp.CalculatorHelper;
import org.omg.CORBA.*;
import org.omg.CosNaming.*;

public class CalculatorClient {
    public static void main(String[] args) {
        try {

            ORB orb = ORB.init(args, null);


            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            Calculator calculator = CalculatorHelper.narrow(ncRef.resolve_str("Calculator"));


            float x = 10.0f;
            float y = 5.0f;
            System.out.println("x = " + x + ", y = " + y);
            System.out.println("x + y = " + calculator.add(x, y));
            System.out.println("x - y = " + calculator.subtract(x, y));
            System.out.println("x * y = " + calculator.multiply(x, y));
            System.out.println("x / y = " + calculator.divide(x, y));


            orb.shutdown(true);
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}

