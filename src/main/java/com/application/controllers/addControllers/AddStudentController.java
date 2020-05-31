package com.application.controllers.addControllers;


import com.application.dao.StudentDao;
import com.application.entities.Address;
import com.application.entities.BirthCertificate;
import com.application.entities.PassportData;
import com.application.entities.Student;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddStudentController {

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
    private TextField snilsNumber;

    @FXML
    private TextField tinNumber;

    @FXML
    private TextField birthDate;

    @FXML
    private Button addButton;

    private Table table;

    @FXML
    void initialize() {

        addButton.setOnAction(addEvent -> {
            StudentDao studentDao = new StudentDao();
            Student student = new Student();

            String[] birhtDate = birthDate.getText().split("-");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(birhtDate[0]), Integer.parseInt(birhtDate[1]), Integer.parseInt(birhtDate[2]));
            Date date = new Date();
            date.setTime(calendar.getTimeInMillis());

            student.setStudentFullName(name.getText());
            student.setBirthDate(date);
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
            birthCertificate.setDateIssue(date);

            student.setBirthCertificate(birthCertificate);

            PassportData passport = new PassportData();
            passport.setStudentFullName(name.getText());
            passport.setBirthDate(date);
            passport.setPlaceResidence(placeResidence.getText());
            passport.setSeries(Integer.parseInt(passportSeries.getText()));
            passport.setNumber(Integer.parseInt(passportNumber.getText()));
            passport.setIssuedBy(issuedPassportBy.getText());

            String[] passportDate = issuedDate.getText().split("-");

            calendar = new GregorianCalendar(Integer.parseInt(passportDate[0]), Integer.parseInt(passportDate[1]), Integer.parseInt(passportDate[2]));
            date = new Date();
            date.setTime(calendar.getTimeInMillis());

            passport.setDateIssue(date);
            passport.setDepartmentCode(Integer.parseInt(depCode.getText()));
            passport.setTin(Integer.parseInt(tinNumber.getText()));
            passport.setSnilsNumber(Integer.parseInt(snilsNumber.getText()));

            student.setPassportData(passport);


            studentDao.save(student);

            table.showStudentTable();

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
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
