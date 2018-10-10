package model.interfaces;

import model.Point;

import java.awt.*;

public interface IFillShapeStrategy {
    void fillShape(Graphics2D graphics, Color primaryColor, Point startingPoint, Point endingPoint);
}
