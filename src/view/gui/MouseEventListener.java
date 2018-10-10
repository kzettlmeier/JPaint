package view.gui;

import command.CreateShapeCommand;
import model.Point;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventListener implements MouseListener {
    private final IApplicationState applicationState;
    private final IShapeList shapeList;

    public MouseEventListener(IApplicationState applicationState, IShapeList shapeList) {
        this.applicationState = applicationState;
        this.shapeList = shapeList;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.applicationState.resetCurrentCoordinates();
        this.applicationState.setStartingCoordinatePoint(new Point(e.getX(), e.getY()));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point startingPoint = this.applicationState.getStartingCoordinatePoint();
        Point endingPoint = new Point(e.getX(), e.getY());

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

        this.applicationState.setStartingCoordinatePoint(startingPoint);
        this.applicationState.setEndingCoordinatePoint(endingPoint);

        CreateShapeCommand command = new CreateShapeCommand(this.applicationState, this.shapeList);
        command.run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}