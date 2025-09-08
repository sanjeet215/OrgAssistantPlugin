package com.example.orgassistantplugin;

import com.example.orgassistantplugin.timeconvert.TimeConvertMouseAction;
import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.example.orgassistantplugin.ApplicationConstants.TIME_ZONE_CONVERT;

public class AiToolWindowPanel {
    private final JPanel mainPanel;

    public AiToolWindowPanel() {
        mainPanel = new JPanel(new BorderLayout());
        Tree tree = AiTreeBuilder.buildTree();
        TimeConvertMouseAction._mouse_click_right(tree);
        JBScrollPane treeScroll = new JBScrollPane(tree);
        mainPanel.add(treeScroll, BorderLayout.CENTER);
    }

    public JComponent getMainComponent() {
        return mainPanel;
    }
}