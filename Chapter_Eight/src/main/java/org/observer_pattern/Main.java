package org.observer_pattern;

public class Main {
    public static void main(String[] args) {
        ConcreteObservable observable = new ConcreteObservable();
        ConcreteObserver observer = new ConcreteObserver(observable);
        ConcreteObserver observer2 = new ConcreteObserver(observable);
        observable.addObserver(observer);
        observable.addObserver(observer2);

        observable.setState("new state");
    }
}
