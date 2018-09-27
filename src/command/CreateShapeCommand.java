package command;

import controller.IJPaintController;
import model.Point;
import view.interfaces.IEventCallback;

public class CreateShapeCommand implements IEventCallback {
    private final IJPaintController paintController;
    private final Point startingPoint;
    private final Point endingPoint;

    public CreateShapeCommand(IJPaintController paintController, Point startingPoint, Point endingPoint) {
        this.paintController = paintController;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public void run() {
        this.paintController.createShape(startingPoint, endingPoint);
    }
}
