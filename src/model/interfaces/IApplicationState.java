package model.interfaces;

import model.*;
import view.gui.PaintCanvas;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    void setStartingCoordinatePoint(Point startingPoint);

    void setEndingCoordinatePoint(Point endingCoordinatePoint);

    void resetCurrentCoordinates();

    PaintCanvas getPaintCanvas();

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    Point getStartingCoordinatePoint();

    Point getEndingCoordinatePoint();

    IShapeList getShapeList();
}
