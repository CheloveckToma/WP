package com.application.controllers.addControllers;


import com.application.daoTest.SubjectDao;
import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

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
            Session session = HibernateUtil.getSession();

            SubjectDao subjectDao = new SubjectDao(session);

            Subject subject = new Subject();
            subject.setSubjectName(subjectName.getText());
            subject.setTeacherName(teacherName.getText());

            subjectDao.save(subject);

            session.close();

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
