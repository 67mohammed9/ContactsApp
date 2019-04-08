package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.awt.event.ActionEvent;
import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class ContactsAppController {
    @FXML
    private Button uploadButton;
    @FXML
    private ImageView imageView;
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
        addButton.setDisable(false);
        saveButton.setDisable(true);
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
        }
        addButton.setDisable(false);
        saveButton.setDisable(true);
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
        Contacts newContact = new Contacts(null,null,null,null);
        newContact.setFirst(firstNameTextField.getText());
        newContact.setLast(lastNameTextField.getText());
        newContact.setPhoneNumber(phoneNumberTextField.getText());
        newContact.setEmail(emailTextField.getText());
        Node v = gridPane.getChildren().get(12);
        Node w = gridPane.getChildren().get(13);
        Node x = gridPane.getChildren().get(14);
        Node y = gridPane.getChildren().get(15);
        Node z = gridPane.getChildren().get(16);
        if((newContact.getFirst().isEmpty()==false  || newContact.getLast().isEmpty() == false) &&
                (newContact.getPhoneNumber().isEmpty() == false || newContact.getEmail().isEmpty() == false)){
            contacts.add(newContact);
            sortByLast lastNameSort = new sortByLast();
            Collections.sort(contacts, lastNameSort);
            v.setVisible(false);
            w.setVisible(false);
            x.setVisible(false);
            y.setVisible(false);
            z.setVisible(false);
        }
        else{
            if((newContact.getFirst().isEmpty()==true  || newContact.getLast().isEmpty() == true )&&
                    (newContact.getPhoneNumber().isEmpty() == true || newContact.getEmail().isEmpty() == true)){
                v.setVisible(true);
                if(newContact.getFirst().isEmpty()){
                    w.setVisible(true);
                }
                if(newContact.getLast().isEmpty()){
                    x.setVisible(true);
                }
                if(newContact.getPhoneNumber().isEmpty()){
                    y.setVisible(true);
                }
                if(newContact.getEmail().isEmpty()){
                    z.setVisible(true);
                }
            }
        }
        addButton.setDisable(false);
        saveButton.setDisable(true);
    }


    public void onUploadButtonPressed(javafx.event.ActionEvent actionEvent){
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        String s = null;
        if(selectedFile != null)
        {
             s = selectedFile.getPath();
             Image image = new Image("file:///"+s);
             imageView.setImage(image);

        }
    }

}