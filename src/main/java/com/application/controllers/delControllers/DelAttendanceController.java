package com.application.controllers.delControllers;


import com.application.dao.AttendanceDao;
import com.application.entities.Attendance;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *  Контроллер для окна удаления записей о посещаемости
 */

public class DelAttendanceController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        delButton.setOnAction(addEvent -> {
            AttendanceDao attendanceDao = new AttendanceDao();
            Attendance attendance = attendanceDao.findById(Integer.parseInt(id.getText()));
            attendanceDao.delete(attendance);

            displayTable.showAttendanceTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields(){
        id.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
