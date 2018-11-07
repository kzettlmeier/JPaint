package controller;

import command.CommandHistory;
import command.CopyShapesCommand;
import command.DeleteShapesCommand;
import command.PasteShapesCommand;
import model.interfaces.IApplicationState;
import model.interfaces.IShapeList;
import view.EventName;
import view.interfaces.IUiModule;

public class JPaintController implements IJPaintController {
    private final IUiModule uiModule;
    private final IApplicationState applicationState;
    private final IShapeList drawnShapes;
    private final IShapeList selectedShapes;
    private final IShapeList copiedShapes;

    public JPaintController(IUiModule uiModule, IApplicationState applicationState, IShapeList drawnShapes, IShapeList selectedShapes, IShapeList copiedShapes) {
        this.uiModule = uiModule;
        this.applicationState = applicationState;
        this.drawnShapes = drawnShapes;
        this.selectedShapes = selectedShapes;
        this.copiedShapes = copiedShapes;
    }

    @Override
    public void setup() {
        setupEvents();
    }

    private void setupEvents() {
        uiModule.addEvent(EventName.CHOOSE_SHAPE, () -> applicationState.setActiveShape());
        uiModule.addEvent(EventName.CHOOSE_PRIMARY_COLOR, () -> applicationState.setActivePrimaryColor());
        uiModule.addEvent(EventName.CHOOSE_SECONDARY_COLOR, () -> applicationState.setActiveSecondaryColor());
        uiModule.addEvent(EventName.CHOOSE_SHADING_TYPE, () -> applicationState.setActiveShadingType());
        uiModule.addEvent(EventName.CHOOSE_START_POINT_ENDPOINT_MODE, () -> applicationState.setActiveStartAndEndPointMode());
        uiModule.addEvent(EventName.COPY, () -> new CopyShapesCommand(this.selectedShapes, this.copiedShapes).run());
        uiModule.addEvent(EventName.PASTE, () -> new PasteShapesCommand(this.drawnShapes, this.copiedShapes).run());
        uiModule.addEvent(EventName.DELETE, () -> new DeleteShapesCommand(this.drawnShapes, this.selectedShapes).run());
        uiModule.addEvent(EventName.UNDO, () -> CommandHistory.undo(this.drawnShapes));
        uiModule.addEvent(EventName.REDO, () -> CommandHistory.redo(this.drawnShapes));
    }
}
