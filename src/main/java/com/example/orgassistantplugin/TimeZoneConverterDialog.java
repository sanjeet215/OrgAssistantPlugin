package com.example.orgassistantplugin;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class TimeZoneConverterDialog extends DialogWrapper {
    private final JSpinner dateTimeSpinner;
    private final JComboBox<String> sourceZoneCombo;
    private final JComboBox<String> targetZoneCombo;
    private final JLabel resultLabel;

    public TimeZoneConverterDialog() {
        super(true);
        setTitle("Time Zone Converter");

        // DateTime spinner (with calendar + time)
        SpinnerDateModel model = new SpinnerDateModel();
        dateTimeSpinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(dateTimeSpinner, "yyyy-MM-dd HH:mm");
        dateTimeSpinner.setEditor(editor);

        // Populate available time zones in a dropdown
        Vector<String> zones = new Vector<>(ZoneId.getAvailableZoneIds());
        zones.sort(String::compareTo);

        sourceZoneCombo = new JComboBox<>(zones);
        sourceZoneCombo.setSelectedItem(ZoneId.systemDefault().getId());

        targetZoneCombo = new JComboBox<>(zones);
        targetZoneCombo.setSelectedItem("UTC");

        resultLabel = new JLabel("Result will be shown here");

        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 8, 8));

        panel.add(new JLabel("Select Date & Time:"));
        panel.add(dateTimeSpinner);

        panel.add(new JLabel("Source Time Zone:"));
        panel.add(sourceZoneCombo);

        panel.add(new JLabel("Target Time Zone:"));
        panel.add(targetZoneCombo);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(e -> doConvert());
        panel.add(convertButton);

        panel.add(resultLabel);

        return panel;
    }

    /**
     * Converts the date and time selected in the spinner from the source time zone to the target time zone.
     * The result is formatted as "yyyy-MM-dd HH:mm" and displayed in the result label.
     * This method is triggered by the Convert button in the dialog.
     */
    private void doConvert() {
        java.util.Date selectedDate = (java.util.Date) dateTimeSpinner.getValue();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(selectedDate.toInstant(), ZoneId.systemDefault());

        ZoneId sourceZone = ZoneId.of((String) sourceZoneCombo.getSelectedItem());
        ZoneId targetZone = ZoneId.of((String) targetZoneCombo.getSelectedItem());

        String converted = localDateTime
                .atZone(sourceZone)
                .withZoneSameInstant(targetZone)
                .toLocalDateTime()
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        resultLabel.setText("Converted: " + converted);
    }
}

