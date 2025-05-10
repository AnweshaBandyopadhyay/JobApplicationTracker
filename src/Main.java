import controller.TrackerController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.TrackerView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        TrackerView view = new TrackerView();
        new TrackerController(view);

        Scene scene = new Scene(view.setupUI(), 800, 500);
        primaryStage.setTitle("Job Application Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
