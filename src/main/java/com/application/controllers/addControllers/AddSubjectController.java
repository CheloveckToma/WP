package com.application.controllers.addControllers;


import com.application.dao.StudentDao;
import com.application.dao.SubjectDao;
import com.application.entities.Attendance;
import com.application.entities.Student;
import com.application.entities.Subject;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddSubjectController {

    @FXML
    private TextField subjectName;

    @FXML
    private TextField teacherName;

    @FXML
    private Button addButton;

    private Table table;

    @FXML
    void initialize() {

        addButton.setOnAction(addEvent -> {
            SubjectDao subjectDao = new SubjectDao();

            Subject subject = new Subject();

            subject.setSubjectName(subjectName.getText());
            subject.setTeacherName(teacherName.getText());

            subjectDao.save(subject);


            subjectName.clear();
            teacherName.clear();

            table.showSubjectTable();

        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
