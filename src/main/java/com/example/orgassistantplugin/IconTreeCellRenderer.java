package com.example.orgassistantplugin;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.util.Objects;

public class IconTreeCellRenderer extends DefaultTreeCellRenderer {
    private final Icon testIcon     = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/inlineSettings.png")));
    private final Icon jiraIcon     = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/inlineSettings.png")));
    private final Icon codeIcon     = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/taskGroup.png")));
    private final Icon buildIcon    = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/taskGroup_dark.png")));
    private final Icon timezoneIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/arrowLeftRight.png")));
    private final Icon commentsIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/arrowLeftRight_dark.png")));
    private final Icon utilities = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/taskGroup.png")));
    //private final Icon hotSwap = new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/hotSwap.png")));

    @Override
    public Component getTreeCellRendererComponent(
            JTree tree, Object value, boolean sel, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        String nodeText = value.toString();

        switch (nodeText) {
            case "Generate Test": setIcon(testIcon); break;
            case "Summarize Jira Ticket": setIcon(jiraIcon); break;
            case "Analyze Code": setIcon(codeIcon); break;
            case "build my Code": setIcon(buildIcon); break;
            case "TimeZone Converter": setIcon(timezoneIcon); break;
            case "Generate method comments": setIcon(commentsIcon); break;
            case "Utilities": setIcon(utilities); break;
            default: break;
        }
        return this;
    }


}

