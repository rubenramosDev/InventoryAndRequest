package edu.utl.rubenRamos.lasPalmasSystem.utils;

import javafx.scene.control.Tooltip;

public class TooltipGenerator {

    public static Tooltip regularTooltip(String message) {
        final Tooltip tooltip = new Tooltip();
        tooltip.setText(message);
        return tooltip;
    }

}
