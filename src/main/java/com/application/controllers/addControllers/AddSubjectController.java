package com.application.controllers.addControllers;


import com.application.dao.SubjectDao;
import com.application.entities.Subject;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Контроллер для окна добавления записей об предметах
 */

public class AddSubjectController {

    @FXML
    private TextField subjectName;

    @FXML
    private TextField teacherName;

    @FXML
    private Button addButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        addButton.setOnAction(addEvent -> {
            SubjectDao subjectDao = new SubjectDao();

            Subject subject = new Subject();
            subject.setSubjectName(subjectName.getText());
            subject.setTeacherName(teacherName.getText());

            subjectDao.save(subject);

            displayTable.showSubjectTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    public void clearFields(){
        subjectName.clear();
        teacherName.clear();
    }

    /**
     * @param displayTable - объект отображения таблицы
     */

    public void setDisplayTable(DisplayTable displayTable) {
        this.displayTable = displayTable;
    }
}
