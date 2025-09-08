package com.example.orgassistantplugin.style;

import com.intellij.ui.JBColor;
import com.intellij.ui.RoundedLineBorder;
import com.intellij.util.ui.JBFont;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import javax.swing.border.Border;

public class MenuStyle {

    public static void styleSubMenuItem(JMenuItem menuItem) {
        menuItem.setBackground(JBColor.background());
        menuItem.setForeground(JBColor.foreground());
        menuItem.setFont(JBFont.regular());
        Border roundedBorder = new RoundedLineBorder(JBColor.foreground(),10);
        Border padding = JBUI.Borders.empty();
        menuItem.setBorder(BorderFactory.createCompoundBorder(roundedBorder, padding));
    }
}
