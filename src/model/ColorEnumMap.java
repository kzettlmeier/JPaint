package model;

import java.awt.*;
import java.util.EnumMap;

public class ColorEnumMap {
    private static final ColorEnumMap instance = new ColorEnumMap();
    private final EnumMap<ShapeColor, Color> colorEnumMap;

    private ColorEnumMap() {
        this.colorEnumMap = new EnumMap<>(ShapeColor.class);
        this.buildEnumMap();
    }

    private void buildEnumMap() {
        colorEnumMap.put(ShapeColor.BLUE, Color.BLUE);
        colorEnumMap.put(ShapeColor.GREEN, Color.GREEN);
        colorEnumMap.put(ShapeColor.BLACK, Color.BLACK);
        colorEnumMap.put(ShapeColor.WHITE, Color.WHITE);
        colorEnumMap.put(ShapeColor.CYAN, Color.CYAN);
        colorEnumMap.put(ShapeColor.DARK_GRAY, Color.DARK_GRAY);
        colorEnumMap.put(ShapeColor.GRAY, Color.GRAY);
        colorEnumMap.put(ShapeColor.LIGHT_GRAY, Color.LIGHT_GRAY);
        colorEnumMap.put(ShapeColor.MAGENTA, Color.MAGENTA);
        colorEnumMap.put(ShapeColor.ORANGE, Color.ORANGE);
        colorEnumMap.put(ShapeColor.PINK, Color.PINK);
        colorEnumMap.put(ShapeColor.RED, Color.RED);
        colorEnumMap.put(ShapeColor.YELLOW, Color.YELLOW);
    }

    public EnumMap<ShapeColor, Color> getColorEnumMap() {
        return this.colorEnumMap;
    }

    public static ColorEnumMap getInstance() {
        return instance;
    }
}
