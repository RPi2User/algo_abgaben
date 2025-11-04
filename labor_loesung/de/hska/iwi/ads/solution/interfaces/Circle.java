package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.AbstractCircle;
import de.hska.iwi.ads.interfaces.Vector;

public class Circle extends AbstractCircle {

    public Circle(Vector middlePoint, double radius) {
        super(radius);
    }

    public Circle(double radius) {
        super(radius);
    }

    @Override
    public void scale(double factor) {
        // scales radius accordingly
        this.radius *= factor;
    }

    @Override
    public double getDimension() {
        return this.radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}
