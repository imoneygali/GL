package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    static Boolean isSplashLoaded = false;

    static int body_index = 0, body_progress = 0;
    static int legs_index = 0, legs_progress = 0;
    static int biceps_index = 0, biceps_progress = 0;


    static String[] body_ex = {"Barbell Bench Press", "Dumbbell Bench Press", "Bent Over Barbell Row",
                                       "Dips - Triceps Version", "Hanging Leg Raise", "Barbell Squat", " Standing Calf Raises"};

    static String[] legs_ex = {"Dumbbell Lunges", "Leg Press", "Lying Leg Curls", "Leg Extensions",
                    "Thigh Abductor", "Front Barbell Squat", "Barbell Lunge"};

    static String[] biceps_ex = {"Incline Hammer Curls", "Spider Curl", "Hammer Curls", "Overhead Cable Curl",
                "Wide-Grip Standing Barbell Curl", "Biceps Curl To Shoulder Press", "Close-Grip EZ Bar Curl"};




    @Override

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("GL");
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(800);



        stage.show();
        stage.setResizable(false);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
