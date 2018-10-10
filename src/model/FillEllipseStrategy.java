package model;

import model.interfaces.IFillShapeStrategy;

import java.awt.*;

public class FillEllipseStrategy implements IFillShapeStrategy {
    @Override
    public void fillShape(Graphics2D graphics, Color primaryColor, Point startingPoint, Point endingPoint) {
        graphics.setColor(primaryColor);
        graphics.fillOval(startingPoint.getX(), startingPoint.getY(),
                endingPoint.getX() - startingPoint.getX(),
                endingPoint.getY() - startingPoint.getY());
    }
}
