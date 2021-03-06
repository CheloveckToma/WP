package com.application.controllers.addControllers;


import com.application.daoTest.StudentDao;
import com.application.date.Date;
import com.application.entities.*;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * Контроллер для окна добавления записей о посещаемости
 */

public class AddAttendanceController {

    @FXML
    private TextField id;

    @FXML
    private TextField date;

    @FXML
    private TextField hours;

    @FXML
    private Button addButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        addButton.setOnAction(addEvent -> {
            Session session = HibernateUtil.getSession();

            StudentDao studentDao = new StudentDao(session);

            Student student = studentDao.findById(Integer.parseInt(id.getText()));

            Attendance attendance = new Attendance();
            attendance.setDate(Date.createObjectDate(date.getText()));
            attendance.setHours(Integer.parseInt(hours.getText()));

            student.addAttendance(attendance);

            studentDao.update(student);

            session.close();

            displayTable.showAttendanceTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
        date.clear();
        hours.clear();
        id.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
