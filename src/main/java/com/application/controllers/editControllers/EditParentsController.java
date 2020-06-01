package com.application.controllers.editControllers;


import com.application.daoTest.ParentDao;
import com.application.entities.Address;
import com.application.entities.Parent;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * Контроллер для окна редактирования записей об родителях
 */

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

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(addEvent -> {
            Session session  = HibernateUtil.getSession();

            ParentDao parentDao = new ParentDao(session);

            Parent parent = parentDao.findById(Integer.parseInt(parentId.getText()));
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

            session.close();

            displayTable.showParentsTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
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
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
