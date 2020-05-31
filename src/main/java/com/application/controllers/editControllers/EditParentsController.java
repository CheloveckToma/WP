package com.application.controllers.editControllers;


import com.application.dao.ParentDao;
import com.application.dao.StudentDao;
import com.application.entities.Address;
import com.application.entities.Parent;
import com.application.entities.Student;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EditParentsController {

    @FXML
    private TextField id;

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
    private TextField phoneNumber;

    @FXML
    private TextField childrenNumber;

    @FXML
    private Button editButton;

    @FXML
    private TextField name;

    @FXML
    private TextField parentId;

    private Table table;

    @FXML
    void initialize() {

        editButton.setOnAction(addEvent -> {
            ParentDao parentDao = new ParentDao();
            Parent parent =  parentDao.findById(Integer.parseInt(parentId.getText()));

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
            parentDao.update(parent);

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
