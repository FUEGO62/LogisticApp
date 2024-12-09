package org.observer_pattern;

public interface Observable{

    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
