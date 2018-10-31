package command;

import command.interfaces.IShapeCommand;
import model.Point;
import model.builders.ShapeBuilder;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class PasteShapesCommand implements IShapeCommand {
    private final IShapeList drawnShapes;
    private final IShapeList copiedShapes;
    public PasteShapesCommand(IShapeList drawnShapes, IShapeList copiedShapes) {
        this.drawnShapes = drawnShapes;
        this.copiedShapes = copiedShapes;
    }

    @Override
    public void run() {
        for (IShape copiedShape : copiedShapes.getShapes()) {
            ShapeBuilder shapeBuilder = new ShapeBuilder();
            shapeBuilder.setShapeType(copiedShape.getShapeType());
            shapeBuilder.setShadingType(copiedShape.getShadingType());
            shapeBuilder.setPrimaryColor(copiedShape.getPrimaryColor());
            shapeBuilder.setSecondaryColor(copiedShape.getSecondaryColor());

            Point currentStartingPoint = copiedShape.getStartingCoordinate();
            Point newStartingPoint = new Point(currentStartingPoint.getX() + 25, currentStartingPoint.getY() + 25);
            Point currentEndingPoint = copiedShape.getEndingCoordinate();
            Point newEndingPoint = new Point(currentEndingPoint.getX() + 25, currentEndingPoint.getY() + 25);
            shapeBuilder.setStartingPoint(newStartingPoint);
            shapeBuilder.setEndingPoint(newEndingPoint);

            this.drawnShapes.addShape(shapeBuilder.toShape(), true);
        }
    }
}
