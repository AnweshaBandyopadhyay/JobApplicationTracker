package ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.JobApplication;

public class TrackerView {
    public TextField companyField = new TextField();
    public TextField titleField = new TextField();
    public DatePicker datePicker = new DatePicker();
    public ComboBox<String> statusCombo = new ComboBox<>();
    public Button addButton = new Button("Add Job");
    public TableView<JobApplication> table = new TableView<>();
    public ObservableList<JobApplication> jobList = FXCollections.observableArrayList();

    public VBox setupUI() {
        GridPane form = new GridPane();
        form.setVgap(10);
        form.setHgap(10);

        form.add(new Label("Company:"), 0, 0);
        form.add(companyField, 1, 0);

        form.add(new Label("Job Title:"), 0, 1);
        form.add(titleField, 1, 1);

        form.add(new Label("Date:"), 0, 2);
        form.add(datePicker, 1, 2);

        form.add(new Label("Status:"), 0, 3);
        statusCombo.getItems().addAll("Applied", "Interview", "Offer", "Rejected");
        form.add(statusCombo, 1, 3);

        form.add(addButton, 1, 4);

        // Table
        TableColumn<JobApplication, String> companyCol = new TableColumn<>("Company");
        companyCol.setCellValueFactory(new PropertyValueFactory<>("company"));

        TableColumn<JobApplication, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<JobApplication, String> dateCol = new TableColumn<>("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<JobApplication, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        table.setItems(jobList);
        table.getColumns().addAll(companyCol, titleCol, dateCol, statusCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        VBox layout = new VBox(15, form, table);
        layout.setPadding(new javafx.geometry.Insets(20));
        return layout;
    }
}
