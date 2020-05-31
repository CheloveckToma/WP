package com.application.controllers.editControllers;


import com.application.dao.PerformanceDao;
import com.application.dao.SubjectDao;
import com.application.entities.Performance;
import com.application.entities.Subject;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Контроллер для окна редактирования записей об успеваемости
 */

public class EditPerformanceController {

    @FXML
    private TextField perfId;

    @FXML
    private TextField id;

    @FXML
    private TextField mark;

    @FXML
    private TextField subjectId;

    @FXML
    private Button editButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(addEvent -> {
            PerformanceDao performanceDao = new PerformanceDao();

            Performance performance = performanceDao.findById(Integer.parseInt(perfId.getText()));
            performance.setMark(Integer.parseInt(mark.getText()));

            SubjectDao subjectDao = new SubjectDao();

            Subject subject = subjectDao.findById(Integer.parseInt(subjectId.getText()));

            performance.setSubject(subject);

            subjectDao.closeSession();

            performanceDao.update(performance);

            displayTable.showPerformanceTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
        perfId.clear();
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
