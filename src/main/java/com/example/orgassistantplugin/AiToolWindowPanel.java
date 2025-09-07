package com.example.orgassistantplugin;

import com.intellij.ui.components.JBScrollPane;
import com.intellij.ui.treeStructure.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AiToolWindowPanel {
    private final JPanel mainPanel;

    public AiToolWindowPanel() {
        mainPanel = new JPanel(new BorderLayout());
        Tree tree = AiTreeBuilder.buildTree();

        _mouse_click_right(tree);

        JBScrollPane treeScroll = new JBScrollPane(tree);
        mainPanel.add(treeScroll, BorderLayout.CENTER);
    }

    private static void _mouse_click_right(Tree tree) {
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                        if ("TimeZone Converter".equals(node.getUserObject().toString())) {
                            JPopupMenu menu = new JPopupMenu();
                            JMenuItem runItem = new JMenuItem("Run");
                            runItem.addActionListener(actionEvent -> {
                                TimeZoneConverterDialog dialog = new TimeZoneConverterDialog();
                                dialog.show();
                            });
                            menu.add(runItem);
                            menu.show(tree, e.getX(), e.getY());
                        }
                    }
                }
            }
        });
    }

    public JComponent getMainComponent() {
        return mainPanel;
    }
}