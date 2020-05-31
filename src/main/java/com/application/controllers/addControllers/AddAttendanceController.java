package com.application.controllers.addControllers;


import com.application.dao.StudentDao;
import com.application.entities.*;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AddAttendanceController {


    @FXML
    private TextField id;

    @FXML
    private TextField date;

    @FXML
    private TextField hours;

    @FXML
    private Button addButton;

    private Table table;

    @FXML
    void initialize() {

        addButton.setOnAction(addEvent -> {
            StudentDao studentDao = new StudentDao();

            Student student = studentDao.findById(Integer.parseInt(id.getText()));

            Attendance attendance = new Attendance();

            String[] attendanceDate = date.getText().split("-");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(attendanceDate[0]), Integer.parseInt(attendanceDate[1]), Integer.parseInt(attendanceDate[2]));
            Date attDate = new Date();
            attDate.setTime(calendar.getTimeInMillis());

            attendance.setDate(attDate);
            attendance.setHours(Integer.parseInt(hours.getText()));

            student.addAttendance(attendance);

            studentDao.update(student);

            date.clear();
            hours.clear();
            id.clear();

            table.showAttendanceTable();

        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
