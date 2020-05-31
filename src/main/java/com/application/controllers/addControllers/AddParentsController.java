package com.application.controllers.addControllers;


import com.application.dao.StudentDao;
import com.application.entities.*;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddParentsController {

    @FXML
    private TextField id;

    @FXML
    private TextField phoneNumber;

    @FXML
    private TextField town;

    @FXML
    private TextField street;

    @FXML
    private TextField houseNumber;

    @FXML
    private TextField flatNumber;

    @FXML
    private TextField workPlace;

    @FXML
    private TextField familyStatus;

    @FXML
    private TextField childrenNumber;

    @FXML
    private Button addButton;

    @FXML
    private TextField name;

    private Table table;

    @FXML
    void initialize() {

        addButton.setOnAction(addEvent -> {

            StudentDao studentDao = new StudentDao();
            Student student = studentDao.findById(Integer.parseInt(id.getText()));

            Parent parent = new Parent();
            parent.setFamilyStatus(familyStatus.getText());
            parent.setNumberChildren(Integer.parseInt(childrenNumber.getText()));
            parent.setParentFullName(name.getText());
            parent.setPhoneNumber(Long.parseLong(phoneNumber.getText()));
            parent.setPlaceWork(workPlace.getText());

            Address address = new Address();
            address.setCity(town.getText());
            address.setStreet(street.getText());
            address.setHouseNumber(Integer.parseInt(houseNumber.getText()));
            address.setFlatNumber(Integer.parseInt(flatNumber.getText()));

            parent.setAddress(address);
            student.addParent(parent);

            studentDao.update(student);

            table.showParentsTable();

            id.clear();
            name.clear();
            phoneNumber.clear();
            town.clear();
            street.clear();
            houseNumber.clear();
            flatNumber.clear();
            workPlace.clear();
            familyStatus.clear();
            childrenNumber.clear();
        });


    }
    public void setTable(Table table) {
        this.table = table;
    }
}
