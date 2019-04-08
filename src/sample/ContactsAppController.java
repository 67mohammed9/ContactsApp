package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.Comparator;


public class ContactsAppController {
    @FXML
    private GridPane gridPane;
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
    private Button addButton;
    @FXML
    private Button saveButton;

    @FXML
    private TextField emailTextField;



    public final ObservableList<Contacts> contacts =
            FXCollections.observableArrayList();

    class sortByLast implements Comparator<Contacts> {
        public int compare(Contacts i1, Contacts i2) {
            return i1.getLast().compareTo(i2.getLast());
        }
    }
    public void initialize(){
        contacts.add(new Contacts("Mohammed","Bhuiyan","(917)462-7397",
                "mohammedbhuiyan73@gmail.com"));
        contacts.add(new Contacts("Varun","Chenna","(347)414-1917",
                "varun@gmail.com"));
        contacts.add(new Contacts("Kazi","siam","(347)863-9999",
                "kazi@gmail.com"));
        contacts.add(new Contacts("James","Apples","(347)863-9999",
                "kazi@gmail.com"));

        contacts.add(new Contacts("James","Dog","(347)863-9999",
                "kazi@gmail.com"));

        sortByLast lastNameSort = new sortByLast();
        Collections.sort(contacts, lastNameSort);
        contactsListView.setItems(contacts);


        contactsListView.getSelectionModel().selectedItemProperty().
                addListener(
                        new ChangeListener<Contacts>() {
                            @Override
                            public void changed(ObservableValue<? extends Contacts> ov,
                                                Contacts oldValue, Contacts newValue) {
                                firstNameTextField.setText(newValue.getFirst());
                                lastNameTextField.setText(newValue.getLast());
                                phoneNumberTextField.setText(newValue.getPhoneNumber());
                                emailTextField.setText(newValue.getEmail());
                            }
                        }
                );
    }


    public void onEditButtonPressed(javafx.event.ActionEvent actionEvent) {
        final int selectedIdx = contactsListView.getSelectionModel().getSelectedIndex();
        if(selectedIdx != -1)
        {
            Contacts editsMade = contactsListView.getSelectionModel().getSelectedItem();
            editsMade.setFirst(firstNameTextField.getText());
            editsMade.setLast(lastNameTextField.getText());
            editsMade.setEmail(emailTextField.getText());
            editsMade.setPhoneNumber(phoneNumberTextField.getText());
            contacts.remove(selectedIdx);
            contacts.add(editsMade);
            sortByLast lastNameSort = new sortByLast();
            Collections.sort(contacts, lastNameSort);
            contactsListView.setItems(contacts);
        }
    }

    public void onDeleteButtonPressed(javafx.event.ActionEvent actionEvent) {

        final int selectedIdx = contactsListView.getSelectionModel().getSelectedIndex();
        if(selectedIdx != -1)
        {
            Contacts itemToRemove = contactsListView.getSelectionModel().getSelectedItem();

            final int newSelectedIdx =
                    (selectedIdx == contactsListView.getItems().size() - 1)
                            ? selectedIdx - 1
                            : selectedIdx;
            contactsListView.getItems().remove(selectedIdx);
            contactsListView.getSelectionModel().select(newSelectedIdx);
            //removes the player for the array
            System.out.println("selectIdx: " + selectedIdx);
            System.out.println("item: " + itemToRemove);
           // contactsListView.remove(selectedIdx);

        }
    }
    public void onAddButtonPressed(javafx.event.ActionEvent actionEvent) {
        firstNameTextField.clear();
        lastNameTextField.clear();
        phoneNumberTextField.clear();
        emailTextField.clear();
        addButton.setDisable(true);
        saveButton.setDisable(false);
    }
    public void onSaveButtonPressed(javafx.event.ActionEvent actionEvent){
        Contacts newContact = new Contacts(" "," "," "," ");
        newContact.setFirst(firstNameTextField.getText());
        newContact.setLast(lastNameTextField.getText());
        newContact.setPhoneNumber(phoneNumberTextField.getText());
        newContact.setEmail(emailTextField.getText());
        if(newContact.getFirst() != " " && newContact.getLast() != " " && newContact.getPhoneNumber() != " " && newContact.getEmail() != " "){
            contacts.add(newContact);
            contactsListView.setItems(contacts); 
        }

        addButton.setDisable(false);
        saveButton.setDisable(true);
    }

}