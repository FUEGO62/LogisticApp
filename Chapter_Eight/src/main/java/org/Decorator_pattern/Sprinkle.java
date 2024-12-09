package org.Decorator_pattern;

public class Sprinkle implements Beverage{
    private Beverage beverage;

    public Sprinkle(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public int cost() {
        return beverage.cost() + 2;
    }
}
