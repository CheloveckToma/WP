package com.application.controllers.editControllers;


import com.application.daoTest.PerformanceDao;
import com.application.daoTest.SubjectDao;
import com.application.entities.Performance;
import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

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
            Session session = HibernateUtil.getSession();

            PerformanceDao performanceDao = new PerformanceDao(session);

            Performance performance = performanceDao.findById(Integer.parseInt(perfId.getText()));
            performance.setMark(Integer.parseInt(mark.getText()));

            SubjectDao subjectDao = new SubjectDao(session);

            Subject subject = subjectDao.findById(Integer.parseInt(subjectId.getText()));

            performance.setSubject(subject);

            performanceDao.update(performance);

            session.close();

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
