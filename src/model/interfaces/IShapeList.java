package model.interfaces;

import java.util.List;

public interface IShapeList {
    void addShape(IShape shape);
    void removeShape(IShape shape);
    List<IShape> getShapes();
}
