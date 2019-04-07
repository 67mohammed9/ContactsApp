package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class ContactsAppController {

    @FXML
    private ListView<Contacts> contactsListView;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField phoneNumberTextField;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button onAddButtonPressed;

    @FXML
    void onDeleteButtonPressed(ActionEvent event) {

    }

    @FXML
    void onEditButtonPressed(ActionEvent event) {

    }

    public void onEditButtonPressed(javafx.event.ActionEvent actionEvent) {
    }

    public void onDeleteButtonPressed(javafx.event.ActionEvent actionEvent) {
    }
}