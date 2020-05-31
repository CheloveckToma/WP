package com.application.controllers.addControllers;


import com.application.dao.StudentDao;
import com.application.dao.SubjectDao;
import com.application.entities.*;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddPerformanceController {

    @FXML
    private TextField id;

    @FXML
    private TextField mark;

    @FXML
    private TextField subjectId;

    @FXML
    private Button addButton;

    private Table table;

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

            table.showPerformanceTable();

            id.clear();
            mark.clear();
            subjectId.clear();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
