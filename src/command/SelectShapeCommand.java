package command;

import command.interfaces.IShapeCommand;
import model.Point;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

import java.awt.*;

public class SelectShapeCommand implements IShapeCommand {
    private final IApplicationState appState;
    private final IShapeList drawnShapes;
    private final IShapeList selectedShapes;

    public SelectShapeCommand(IApplicationState appState, IShapeList drawnShapes, IShapeList selectedShapes) {
        this.appState = appState;
        this.drawnShapes = drawnShapes;
        this.selectedShapes = selectedShapes;
    }

    @Override
    public void run() {
        this.selectedShapes.removeAllShapes(false);

        Point startingPoint = appState.getStartingCoordinatePoint();
        Point endingPoint = appState.getEndingCoordinatePoint();
        int width = endingPoint.getX() - startingPoint.getX();
        int height = endingPoint.getY() - startingPoint.getY();
        Rectangle boundingBox = new Rectangle(startingPoint.getX(), startingPoint.getY(), width, height);

        for(IShape shape : this.drawnShapes.getShapes()) {
            Point shapeStartingPoint = shape.getStartingCoordinate();
            Point shapeEndingPoint = shape.getEndingCoordinate();
            int shapeWidth = shapeEndingPoint.getX() - shapeStartingPoint.getX();
            int shapeHeight = shapeEndingPoint.getY() - shapeStartingPoint.getY();
            Rectangle shapeBounds = new Rectangle(shapeStartingPoint.getX(), shapeStartingPoint.getY(), shapeWidth, shapeHeight);
            if (boundingBox.intersects(shapeBounds)) {
                selectedShapes.addShape(shape, false);
            }
        }
    }
}
