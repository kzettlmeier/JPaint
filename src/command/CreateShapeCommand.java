package command;

import command.interfaces.IShapeCommand;
import model.builders.ShapeBuilder;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;

public class CreateShapeCommand implements IShapeCommand {
    private final IApplicationState applicationState;

    public CreateShapeCommand(IApplicationState applicationState) {
        this.applicationState = applicationState;
    }

    public void run() {
        ShapeBuilder builder = new ShapeBuilder();
        builder.setShapeType(applicationState.getActiveShapeType());
        builder.setPrimaryColor(applicationState.getActivePrimaryColor());
        builder.setSecondaryColor(applicationState.getActiveSecondaryColor());
        builder.setShadingType(applicationState.getActiveShapeShadingType());
        builder.setStartingPoint(applicationState.getStartingCoordinatePoint());
        builder.setEndingPoint(applicationState.getEndingCoordinatePoint());
        IShape shape = builder.toShape();
        applicationState.getShapeList().addShape(shape);
    }
}
