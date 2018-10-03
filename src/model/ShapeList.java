package model;

import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

import java.util.ArrayList;
import java.util.List;

public class ShapeList implements IShapeList {
    private List<IShape> shapes;
    private IDrawShapeHandler drawShapeHandler;

    public ShapeList(IDrawShapeHandler drawShapeHandler) {
        this.shapes = new ArrayList<>();
        this.drawShapeHandler = drawShapeHandler;
    }

    @Override
    public void addShape(IShape shape) {
        this.shapes.add(shape);
        this.drawShapeHandler.update();
    }

    @Override
    public void removeShape(IShape shape) {
        this.shapes.remove(shape);
        this.drawShapeHandler.update();
    }

    @Override
    public List<IShape> getShapes() {
        return this.shapes;
    }
}
