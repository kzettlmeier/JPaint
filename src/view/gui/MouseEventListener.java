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
        this.applicationState.setEndingCoordinatePoint(new Point(e.getX(), e.getY()));
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