
package project4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Project4 extends JFrame implements ActionListener {

private static int xpos=0,ypos=0;// place window at this position
private static int xsize=700,ysize=500;// set window to this size

// Private state variables.

private JPanel northPanel,centerPanel;
private JButton pushButton,popButton,dumpButton,exitButton;
private JTextField colorField;
private JTextField codeField;
private JTextArea outputArea, roomInfo;
private Room currentRoom;
private Stack roomStack;

////////////MAIN////////////////////////

public static void main(String[] args) {
        Project4 tpo = new Project4();  
}

////////////CONSTRUCTOR/////////////////////

public Project4 ()
{
       addScreenComponents();   // put the stuff on the screen

       // Exit when the window is closed. i.e. when top right X box pressed
       addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
       
       roomStack = new Stack(100);
       
       setRoom("green");
       
       setSize(xsize,ysize);
       setLocation(xpos,ypos);
       setVisible(true);

}

public void setRoom(String k){
       currentRoom = new Room(k);
       currentRoom.setMessage();
       outputArea.setText(currentRoom.getMessage());
}

public boolean isRoomOption(String s){
    s = s.toUpperCase();
    boolean isOption = false;
    String[] adjRooms = currentRoom.getAdjRooms();
    int len = adjRooms.length;
    for(int i = 0; i<len; i++){
        if(s.equals(adjRooms[i])){
            isOption = true;
        }
    }
    return isOption;
}

public void addScreenComponents()  {
       northPanel = new JPanel();
       northPanel.add(new JLabel("Enter A Color: "));
       colorField = new JTextField("",15);
       northPanel.add(colorField);
       northPanel.add(new JLabel("And A Code: "));
       codeField = new JTextField("",5);
       northPanel.add(codeField);

       pushButton = new JButton("Push");
       northPanel.add(pushButton);
       pushButton.addActionListener(this);
       popButton = new JButton("Pop");
       northPanel.add(popButton);
       popButton.addActionListener(this);
       dumpButton = new JButton("Dump");
       northPanel.add(dumpButton);
       dumpButton.addActionListener(this);
       exitButton = new JButton("Exit");
       northPanel.add(exitButton);
       exitButton.addActionListener(this);

       getContentPane().add("North",northPanel);

       centerPanel = new JPanel();
       outputArea = new JTextArea("Who Dares Enter.... The Temple of Gloom!",20,60);
       centerPanel.add(outputArea);
       getContentPane().add(centerPanel,"Center");

}
////////////BUTTON CLICKS ///////////////////////////

public void actionPerformed(ActionEvent e) {

         if (e.getSource()== exitButton) {
            dispose(); System.exit(0);
         }

         if (e.getSource()== popButton) {
                String newcolor = colorField.getText();
                outputArea.setText("Pop returning to " + newcolor);
                // add code to pop color off the stack, check that the color/code matches and change to that color room
         }

         if (e.getSource()== pushButton) {
                String newcolor = colorField.getText();
                if(isRoomOption(newcolor) == true){
                    currentRoom.setCode(Integer.parseInt(codeField.getText()));
                    roomStack.push(currentRoom);
                    setRoom(newcolor);
                }
                 // add code to push color/code ON the stack and change to that color room
         }

         if (e.getSource()== dumpButton) {
                System.out.println("Stack Contents Dump: ");
                 // add code to print contents of Stack to the CONSOLE
         }

}

}     // End Of Project4
