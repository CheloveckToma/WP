package com.application.controllers.delControllers;


import com.application.dao.AttendanceDao;
import com.application.dao.StudentDao;
import com.application.entities.Attendance;
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

public class DelAttendanceController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;

    private Table table;

    @FXML
    void initialize() {

        delButton.setOnAction(addEvent -> {
            AttendanceDao attendanceDao = new AttendanceDao();
            Attendance attendance = attendanceDao.findById(Integer.parseInt(id.getText()));
            attendanceDao.delete(attendance);
            table.showAttendanceTable();
        });


    }
    public void setTable(Table table) {
        this.table = table;
    }
}
