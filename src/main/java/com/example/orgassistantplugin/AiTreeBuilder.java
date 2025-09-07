package com.example.orgassistantplugin;

import com.intellij.ui.treeStructure.Tree;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class AiTreeBuilder {
    public static Tree buildTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Tasks");

        DefaultMutableTreeNode buildNode = new DefaultMutableTreeNode("Utilities");
        buildNode.add(new DefaultMutableTreeNode("Generate Test"));
        buildNode.add(new DefaultMutableTreeNode("Summarize Jira Ticket"));
        buildNode.add(new DefaultMutableTreeNode("Analyze Code"));
        buildNode.add(new DefaultMutableTreeNode("build my Code"));
        buildNode.add(new DefaultMutableTreeNode("TimeZone Converter"));
        buildNode.add(new DefaultMutableTreeNode("Generate method comments"));
        root.add(buildNode);

        DefaultMutableTreeNode verificationNode = new DefaultMutableTreeNode("verification");
        verificationNode.add(new DefaultMutableTreeNode("test"));
        verificationNode.add(new DefaultMutableTreeNode("check"));
        root.add(verificationNode);

        Tree tree = new Tree(new DefaultTreeModel(root));
        tree.setRootVisible(true);
        tree.setShowsRootHandles(true);
        tree.setCellRenderer(new IconTreeCellRenderer());
        return tree;
    }
}
