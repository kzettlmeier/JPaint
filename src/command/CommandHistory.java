package command;

import model.interfaces.IShape;
import model.interfaces.IShapeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandHistory {
    private static final Stack<List<IShape>> undoStack = new Stack<>();
    private static final Stack<List<IShape>> redoStack = new Stack<>();

    public static void add(IShapeList shapeList) {
        List<IShape> newList = new ArrayList<>();
        for (IShape shape : shapeList.getShapes()) {
            newList.add(shape);
        }
        undoStack.push(newList);
        redoStack.clear();
    }

    public static boolean undo(IShapeList currentReference) {
        boolean result = !undoStack.empty();
        if (result) {
            List<IShape> undoObj = undoStack.pop();
            redoStack.push(undoObj);
            if (!undoStack.empty()) {
                List<IShape> newCurrentObj = undoStack.peek();
                currentReference.removeAllShapes(true);
                for (IShape shape : newCurrentObj) {
                    currentReference.addShape(shape, true);
                }
            } else {
                currentReference.removeAllShapes(true);
            }
        }
        return result;
    }

    public static boolean redo(IShapeList currentReference) {
        boolean result = !redoStack.empty();
        if (result) {
            List<IShape> redoObj = redoStack.pop();
            undoStack.push(redoObj);
            currentReference.removeAllShapes(true);
            for (IShape shape : redoObj) {
                currentReference.addShape(shape, true);
            }
        }
        return result;
    }
}
