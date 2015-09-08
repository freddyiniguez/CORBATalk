public class ListenerImpl extends ListenerPOA {

    public void message(String msg) {
        System.out.println("Message from server : " + msg);
    }
}