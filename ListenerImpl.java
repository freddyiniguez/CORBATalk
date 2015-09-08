public class ListenerImpl extends ListenerPOA {
	MessageServerWindow w;

	public ListenerImpl(){
		this.w = new MessageServerWindow();
	}

    public void message(String msg) {
     	w.print(msg);
    }
}