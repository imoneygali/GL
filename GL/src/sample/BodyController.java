package sample;

import com.jfoenix.controls.JFXButton;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

import static sample.Main.body_ex;
import static sample.Main.body_index;
import static sample.Main.body_progress;

/**
 * Created by OurMine on 08.04.2018.
 */
public class BodyController {


    @FXML
    private AnchorPane rootPane;

    @FXML
    private Circle c1;

    @FXML
    private Circle c2;

    @FXML
    private Circle c3;

    @FXML
    private Circle c4;

    @FXML
    private Circle c5;

    @FXML
    private Circle c6;

    @FXML
    private Circle c7;

    @FXML
    private ImageView img_ex1;

    @FXML
    private ImageView img_ex2;



    @FXML
    private ImageView img_home;

    @FXML
    private JFXButton btn_start;

    @FXML
    private Text body_ex_name;

    @FXML
    private Text body_ex_num;

    @FXML
    private Label timer;

    private final Integer starttime=30;
    private Integer seconds= starttime;

    @FXML
    void action_next(ActionEvent event) throws IOException {

        body_progress++;

        if (body_index > 5) {
            startMain();
        }
        else
            body_index++;
            System.out.println(body_index);

            body_ex_name.setText(body_ex[body_index]);
            body_ex_num.setText("x" + ((body_index + 5) * 5));
            body_ex_num.setLayoutX(490 + (body_ex_name.getText().length() - 15));

        Controller.preferences.put("body_progress", (float) (body_progress * 0.1428571428571429) + "");

        timer.setVisible(true);

        switch (body_index) {
                case 0:
                    c1.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + body_index + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + body_index + "_2.jpg"));
                    seconds = 31;
                    break;

                case 1:
                    c2.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + body_index + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + body_index + "_2.jpg"));
                    seconds = 31;
                    break;

                case 2:
                    c3.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + body_index + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + body_index + "_2.jpg"));
                    seconds = 31;
                    break;

                case 3:
                    c4.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + body_index + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + body_index + "_2.jpg"));
                    seconds = 31;
                    break;

                case 4:
                    c5.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + body_index + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + body_index + "_2.jpg"));
                    seconds = 31;
                    break;

                case 5:
                    c6.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + body_index + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + body_index + "_2.jpg"));
                    seconds = 31;
                    break;

                case 6:
                    btn_start.setText("FINISH");
                    c7.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + body_index + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + body_index + "_2.jpg"));
                    seconds = 31;
                    break;

                default:
                    break;
            }
    }



    private void startMain () throws IOException {

        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("sample.fxml"));
        rootPane.getChildren().addAll(pane);
    }

    @FXML
    void initialize() throws IOException {
        timer.setVisible(false);

        doTime();

        for (int i = 0; i <= body_index; i++) {
            body_ex_name.setText(body_ex[i]);
            body_ex_num.setText("x" + ((i + 5) * 5));
            body_ex_num.setLayoutX(490 + (body_ex_name.getText().length() - 15));


            switch (i) {

                case 0:
                    c1.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + i + "_2.jpg"));
                    break;

                case 1:
                    c2.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + i + "_2.jpg"));
                    break;

                case 2:
                    c3.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + i + "_2.jpg"));
                    break;

                case 3:
                    c4.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + i + "_2.jpg"));
                    break;

                case 4:
                    c5.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + i + "_2.jpg"));
                    break;

                case 5:
                    c6.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + i + "_2.jpg"));
                    break;

                case 6:
                    btn_start.setText("FINISH");
                    c7.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/BODY_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/BODY_" + i + "_2.jpg"));
                    break;

                default:
                    break;
            }
        }

        img_home.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                try {
                    startMain();
                    System.out.println(body_index);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void doTime() {
        Timeline time= new Timeline();


        KeyFrame frame= new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {


                seconds--;
                timer.setText(seconds.toString());
                if(seconds<=0){
                    time.stop();
                    body_index++;
                }


            }


        });

        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(frame);
        if(time!=null){
            time.stop();
        }
        time.play();


    }

}

