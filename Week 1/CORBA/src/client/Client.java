package clientSide;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import MessageApp.*;

public class Client {
    public static void main(String args[]) {
        try {
            // Create ORB
            ORB orb = ORB.init(args, null);

            // Get Naming Service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Request Message service -> ping
            Message messageRef = MessageHelper.narrow(ncRef.resolve_str("Message"));
            String reply = messageRef.send("Hello from Client");
            System.out.println("Message Service reply: \n\t" + reply + "\n");

            // Request Dog service
            Dog dogRef = DogHelper.narrow(ncRef.resolve_str("Dog"));

            dogRef.setDog("Rex", "German Shepherd", "Brown", 5);

            // Attributes
            System.out.println("Dog Info:");
            System.out.println("Name: " + dogRef.getName());
            System.out.println("Kind: " + dogRef.getKind());
            System.out.println("Hair Color: " + dogRef.getHairColor());
            System.out.println("Age: " + dogRef.getAge());

            // Methods
            System.out.println(dogRef.bark());
            System.out.println(dogRef.walk());
            System.out.println(dogRef.playCatch("ball"));

            System.out.println("\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
