package com.application.controllers.editControllers;


import com.application.dao.AttendanceDao;
import com.application.date.Date;
import com.application.entities.Attendance;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Контроллер для окна редактирования записей о посещаемости
 */

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

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(addEvent -> {
            AttendanceDao attendanceDao = new AttendanceDao();
            Attendance attendance = attendanceDao.findById(Integer.parseInt(attId.getText()));
            attendance.setDate(Date.createObjectDate(date.getText()));
            attendance.setHours(Integer.parseInt(hours.getText()));

            attendanceDao.update(attendance);

            displayTable.showAttendanceTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields(){
        date.clear();
        hours.clear();
        stId.clear();
        attId.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
