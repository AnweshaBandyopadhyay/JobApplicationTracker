package controller;

import model.JobApplication;
import ui.TrackerView;

public class TrackerController {

    private final TrackerView view;

    public TrackerController(TrackerView view) {
        this.view = view;
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
            view.jobList.add(job);

            // Clear form
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
