package com.example.dbconnection;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private VBox contentVBox;
    @FXML
    private BorderPane borderPane;

    @FXML
    private AnchorPane anchorPaneTitle, anchorPaneHead, anchorPaneHeader, anchorPaneBtns, anchorPaneContentSU, anchorPaneContentSI;

    @FXML
    private Label lblTitle, lblHeader, lblNumber, lblLName, lblCourse, lblPass, lblFName, lblSINumber, lblPassSi, lblForgor;

    @FXML
    private TextField txtCourse, txtLName, txtNumber, txtFname, txtSINumber;

    @FXML
    private Button btnToggle, btnExit, btnFinish, btnSI;

    @FXML
    private PasswordField passPass,passSI;
    private boolean isSignInMode = true;


    public void initialize() {
        anchorPaneHeader.getStyleClass().add("animated-pane");
        anchorPaneHeader.toFront();
        anchorPaneContentSI.toFront();
        anchorPaneContentSU.toBack();
        anchorPaneContentSU.setVisible(false);
        TranslateTransition dropDownTransition = new TranslateTransition(Duration.seconds(1.5), borderPane);
        dropDownTransition.setFromY(-400);
        dropDownTransition.setToY(0);
        dropDownTransition.play();
    }

    @FXML
    private void switchState() {
        if (isSignInMode) {
            anchorPaneContentSI.toBack();
            anchorPaneContentSU.toFront();
            anchorPaneHeader.toFront();
            anchorPaneContentSU.setVisible(true);
            isSignInMode = false;
            btnToggle.setDisable(true);
            btnToggle.setText("New here?");
            lblHeader.setText("Register");

            anchorPaneHeader.getStyleClass().remove("collapsed-pane");
            anchorPaneHeader.getStyleClass().add("expanded-pane");

            TranslateTransition translate = new TranslateTransition(Duration.seconds(1.0), anchorPaneHeader);
            translate.setByX(-borderPane.getWidth() + anchorPaneHeader.getWidth());
            translate.play();
            translate.setOnFinished(event -> {
                anchorPaneContentSI.setVisible(false);
                btnToggle.setDisable(false);
            });


        } else {
            anchorPaneContentSU.toBack();
            anchorPaneContentSI.toFront();
            anchorPaneHeader.toFront();
            anchorPaneContentSI.setVisible(true);
            isSignInMode = true;
            btnToggle.setDisable(true);
            btnToggle.setText("!New here?");
            lblHeader.setText("Log In");

            TranslateTransition translate = new TranslateTransition(Duration.seconds(1.0), anchorPaneHeader);
            translate.setByX(borderPane.getWidth() - anchorPaneHeader.getWidth());
            translate.play();
            translate.setOnFinished(event -> {
                anchorPaneContentSU.setVisible(false);
                btnToggle.setDisable(false);
            });




        }
    }

    @FXML
    private void exitAnimation() {
        if(isSignInMode){
            TranslateTransition dropDownTransition = new TranslateTransition(Duration.seconds(1.5), borderPane);
            dropDownTransition.setFromY(0);
            dropDownTransition.setToY(1000);
            dropDownTransition.play();
            dropDownTransition.setOnFinished(event -> {
                borderPane.setVisible(false);
                borderPane.toBack();
            });
        }
        else{

        }
    }
}