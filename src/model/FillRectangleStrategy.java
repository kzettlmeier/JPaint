package model;

import model.interfaces.IFillShapeStrategy;

import java.awt.*;

public class FillRectangleStrategy implements IFillShapeStrategy {
    @Override
    public void fillShape(Graphics2D graphics, Color primaryColor, Point startingPoint, Point endingPoint) {
        graphics.setColor(primaryColor);
        graphics.fillRect(startingPoint.getX(), startingPoint.getY(),
                endingPoint.getX() - startingPoint.getX(),
                endingPoint.getY() - startingPoint.getY());
    }
}
