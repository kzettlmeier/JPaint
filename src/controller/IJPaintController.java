package controller;

import model.Point;

public interface IJPaintController {
    void setup();

    void createShape(Point startingPoint, Point endingPoint);
}
