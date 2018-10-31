package command;

import command.interfaces.IShapeCommand;
import model.interfaces.IShape;
import model.interfaces.IShapeList;

public class CopyShapesCommand implements IShapeCommand {
    private final IShapeList selectedShapes;
    private final IShapeList copiedShapes;
    public CopyShapesCommand(IShapeList selectedShapes, IShapeList copiedShapes) {
        this.selectedShapes = selectedShapes;
        this.copiedShapes = copiedShapes;
    }

    @Override
    public void run() {
        this.copiedShapes.removeAllShapes(false);
        for (IShape shape : selectedShapes.getShapes()) {
            this.copiedShapes.addShape(shape, false);
        }
    }
}
