package controller;

import Model.Holiday;
import View.HolidayView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class HolidayController {

    private HolidayView view;
    private Holiday model;

    public HolidayController(HolidayView view, Holiday model) {
        this.view = view;
        this.model = model;
        initializeListeners();
    }

    private void initializeListeners() {
        view.getAddButton().addActionListener(e -> handleAddHoliday());
        view.getUpdateButton().addActionListener(e -> handleUpdateHoliday());
        view.getDeleteButton().addActionListener(e -> handleDeleteHoliday());
        view.getListButton().addActionListener(e -> handleListHolidays());
    }

    private void handleAddHoliday() {
        try {
            int employeeId = Integer.parseInt(view.getEndField().getText());
            String reason = view.getEndField().getText();
            if (reason.isEmpty()) {
                view.showErrorMessage("Reason cannot be empty.");
                return;
            }
            java.util.Date startDate = view.parseDate(view.getStartField().getText());
            java.util.Date endDate = view.parseDate(view.getEndField().getText());
            if (startDate == null || endDate == null) {
                view.showErrorMessage("Invalid date format. Use yyyy-MM-dd.");
                return;
            }

            Holiday holiday = new Holiday(0, new java.sql.Date(startDate.getTime()), new java.sql.Date(endDate.getTime()), reason, employeeId);
            model.updateHoliday(holiday);
            view.showSuccessMessage("Holiday added successfully.");
        } catch (NumberFormatException ex) {
            view.showErrorMessage("Please enter a valid Employee ID.");
        }
    }

    private void handleUpdateHoliday() {
        try {
            int id = Integer.parseInt(view.getIdField().getText());
            int employeeId = Integer.parseInt(view.getEndField().getText());
            String reason = view.getEndField().getText();
            if (reason.isEmpty()) {
                view.showErrorMessage("Reason cannot be empty.");
                return;
            }
            java.util.Date startDate = view.parseDate(view.getStartField().getText());
            java.util.Date endDate = view.parseDate(view.getEndField().getText());
            if (startDate == null || endDate == null) {
                view.showErrorMessage("Invalid date format. Use yyyy-MM-dd.");
                return;
            }

            Holiday holiday = new Holiday(id, new java.sql.Date(startDate.getTime()), new java.sql.Date(endDate.getTime()), reason, employeeId);
            model.updateHoliday(holiday);
            view.showSuccessMessage("Holiday updated successfully.");
        } catch (NumberFormatException ex) {
            view.showErrorMessage("Please enter valid IDs.");
        }
    }

    private void handleDeleteHoliday() {
        try {
            int id = Integer.parseInt(view.getIdField().getText());
            model.deleteHoliday(id);
            view.showSuccessMessage("Holiday deleted successfully.");
        } catch (NumberFormatException ex) {
            view.showErrorMessage("Please enter a valid ID.");
        }
    }

    private void handleListHolidays() {
        List<Holiday> holidays = (List<Holiday>) model.getAllHolidays();
        DefaultTableModel tableModel = (DefaultTableModel) view.getHolidayType().getModel();
        tableModel.setRowCount(0);

        for (Holiday holiday : holidays) {
            tableModel.addRow(new Object[] {
                holiday.getId(),
                holiday.getStartDate(),
                holiday.getEndDate(),
                holiday.getReason(),
                holiday.getEmployee()
            });
        }
    }
}