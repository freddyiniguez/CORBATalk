import java.util.Properties;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import javax.swing.JOptionPane;

public class Client {

    public static void main(String[] args) {
        try {
        
            //initialize orb
            Properties props = System.getProperties();
            props.put("org.omg.CORBA.ORBInitialPort", "1050");
            //Replace MyHost with the name of the host on which you are running the server
            props.put("org.omg.CORBA.ORBInitialHost", "192.168.0.12");
            ORB orb = ORB.init(args, props);
            System.out.println("Initialized ORB");

            //Instantiate Servant and create reference
            POA rootPOA = POAHelper.narrow(
                orb.resolve_initial_references("RootPOA"));
            ListenerImpl listener  = new ListenerImpl();
            rootPOA.activate_object(listener);
            Listener ref = ListenerHelper.narrow(
                rootPOA.servant_to_reference(listener));

            //Resolve MessageServer
            MessageServer msgServer = MessageServerHelper.narrow(
                orb.string_to_object("corbaname:iiop:192.168.0.12:1050#MessageServer"));

            //Register listener reference (callback object) with MessageServer
            msgServer.register(ref);
            System.out.println("Listener registered with MessageServer");

            //Activate rootpoa
            rootPOA.the_POAManager().activate();

            //Wait for messages
            System.out.println("Wait for incoming messages");
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}