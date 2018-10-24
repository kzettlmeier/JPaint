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
    public void addShape(IShape shape, boolean drawShapes) {
        this.shapes.add(shape);
        if (drawShapes) {
            this.drawShapeHandler.update(this);
        }
    }

    @Override
    public void removeShape(IShape shape, boolean drawShapes) {
        this.shapes.remove(shape);
        if (drawShapes) {
            this.drawShapeHandler.update(this);
        }
    }

    @Override
    public void removeAllShapes(boolean drawShapes) {
        this.shapes = new ArrayList<>();
        if (drawShapes) {
            this.drawShapeHandler.update(this);
        }
    }

    @Override
    public List<IShape> getShapes() {
        return this.shapes;
    }
}
