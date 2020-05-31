package com.application.controllers.editControllers;


import com.application.dao.SubjectDao;
import com.application.entities.Subject;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Контроллер для окна редактирования записей о предметах
 */

public class EditSubjectController {

    @FXML
    private TextField id;

    @FXML
    private TextField subjectName;

    @FXML
    private TextField teacherName;

    @FXML
    private Button editButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        editButton.setOnAction(addEvent -> {
            SubjectDao subjectDao = new SubjectDao();

            Subject subject = subjectDao.findById(Integer.parseInt(id.getText()));
            subject.setSubjectName(subjectName.getText());
            subject.setTeacherName(teacherName.getText());

            subjectDao.update(subject);

            displayTable.showSubjectTable();

            clearFields();
        });
    }

    /**
     * Метод чистит поля ввода
     */

    private void clearFields() {
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
