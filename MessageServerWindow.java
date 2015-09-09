/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
    JTextArea jtaSend;
    
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
        this.setBounds(0,0,445,380);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setLayout(new BorderLayout());
        this.setContentPane(new JLabel(new ImageIcon("images/corbatalk.png")));
        //this.setLayout(new FlowLayout());
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
        
        jtaSend = new JTextArea();
        //jtaSend.setBackground(new Color(0,0,0,0));
        //jtaSend.setText("CORBATalk > ");
        JScrollPane jspScroll = new JScrollPane(jtaSend);
        jspScroll.setBounds(0,65,440,235);
        jspScroll.setOpaque(false);
        jspScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(jspScroll);

        this.setVisible(true);
    }

    /** 
     * Method: ActionPerformed
     * Description: Takes an action corresponding to the MenuBar's window.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == miAddHost){
            JOptionPane.showMessageDialog(null, "Run a new Console and follow instructions to start a new CORBATalk.");
        }
        else if(src == miExit){
            System.exit(0);
        }
    }

    /** 
    * Method: print
    * Description: Receive the Server message and wrote it on screen.
     * @param message
    */
    public void print(String message){
    	jtaSend.append("CORBATalk > "+message+"\n");
    }
    
    public static void main(String[] args){
        MessageServerWindow chat = new MessageServerWindow();
        chat.setVisible(true);
    }
}

