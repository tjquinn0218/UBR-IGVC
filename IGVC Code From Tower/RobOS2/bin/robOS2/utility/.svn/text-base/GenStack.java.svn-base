/*
 * UB Robotics - BV
 * Monday January 31, 2011
 * Creates a generic stack of type T, specified by the user,
 * 
 */

package robOS2.utility;

import java.util.LinkedList;

public class GenStack<T> {
	
	//Linked List
	private LinkedList<T> _fiFo;
	
	//Creates a new Generic FiFo stack
	public GenStack(){
		_fiFo = new LinkedList<T>();
	}
	
	//To add elements to the stack of FiFo
	public LinkedList<T> push(T t){
		_fiFo.add(t);
		return _fiFo;
	}
	
	//To remove elements to the stack of FiFo
	public T pop(){
		T top = (T)_fiFo.get(0);
		_fiFo.remove(_fiFo.get(0));
		return top;
	}
	
	//To view the next value on top
	public T peek(){
		return (T)_fiFo.get(0);
	}
	
	//To retrieve the number of values in the queue
	public int getSize(){
		return _fiFo.size();
	}
	
	public String toString(){
		return _fiFo.toString();
	}
}
