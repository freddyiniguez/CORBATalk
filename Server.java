import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import javax.swing.JOptionPane;

public class Server {

    public static void main(String[] args) {
        try {
            //create and initialize the ORB
            Properties props = System.getProperties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            //Replace MyHost with the name of the host on which you are running the server
            props.put("org.omg.CORBA.ORBInitialHost", "192.168.0.12");
            ORB orb = ORB.init(args, props);
            System.out.println("Initialized ORB");

            //Instantiate Servant and create reference
            POA rootPOA = POAHelper.narrow(
                orb.resolve_initial_references("RootPOA"));
            MessageServerImpl msImpl = new MessageServerImpl();
            rootPOA.activate_object(msImpl);
            MessageServer msRef = MessageServerHelper.narrow(
                rootPOA.servant_to_reference(msImpl));

            //Bind reference with NameService
            NamingContext namingContext = NamingContextHelper.narrow(
                orb.resolve_initial_references("NameService"));
            System.out.println("Resolved NameService");
            NameComponent[] nc = { new NameComponent("MessageServer", "") };
            namingContext.rebind(nc, msRef);

            //Activate rootpoa
            rootPOA.the_POAManager().activate();

            //Start readthread and wait for incoming requests
            System.out.println("\n\t\t\t\t__W_E_L_C_O_M_E__");
            System.out.println("\t\tCORBATalk: Distributed Messages System\n");
            msImpl.startReadThread();
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}