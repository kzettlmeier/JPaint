package model;

import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import view.gui.PaintCanvas;

public class DrawShapeHandler implements IDrawShapeHandler {
    private final PaintCanvas canvas;

    public DrawShapeHandler(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void update(IShapeList shapeList) {
        for (IShape shape : shapeList.getShapes()) {
            shape.draw(this.canvas);
        }
    }
}
