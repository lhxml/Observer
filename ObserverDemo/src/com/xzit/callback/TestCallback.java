package com.xzit.callback;

interface Callback{
	void next();
}

abstract class ConcreteCallBack implements Callback{
	
	public void next() {
		System.out.println("ConcreteCallback");
		_next();
	}
	protected abstract void _next();
	
}
class Subject{
	private Callback callback;
	
	public void registerCallback(Callback callback){
		this.callback = callback;
		this.callback.next();
	}
	
	
	
}
public class TestCallback {
	public static void main(String[] args) {
		
		Subject subject = new Subject();
		subject.registerCallback(new ConcreteCallBack() {
			
			@Override
			protected void _next() {
				System.out.println("AAAA");
			}
		});
	}

}
