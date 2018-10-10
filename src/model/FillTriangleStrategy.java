package model;

import model.interfaces.IFillShapeStrategy;

import java.awt.*;

public class FillTriangleStrategy implements IFillShapeStrategy {
    @Override
    public void fillShape(Graphics2D graphics, Color primaryColor, Point startingPoint, Point endingPoint) {
        int[] x = new int[3];
        int[] y = new int[3];
        x[0] = startingPoint.getX();
        x[1] = startingPoint.getX() + ((endingPoint.getX() - startingPoint.getX()) / 2);
        x[2] = endingPoint.getX();
        y[0] = startingPoint.getY();
        y[1] = endingPoint.getY();
        y[2] = startingPoint.getY();

        graphics.setColor(primaryColor);
        graphics.fillPolygon(x, y, 3);
    }
}
