package sample;

import com.jfoenix.controls.JFXDrawer   ;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import static sample.Main.*;


public class Controller implements Initializable {

    public static Preferences preferences = Preferences.userNodeForPackage(Controller.class);

    @FXML
    private  AnchorPane root;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXProgressBar prog_body;

    @FXML
    private JFXProgressBar prog_legs;

    @FXML
    private JFXProgressBar prog_biceps;

    @FXML
    private Pane pane_about;

    @FXML
    private ImageView ava;



    @FXML
    private Text welcome_text;

    @FXML
    private Button start;

    @FXML
    private Button reset;

    @FXML
    void show_text(ActionEvent event) {

        welcome_text.setVisible(true);

    }

    @FXML
    void reset(ActionEvent event) throws BackingStoreException {
        preferences.clear();
        prog_body.setProgress(0);
        prog_legs.setProgress(0);
        prog_biceps.setProgress(0);
    }

    boolean about_check = true;



    @FXML
    void about_handle(MouseEvent event) {
        pane_about.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!Main.isSplashLoaded) {
            loadSplashScreen();
        }
        else {
            float bodyValue = Float.parseFloat(preferences.get("body_progress", "0"));
            float legsValue = Float.parseFloat(preferences.get("legs_progress", "0"));
            float bicepsValue = Float.parseFloat(preferences.get("biceps_progress", "0"));

            Timeline timeline = new Timeline(
                    new KeyFrame(
                            Duration.ZERO,
                            new KeyValue(prog_body.progressProperty(), 0)),
                    new KeyFrame(
                            Duration.seconds(1),
                            new KeyValue(prog_body.progressProperty(), bodyValue/2)),
                    new KeyFrame(
                            Duration.seconds(2),
                            new KeyValue(prog_body.progressProperty(), bodyValue)),

            new KeyFrame(
                    Duration.ZERO,
                    new KeyValue(prog_legs.progressProperty(), 0)),
                    new KeyFrame(
                            Duration.seconds(1),
                            new KeyValue(prog_legs.progressProperty(), legsValue/2)),

                    new KeyFrame(
                            Duration.seconds(2),
                            new KeyValue(prog_legs.progressProperty(), legsValue)),

            new KeyFrame(
                    Duration.ZERO,
                    new KeyValue(prog_biceps.progressProperty(), 0)),
                    new KeyFrame(
                            Duration.seconds(1),
                            new KeyValue(prog_biceps.progressProperty(), bicepsValue/2)),
                    new KeyFrame(
                            Duration.seconds(2),
                            new KeyValue(prog_biceps.progressProperty(), bicepsValue)));

            timeline.play();
        }

        try {

            FXMLLoader sidepaneloader = new FXMLLoader();


            sidepaneloader.setLocation(getClass().getResource("SidePanel.fxml"));
            VBox box = sidepaneloader.load();
            drawer.setSidePane(box);


            Object[] nodes = box.getChildren().toArray();
            for (Object node : nodes) {
                Node item = (Node) node;
                if (node instanceof Button) {
                    Button btn = (Button) node;

                    btn.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {

                            System.out.println(btn.getText());

                            switch (btn.getText()) {

                                case "BODY":
                                    try {
                                        body();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                break;

                                case "LEGS":
                                    try {
                                        legs();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                break;


                                case "BICEPS":
                                    try {
                                        biceps();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                break;

                                case "ABOUT":
                                    pane_about.setVisible(true);
                                break;


                                 default:
                                     break;

                            }

                        }
                    });


                }
            }


        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        HamburgerBackArrowBasicTransition transition = new HamburgerBackArrowBasicTransition(hamburger);
        transition.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            transition.setRate(transition.getRate() * -1);
            transition.play();

            if (drawer.isShown()) {
                drawer.close();
            } else {
                drawer.open();
            }
        });
    }


    private void loadSplashScreen() {
        try {
            Main.isSplashLoaded = true;

            StackPane pane = FXMLLoader.load(getClass().getResource(("Splash.fxml")));
            root.getChildren().setAll(pane);

            FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.setCycleCount(1);

            FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
            fadeOut.setFromValue(1);
            fadeOut.setToValue(0);
            fadeOut.setCycleCount(1);

            fadeIn.play();

            fadeIn.setOnFinished((e) -> {
                fadeOut.play();
            });

            fadeOut.setOnFinished((e) -> {
                try {
                    AnchorPane parentContent = FXMLLoader.load(getClass().getResource(("sample.fxml")));
                    root.getChildren().setAll(parentContent);

                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        }

        catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void body () throws IOException {

        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("body.fxml"));
        root.getChildren().addAll(pane);

    }

    private void legs () throws IOException {

        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("legs.fxml"));
        root.getChildren().addAll(pane);

    }

    private void biceps () throws IOException {

        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("biceps.fxml"));
        root.getChildren().addAll(pane);

    }







}
