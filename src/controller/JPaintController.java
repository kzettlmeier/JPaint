package controller;

import model.Point;
import model.interfaces.IApplicationState;
import model.interfaces.IShape;
import model.Shape;
import view.EventName;
import view.gui.PaintCanvas;
import view.interfaces.IUiModule;

import java.awt.*;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final PaintCanvas paintCanvas;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, PaintCanvas paintCanvas) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    @Override
    public void createShape(Point startingPoint, Point endingPoint) {
        IShape shape = new Shape(this.applicationState.getActiveShapeType(), this.applicationState.getActivePrimaryColor(), this.applicationState.getActiveSecondaryColor(), this.applicationState.getActiveShapeShadingType(), startingPoint, endingPoint);

        Point pointDifference = new Point(endingPoint.getX() - startingPoint.getX(), endingPoint.getY() - startingPoint.getY());
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.drawRect(startingPoint.getX(), startingPoint.getY(), pointDifference.getX(), pointDifference.getY());

        this.applicationState.addShape(shape);
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
    }
}
