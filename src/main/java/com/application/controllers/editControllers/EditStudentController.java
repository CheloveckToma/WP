package com.application.controllers.editControllers;


import com.application.daoTest.StudentDao;
import com.application.date.Date;
import com.application.entities.Address;
import com.application.entities.BirthCertificate;
import com.application.entities.PassportData;
import com.application.entities.Student;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * Контроллер для окна редактирования записей о студентах
 */

public class EditStudentController {

    @FXML
    private TextField id;

    @FXML
    private TextField name;

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
    private TextField issuedBirthCertBy;

    @FXML
    private TextField birthCertNumber;

    @FXML
    private TextField birthCertSeries;

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

    private Session session;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(addEvent -> {
            Session session = HibernateUtil.getSession();

            StudentDao studentDao = new StudentDao(session);

            Student student = studentDao.findById(Integer.parseInt(id.getText()));
            student.setStudentFullName(name.getText());
            student.setBirthDate(Date.createObjectDate(birthDate.getText()));
            student.setPhoneNumber(Long.parseLong(phoneNumber.getText()));

            Address address = new Address();
            address.setCity(town.getText());
            address.setStreet(street.getText());
            address.setHouseNumber(Integer.parseInt(houseNumber.getText()));
            address.setFlatNumber(Integer.parseInt(flatNumber.getText()));

            student.setAddress(address);

            BirthCertificate birthCertificate = new BirthCertificate();
            birthCertificate.setSeries(Integer.parseInt(birthCertSeries.getText()));
            birthCertificate.setNumber(Integer.parseInt(birthCertNumber.getText()));
            birthCertificate.setIssuedBy(issuedBirthCertBy.getText());
            birthCertificate.setDateIssue(Date.createObjectDate(issuedDate.getText()));

            student.setBirthCertificate(birthCertificate);

            PassportData passport = new PassportData();
            passport.setStudentFullName(name.getText());
            passport.setBirthDate(Date.createObjectDate(birthDate.getText()));
            passport.setPlaceResidence(placeResidence.getText());
            passport.setSeries(Integer.parseInt(passportSeries.getText()));
            passport.setNumber(Integer.parseInt(passportNumber.getText()));
            passport.setIssuedBy(issuedPassportBy.getText());
            passport.setDateIssue(Date.createObjectDate(issuedDate.getText()));
            passport.setDepartmentCode(Integer.parseInt(depCode.getText()));
            passport.setTin(Integer.parseInt(tinNumber.getText()));
            passport.setSnilsNumber(Integer.parseInt(snilsNumber.getText()));

            student.setPassportData(passport);

            studentDao.save(student);

            session.close();

            displayTable.showStudentTable();

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
        issuedBirthCertBy.clear();
        birthCertNumber.clear();
        birthCertSeries.clear();
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
