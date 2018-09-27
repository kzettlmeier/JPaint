package model.persistence;

import model.*;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import model.interfaces.IShape;
import view.interfaces.IUiModule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ApplicationState implements IApplicationState, Serializable {
    private static final long serialVersionUID = -5545483996576839007L;
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private StartAndEndPointMode activeStartAndEndPointMode;
    private Point startingCoordinatePoint;
    private Point endingCoordinatePoint;
    private List<IShape> shapeList;

    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeStartAndEndPointMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }

    @Override
    public void setStartingCoordinatePoint(Point startingPoint) {
        this.startingCoordinatePoint = startingPoint;
    }

    @Override
    public void setEndingCoordinatePoint(Point endingPoint) {
        this.endingCoordinatePoint = endingPoint;
    }

    @Override
    public void resetCurrentCoordinates() {
        this.startingCoordinatePoint = null;
        this.endingCoordinatePoint = null;
    }

    @Override
    public void addShape(IShape shape) {
        this.shapeList.add(shape);
    }

    @Override
    public void deleteShape(IShape shape) {
        this.shapeList.remove(shape);
    }

    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public StartAndEndPointMode getActiveStartAndEndPointMode() {
        return activeStartAndEndPointMode;
    }

    @Override
    public Point getStartingCoordinatePoint() { return this.startingCoordinatePoint; }

    @Override
    public Point getEndingCoordinatePoint() { return this.endingCoordinatePoint; }

    @Override
    public List<IShape> getShapeList() { return this.shapeList; }

    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeStartAndEndPointMode = StartAndEndPointMode.DRAW;
        this.shapeList = new ArrayList<>();
    }
}
