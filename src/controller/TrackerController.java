package controller;

import model.JobApplication;
import ui.TrackerView;
import database.JobApplicationDatabase;

public class TrackerController {

    private final TrackerView view;
    //private final JobApplicationDatabase jobDB;

    public TrackerController(TrackerView view) {
        this.view = view;
        //this.jobDB = new JobApplicationDatabase(); // create DB helper object
        setupListeners();
    }

    private void setupListeners() {
        view.addButton.setOnAction(e -> {
            String company = view.companyField.getText();
            String title = view.titleField.getText();
            var date = view.datePicker.getValue();
            String status = view.statusCombo.getValue();

            if (company.isEmpty() || title.isEmpty() || date == null || status == null) {
                showAlert("All fields must be filled.");
                return;
            }

            JobApplication job = new JobApplication(company, title, date, status);

            // ✅ Save to observable list (for UI)
            view.jobList.add(job);

            // ✅ Save to database
            boolean success = JobApplicationDatabase.insertJob(job);
            if (!success) {
                showAlert("Failed to save to database.");
                return;
            }

            // ✅ Clear form
            view.companyField.clear();
            view.titleField.clear();
            view.datePicker.setValue(null);
            view.statusCombo.setValue(null);
        });
    }

    private void showAlert(String msg) {
        var alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setContentText(msg);
        alert.showAndWait();
    }
}