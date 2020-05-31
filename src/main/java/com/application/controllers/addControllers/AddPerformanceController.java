package com.application.controllers.addControllers;


import com.application.dao.StudentDao;
import com.application.dao.SubjectDao;
import com.application.entities.*;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Контроллер для окна добавления записей об успеваемости
 */

public class AddPerformanceController {

    @FXML
    private TextField id;

    @FXML
    private TextField mark;

    @FXML
    private TextField subjectId;

    @FXML
    private Button addButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        addButton.setOnAction(addEvent -> {
            StudentDao studentDao = new StudentDao();

            Student student = studentDao.findById(Integer.parseInt(id.getText()));

            Performance performance = new Performance();
            performance.setMark(Integer.parseInt(mark.getText()));
            performance.setStudent(student);

            SubjectDao subjectDao = new SubjectDao();

            Subject subject = subjectDao.findById(Integer.parseInt(subjectId.getText()));

            subject.addPerformance(performance);

            student.addPerformance(performance);

            studentDao.update(student);

            displayTable.showPerformanceTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
        id.clear();
        mark.clear();
        subjectId.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
