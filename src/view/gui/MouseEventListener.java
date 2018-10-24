package view.gui;

import command.CreateShapeCommand;
import command.MoveShapeCommand;
import command.SelectShapeCommand;
import command.interfaces.IShapeCommand;
import model.Point;
import model.StartAndEndPointMode;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventListener implements MouseListener {
    private final IApplicationState applicationState;
    private final IShapeList shapeList;
    private final IShapeList selectedShapeList;

    public MouseEventListener(IApplicationState applicationState, IShapeList shapeList, IShapeList selectedShapes) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
        this.selectedShapeList = selectedShapes;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.applicationState.resetCurrentCoordinates();
        this.applicationState.setStartingCoordinatePoint(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        StartAndEndPointMode mode = applicationState.getActiveStartAndEndPointMode();

        Point startingPoint = this.applicationState.getStartingCoordinatePoint();
        Point endingPoint = new Point(e.getX(), e.getY());

        if (!mode.equals(StartAndEndPointMode.MOVE)) {
            if (startingPoint.getX() > endingPoint.getX()) {
                int oldInt = startingPoint.getX();
                startingPoint = new Point(endingPoint.getX(), startingPoint.getY());
                endingPoint = new Point(oldInt, endingPoint.getY());
            }
            if (startingPoint.getY() > endingPoint.getY()) {
                int oldInt = startingPoint.getY();
                startingPoint = new Point(startingPoint.getX(), endingPoint.getY());
                endingPoint = new Point(endingPoint.getX(), oldInt);
            }
        }

        this.applicationState.setStartingCoordinatePoint(startingPoint);
        this.applicationState.setEndingCoordinatePoint(endingPoint);

        IShapeCommand command = null;
        if (mode.equals(StartAndEndPointMode.DRAW)) {
            command = new CreateShapeCommand(this.applicationState, this.shapeList);
        } else if (mode.equals(StartAndEndPointMode.SELECT)) {
            command = new SelectShapeCommand(this.applicationState, this.shapeList, this.selectedShapeList);
        } else {
            command = new MoveShapeCommand(this.applicationState, this.shapeList, this.selectedShapeList);
        }
        command.run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}