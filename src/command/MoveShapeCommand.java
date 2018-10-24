package command;

import command.interfaces.IShapeCommand;
import model.Point;
import model.builders.ShapeBuilder;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoveShapeCommand implements IShapeCommand {
    private final IApplicationState appState;
    private final IShapeList drawnShapes;
    private final IShapeList selectedShapes;

    public MoveShapeCommand(IApplicationState appState, IShapeList drawnShapes, IShapeList selectedShapes) {
        this.appState = appState;
        this.drawnShapes = drawnShapes;
        this.selectedShapes = selectedShapes;
    }

    @Override
    public void run() {
        Point startingPoint = appState.getStartingCoordinatePoint();
        Point endingPoint = appState.getEndingCoordinatePoint();
        int xDiff = endingPoint.getX() - startingPoint.getX();
        int yDiff = endingPoint.getY() - startingPoint.getY();

        List<IShape> selectedShapesList = this.selectedShapes.getShapes();
        List<IShape> drawnShapesList = this.drawnShapes.getShapes();

        Map<IShape, IShape> mapOfShapes = new HashMap<>();
        for (IShape selectedShape : selectedShapesList) {
            for (IShape drawnShape : drawnShapesList) {
                if (selectedShape.equals(drawnShape)) {
                    ShapeBuilder shapeBuilder = new ShapeBuilder();
                    shapeBuilder.setShapeType(drawnShape.getShapeType());
                    shapeBuilder.setShadingType(drawnShape.getShadingType());
                    shapeBuilder.setPrimaryColor(drawnShape.getPrimaryColor());
                    shapeBuilder.setSecondaryColor(drawnShape.getSecondaryColor());

                    Point currentStartingPoint = drawnShape.getStartingCoordinate();
                    Point newStartingPoint = new Point(currentStartingPoint.getX() + xDiff, currentStartingPoint.getY() + yDiff);
                    Point currentEndingPoint = drawnShape.getEndingCoordinate();
                    Point newEndingPoint = new Point(currentEndingPoint.getX() + xDiff, currentEndingPoint.getY() + yDiff);
                    shapeBuilder.setStartingPoint(newStartingPoint);
                    shapeBuilder.setEndingPoint(newEndingPoint);

                    mapOfShapes.put(drawnShape, shapeBuilder.toShape());
                }
            }
        }

        for (IShape deleteShape : mapOfShapes.keySet()) {
            IShape addShape = mapOfShapes.get(deleteShape);
            this.drawnShapes.removeShape(deleteShape, true);
            this.drawnShapes.addShape(addShape, true);
        }
    }
}
