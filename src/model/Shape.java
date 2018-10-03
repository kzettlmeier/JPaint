package model;

import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;

public class Shape implements IShape {
    private final ShapeType shapeType;
    private final ShapeColor primaryColor;
    private final ShapeColor secondaryColor;
    private final ShapeShadingType shadingType;
    private final Point startingPoint;
    private final Point endingPoint;

    public Shape(ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, Point startingPoint, Point endingPoint) {
        this.shapeType = shapeType;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public ShapeType getShapeType() {
        return this.shapeType;
    }

    public ShapeColor getPrimaryColor() {
        return this.primaryColor;
    }

    public ShapeColor getSecondaryColor() {
        return this.secondaryColor;
    }

    public ShapeShadingType getShadingType() {
        return this.shadingType;
    }

    public Point getStartingCoordinate() {
        return this.startingPoint;
    }

    public Point getEndingCoordinate() {
        return this.endingPoint;
    }

    public void draw(PaintCanvas canvas) {
        Graphics2D graphics2d = canvas.getGraphics2D();
        graphics2d.drawRect(this.getStartingCoordinate().getX(), this.getStartingCoordinate().getY(),
                this.getEndingCoordinate().getX() - this.getStartingCoordinate().getX(),
                this.getEndingCoordinate().getY() - this.getStartingCoordinate().getY());
    }
}
