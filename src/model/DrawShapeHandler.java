package model;

import model.interfaces.IApplicationState;
import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShape;

public class DrawShapeHandler implements IDrawShapeHandler {
    private final IApplicationState appState;

    public DrawShapeHandler(IApplicationState appState) {
        this.appState = appState;
    }

    @Override
    public void update() {
        for (IShape shape : this.appState.getShapeList().getShapes()) {
            shape.draw(this.appState.getPaintCanvas());
        }
    }
}
