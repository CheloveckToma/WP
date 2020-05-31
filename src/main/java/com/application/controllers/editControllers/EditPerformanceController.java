package com.application.controllers.editControllers;


import com.application.dao.PerformanceDao;
import com.application.dao.StudentDao;
import com.application.dao.SubjectDao;
import com.application.entities.Performance;
import com.application.entities.Student;
import com.application.entities.Subject;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    private Table table;
    @FXML
    void initialize() {

        editButton.setOnAction(addEvent -> {

            PerformanceDao performanceDao = new PerformanceDao();
            Performance performance =performanceDao.findById(Integer.parseInt(perfId.getText()));
            performance.setMark(Integer.parseInt(mark.getText()));

            SubjectDao subjectDao = new SubjectDao();

            Subject subject = subjectDao.findById(Integer.parseInt(subjectId.getText()));

            performance.setSubject(subject);

            performanceDao.update(performance);

            table.showPerformanceTable();

            perfId.clear();
            id.clear();
            mark.clear();
            subjectId.clear();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
