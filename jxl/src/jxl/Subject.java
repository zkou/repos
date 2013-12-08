package jxl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Subject {
	private List<Observer> observerList;

	public Subject() {
		observerList = new LinkedList<Observer>();
	}

	public void attach(Observer obs) {
		observerList.add(obs);
	}

	public void detach(Observer obs) {
		observerList.remove(obs);
	}
	
	public void notifyObserver() {
		Iterator<Observer> obsIt = observerList.iterator();

		while (obsIt.hasNext()) {
			obsIt.next().update(this);
		}
	}
	
	public Object getSubject()
	{
		return this;
	}
	
	public void timer(long interval) throws InterruptedException {
		while (true) {
			notifyObserver();
		//	System.out.println("1");
			Thread.sleep(interval);
		}
	}
}
