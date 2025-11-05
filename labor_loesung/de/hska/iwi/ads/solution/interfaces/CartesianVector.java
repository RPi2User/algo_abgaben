package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.Vector;

public class CartesianVector implements Vector {
    // can hardcode this here, because all carteisan vectors are scaleable
    private final int DIMENSION = 2;

    private double x,y;

    public CartesianVector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * returns the x-coordinate of this Vector
     */
    @Override
    public double getX() {
        return this.x;
    }

    /**
     * returns the y-coordinate of this Vector
     */
    @Override
    public double getY() {
        return this.y;
    }

    /**
     * Returns the direction of this vector as an angle
     * counter-clockwise from the "x-axis".
     * The angle is in the range of [-Math.PI .. Math.PI].
     * The value 0 represents a vector pointing along the positive x axis.
     * The value {@link Math.PI} / 2.0 represents a vector pointing
     * along the positive y axis.
     */
    @Override
    public double getDirection() {
        return Math.atan2(this.y, this.x);
    }

    /**
     * Adds the given vector <code>addend</code> to this Vector
     * and returns the sum as a new Vector.
     * <code>addend</code> and this Vector remain unchanged.
     * If <code>addend</code> is null, then addend is treated like
     * the null-vector (0,0).
     *
     * @param addend
     */
    @Override
    public Vector add(Vector addend) {
        if (addend == null) {
            return this;
        }
        return new CartesianVector(
                x = this.x + addend.getX(),
                y = this.y + addend.getY()
        );
    }

    /**
     * Scales this Scaleable by the given factor.
     *
     * @param factor >= 0
     * @throws IllegalArgumentException if factor is negative
     */
    @Override
    public void scale(double factor) {
        this.x *= factor;
        this.y *= factor;
    }

    /**
     * Returns the positive or zero dimension of this Scaleable.
     */
    @Override
    public double getDimension() {
        return DIMENSION;
    }
}
