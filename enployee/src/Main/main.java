package Main;

import Model.Holiday;
import View.HolidayView;
import controller.HolidayController;

public class main {

    public static void main(String[] args) {
        // Initialize the View and Model for the Holiday Management System
        HolidayView view = new HolidayView();
        Holiday model = new Holiday(0, null, null, null, null, null);

        // Connect the Controller to the View and Model
        new HolidayController(view, model);

        // Make the application visible
        view.setVisible(true);
    }
}
