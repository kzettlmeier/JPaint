package command;

import command.interfaces.IShapeCommand;
import model.builders.ShapeBuilder;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class CreateShapeCommand implements IShapeCommand {
    private final IApplicationState applicationState;
    private final IShapeList shapeList;

    public CreateShapeCommand(IApplicationState applicationState, IShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
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
        this.shapeList.addShape(shape, true);
        CommandHistory.add(this.shapeList);
    }
}
