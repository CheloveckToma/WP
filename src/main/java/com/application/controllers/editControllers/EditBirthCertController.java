package com.application.controllers.editControllers;


import com.application.dao.BirthCertificateDao;
import com.application.dao.StudentDao;
import com.application.dao.SubjectDao;
import com.application.entities.BirthCertificate;
import com.application.entities.Performance;
import com.application.entities.Student;
import com.application.entities.Subject;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EditBirthCertController {

    @FXML
    private TextField id;

    @FXML
    private TextField issuedDate;

    @FXML
    private TextField issuedBy;

    @FXML
    private TextField number;

    @FXML
    private TextField series;

    @FXML
    private Button editButton;

    private Table table;

    @FXML
    void initialize() {

        editButton.setOnAction(addEvent -> {

            BirthCertificateDao birthCertificateDao = new BirthCertificateDao();

            BirthCertificate birthCertificate = birthCertificateDao.findById(Integer.parseInt(id.getText()));


            String[] issuedDateArray = issuedDate.getText().split("-");

            Calendar calendar = new GregorianCalendar(Integer.parseInt(issuedDateArray[0]), Integer.parseInt(issuedDateArray[1]), Integer.parseInt(issuedDateArray[2]));
            Date date = new Date();
            date.setTime(calendar.getTimeInMillis());


            birthCertificate.setDateIssue(date);
            birthCertificate.setIssuedBy(issuedBy.getText());
            birthCertificate.setNumber(Integer.parseInt(number.getText()));
            birthCertificate.setSeries(Integer.parseInt(series.getText()));

            birthCertificateDao.update(birthCertificate);

            id.clear();
            issuedDate.clear();
            issuedBy.clear();
            number.clear();
            series.clear();

            table.showBirthCertificateTable();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
