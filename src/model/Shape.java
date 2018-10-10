package model;

import model.interfaces.IOutlineShapeStrategy;
import model.interfaces.IFillShapeStrategy;
import model.interfaces.IShape;
import view.gui.PaintCanvas;

import java.awt.*;
import java.util.EnumMap;

public class Shape implements IShape {
    private final ShapeType shapeType;
    private final ShapeColor primaryColor;
    private final ShapeColor secondaryColor;
    private final ShapeShadingType shadingType;
    private final Point startingPoint;
    private final Point endingPoint;
    private final EnumMap<ShapeColor, Color> colorMap;
    private final IOutlineShapeStrategy outlineShapeStrategy;
    private final IFillShapeStrategy fillShapeStrategy;

    public Shape(ShapeType shapeType, ShapeColor primaryColor, ShapeColor secondaryColor, ShapeShadingType shadingType, Point startingPoint, Point endingPoint) {
        this.shapeType = shapeType;
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
        this.shadingType = shadingType;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.colorMap = ColorEnumMap.getInstance().getColorEnumMap();

        if (this.shapeType.equals(ShapeType.RECTANGLE)) {
            if (this.shadingType.equals(ShapeShadingType.OUTLINE)) {
                this.outlineShapeStrategy = new OutlineRectangleStrategy(colorMap.get(getPrimaryColor()));
                this.fillShapeStrategy = null;
            } else if (this.shadingType.equals(ShapeShadingType.FILLED_IN)) {
                this.fillShapeStrategy = new FillRectangleStrategy();
                this.outlineShapeStrategy = null;
            } else {
                this.outlineShapeStrategy = new OutlineRectangleStrategy(colorMap.get(getSecondaryColor()));
                this.fillShapeStrategy = new FillRectangleStrategy();
            }
        } else if (this.shapeType.equals(ShapeType.ELLIPSE)) {
            if (this.shadingType.equals(ShapeShadingType.OUTLINE)) {
                this.outlineShapeStrategy = new OutlineEllipseStrategy(colorMap.get(getPrimaryColor()));
                this.fillShapeStrategy = null;
            } else if (this.shadingType.equals(ShapeShadingType.FILLED_IN)) {
                this.fillShapeStrategy = new FillEllipseStrategy();
                this.outlineShapeStrategy = null;
            } else {
                this.outlineShapeStrategy = new OutlineEllipseStrategy(colorMap.get(getSecondaryColor()));
                this.fillShapeStrategy = new FillEllipseStrategy();
            }
        } else {
            if (this.shadingType.equals(ShapeShadingType.OUTLINE)) {
                this.outlineShapeStrategy = new OutlineTriangleStrategy(colorMap.get(getPrimaryColor()));
                this.fillShapeStrategy = null;
            } else if (this.shadingType.equals(ShapeShadingType.FILLED_IN)) {
                this.fillShapeStrategy = new FillTriangleStrategy();
                this.outlineShapeStrategy = null;
            } else {
                this.outlineShapeStrategy = new OutlineTriangleStrategy(colorMap.get(getSecondaryColor()));
                this.fillShapeStrategy = new FillTriangleStrategy();
            }
        }
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
        Point startingCoordinates = this.getStartingCoordinate();
        Point endingCoordinates = this.getEndingCoordinate();

        if (this.fillShapeStrategy != null) {
            this.fillShapeStrategy.fillShape(graphics2d, colorMap.get(getPrimaryColor()), startingCoordinates, endingCoordinates);
        }

        if (this.outlineShapeStrategy != null) {
            this.outlineShapeStrategy.drawShape(graphics2d, startingCoordinates, endingCoordinates);
        }
    }
}
