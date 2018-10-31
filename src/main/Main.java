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
        IDrawShapeHandler drawShapeHandler = new DrawShapeHandler(paintCanvas);
        IShapeList shapeList = new ShapeList(drawShapeHandler);
        IShapeList selectedShapes = new ShapeList(drawShapeHandler);
        IShapeList copiedShapes = new ShapeList(drawShapeHandler);
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList, selectedShapes, copiedShapes);
        paintCanvas.addMouseListener(new MouseEventListener(appState, shapeList, selectedShapes));
        controller.setup();
    }
}
