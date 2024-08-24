/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project4;

/**
 *
 * @author heathermaclean
 */
class LinkedStack implements StackInterface {
        Node top;
        public LinkedStack(){
            top = null;
        }
        public boolean isEmpty(){
            return top == null;
        }
        public void push(char item){
            Node n = new Node(item);
            n.next = top;
            top = n;
        }
        public char pop() throws StackException{
            if(isEmpty())
                throw new StackException("Cannot remove, empty stack");
            else{
                char temp = top.data;
                top = top.next;
                return temp;
            }
        }
        public void popAll(){
            top = null;
        }
        public int peek() throws StackException{
            if(isEmpty())
                throw new StackException("Cannot peek, empty stack");
            else{
                return top.data;
            }
        }
    }

    class Node {
        char data;
        Node next;
        public Node(){
            data = 0;
            next = null;
        }
        public Node(char data){
            this.data = data;
        }
@Override
        public String toString(){
            return data + " ";
        }
    }
