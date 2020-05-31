package com.application.controllers.editControllers;


import com.application.dao.AttendanceDao;
import com.application.dao.StudentDao;
import com.application.entities.Attendance;
import com.application.entities.Student;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EditAttendanceController {


    @FXML
    private TextField attId;

    @FXML
    private TextField stId;

    @FXML
    private TextField date;

    @FXML
    private TextField hours;

    @FXML
    private Button editButton;

    private Table table;
    @FXML
    void initialize() {

        editButton.setOnAction(addEvent -> {

            AttendanceDao attendanceDao = new AttendanceDao();
            Attendance attendance = attendanceDao.findById(Integer.parseInt(attId.getText()));

            String[] attendanceDate = date.getText().split("-");
            Calendar calendar = new GregorianCalendar(Integer.parseInt(attendanceDate[0]), Integer.parseInt(attendanceDate[1]), Integer.parseInt(attendanceDate[2]));
            Date attDate = new Date();
            attDate.setTime(calendar.getTimeInMillis());

            attendance.setDate(attDate);
            attendance.setHours(Integer.parseInt(hours.getText()));

            attendanceDao.update(attendance);

            table.showAttendanceTable();

            date.clear();
            hours.clear();
            stId.clear();
            attId.clear();

        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
