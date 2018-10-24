package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.DrawShapeHandler;
import model.ShapeList;
import model.interfaces.IDrawShapeHandler;
import model.interfaces.IShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.MouseEventListener;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvas paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        IDrawShapeHandler drawShapeHandler = new DrawShapeHandler(paintCanvas);
        IShapeList shapeList = new ShapeList(drawShapeHandler);
        IShapeList selectedShapes = new ShapeList(drawShapeHandler);
        paintCanvas.addMouseListener(new MouseEventListener(appState, shapeList, selectedShapes));
        controller.setup();

        // For example purposes only; remove from your final project.
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Graphics2D graphics2d = paintCanvas.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
    }
}
