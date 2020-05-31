package com.application.controllers.editControllers;


import com.application.dao.AttendanceDao;
import com.application.dao.SubjectDao;
import com.application.entities.Attendance;
import com.application.entities.Subject;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EditSubjectController {

    @FXML
    private TextField id;

    @FXML
    private TextField subjectName;

    @FXML
    private TextField teacherName;

    @FXML
    private Button editButton;

    private Table table;

    @FXML
    void initialize() {

        editButton.setOnAction(addEvent -> {

            SubjectDao subjectDao = new SubjectDao();

            Subject subject = subjectDao.findById(Integer.parseInt(id.getText()));

            subject.setSubjectName(subjectName.getText());
            subject.setTeacherName(teacherName.getText());

            subjectDao.update(subject);


            subjectName.clear();
            teacherName.clear();

            table.showSubjectTable();

        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
