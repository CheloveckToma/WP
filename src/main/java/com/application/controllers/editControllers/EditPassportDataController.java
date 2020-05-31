package com.application.controllers.editControllers;


import com.application.dao.PassportDataDao;
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

    private Table table;

    @FXML
    void initialize() {

        editButton.setOnAction(addEvent -> {

            PassportDataDao passportDataDao = new PassportDataDao();
            PassportData passportData = passportDataDao.findById(Integer.parseInt(passportId.getText()));

            String[] birthDateArray = birthDate.getText().split("-");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(birthDateArray[0]), Integer.parseInt(birthDateArray[1]), Integer.parseInt(birthDateArray[2]));
            Date date = new Date();
            date.setTime(calendar.getTimeInMillis());

            passportData.setBirthDate(date);

            String[] issuedDateArray = issuedDate.getText().split("-");

            calendar = new GregorianCalendar(Integer.parseInt(issuedDateArray[0]), Integer.parseInt(issuedDateArray[1]), Integer.parseInt(issuedDateArray[2]));
            date = new Date();
            date.setTime(calendar.getTimeInMillis());

            passportData.setDateIssue(date);

            passportData.setDepartmentCode(Integer.parseInt(depCode.getText()));
            passportData.setIssuedBy(issuedPassportBy.getText());
            passportData.setNumber(Integer.parseInt(passportNumber.getText()));
            passportData.setSeries(Integer.parseInt(passportSeries.getText()));
            passportData.setPlaceResidence(placeResidence.getText());
            passportData.setStudentFullName(name.getText());
            passportData.setSnilsNumber(Integer.parseInt(snilsNumber.getText()));
            passportData.setTin(Integer.parseInt(tinNumber.getText()));

            passportDataDao.update(passportData);

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

            table.showPassportDataTable();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
