package model.interfaces;

import model.Point;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import view.gui.PaintCanvas;

public interface IShape {
    ShapeType getShapeType();
    ShapeColor getPrimaryColor();
    ShapeColor getSecondaryColor();
    ShapeShadingType getShadingType();
    Point getStartingCoordinate();
    Point getEndingCoordinate();
    void draw(PaintCanvas canvas);
}
