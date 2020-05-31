package com.application.controllers.delControllers;


import com.application.dao.AttendanceDao;
import com.application.dao.SubjectDao;
import com.application.entities.Attendance;
import com.application.entities.Subject;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DelSubjectController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;


    private Table table;

    @FXML
    void initialize() {

        delButton.setOnAction(addEvent -> {
            SubjectDao subjectDao = new SubjectDao();
            Subject subject = subjectDao.findById(Integer.parseInt(id.getText()));
            subjectDao.delete(subject);
            table.showSubjectTable();
            id.clear();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
