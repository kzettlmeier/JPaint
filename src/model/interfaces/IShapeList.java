package model.interfaces;

import java.util.List;

public interface IShapeList {
    void addShape(IShape shape, boolean drawShapes);
    void removeShape(IShape shape, boolean drawShapes);
    void removeAllShapes(boolean drawShapes);
    List<IShape> getShapes();
}
