package org.example;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

public class CalculatorServer {
    public static void main(String args[]) {
        try {

            ORB orb = ORB.init(args, null);
            CalculatorImpl calculatorImpl = new CalculatorImpl();


            org.omg.CORBA.Object objRef = orb.resolve_initial_references("RootPOA");
            POA rootpoa = POAHelper.narrow(objRef);
            rootpoa.the_POAManager().activate();
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(calculatorImpl);

            // Registrar la referencia en el servicio de nombres
            NamingContextExt ncRef = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
            NameComponent path[] = ncRef.to_name("Calculator");
            ncRef.rebind(path, ref);

            System.out.println("Calculator server ready and waiting...");

            // Esperar llamadas
            orb.run();
        } catch (Exception e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }
}
