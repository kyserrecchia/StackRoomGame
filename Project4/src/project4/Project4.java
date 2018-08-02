
package project4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class Project4 extends JFrame implements ActionListener {

private static int xpos=0,ypos=0;// place window at this position
private static int xsize=700,ysize=500;// set window to this size

// Private state variables.

private JPanel northPanel,centerPanel,southPanel;
private JButton pushButton,popButton,dumpButton,exitButton;
private JTextField colorField, codeField;
private JTextArea outputArea,roomArea;
private Room currentRoom;
private Stack roomStack;

////////////MAIN////////////////////////

public static void main(String[] args) {
        Project4 tpo = new Project4();  
}

////////////CONSTRUCTOR/////////////////////

public Project4 ()
{
       
    addScreenComponents();
    roomStack = new Stack(100);
    setRoom("green");
    
    setSize(xsize,ysize);
    setLocation(xpos,ypos);
    setVisible(true);
    
    clearTextFields();
       addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    });// put the stuff on the screen
     
}

public void startGame(){
    dispose();
    Project4 tpo = new Project4();
}

public void setRoom(String k){
       currentRoom = new Room(k);
       currentRoom.setMessage();
       roomArea.setText(currentRoom.getMessage());
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

public void clearTextFields(){
    colorField.setText(null);
    codeField.setText(null);
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
       outputArea = new JTextArea("",20,60);
       outputArea.setText("Who dares enter... The Temple of Gloom!"
               + "\n\nYour mission: Enter the color of a door you see and any code you wish,"
               + "\nseeking the golden chalice in the golden room."
               + "\n\nThen come back exactly the way you came,"
               + " entering the same codes in reverse,"
               + "\nand keep the golden chalice... or fail and perish!");
       centerPanel.add(outputArea);
       getContentPane().add(centerPanel,"Center");
       
       southPanel = new JPanel();
       roomArea = new JTextArea("",20,60);
       southPanel.add(roomArea);
       getContentPane().add(southPanel, "South");

}
////////////BUTTON CLICKS ///////////////////////////

public void actionPerformed(ActionEvent e) {

         if (e.getSource()== exitButton) {
            dispose(); System.exit(0);
         }

         if (e.getSource()== popButton) {
                //inputs
                String newcolor = colorField.getText().toUpperCase();
                
                if(isRoomOption(newcolor) == true){
                    outputArea.setText("Pop returning to " + newcolor);
                    int newcode = Integer.parseInt(codeField.getText());

                    //room variable - top of stack to compare to inputs
                    Room topRoom = roomStack.peek();
                    String roomColor = topRoom.getRoomColor();
                    int roomCode = topRoom.getCode();

                    if(newcolor.equals(roomColor) && newcode == roomCode){
                        roomStack.pop();
                        setRoom(roomColor);

                        if(roomStack.empty() == true){
                            wonGame();
                            System.out.println("You won!");
                        }
                    } else{
                        lostGame();
                        System.out.println("You lose!");
                    }
                } else{
                    lostGame();
                    System.out.println("You lose!");
                }
                
                // add code to pop color off the stack, check that the color/code matches and change to that color room
         }

         if (e.getSource()== pushButton) {
                String newcolor = colorField.getText().toUpperCase();
               
                if(isRoomOption(newcolor) == true){
                    outputArea.setText("Push entering " + newcolor);
                    currentRoom.setCode(Integer.parseInt(codeField.getText()));
                    roomStack.push(currentRoom);
                    setRoom(newcolor);
                    
                } else{
//                    lostGame();
                    System.out.println("You lose!");
                }
                 // add code to push color/code ON the stack and change to that color room
         }

         if (e.getSource()== dumpButton) {
                System.out.println("Stack Contents Dump: ");
                 // add code to print contents of Stack to the CONSOLE
         }

}

    public void wonGame(){
        startGame();
    }
    
    public void lostGame(){
        startGame();
    }

}     // End Of Project4
