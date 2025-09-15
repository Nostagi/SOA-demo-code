package serverSide;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import MessageApp.*;
import serverService.*;

public class Server {
    public static void main(String args[]) {
        try {
            // Create ORB link
            ORB orb = ORB.init(args, null);

            // Set POA root & activate
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create object MessageImpl on ready
            MessageImpl messageImpl = new MessageImpl();
            org.omg.CORBA.Object ref1 = rootpoa.servant_to_reference(messageImpl);
            Message messageRef = MessageHelper.narrow(ref1);

            // Create object DogImpl on ready
            DogImpl dogImpl = new DogImpl();
            org.omg.CORBA.Object ref2 = rootpoa.servant_to_reference(dogImpl);
            Dog dogRef = DogHelper.narrow(ref2);

            // Registry to provide 2 Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            ncRef.rebind(ncRef.to_name("Message"), messageRef);
            ncRef.rebind(ncRef.to_name("Dog"), dogRef);

            System.out.println("Server ready and waiting ...\n\n");

            // Run ORB on waiting
            orb.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}