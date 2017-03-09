package com.xzit.observer;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;




abstract class Subject{
	private List<Observer> list = new ArrayList<Observer>();
	public void attach(Observer observer){
		
		list.add(observer);
	}
	public void detach(Observer observer){
		
		list.remove(observer);
	}
	
	public void notifyObservers(String newState){
		
		for(Observer observer:list){
			observer.update(newState);
		}
	}
	
}
class ConcreteSubject extends Subject{
	
	private String state;
	
	public String getState(){
		return state;
	}
	
	public void change(String newState){
		
		state = newState;
		this.notifyObservers(state);
	}
	
}
interface Observer{
	void update(String state);
}
class ConcreteObserver implements Observer{
	
	private String state;

	public void update(String state) {
		this.state = state;
		
	}
	
}

public class TestObserver {
	
}
