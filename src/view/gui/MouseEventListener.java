package view.gui;

import command.CreateShapeCommand;
import controller.IJPaintController;
import model.Point;
import model.interfaces.IApplicationState;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventListener implements MouseListener {
    private final IJPaintController paintController;
    private Point startingPoint;

    public MouseEventListener(IJPaintController paintController) {
        this.paintController = paintController;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startingPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        CreateShapeCommand command = new CreateShapeCommand(this.paintController, this.startingPoint, new Point(e.getX(), e.getY()));
        command.run();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}