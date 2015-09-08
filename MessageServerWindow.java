import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Freddy Iñiguez López
 */
public class MessageServerWindow extends JFrame implements ActionListener{
    // VARIABLES
    JMenuBar mbMenu;
    JMenu mFile;
    JMenuItem miAddHost;
    JMenuItem miExit;
    JButton jbSend;
    
    // CONSTRUCTORS
    public MessageServerWindow(){
        super("CORBATalk | Distributed Message System");
        __setting_MessageServerWindow();
    }
    
    public MessageServerWindow(String title){
        super(title);
        __setting_MessageServerWindow();
    }
    
    // METHODS
    /** 
     * Method: __setting MessageServerWindow
     * Description: This method is used to define the characteristics of MessageServerWindow window.
     */
    private void __setting_MessageServerWindow(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(0,0,400,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        mbMenu = new JMenuBar();
        this.setJMenuBar(mbMenu);
        mFile = new JMenu("File");
        mbMenu.add(mFile);
        miAddHost = new JMenuItem("Add a new device", new ImageIcon("images/add.png"));
        miAddHost.addActionListener(this);
        mFile.add(miAddHost);
        miExit = new JMenuItem("Exit CORBATalk", new ImageIcon("images/exit.png"));
        miExit.addActionListener(this);
        mFile.add(miExit);
        
        jbSend = new JButton("Send");
        jbSend.setSize(100,50);
        jbSend.addActionListener(this);
        this.add(jbSend);

        this.setVisible(true);
    }

    /** 
     * Method: ActionPerformed
     * Description: Takes an action corresponding to the MenuBar's window.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == miAddHost){
            JOptionPane.showMessageDialog(null, "Run a new Console and follow instructions to start a new CORBATalk.");
        }
        else if(src == jbSend){
            JOptionPane.showMessageDialog(null, "Mensaje enviado", "CORBATalk | Distributed Messages System", JOptionPane.INFORMATION_MESSAGE);
        }
        else if(src == miExit){
            System.exit(0);
        }
    }

    /** 
    * Method: print
    */
    public void print(String message){
    	jbSend.setText(message);
    }
    
    public static void main(String[] args){
        MessageServerWindow chat = new MessageServerWindow();
        chat.setVisible(true);
    }
}
