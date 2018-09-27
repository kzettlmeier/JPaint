package model.interfaces;

import model.*;

import java.util.List;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    void setStartingCoordinatePoint(Point startingPoint);

    void setEndingCoordinatePoint(Point endingCoordinatePoint);

    void resetCurrentCoordinates();

    void addShape(IShape shape);

    void deleteShape(IShape shape);

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    StartAndEndPointMode getActiveStartAndEndPointMode();

    Point getStartingCoordinatePoint();

    Point getEndingCoordinatePoint();

    List<IShape> getShapeList();
}
