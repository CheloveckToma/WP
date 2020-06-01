package com.application.controllers.addControllers;


import com.application.daoTest.StudentDao;
import com.application.entities.*;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * Контроллер для окна добавления записей о родителях
 */

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

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        addButton.setOnAction(addEvent -> {
            Session session = HibernateUtil.getSession();

            StudentDao studentDao = new StudentDao(session);
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

            session.close();

            displayTable.showParentsTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields(){
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
