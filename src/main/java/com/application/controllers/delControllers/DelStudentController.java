package com.application.controllers.delControllers;


import com.application.dao.StudentDao;
import com.application.entities.Student;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Контроллер для окна удаления записей о студентах
 */

public class DelStudentController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        delButton.setOnAction(addEvent -> {
            StudentDao studentDao = new StudentDao();
            Student student = studentDao.findById(Integer.parseInt(id.getText()));
            studentDao.delete(student);

            displayTable.showStudentTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
        id.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
