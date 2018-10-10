package model;

import model.interfaces.IOutlineShapeStrategy;

import java.awt.*;

public class OutlineRectangleStrategy implements IOutlineShapeStrategy {
    private final Color primaryColor;

    OutlineRectangleStrategy(Color primaryColor) {
        this.primaryColor = primaryColor;
    }

    @Override
    public void drawShape(Graphics2D graphics, Point startingPoint, Point endingPoint) {
        graphics.setColor(this.primaryColor);
        graphics.drawRect(startingPoint.getX(), startingPoint.getY(),
                endingPoint.getX() - startingPoint.getX(),
                endingPoint.getY() - startingPoint.getY());
    }
}
