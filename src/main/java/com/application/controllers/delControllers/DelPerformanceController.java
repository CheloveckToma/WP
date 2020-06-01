package com.application.controllers.delControllers;


import com.application.daoTest.PerformanceDao;
import com.application.entities.Performance;
import com.application.main.HibernateUtil;
import com.application.tables.DisplayTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.hibernate.Session;

/**
 * Контроллер для окна удаления записей об успеваемости
 */

public class DelPerformanceController {

    @FXML
    private TextField id;

    @FXML
    private Button addButton;

    private DisplayTable displayTable;

    @FXML
    void initialize() {
        addButton.setOnAction(addEvent -> {
            Session session = HibernateUtil.getSession();

            PerformanceDao performanceDao = new PerformanceDao(session);
            Performance performance = performanceDao.findById(Integer.parseInt(id.getText()));
            performanceDao.delete(performance);

            session.close();

            displayTable.showPerformanceTable();

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
