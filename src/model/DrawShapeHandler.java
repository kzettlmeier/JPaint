package model;

import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShape;
import model.interfaces.IShapeList;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.List;


public class DrawShapeHandler implements IDrawShapeHandler {
    private final PaintCanvas canvas;

    public DrawShapeHandler(PaintCanvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public void update(IShapeList shapeList) {
        Graphics2D graphics = this.canvas.getGraphics2D();
        graphics.setColor(canvas.getBackground());
        graphics.clearRect(0, 0, this.canvas.getWidth(), this.canvas.getHeight());
        List<IShape> shapes = shapeList.getShapes();
        for (IShape shape : shapes) {
            shape.draw(this.canvas);
        }
    }
}
