package model;

import model.interfaces.IOutlineShapeStrategy;

import java.awt.*;

public class OutlineEllipseStrategy implements IOutlineShapeStrategy {
    private final Color primaryColor;

    OutlineEllipseStrategy(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    @Override
    public void drawShape(Graphics2D graphics, Point startingPoint, Point endingPoint) {
        graphics.setColor(this.primaryColor);
        graphics.drawOval(startingPoint.getX(), startingPoint.getY(),
                endingPoint.getX() - startingPoint.getX(),
                endingPoint.getY() - startingPoint.getY());
    }
}
