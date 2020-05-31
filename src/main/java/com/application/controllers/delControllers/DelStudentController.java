package com.application.controllers.delControllers;


import com.application.dao.StudentDao;
import com.application.entities.Performance;
import com.application.entities.Student;
import com.application.entities.Subject;
import com.application.tables.Table;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DelStudentController {

    @FXML
    private TextField id;

    @FXML
    private Button delButton;

    private Table table;

    @FXML
    void initialize() {
        delButton.setOnAction(addEvent -> {
            StudentDao studentDao = new StudentDao();
            Student student = studentDao.findById(Integer.parseInt(id.getText()));
            studentDao.delete(student);
            table.showStudentTable();
        });


    }

    public void setTable(Table table) {
        this.table = table;
    }
}
