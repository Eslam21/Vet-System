package com.project217ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.project217ui.Controllers.SignInController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignInFrame {

    @FXML
    private Button enterSignBT;

    @FXML
    private Label introLB;

    @FXML
    private Pane mainPane;

    @FXML
    private Label passwordLB;

    @FXML
    private TextField passwordTF;

    @FXML
    private Label signinLB;

    @FXML
    private Label usernameLB;

    @FXML
    private TextField usernameTF;

    @FXML
    private Label messageLB;
    @FXML
    void switchToOptions(ActionEvent event) throws IOException
    {
        if(SignInController.CheckLoginInfo(usernameTF.getText(), passwordTF.getText()))
        {
            Parent root = FXMLLoader.load(getClass().getResource("OptionsFrame.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            System.out.println(usernameTF.getText()+passwordTF.getText());
            messageLB.setText("Incorrect Username or Password");
        }
    }

}
