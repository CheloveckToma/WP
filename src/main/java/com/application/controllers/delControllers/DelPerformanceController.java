package com.application.controllers.delControllers;


import com.application.dao.PerformanceDao;
import com.application.dao.StudentDao;
import com.application.entities.Performance;
import com.application.entities.Student;
import com.application.entities.Subject;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DelPerformanceController {

    @FXML
    private TextField id;

    @FXML
    private Button addButton;

    private Table table;

    @FXML
    void initialize() {

        addButton.setOnAction(addEvent -> {
            PerformanceDao performanceDao = new PerformanceDao();
            Performance performance = performanceDao.findById(Integer.parseInt(id.getText()));
            performanceDao.delete(performance);
            table.showPerformanceTable();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
