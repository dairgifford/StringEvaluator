/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package project4;

/**
 *
 * @author heathermaclean
 */
public interface StackInterface {
    //Arraybased stack
    public boolean isEmpty();
    //public boolean isFull();
    public void push(char item) throws StackException;
    public char pop() throws StackException;
    public void popAll();
    public int peek() throws StackException;
}
