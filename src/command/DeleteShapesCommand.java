package command;

import command.interfaces.IShapeCommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class DeleteShapesCommand implements IShapeCommand {
    private final IShapeList drawnShapes;
    private final IShapeList selectedShapes;

    public DeleteShapesCommand(IShapeList drawnShapes, IShapeList selectedShapes) {
        this.drawnShapes = drawnShapes;
        this.selectedShapes = selectedShapes;
    }

    @Override
    public void run() {
        for (IShape selectedShape : this.selectedShapes.getShapes()) {
            this.drawnShapes.removeShape(selectedShape, true);
        }
        CommandHistory.add(this.drawnShapes);
    }
}
