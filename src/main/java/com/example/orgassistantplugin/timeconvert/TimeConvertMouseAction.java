package com.example.orgassistantplugin.timeconvert;

import com.example.orgassistantplugin.TimeZoneConverterDialog;
import com.example.orgassistantplugin.style.MenuStyle;
import com.intellij.ui.JBColor;
import com.intellij.ui.treeStructure.Tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.example.orgassistantplugin.ApplicationConstants.TIME_ZONE_CONVERT;

public class TimeConvertMouseAction {
    public static void _mouse_click_right(Tree tree) {
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                        if (TIME_ZONE_CONVERT.equals(node.getUserObject().toString())) {
                            JPopupMenu menu = new JPopupMenu();
                            JMenuItem runItem = new JMenuItem("Run");
                            MenuStyle.styleSubMenuItem(runItem);
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
}
