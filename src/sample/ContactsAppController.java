package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import org.w3c.dom.Text;

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

    public final ObservableList<Contacts> contacts =
            FXCollections.observableArrayList();

    public void initialize(){
        contacts.add(new Contacts("Mohammed","Bhuiyan","(917)462-7397",
                "mohammedbhuiyan73@gmail.com"));
        contacts.add(new Contacts("Varun","Chenna","(347)414-1917",
                "varun@gmail.com"));
        contacts.add(new Contacts("Kazi","siam","(347)863-9999",
                "kazi@gmail.com"));
        contactsListView.setItems(contacts);


        contactsListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Contacts>() {
                            @Override
                            public void changed(ObservableValue<? extends Contacts> ov,
                                                Contacts oldValue, Contacts newValue) {
                                firstNameTextField.setText(newValue.getFirst());
                                lastNameTextField.setText(newValue.getLast());
                            }
                        }
                );
    }


    public void onEditButtonPressed(javafx.event.ActionEvent actionEvent) {
    }

    public void onDeleteButtonPressed(javafx.event.ActionEvent actionEvent) {
    }
}