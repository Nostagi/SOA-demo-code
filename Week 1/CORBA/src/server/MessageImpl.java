package serverService;

import MessageApp.*;
import org.omg.CORBA.*;

public class MessageImpl extends MessagePOA {
    private ORB orb;
    

    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    // Implement Response function
    @Override
    public String send(String msg) {
        System.out.println("Server receive a message: \n\t" + msg + "\n\n");
        return "Server confirm receiving your message: \n\t" + msg;
    }
}