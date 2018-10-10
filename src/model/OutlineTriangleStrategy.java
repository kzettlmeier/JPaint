package model;

import model.interfaces.IOutlineShapeStrategy;

import java.awt.*;

public class OutlineTriangleStrategy implements IOutlineShapeStrategy {
    private final Color primaryColor;

    OutlineTriangleStrategy(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    @Override
    public void drawShape(Graphics2D graphics, Point startingPoint, Point endingPoint) {
        graphics.setColor(this.primaryColor);

        int[] x = new int[3];
        int[] y = new int[3];
        x[0] = startingPoint.getX();
        x[1] = startingPoint.getX() + ((endingPoint.getX() - startingPoint.getX()) / 2);
        x[2] = endingPoint.getX();
        y[0] = startingPoint.getY();
        y[1] = endingPoint.getY();
        y[2] = startingPoint.getY();

        graphics.drawPolygon(x, y, 3);
    }
}
