package com.application.controllers.editControllers;


import com.application.daoTest.PassportDataDao;
import com.application.date.Date;
import com.application.entities.PassportData;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * Контроллер для окна редактирования записей паспортных данных
 */

public class EditPassportDataController {
    @FXML
    private TextField name;

    @FXML
    private TextField issuedDate;

    @FXML
    private TextField issuedPassportBy;

    @FXML
    private TextField depCode;

    @FXML
    private TextField passportNumber;

    @FXML
    private TextField passportSeries;

    @FXML
    private TextField placeResidence;

    @FXML
    private TextField birthDate;

    @FXML
    private TextField snilsNumber;

    @FXML
    private TextField tinNumber;

    @FXML
    private Button editButton;

    @FXML
    private TextField passportId;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(addEvent -> {
            Session session = HibernateUtil.getSession();

            PassportDataDao passportDataDao = new PassportDataDao(session);

            PassportData passportData = passportDataDao.findById(Integer.parseInt(passportId.getText()));
            passportData.setBirthDate(Date.createObjectDate(birthDate.getText()));
            passportData.setDateIssue(Date.createObjectDate(issuedDate.getText()));
            passportData.setDepartmentCode(Integer.parseInt(depCode.getText()));
            passportData.setIssuedBy(issuedPassportBy.getText());
            passportData.setNumber(Integer.parseInt(passportNumber.getText()));
            passportData.setSeries(Integer.parseInt(passportSeries.getText()));
            passportData.setPlaceResidence(placeResidence.getText());
            passportData.setStudentFullName(name.getText());
            passportData.setSnilsNumber(Integer.parseInt(snilsNumber.getText()));
            passportData.setTin(Integer.parseInt(tinNumber.getText()));

            passportDataDao.update(passportData);

            session.close();

            displayTable.showPassportDataTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
        name.clear();
        passportId.clear();
        birthDate.clear();
        issuedDate.clear();
        issuedPassportBy.clear();
        depCode.clear();
        passportNumber.clear();
        passportSeries.clear();
        placeResidence.clear();
        snilsNumber.clear();
        tinNumber.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
