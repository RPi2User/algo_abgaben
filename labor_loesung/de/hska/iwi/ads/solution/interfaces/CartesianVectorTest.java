package de.hska.iwi.ads.solution.interfaces;

import de.hska.iwi.ads.interfaces.Vector;
import de.hska.iwi.ads.interfaces.VectorTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartesianVectorTest extends VectorTest  {
    @Override
    public CartesianVector createVector(double x, double y) {
        return new CartesianVector(x, y);
    }
    @Test
    void testScale1() {
        CartesianVector vector = createVector(1.0, 1.5);
        vector.scale(2.0);
        assertEquals(2.0, vector.getX(), 0.0000001);
        assertEquals(3.0, vector.getY(), 0.0000001);
    }

    @Test
    void testScale2(){
        CartesianVector v2 = createVector(1,1);
        v2.scale(Math.pow(2,30));
        assertEquals(Math.pow(2,30), v2.getX(), 0.0000001);
        assertEquals(Math.pow(2,30), v2.getY(), 0.0000001);
    }

    @Test
    void testGetDirection1() {
        Vector vector = createVector(0.0, 2.0);
        assertEquals(Math.PI / 2.0, vector.getDirection(), 0.0000001);
    }

    @Test
    void testGetDirection2() {
        Vector vector = createVector(0.0, -2.0);
        assertEquals(-Math.PI / 2.0, vector.getDirection(), 0.0000001);
    }
}
