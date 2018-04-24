package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;

import static sample.Main.*;

/**
 * Created by OurMine on 08.04.2018.
 */
public class LegsController {


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
    private Text legs_ex_name;

    @FXML
    private Text legs_ex_num;



    @FXML
    void action_next(ActionEvent event) throws IOException {


        legs_progress++;

        if (legs_index > 5) {
            startMain();
        }
        else
            legs_index++;

        legs_ex_name.setText(legs_ex[legs_index]);
        legs_ex_num.setText("x" + ((legs_index + 5) * 5));
        legs_ex_num.setLayoutX(490 + (legs_ex_name.getText().length() - 15));

        Controller.preferences.put("legs_progress", (float) (legs_progress * 0.1428571428571429) + "");


        switch (legs_index) {
            case 0:
                c1.setFill(Paint.valueOf("#0e9654"));
                img_ex1.setImage(new Image("/image/ex/LEGS_" + legs_index + "_1.jpg"));
                img_ex2.setImage(new Image("/image/ex/LEGS_" + legs_index + "_2.jpg"));
                break;

            case 1:
                c2.setFill(Paint.valueOf("#0e9654"));
                img_ex1.setImage(new Image("/image/ex/LEGS_" + legs_index + "_1.jpg"));
                img_ex2.setImage(new Image("/image/ex/LEGS_" + legs_index + "_2.jpg"));
                break;

            case 2:
                c3.setFill(Paint.valueOf("#0e9654"));
                img_ex1.setImage(new Image("/image/ex/LEGS_" + legs_index + "_1.jpg"));
                img_ex2.setImage(new Image("/image/ex/LEGS_" + legs_index + "_2.jpg"));
                break;

            case 3:
                c4.setFill(Paint.valueOf("#0e9654"));
                img_ex1.setImage(new Image("/image/ex/LEGS_" + legs_index + "_1.jpg"));
                img_ex2.setImage(new Image("/image/ex/LEGS_" + legs_index + "_2.jpg"));
                break;

            case 4:
                c5.setFill(Paint.valueOf("#0e9654"));
                img_ex1.setImage(new Image("/image/ex/LEGS_" + legs_index + "_1.jpg"));
                img_ex2.setImage(new Image("/image/ex/LEGS_" + legs_index + "_2.jpg"));
                break;

            case 5:
                c6.setFill(Paint.valueOf("#0e9654"));
                img_ex1.setImage(new Image("/image/ex/LEGS_" + legs_index + "_1.jpg"));
                img_ex2.setImage(new Image("/image/ex/LEGS_" + legs_index + "_2.jpg"));
                break;

            case 6:
                btn_start.setText("FINISH");
                c7.setFill(Paint.valueOf("#0e9654"));
                img_ex1.setImage(new Image("/image/ex/LEGS_" + legs_index + "_1.jpg"));
                img_ex2.setImage(new Image("/image/ex/LEGS_" + legs_index + "_2.jpg"));
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


        for (int i = 0; i <= legs_index; i++) {
            legs_ex_name.setText(legs_ex[i]);
            legs_ex_num.setText("x" + ((i + 5) * 5));
            legs_ex_num.setLayoutX(490 + (legs_ex_name.getText().length() - 15));


            switch (i) {

                case 0:
                    c1.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/LEGS_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/LEGS_" + i + "_2.jpg"));
                    break;

                case 1:
                    c2.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/LEGS_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/LEGS_" + i + "_2.jpg"));
                    break;

                case 2:
                    c3.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/LEGS_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/LEGS_" + i + "_2.jpg"));
                    break;

                case 3:
                    c4.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/LEGS_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/LEGS_" + i + "_2.jpg"));
                    break;

                case 4:
                    c5.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/LEGS_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/LEGS_" + i + "_2.jpg"));
                    break;

                case 5:
                    c6.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/LEGS_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/LEGS_" + i + "_2.jpg"));
                    break;

                case 6:
                    btn_start.setText("FINISH");
                    c7.setFill(Paint.valueOf("#0e9654"));
                    img_ex1.setImage(new Image("/image/ex/LEGS_" + i + "_1.jpg"));
                    img_ex2.setImage(new Image("/image/ex/LEGS_" + i + "_2.jpg"));
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
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}

