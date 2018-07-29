
package project4;

//room stack
public class Stack { 
    private int maxSize;
    private Room[] stackArray;
    private int top;
    
    public Stack(int s){
        maxSize = s;
        stackArray = new Room[maxSize];
        top = -1;
    }
    
    public void push(Room j){
        stackArray[++top] = j;
    }
    
    public Room pop(){
        return stackArray[top--];
    }
    
    public Room peek(){
        return stackArray[top];
    }
    
    public boolean empty(){
        return (top == -1);
    }
    
    public boolean full(){
        return (top == maxSize -1);
    }
}
