package model.interfaces;

import model.Point;

import java.awt.Graphics2D;

public interface IOutlineShapeStrategy {
    void drawShape(Graphics2D graphics, Point startingPoint, Point endingPoint);
}
