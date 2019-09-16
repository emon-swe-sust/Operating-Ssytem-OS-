package chats_1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class gui extends javax.swing.JFrame {

    public static String Name;
    public static int Sourceport;
    public static int Destinationport;
    public static String DestinationIP;
    
    public static boolean main = false;
    public static boolean good = false;
    public static Channel channel = new Channel();
    public static InetSocketAddress address;
    
    public gui() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        monitor = new javax.swing.JTextArea();
        Message = new javax.swing.JTextField();
        Send = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        sourceport = new javax.swing.JTextField();
        destinationIP = new javax.swing.JTextField();
        destinationPort = new javax.swing.JTextField();
        Done = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        monitor.setBackground(new java.awt.Color(204, 255, 204));
        monitor.setColumns(20);
        monitor.setRows(5);
        jScrollPane1.setViewportView(monitor);

        Message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MessageActionPerformed(evt);
            }
        });

        Send.setBackground(new java.awt.Color(51, 255, 51));
        Send.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Send.setText("Send");
        Send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendActionPerformed(evt);
            }
        });

        name.setBackground(new java.awt.Color(51, 255, 204));
        name.setText("Name");
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        sourceport.setBackground(new java.awt.Color(51, 255, 204));
        sourceport.setText("Source Port");
        sourceport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceportActionPerformed(evt);
            }
        });

        destinationIP.setBackground(new java.awt.Color(51, 255, 204));
        destinationIP.setText("Dest. IP");

        destinationPort.setBackground(new java.awt.Color(51, 255, 204));
        destinationPort.setText("Dest. Port");

        Done.setBackground(new java.awt.Color(0, 255, 51));
        Done.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Done.setText("OK");
        Done.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Message)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Send, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sourceport, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destinationIP, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(destinationPort, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Done, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name)
                    .addComponent(sourceport)
                    .addComponent(destinationIP)
                    .addComponent(Done, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(destinationPort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Send, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(Message)))
        );

        pack();
    }// </editor-fold>                        

    private void MessageActionPerformed(java.awt.event.ActionEvent evt) {                                        
 
    }                                       

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void SendActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        String msg = Message.getText();
        msg = Name +" >>  " + msg;
        set(msg);
        try {
            channel.sendTo(address, msg);
        } catch (IOException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        Message.setText("");
    }                                    

    private void sourceportActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void DoneActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        Name = name.getText();
        Destinationport = Integer.parseInt(destinationPort.getText());
        Sourceport = Integer.parseInt(sourceport.getText());
        DestinationIP = destinationIP.getText();
        
        try {
            channel.bind(Sourceport);
        } catch (SocketException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        address = new InetSocketAddress(DestinationIP,Destinationport);
        channel.start();
        monitor.setText("Started " + "\n");
        
    }                                    

    public static void main(String args[]) throws IOException{
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }
    public static void set(String str)
    {
        monitor.setText(monitor.getText() + "\n" +  str);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Done;
    private static javax.swing.JTextField Message;
    private javax.swing.JButton Send;
    public static javax.swing.JTextField destinationIP;
    public static javax.swing.JTextField destinationPort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextArea monitor;
    public static javax.swing.JTextField name;
    public static javax.swing.JTextField sourceport;
    // End of variables declaration                   
}
