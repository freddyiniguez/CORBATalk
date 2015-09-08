import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.Iterator;

public class MessageServerImpl extends MessageServerPOA {

    private Vector clients = new Vector();
    private ReadThread rt = null;

    public MessageServerImpl() {
        rt = new ReadThread(this);
    }

    public void register(Listener lt) {
        clients.add(lt);
    }

    public void startReadThread() {
        rt.start();
    }

    public void message(String msg) {
        Iterator it = clients.iterator();
        while (it.hasNext()) {
            Listener lt = (Listener) it.next();
            lt.message(msg);
            //FOR THE SIMPLER EXAMPLE, ADD A SIMPLE
            //MESSAGE TO BE CALLED BACK, FOR EXAMPLE,
            //SLEEP FOR 30 SECONDS, THEN SEND THE TIME
        }
    }
}

//EXCLUDE THIS CLASS FOR THE SIMPLER EXAMPLE
class ReadThread extends Thread {

    MessageServerImpl msImpl = null;

    public ReadThread(MessageServerImpl msImpl) {
        this.msImpl = msImpl;
    }

    public void run() {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        try {
            for (;;) {
                System.out.print("message > ");
                String msg = br.readLine();
                msImpl.message(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}