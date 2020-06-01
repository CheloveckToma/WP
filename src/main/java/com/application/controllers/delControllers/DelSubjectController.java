package com.application.controllers.delControllers;


import com.application.daoTest.SubjectDao;
import com.application.entities.Subject;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * Контроллер для окна удаления записей о предметах
 */

public class DelSubjectController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;


    private DisplayTable displayTable;

    @FXML
    void initialize() {
        delButton.setOnAction(addEvent -> {
            Session session = HibernateUtil.getSession();

            SubjectDao subjectDao = new SubjectDao(session);
            Subject subject = subjectDao.findById(Integer.parseInt(id.getText()));
            subjectDao.delete(subject);

            session.close();

            displayTable.showSubjectTable();

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
